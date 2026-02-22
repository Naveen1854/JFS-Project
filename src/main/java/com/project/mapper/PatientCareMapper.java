package com.project.mapper;

import com.project.dto.PatientCareDto;
import com.project.entity.PatientCare;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientCareMapper {

    //    Entity ➜ DTO
    PatientCareDto toDto(PatientCare patientCare);

    //    DTO ➜ Entity
    PatientCare toEntity(PatientCareDto patientCareDto);

    //    List<Entity> ➜ List<Dto>
    List<PatientCareDto> toDtoList(List<PatientCare> patientCares);

    //    List<DTO> ➜ List<Entity>(optional)
    List<PatientCare> toEntityList(List<PatientCareDto> patientCaresDto);





















    /**
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
     */
}
