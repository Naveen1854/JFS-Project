package com.project.service;

import com.project.dto.PrescriptionDto;
import com.project.entity.Doctor;
import com.project.entity.Patient;
import com.project.entity.Prescription;
import com.project.exception.DoctorNotFoundException;
import com.project.exception.PatientNotFoundException;
import com.project.exception.PrescriptionNotFoundException;
import com.project.mapper.PrescriptionMapper;
import com.project.repository.DoctorRepository;
import com.project.repository.PatientRepository;
import com.project.repository.PrescriptionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final PrescriptionMapper prescriptionMapper;
    private final PatientRepository  patientRepository;
    private final DoctorRepository  doctorRepository;

    @Override
    public PrescriptionDto getPrescriptionById(Long prescriptionId) {
        Prescription prescription = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new PrescriptionNotFoundException("Prescription not found with ID: " + prescriptionId));
        return prescriptionMapper.toDto(prescription);
    }

    @Override
    public List<PrescriptionDto> getAllPrescriptions() {
        return prescriptionMapper.toDtoList(prescriptionRepository.findAll());
    }

    @Override
    public PrescriptionDto savePrescription(PrescriptionDto prescriptionDto) {
       Patient patinet = patientRepository.findById(prescriptionDto.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + prescriptionDto.getPatientId()));
        Doctor doctor = doctorRepository.findById(prescriptionDto.getDoctorId())
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id: " + prescriptionDto.getDoctorId()));
        Prescription prescription = prescriptionMapper.toEntity(prescriptionDto);
        prescription.setPatient(patinet);
        prescription.setDoctor(doctor);
        Prescription savedPrescription = prescriptionRepository.save(prescription);
        return prescriptionMapper.toDto(savedPrescription);
    }

    @Override
    public PrescriptionDto updatePrescriptionById(Long prescriptionId, PrescriptionDto prescriptionDto) {
        Prescription existingPrescription = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new PrescriptionNotFoundException("Prescription not found with ID: " + prescriptionId));

        // Use MapStruct to update only non-null fields
        prescriptionMapper.updatePrescriptionFromDto(prescriptionDto, existingPrescription);

        Prescription updatedPrescription = prescriptionRepository.save(existingPrescription);
        return prescriptionMapper.toDto(updatedPrescription);
    }

    @Override
    public PrescriptionDto deletePrescriptionById(Long prescriptionId) {
        Prescription prescription = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new PrescriptionNotFoundException("Prescription not found with ID: " + prescriptionId));
        prescriptionRepository.delete(prescription);
        return prescriptionMapper.toDto(prescription);
    }


    //  Extra methods

    @Override
    public List<PrescriptionDto> getPrescriptionsByPatientId(Integer patientId) {
        List<Prescription> prescriptions = prescriptionRepository.findByPatient_PatientId(patientId);
        if (prescriptions.isEmpty()) {
            throw new PrescriptionNotFoundException("No prescriptions found for patient ID: " + patientId);
        }
        return prescriptionMapper.toDtoList(prescriptions);
    }

    @Override
    public List<PrescriptionDto> getPrescriptionsByDoctorId(Integer doctorId) {
        List<Prescription> prescriptions = prescriptionRepository.findByDoctor_DoctorId(doctorId);
        if (prescriptions.isEmpty()) {
            throw new PrescriptionNotFoundException("No prescriptions found for doctor ID: " + doctorId);
        }
        return prescriptionMapper.toDtoList(prescriptions);
    }

    @Override
    public List<PrescriptionDto> getPrescriptionsByDate(LocalDate prescriptionDate) {
        List<Prescription> prescriptions = prescriptionRepository.findByPrescriptionDate(prescriptionDate);
        if (prescriptions.isEmpty()) {
            throw new PrescriptionNotFoundException("No prescriptions found for date: " + prescriptionDate);
        }
        return prescriptionMapper.toDtoList(prescriptions);
    }
}