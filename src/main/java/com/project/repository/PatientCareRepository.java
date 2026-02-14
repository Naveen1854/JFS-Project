package com.project.repository;

import com.project.entity.PatientCare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientCareRepository extends JpaRepository<PatientCare, Long> {
}
