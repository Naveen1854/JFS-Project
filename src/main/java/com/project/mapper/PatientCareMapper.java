package com.project.mapper;

import com.project.dto.PatientCareDto;
import com.project.entity.PatientCare;

public class PatientCareMapper {

    public static PatientCareDto mapToDto(PatientCare patientCare){
        return new PatientCareDto(
          patientCare.getCareId(),
          patientCare.getCareType(),
          patientCare.getCareStartDate(),
          patientCare.getCareEndDate(),
          patientCare.getNurseId(),
          patientCare.getPatientId()
        );
    }

    public static PatientCare mapToPatientCare(PatientCareDto patientCareDto){
        return new PatientCare(
                patientCareDto.getCareId(),
                patientCareDto.getCareType(),
                patientCareDto.getCareStartDate(),
                patientCareDto.getCareEndDate(),
                patientCareDto.getNurseId(),
                patientCareDto.getPatientId()
        );
    }
}
