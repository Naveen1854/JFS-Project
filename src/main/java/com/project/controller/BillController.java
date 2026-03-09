package com.project.controller;

import com.project.dto.BillDto;
import com.project.service.BillService;
import com.project.util.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping
    public ResponseEntity<SuccessResponse<BillDto>> saveBill(@RequestBody BillDto billDto) {
        BillDto savedBill = billService.saveBill(billDto);
        SuccessResponse<BillDto> response = new SuccessResponse<>(
                "Bill saved successfully",
                HttpStatus.CREATED.value(),
                savedBill
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<SuccessResponse<List<BillDto>>> getAllBills() {
        List<BillDto> bills = billService.getAllBills();
        SuccessResponse<List<BillDto>> response = new SuccessResponse<>(
                "All bills fetched successfully",
                HttpStatus.OK.value(),
                bills
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<SuccessResponse<BillDto>> getBillById(@PathVariable Long paymentId) {
        BillDto bill = billService.getBillById(paymentId);
        SuccessResponse<BillDto> response = new SuccessResponse<>(
                "Bill fetched successfully by id",
                HttpStatus.OK.value(),
                bill
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<SuccessResponse<BillDto>> updateBillById(@PathVariable Long paymentId, @RequestBody BillDto billDto) {
        BillDto updatedBill = billService.updateBillById(paymentId, billDto);
        SuccessResponse<BillDto> response = new SuccessResponse<>(
                "Bill updated successfully by id",
                HttpStatus.OK.value(),
                updatedBill
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<SuccessResponse<BillDto>> deleteBillById(@PathVariable Long paymentId) {
        BillDto deletedBill = billService.deleteBillById(paymentId);
        SuccessResponse<BillDto> response = new SuccessResponse<>(
                "Bill deleted successfully by payment id",
                HttpStatus.OK.value(),
                deletedBill
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<SuccessResponse<List<BillDto>>> getBillsByPatientId(@PathVariable Long patientId) {
        List<BillDto> bills = billService.getBillsByPatientId(patientId);
        SuccessResponse<List<BillDto>> response = new SuccessResponse<>(
                "Bills fetched successfully for patient ID: " + patientId,
                HttpStatus.OK.value(),
                bills
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/status")
    public ResponseEntity<SuccessResponse<List<BillDto>>> getBillsByPaymentStatus(@RequestParam String paymentStatus) {
        List<BillDto> bills = billService.getBillsByPaymentStatus(paymentStatus);
        SuccessResponse<List<BillDto>> response = new SuccessResponse<>(
                "Bills fetched successfully for payment status: " + paymentStatus,
                HttpStatus.OK.value(),
                bills
        );
        return ResponseEntity.ok(response);
    }
}
