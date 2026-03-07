package com.project.repository;

import com.project.dto.DoctorDto;
import com.project.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    public List<Doctor> findByDoctorName(String doctorName);

    List<Doctor> findBySpeciality(String speciality);

    Doctor findByEmailId(String emailId);

    Doctor findByPhoneNumber(String phoneNumber);

    List<Doctor> findByDepartmentDepartmentId(Long departmentId);

    List<Doctor> findByDoctorNameAndSpeciality(String doctorName, String speciality);

    List<Doctor> findBySpecialityAndDepartmentDepartmentId(String speciality, Long departmentId);
}
