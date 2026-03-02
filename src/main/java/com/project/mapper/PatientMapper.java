package com.project.mapper;

import java.util.List;

import org.mapstruct.*;

import com.project.dto.PatientDto;
import com.project.entity.Patient;

@Mapper(componentModel = "spring")
public interface PatientMapper {


    // Entity ➜ DTO
    PatientDto toDto(Patient patient);

    // DTO ➜ Entity
    Patient toEntity(PatientDto patientDto);

    // List<Entity> ➜ List<DTO>
    List<PatientDto> toDtoList(List<Patient> patients);

    // List<DTO> ➜ List<Entity> (optional)
    List<Patient> toEntityList(List<PatientDto> patientDtos);

    @Mapping(target = "patientId", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePatientFromDto(PatientDto dto, @MappingTarget Patient entity);

}
