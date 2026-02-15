package com.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.entity.Patient;
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
    @GetMapping("/")
    public String welcomeMessage() {
        return "Welcome to Hospital Management System !!!";
    }

    // ---------------------------------------------
    // CREATE PATIENT
    // POST /api/v1/patients
    // ---------------------------------------------
    @PostMapping
    public ResponseEntity<ErrorResponse<Patient>> savePatient(@RequestBody Patient patient) {

        Patient savedPatient = patientService.savePatient(patient);

        ErrorResponse<Patient> response = new ErrorResponse<>(
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
    public ResponseEntity<ErrorResponse<List<Patient>>> getAllPatients() {

        List<Patient> patients = patientService.getAllPatients();

        ErrorResponse<List<Patient>> response = new ErrorResponse<>(
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
    public ResponseEntity<ErrorResponse<Patient>> findPatientById(@PathVariable Long patientId) {

        Patient dbPatient = patientService.findPatientById(patientId);

        ErrorResponse<Patient> response = new ErrorResponse<>(
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
    public ResponseEntity<ErrorResponse<Patient>> updatePatientById(
            @PathVariable Long patientId,
            @RequestBody Patient newPatient) {

        Patient updated = patientService.updatePatientById(patientId, newPatient);

        ErrorResponse<Patient> response = new ErrorResponse<>(
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
    public ResponseEntity<ErrorResponse<Patient>> deletePatientById(@PathVariable Long patientId) {

        Patient deleted = patientService.deletePatientById(patientId);

        ErrorResponse<Patient> response = new ErrorResponse<>(
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
    public ResponseEntity<ErrorResponse<List<Patient>>> getPatientByName(@PathVariable String name) {

        List<Patient> patients = patientService.findPatientByName(name);

        ErrorResponse<List<Patient>> response = new ErrorResponse<>(
                "Patients fetched by name",
                HttpStatus.OK.value(),
                patients
        );

        return ResponseEntity.ok(response);
    }

    // GET /api/v1/patients/search/phone/9876543210
    @GetMapping("/phone/{phone}")
    public ResponseEntity<ErrorResponse<Patient>> getPatientByPhone(@PathVariable String phone) {

        Patient patient = patientService.findPatientByPhone(phone);

        ErrorResponse<Patient> response = new ErrorResponse<>(
                "Patient fetched by phone number",
                HttpStatus.OK.value(),
                patient
        );

        return ResponseEntity.ok(response);
    }

    // GET /api/v1/patients/search/gender/male
    @GetMapping("/gender/{gender}")
    public ResponseEntity<ErrorResponse<List<Patient>>> getPatientByGender(@PathVariable String gender) {

        List<Patient> patients = patientService.findPatientByGender(gender);

        ErrorResponse<List<Patient>> response = new ErrorResponse<>(
                "Patients fetched by gender",
                HttpStatus.OK.value(),
                patients
        );

        return ResponseEntity.ok(response);
    }

    // GET /api/v1/patients/search/age?min=20&max=40
    @GetMapping("/age")
    public ResponseEntity<ErrorResponse<List<Patient>>> getPatientByAgeRange(
            @RequestParam int min,
            @RequestParam int max) {

        List<Patient> patients = patientService.findPatientByAgeBetween(min, max);

        ErrorResponse<List<Patient>> response = new ErrorResponse<>(
                "Patients fetched by age range",
                HttpStatus.OK.value(),
                patients
        );

        return ResponseEntity.ok(response);
    }

    // GET /api/v1/patients/search/address/bangalore
    @GetMapping("/address/{address}")
    public ResponseEntity<ErrorResponse<List<Patient>>> getPatientByAddress(@PathVariable String address) {

        List<Patient> patients = patientService.findPatientByAddress(address);

        ErrorResponse<List<Patient>> response = new ErrorResponse<>(
                "Patients fetched by address",
                HttpStatus.OK.value(),
                patients
        );

        return ResponseEntity.ok(response);
    }
}
