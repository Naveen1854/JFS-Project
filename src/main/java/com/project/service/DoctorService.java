package com.project.service;

import com.project.dto.DoctorDto;
import com.project.entity.Doctor;

import java.util.List;

public interface DoctorService {

    public DoctorDto saveDoctor(DoctorDto doctorDto);

    public List<DoctorDto> getAllDoctors();

    public DoctorDto getDoctorById(Long doctorId);

    public DoctorDto updateDoctorById(Long doctorId, DoctorDto newDoctorDto);

    public DoctorDto deleteDoctorById(Long doctorId);


    public List<DoctorDto> getByDoctorName(String doctorName);

    List<DoctorDto> getBySpeciality(String speciality);

    DoctorDto getByEmailId(String emailId);

    DoctorDto getByPhoneNumber(String phoneNumber);

    List<DoctorDto> getByDepartmentDepartmentId(Long departmentId);

    List<DoctorDto> getByDoctorNameAndSpeciality(String doctorName, String speciality);

    List<DoctorDto> getBySpecialityAndDepartmentDepartmentId(String speciality, Long departmentId);

}
