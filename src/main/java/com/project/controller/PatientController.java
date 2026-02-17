package com.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.PatientDto;
import com.project.service.PatientService;
import com.project.util.SuccessResponse;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // ---------------------------------------------
    // Welcome API
    // ---------------------------------------------
    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Hospital Management System !!!";
    }

    // ---------------------------------------------
    // CREATE PATIENT
    // POST /api/v1/patients
    // ---------------------------------------------
    @PostMapping
    public ResponseEntity<SuccessResponse<PatientDto>> savePatient(@RequestBody PatientDto patientDto) {

        PatientDto savedPatient = patientService.savePatient(patientDto);

        SuccessResponse<PatientDto> response = new SuccessResponse<>(
                "Patient saved successfully",
                HttpStatus.CREATED.value(),
                savedPatient
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // ---------------------------------------------
    // GET ALL PATIENTS
    // GET /api/v1/patients
    // ---------------------------------------------
    @GetMapping
    public ResponseEntity<SuccessResponse<List<PatientDto>>> getAllPatients() {

        List<PatientDto> patients = patientService.getAllPatients();

        SuccessResponse<List<PatientDto>> response = new SuccessResponse<>(
                "Patients fetched successfully",
                HttpStatus.OK.value(),
                patients
        );

        return ResponseEntity.ok(response);
    }

    // ---------------------------------------------
    // GET PATIENT BY ID
    // GET /api/v1/patients/{id}
    // ---------------------------------------------
    @GetMapping("/{patientId}")
    public ResponseEntity<SuccessResponse<PatientDto>> findPatientById(@PathVariable Long patientId) {

        PatientDto dbPatient = patientService.findPatientById(patientId);

        SuccessResponse<PatientDto> response = new SuccessResponse<>(
                "Patient fetched successfully",
                HttpStatus.OK.value(),
                dbPatient
        );

        return ResponseEntity.ok(response);
    }

    // ---------------------------------------------
    // UPDATE PATIENT
    // PUT /api/v1/patients/{id}
    // ---------------------------------------------
    @PutMapping("/{patientId}")
    public ResponseEntity<SuccessResponse<PatientDto>> updatePatientById(
            @PathVariable Long patientId,
            @RequestBody PatientDto newPatientDto) {

        PatientDto updated = patientService.updatePatientById(patientId, newPatientDto);

        SuccessResponse<PatientDto> response = new SuccessResponse<>(
                "Patient updated successfully",
                HttpStatus.OK.value(),
                updated
        );

        return ResponseEntity.ok(response);
    }

    // ---------------------------------------------
    // DELETE PATIENT
    // DELETE /api/v1/patients/{id}
    // ---------------------------------------------
    @DeleteMapping("/{patientId}")
    public ResponseEntity<SuccessResponse<PatientDto>> deletePatientById(@PathVariable Long patientId) {

        PatientDto deleted = patientService.deletePatientById(patientId);

        SuccessResponse<PatientDto> response = new SuccessResponse<>(
                "Patient deleted successfully",
                HttpStatus.OK.value(),
                deleted
        );

        return ResponseEntity.ok(response);
    }

    // ---------------------------------------------
    // SEARCH OPERATIONS
    // ---------------------------------------------

    // GET /api/v1/patients/search/name/Ravi
    @GetMapping("/search/name/{name}")
    public ResponseEntity<SuccessResponse<List<PatientDto>>> getPatientByName(@PathVariable String name) {

        List<PatientDto> patients = patientService.findPatientByName(name);

        SuccessResponse<List<PatientDto>> response = new SuccessResponse<>(
                "Patients fetched by name",
                HttpStatus.OK.value(),
                patients
        );

        return ResponseEntity.ok(response);
    }

    // GET /api/v1/patients/search/phone/9876543210
    @GetMapping("/search/phone/{phone}")
    public ResponseEntity<SuccessResponse<PatientDto>> getPatientByPhone(@PathVariable String phone) {

    	PatientDto patient = patientService.findPatientByPhone(phone);

    	SuccessResponse<PatientDto> response = new SuccessResponse<>(
                "Patient fetched by phone number",
                HttpStatus.OK.value(),
                patient
        );

        return ResponseEntity.ok(response);
    }

    // GET /api/v1/patients/search/gender/male
    @GetMapping("/search/gender/{gender}")
    public ResponseEntity<SuccessResponse<List<PatientDto>>> getPatientByGender(@PathVariable String gender) {

        List<PatientDto> patients = patientService.findPatientByGender(gender);

        SuccessResponse<List<PatientDto>> response = new SuccessResponse<>(
                "Patients fetched by gender",
                HttpStatus.OK.value(),
                patients
        );

        return ResponseEntity.ok(response);
    }

    // GET /api/v1/patients/search/age?min=20&max=40
    @GetMapping("/search/age")
    public ResponseEntity<SuccessResponse<List<PatientDto>>> getPatientByAgeRange(
            @RequestParam int min,
            @RequestParam int max) {

        List<PatientDto> patients = patientService.findPatientByAgeBetween(min, max);

        SuccessResponse<List<PatientDto>> response = new SuccessResponse<>(
                "Patients fetched by age range",
                HttpStatus.OK.value(),
                patients
        );

        return ResponseEntity.ok(response);
    }

    // GET /api/v1/patients/search/address/bangalore
    @GetMapping("/search/address/{address}")
    public ResponseEntity<SuccessResponse<List<PatientDto>>> getPatientByAddress(@PathVariable String address) {

        List<PatientDto> patients = patientService.findPatientByAddress(address);

        SuccessResponse<List<PatientDto>> response = new SuccessResponse<>(
                "Patients fetched by address",
                HttpStatus.OK.value(),
                patients
        );

        return ResponseEntity.ok(response);
    }
}
