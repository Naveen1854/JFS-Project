package com.project.service;

import com.project.dto.BillDto;

import java.util.List;

public interface BillService {

    BillDto saveBill(BillDto billDto);

    List<BillDto> getAllBills();

    BillDto getBillById(Long paymentId);

    BillDto updateBillById(Long paymentId, BillDto billDto);

    BillDto deleteBillById(Long paymentId);

    List<BillDto> getBillsByPatientId(Long patientId);

    List<BillDto> getBillsByPaymentStatus(String paymentStatus);
}
