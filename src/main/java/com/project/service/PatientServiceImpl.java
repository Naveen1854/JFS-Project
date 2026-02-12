package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Patient;
import com.project.exception.PatientNotFoundException;
import com.project.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	/**
	 * fetch all patients present inside db
	 */
	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	/**
	 * save the patient into database
	 */
	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	/**
	 * find the patient by using patient id
	 */
	@Override
	public Patient findPatientById(Long patientId) {
		return patientRepository.findById(patientId)
				.orElseThrow(() -> 
						new PatientNotFoundException("Patient not found with ID: " + patientId));
	}


	/**
	 * update the patient by using oldPatient id
	 */
	@Override
	public Patient updatePatientById(Long oldPatientId, Patient newPatient) {
		Patient existingPatient = patientRepository.findById(oldPatientId)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + oldPatientId));
		existingPatient.setPatientName(newPatient.getPatientName());
		existingPatient.setAge(newPatient.getAge());
		existingPatient.setGender(newPatient.getGender());
		existingPatient.setContactNumber(newPatient.getContactNumber());
		existingPatient.setAddress(newPatient.getAddress());
		
		return savePatient(existingPatient);
	}
	
	
	/**
	 * delete the patient by using patient id
	 */
	@Override
	public Patient deletePatientById(Long patientId) {
		Patient dbPatient = patientRepository.findById(patientId)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + patientId));

		patientRepository.deleteById(patientId);
		return dbPatient;
	}

}
