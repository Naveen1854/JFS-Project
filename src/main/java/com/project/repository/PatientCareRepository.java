package com.project.repository;

import com.project.entity.PatientCare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientCareRepository extends JpaRepository<PatientCare, Long> {

    List<PatientCare> findByPatient_PatientId(Integer patientId);
    List<PatientCare> findByNurse_NurseId(Integer nurseId);
    List<PatientCare> findByCareStartDate(LocalDate careStartDate);
}
