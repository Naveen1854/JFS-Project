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

	
	
	public List<PatientDto> getPatientByName(String name);

	public PatientDto getPatientByPhone(String phoneNumber);

	public List<PatientDto> getPatientByGender(String gender);

	public List<PatientDto> getPatientByAgeBetween(int minAge, int maxAge);

	public List<PatientDto> getPatientByAddress(String address);


}
