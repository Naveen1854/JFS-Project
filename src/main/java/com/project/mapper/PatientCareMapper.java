package com.project.mapper;

import com.project.dto.PatientCareDto;
import com.project.entity.PatientCare;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientCareMapper {

    //    Entity ➜ DTO
    @Mapping(source = "patient.patientId", target = "patientId")
    @Mapping(source = "nurse.nurseId", target = "nurseId")
    PatientCareDto toDto(PatientCare patientCare);

    //    DTO ➜ Entity
    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "nurse", ignore = true)
    PatientCare toEntity(PatientCareDto patientCareDto);

    //    List<Entity> ➜ List<Dto>
    List<PatientCareDto> toDtoList(List<PatientCare> patientCares);

    //    List<DTO> ➜ List<Entity>(optional)
    List<PatientCare> toEntityList(List<PatientCareDto> patientCaresDto);

    @Mapping(target = "careId", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePatientCareFromDto(PatientCareDto dto, @MappingTarget PatientCare entity);

}
