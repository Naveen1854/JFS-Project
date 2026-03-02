package com.project.controller;

import com.project.dto.PrescriptionDto;
import com.project.service.PrescriptionService;
import com.project.util.SuccessResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    // Get prescription by ID
    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<PrescriptionDto>> getPrescriptionById(@PathVariable Long id) {
        PrescriptionDto prescription = prescriptionService.getPrescriptionById(id);
        SuccessResponse<PrescriptionDto> response = new SuccessResponse<>(
                "Prescription fetched successfully by ID",
                HttpStatus.OK.value(),
                prescription
        );
        return ResponseEntity.ok(response);
    }

    // Get all prescriptions
    @GetMapping
    public ResponseEntity<SuccessResponse<List<PrescriptionDto>>> getAllPrescriptions() {
        List<PrescriptionDto> prescriptions = prescriptionService.getAllPrescriptions();
        SuccessResponse<List<PrescriptionDto>> response = new SuccessResponse<>(
                "All prescriptions fetched successfully",
                HttpStatus.OK.value(),
                prescriptions
        );
        return ResponseEntity.ok(response);
    }

    // Create new prescription
    @PostMapping
    public ResponseEntity<SuccessResponse<PrescriptionDto>> savePrescription(@RequestBody PrescriptionDto prescriptionDto) {
        PrescriptionDto savedPrescription = prescriptionService.savePrescription(prescriptionDto);
        SuccessResponse<PrescriptionDto> response = new SuccessResponse<>(
                "Prescription saved successfully",
                HttpStatus.CREATED.value(),
                savedPrescription
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Full update (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<PrescriptionDto>> updatePrescriptionById(@PathVariable Long id,
                                                                                   @RequestBody PrescriptionDto prescriptionDto) {
        PrescriptionDto updatedPrescription = prescriptionService.updatePrescriptionById(id, prescriptionDto);
        SuccessResponse<PrescriptionDto> response = new SuccessResponse<>(
                "Prescription updated successfully by ID",
                HttpStatus.OK.value(),
                updatedPrescription
        );
        return ResponseEntity.ok(response);
    }

    // Delete prescription
    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse<PrescriptionDto>> deletePrescriptionById(@PathVariable Long id) {
        PrescriptionDto deletedPrescription = prescriptionService.deletePrescriptionById(id);
        SuccessResponse<PrescriptionDto> response = new SuccessResponse<>(
                "Prescription deleted successfully by ID",
                HttpStatus.OK.value(),
                deletedPrescription
        );
        return ResponseEntity.ok(response);
    }

    // Get prescriptions by patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<SuccessResponse<List<PrescriptionDto>>> getPrescriptionsByPatientId(@PathVariable Integer patientId) {
        List<PrescriptionDto> prescriptions = prescriptionService.getPrescriptionsByPatientId(patientId);
        SuccessResponse<List<PrescriptionDto>> response = new SuccessResponse<>(
                "Prescriptions fetched successfully for patient ID: " + patientId,
                HttpStatus.OK.value(),
                prescriptions
        );
        return ResponseEntity.ok(response);
    }

    // Get prescriptions by doctor ID
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<SuccessResponse<List<PrescriptionDto>>> getPrescriptionsByDoctorId(@PathVariable Integer doctorId) {
        List<PrescriptionDto> prescriptions = prescriptionService.getPrescriptionsByDoctorId(doctorId);
        SuccessResponse<List<PrescriptionDto>> response = new SuccessResponse<>(
                "Prescriptions fetched successfully for doctor ID: " + doctorId,
                HttpStatus.OK.value(),
                prescriptions
        );
        return ResponseEntity.ok(response);
    }

    // Get prescriptions by date
    @GetMapping("/date/{date}")
    public ResponseEntity<SuccessResponse<List<PrescriptionDto>>> getPrescriptionsByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<PrescriptionDto> prescriptions = prescriptionService.getPrescriptionsByDate(date);
        SuccessResponse<List<PrescriptionDto>> response = new SuccessResponse<>(
                "Prescriptions fetched successfully for date: " + date,
                HttpStatus.OK.value(),
                prescriptions
        );
        return ResponseEntity.ok(response);
    }
}