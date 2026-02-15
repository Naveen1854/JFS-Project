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
				.orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + patientId));
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

	// ---------------------------------------------
	// SEARCH OPERATIONS
	// ---------------------------------------------

	@Override
	public List<Patient> findPatientByName(String name) {
		List<Patient> dbPatients = patientRepository.findByPatientName(name);
		if (dbPatients.isEmpty()) {
			throw new PatientNotFoundException("No patient found with name: " + name);
		}
		return dbPatients;
	}

	@Override
	public Patient findPatientByPhone(String phoneNumber) {
		Patient dbPatient = patientRepository.findByContactNumber(phoneNumber);
		if (dbPatient == null) {
			throw new PatientNotFoundException("Patient not found with phoneNumber: " + phoneNumber);
		}
		return dbPatient;
	}

	@Override
	public List<Patient> findPatientByGender(String gender) {
		List<Patient> dbPatients = patientRepository.findByGender(gender);
		if(dbPatients.isEmpty()) {
			throw new PatientNotFoundException("No patient found with gender: " + gender);
		}
		return dbPatients;
	}

	@Override
	public List<Patient> findPatientByAgeBetween(int minAge, int maxAge) {
		List<Patient> dbPatients = patientRepository.findByAgeBetween(minAge, maxAge);
		if(dbPatients.isEmpty()) {
			throw new PatientNotFoundException("No patients found between age " + minAge + " and " + maxAge);
		}
		return dbPatients;
	}

	@Override
	public List<Patient> findPatientByAddress(String address) {
		List<Patient> dbPatients = patientRepository.findByAddress(address);
		if(dbPatients.isEmpty()) {
			throw new PatientNotFoundException("No patient found with address: " + address);
		}
		return dbPatients;
	}

}
