package com.project.repository;

import com.project.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription> findByPatient_PatientId(Integer patientId);

    List<Prescription> findByDoctor_DoctorId(Integer doctorId);

    List<Prescription> findByPrescriptionDate(LocalDate prescriptionDate);
}
