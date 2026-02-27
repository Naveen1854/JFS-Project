package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.dto.PatientDto;
import com.project.entity.Patient;
import com.project.exception.PatientNotFoundException;
import com.project.mapper.PatientMapper;
import com.project.repository.PatientRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	private final PatientRepository patientRepository;
	private final PatientMapper patientMapper;
	public PatientServiceImpl(PatientRepository patientRepository, PatientMapper patientMapper) {
		this.patientRepository = patientRepository;
		this.patientMapper = patientMapper;
	}

    /*
	@Autowired
	private  PatientRepository patientRepository;

	@Autowired
	private  PatientMapper patientMapper;
    */


	/*
	 * fetch all patients present inside database
	 */
	@Override
	public List<PatientDto> getAllPatients() {
		List<Patient> dbPatients = patientRepository.findAll();
		return patientMapper.toDtoList(dbPatients);
	}

	/**
	 * save the patient into database
	 */
	@Override
	public PatientDto savePatient(PatientDto patientDto) {
		// DTO ➜ Entity
		Patient patient = patientMapper.toEntity(patientDto);
		Patient saved = patientRepository.save(patient);
		// Entity ➜ DTO
		return patientMapper.toDto(saved);
	}

	/**
	 * find the patient by using patient id
	 */
	@Override
	public PatientDto getPatientById(Long patientId) {
		Patient dbPatient = patientRepository.findById(patientId)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + patientId));
		return patientMapper.toDto(dbPatient);
	}

	/**
	 * update the patient by using oldPatient id
	 */
	@Override
	public PatientDto updatePatientById(Long patientId, PatientDto newPatientDto) {
		Patient existingPatient = patientRepository.findById(patientId)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + patientId));

//		existingPatient.setPatientName(newPatientDto.getPatientName());
//		existingPatient.setAge(newPatientDto.getAge());
//		existingPatient.setGender(newPatientDto.getGender());
//		existingPatient.setContactNumber(newPatientDto.getContactNumber());
//		existingPatient.setAddress(newPatientDto.getAddress());

		patientMapper.updatePatientFromDto(newPatientDto, existingPatient);
		Patient updatedPatient = patientRepository.save(existingPatient);
		return patientMapper.toDto(updatedPatient);
	}

	/**
	 * delete the patient by using patient id
	 */
	@Override
	public PatientDto deletePatientById(Long patientId) {
		Patient dbPatient = patientRepository.findById(patientId)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + patientId));
		PatientDto dto = patientMapper.toDto(dbPatient);
		patientRepository.delete(dbPatient);
		return dto;
	}


    /**
     * ---------------------------------------------
     * SEARCH OPERATIONS
     *---------------------------------------------
     */

	@Override
	public List<PatientDto> findPatientByName(String name) {
		List<Patient> dbPatients = patientRepository.findByPatientName(name);

		return patientMapper.toDtoList(dbPatients);
	}

	@Override
	public PatientDto findPatientByPhone(String phoneNumber) {

		Patient patient = patientRepository.findByContactNumber(phoneNumber)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found with phoneNumber: " + phoneNumber));

		return patientMapper.toDto(patient);
	}

	@Override 
	public List<PatientDto> findPatientByGender(String gender) {
		List<Patient> dbPatients = patientRepository.findByGender(gender);
		return patientMapper.toDtoList(dbPatients);
	}

	@Override
	public List<PatientDto> findPatientByAgeBetween(int minAge, int maxAge) {
		List<Patient> dbPatients = patientRepository.findByAgeBetween(minAge, maxAge);
		return patientMapper.toDtoList(dbPatients);
	}

	@Override
	public List<PatientDto> findPatientByAddress(String address) {
		List<Patient> dbPatients = patientRepository.findByAddress(address);
		return patientMapper.toDtoList(dbPatients);
	}

}
