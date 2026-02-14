package com.project.mapper;

import com.project.dto.DoctorDto;
import com.project.entity.Doctor;

public class DoctorMapper {

    public static DoctorDto mapToDto(Doctor doctor) {
        return new DoctorDto(
                doctor.getDoctorId(),
                doctor.getDoctorName(),
                doctor.getSpeciality(),
                doctor.getPhoneNumber(),
                doctor.getEmailId()
        );
    }

    public static Doctor mapToDoctor(DoctorDto doctorDto) {
        return new Doctor(
                doctorDto.getDoctorId(),
                doctorDto.getDoctorName(),
                doctorDto.getSpeciality(),
                doctorDto.getPhoneNumber(),
                doctorDto.getEmailId()
        );
    }
}
