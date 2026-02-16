package com.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	List<Patient> findByPatientName(String name);

	Optional<Patient> findByContactNumber(String phoneNumber);

	List<Patient> findByGender(String gender);

	List<Patient> findByAgeBetween(int minAge, int maxAge);
	
	List<Patient> findByAddress(String address);
	
}
