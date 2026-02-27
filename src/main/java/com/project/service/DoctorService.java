package com.project.service;

import com.project.dto.DoctorDto;

import java.util.List;

public interface DoctorService {

    public DoctorDto saveDoctor(DoctorDto doctorDto);

    public List<DoctorDto> getAllDoctors();

    public DoctorDto getDoctorById(Long doctorId);

    public DoctorDto updateDoctorById(Long doctorId, DoctorDto newDoctorDto);

    public DoctorDto deleteDoctorById(Long doctorId);
}
