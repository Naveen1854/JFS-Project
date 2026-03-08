package com.project.repository;

import com.project.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {


    //  Find nurse by email ID
    Optional<Nurse> findByEmailId(String emailId);


    //  Find nurses by nurse name
    List<Nurse> findByNurseName(String nurseName);


    //  Find all nurses in a specific department
    List<Nurse> findByDepartmentDepartmentId(Long departmentId);


    //  Check if nurse exists by email
    boolean existsByEmailId(String emailId);
}
