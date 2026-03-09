package com.project.service;

import com.project.dto.BillDto;
import com.project.entity.Bill;
import com.project.entity.Patient;
import com.project.exception.BillNotFoundException;
import com.project.exception.PatientNotFoundException;
import com.project.mapper.BillMapper;
import com.project.repository.BillRepository;
import com.project.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final BillMapper billMapper;
    private final PatientRepository patientRepository;

    @Override
    public BillDto saveBill(BillDto billDto) {
        Patient patient = patientRepository.findById(billDto.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException("Patient Not Found with id: " +  billDto.getPatientId()));
        Bill bill = billMapper.toEntity(billDto);
        bill.setPatient(patient);
        Bill savedBill = billRepository.save(bill);
        return billMapper.toDto(savedBill);
    }

    @Override
    public List<BillDto> getAllBills() {
        List<Bill> bills = billRepository.findAll();
        return billMapper.toDtoList(bills);
    }

    @Override
    public BillDto getBillById(Long paymentId){
       Bill bill =  billRepository.findById(paymentId)
                .orElseThrow(() -> new BillNotFoundException("Bill Not Found with id: " +  paymentId));
       return billMapper.toDto(bill);
    }

    @Override
    public BillDto updateBillById(Long paymentId, BillDto billDto) {
        Bill existingBill = billRepository.findById(paymentId)
                .orElseThrow(() -> new BillNotFoundException("Bill Not Found with id: " +  paymentId));
        billMapper.updateBillFromDto(billDto, existingBill);
        if (billDto.getPatientId() != null) {
          Patient patient = patientRepository.findById(billDto.getPatientId())
                    .orElseThrow(() -> new PatientNotFoundException("Patient Not Found with id: " + billDto.getPatientId()));
          existingBill.setPatient(patient);
        }
        Bill updatedBill = billRepository.save(existingBill);
        return billMapper.toDto(updatedBill);
    }

    @Override
    public BillDto deleteBillById(Long paymentId) {
        Bill bill = billRepository.findById(paymentId)
                .orElseThrow(() -> new BillNotFoundException("Bill Not Found with id: " +  paymentId));
        billRepository.delete(bill);
        return billMapper.toDto(bill);
    }

    @Override
    public List<BillDto> getBillsByPatientId(Long patientId) {
       List<Bill> bills = billRepository.findByPatientPatientId(patientId);
        return billMapper.toDtoList(bills);
    }

    @Override
    public List<BillDto> getBillsByPaymentStatus(String paymentStatus) {
        List<Bill> bills = billRepository.findByPaymentStatus(paymentStatus);
        return billMapper.toDtoList(bills);
    }
}
