package com.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.entity.Patient;
import com.project.util.ErrorResponse;

public interface PatientService {
	
	public Patient savePatient(Patient patient);
	
	public List<Patient> getAllPatients(); 
	
	public Patient findPatientById(Long patientId);
	
	public Patient updatePatientById(Long oldPatientId, Patient newPatient);
	
	public Patient deletePatientById(Long patientId);
}
