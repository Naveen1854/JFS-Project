package com.project.service;

import java.util.List;

import com.project.dto.PatientDto;
import com.project.entity.Patient;

public interface PatientService {

	public PatientDto savePatient(PatientDto patientDto);

	public List<PatientDto> getAllPatients();

	public PatientDto getPatientById(Long patientId);

	public PatientDto updatePatientById(Long patientId, PatientDto newPatientDto);

	public PatientDto deletePatientById(Long patientId);

	
	
	public List<PatientDto> findPatientByName(String name);

	public PatientDto findPatientByPhone(String phoneNumber);

	public List<PatientDto> findPatientByGender(String gender);

	public List<PatientDto> findPatientByAgeBetween(int minAge, int maxAge);

	public List<PatientDto> findPatientByAddress(String address);


}
