package com.project.mapper;

import com.project.dto.PatientDto;
import com.project.entity.Patient;

public class PatientMapper {

    public static PatientDto mapToDto(Patient patient) {
//		implement your code here

        return new PatientDto(
                patient.getPatientId(),
                patient.getPatientName(),
                patient.getAge(),
                patient.getGender(),
                patient.getContactNumber(),
                patient.getAddress()
        );
    }


    public static Patient mapToPatient(PatientDto patientDto) {
//		implement your code here

        return new Patient(
                patientDto.getPatientId(),
                patientDto.getPatientName(),
                patientDto.getAge(),
                patientDto.getGender(),
                patientDto.getContactNumber(),
                patientDto.getAddress()
        );
    }
}
