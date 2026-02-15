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

	
	
	public List<Patient> findPatientByName(String name);

	public Patient findPatientByPhone(String phoneNumber);

	public List<Patient> findPatientByGender(String gender);

	public List<Patient> findPatientByAgeBetween(int minAge, int maxAge);

	public List<Patient> findPatientByAddress(String address);

}
