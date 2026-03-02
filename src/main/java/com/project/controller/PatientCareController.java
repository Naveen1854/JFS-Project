package com.project.controller;

import com.project.dto.PatientCareDto;
import com.project.service.PatientCareService;
import com.project.util.SuccessResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patient-care")
public class PatientCareController {

    private final PatientCareService patientCareService;

    public PatientCareController(PatientCareService patientCareService) {
        this.patientCareService = patientCareService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<PatientCareDto>> getPatientCareById(@PathVariable Long id) {
        PatientCareDto dto = patientCareService.getPatientCareById(id);
        return ResponseEntity.ok(new SuccessResponse<>("PatientCare fetched successfully by ID", HttpStatus.OK.value(), dto));
    }

    @GetMapping
    public ResponseEntity<SuccessResponse<List<PatientCareDto>>> getAllPatientCares() {
        List<PatientCareDto> list = patientCareService.getAllPatientCares();
        return ResponseEntity.ok(new SuccessResponse<>("All PatientCare records fetched successfully", HttpStatus.OK.value(), list));
    }

    @PostMapping
    public ResponseEntity<SuccessResponse<PatientCareDto>> savePatientCare(@RequestBody PatientCareDto dto) {
        PatientCareDto saved = patientCareService.savePatientCare(dto);
        return new ResponseEntity<>(new SuccessResponse<>("PatientCare saved successfully", HttpStatus.CREATED.value(), saved), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<PatientCareDto>> updatePatientCareById(@PathVariable Long id, @RequestBody PatientCareDto dto) {
        PatientCareDto updated = patientCareService.updatePatientCareById(id, dto);
        return ResponseEntity.ok(new SuccessResponse<>("PatientCare updated successfully by ID", HttpStatus.OK.value(), updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse<PatientCareDto>> deletePatientCareById(@PathVariable Long id) {
        PatientCareDto deleted = patientCareService.deletePatientCareById(id);
        return ResponseEntity.ok(new SuccessResponse<>("PatientCare deleted successfully by ID", HttpStatus.OK.value(), deleted));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<SuccessResponse<List<PatientCareDto>>> getPatientCaresByPatientId(@PathVariable Integer patientId) {
        List<PatientCareDto> list = patientCareService.getPatientCaresByPatientId(patientId);
        return ResponseEntity.ok(new SuccessResponse<>("PatientCare records fetched successfully for patient ID: " + patientId, HttpStatus.OK.value(), list));
    }


    @GetMapping("/nurse/{nurseId}")
    public ResponseEntity<SuccessResponse<List<PatientCareDto>>> getPatientCaresByNurseId(@PathVariable Integer nurseId) {
        List<PatientCareDto> list = patientCareService.getPatientCaresByNurseId(nurseId);
        return ResponseEntity.ok(
                new SuccessResponse<>("PatientCare records fetched successfully for nurse ID: " + nurseId, HttpStatus.OK.value(), list));
    }


    @GetMapping("/startDate/{startDate}")
    public ResponseEntity<SuccessResponse<List<PatientCareDto>>> getPatientCaresByStartDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {
        List<PatientCareDto> list = patientCareService.getPatientCaresByStartDate(startDate);
        return ResponseEntity.ok(
                new SuccessResponse<>("PatientCare records fetched successfully for start date: " + startDate, HttpStatus.OK.value(), list)
        );
    }
}
