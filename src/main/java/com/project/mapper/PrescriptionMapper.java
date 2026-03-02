package com.project.mapper;

import com.project.dto.PrescriptionDto;
import com.project.entity.Prescription;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrescriptionMapper {


    //    Entity ➜ DTO
    @Mapping(source = "patient.patientId", target = "patientId")
    @Mapping(source = "doctor.doctorId", target = "doctorId")
    PrescriptionDto toDto(Prescription prescription);

    //    List<Entity> ➜ List<Dto>
    List<PrescriptionDto> toDtoList(List<Prescription> prescriptions);

    //    DTO ➜ Entity
    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "doctor", ignore = true)
    Prescription toEntity(PrescriptionDto prescriptionDto);

    @Mapping(target = "prescriptionId", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePrescriptionFromDto(PrescriptionDto dto, @MappingTarget Prescription entity);

}
