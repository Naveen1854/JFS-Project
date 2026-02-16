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
import com.project.util.ErrorResponse;

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
    public ResponseEntity<ErrorResponse<PatientDto>> savePatient(@RequestBody PatientDto patientDto) {

        PatientDto savedPatient = patientService.savePatient(patientDto);

        ErrorResponse<PatientDto> response = new ErrorResponse<>(
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
    public ResponseEntity<ErrorResponse<List<PatientDto>>> getAllPatients() {

        List<PatientDto> patients = patientService.getAllPatients();

        ErrorResponse<List<PatientDto>> response = new ErrorResponse<>(
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
    public ResponseEntity<ErrorResponse<PatientDto>> findPatientById(@PathVariable Long patientId) {

        PatientDto dbPatient = patientService.findPatientById(patientId);

        ErrorResponse<PatientDto> response = new ErrorResponse<>(
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
    @PutMapping("/{oldPatientId}")
    public ResponseEntity<ErrorResponse<PatientDto>> updatePatientById(
            @PathVariable Long patientId,
            @RequestBody PatientDto newPatientDto) {

        PatientDto updated = patientService.updatePatientById(patientId, newPatientDto);

        ErrorResponse<PatientDto> response = new ErrorResponse<>(
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
    public ResponseEntity<ErrorResponse<PatientDto>> deletePatientById(@PathVariable Long patientId) {

        PatientDto deleted = patientService.deletePatientById(patientId);

        ErrorResponse<PatientDto> response = new ErrorResponse<>(
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
    @GetMapping("/name/{name}")
    public ResponseEntity<ErrorResponse<List<PatientDto>>> getPatientByName(@PathVariable String name) {

        List<PatientDto> patients = patientService.findPatientByName(name);

        ErrorResponse<List<PatientDto>> response = new ErrorResponse<>(
                "Patients fetched by name",
                HttpStatus.OK.value(),
                patients
        );

        return ResponseEntity.ok(response);
    }

    // GET /api/v1/patients/search/phone/9876543210
    @GetMapping("/phone/{phone}")
    public ResponseEntity<ErrorResponse<PatientDto>> getPatientByPhone(@PathVariable String phone) {

    	PatientDto patient = patientService.findPatientByPhone(phone);

        ErrorResponse<PatientDto> response = new ErrorResponse<>(
                "Patient fetched by phone number",
                HttpStatus.OK.value(),
                patient
        );

        return ResponseEntity.ok(response);
    }

    // GET /api/v1/patients/search/gender/male
    @GetMapping("/gender/{gender}")
    public ResponseEntity<ErrorResponse<List<PatientDto>>> getPatientByGender(@PathVariable String gender) {

        List<PatientDto> patients = patientService.findPatientByGender(gender);

        ErrorResponse<List<PatientDto>> response = new ErrorResponse<>(
                "Patients fetched by gender",
                HttpStatus.OK.value(),
                patients
        );

        return ResponseEntity.ok(response);
    }

    // GET /api/v1/patients/search/age?min=20&max=40
    @GetMapping("/age")
    public ResponseEntity<ErrorResponse<List<PatientDto>>> getPatientByAgeRange(
            @RequestParam int min,
            @RequestParam int max) {

        List<PatientDto> patients = patientService.findPatientByAgeBetween(min, max);

        ErrorResponse<List<PatientDto>> response = new ErrorResponse<>(
                "Patients fetched by age range",
                HttpStatus.OK.value(),
                patients
        );

        return ResponseEntity.ok(response);
    }

    // GET /api/v1/patients/search/address/bangalore
    @GetMapping("/address/{address}")
    public ResponseEntity<ErrorResponse<List<PatientDto>>> getPatientByAddress(@PathVariable String address) {

        List<PatientDto> patients = patientService.findPatientByAddress(address);

        ErrorResponse<List<PatientDto>> response = new ErrorResponse<>(
                "Patients fetched by address",
                HttpStatus.OK.value(),
                patients
        );

        return ResponseEntity.ok(response);
    }
}
