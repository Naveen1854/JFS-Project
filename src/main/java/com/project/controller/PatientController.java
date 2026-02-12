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
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Patient;
import com.project.service.PatientService;
import com.project.util.ErrorResponse;

@RestController
//@RequestMapping("/api/v1/patient")
public class PatientController {

	private PatientService patientService;

	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}

	@PostMapping("/savePatient")
	public ResponseEntity<ErrorResponse<Patient>> savePatient(@RequestBody Patient patient) {
		Patient savedPatient = patientService.savePatient(patient);
		ErrorResponse<Patient> response = new ErrorResponse<>(
				"Patient saved Successfully", 
				HttpStatus.CREATED.value(),
				savedPatient
			);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/getAllPatients")
	public ResponseEntity<ErrorResponse<List<Patient>>> getAllPatients() {
		List<Patient> patients =  patientService.getAllPatients();

		ErrorResponse<List<Patient>> response = new ErrorResponse<>(
				"Fetched all Patients Successfully from the db", 
				HttpStatus.CREATED.value(),
				patients
			);
		
		return ResponseEntity.ok(response);
	}

	@GetMapping("/findPatientById/{patientId}")
	public ResponseEntity<ErrorResponse<Patient>> findPatientById(@PathVariable Long patientId) {
		Patient dbPatient =  patientService.findPatientById(patientId);
		
		ErrorResponse<Patient> response = new ErrorResponse<>(
				"Patient Fetched Successfully",
				HttpStatus.OK.value(),
				dbPatient
		);
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/updatePatientById/{oldPatientId}")
	public ResponseEntity<ErrorResponse<Patient>> updatePatientById(@PathVariable Long oldPatientId, @RequestBody Patient newPatient){
		Patient updated = patientService.updatePatientById(oldPatientId, newPatient);
		
		ErrorResponse<Patient> response = new ErrorResponse<>(
				"Patient updated Successfully",
				HttpStatus.OK.value(),
				updated
		);
		
		return ResponseEntity.ok(response);
	}
	
	
	@DeleteMapping("/deletePatientById/{PatientId}")
	public ResponseEntity<ErrorResponse<Patient>> deletePatientById(@PathVariable Long PatientId) {
		Patient deleted = patientService.deletePatientById(PatientId);
		
		ErrorResponse<Patient> response = new ErrorResponse<>(
			"Patient Deleted Successfully",
			HttpStatus.OK.value(),
			deleted
		);
		
		return ResponseEntity.ok(response);
	}
	
}
