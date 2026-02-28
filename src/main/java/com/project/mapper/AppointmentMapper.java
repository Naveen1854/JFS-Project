package com.project.mapper;

import java.util.List;

import org.mapstruct.*;

import com.project.dto.AppointmentDto;
import com.project.entity.Appointment;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    // Entity ➜ DTO
    @Mapping(source = "patient.patientId", target = "patientId")
    @Mapping(source = "doctor.doctorId", target = "doctorId")
    AppointmentDto toDto(Appointment appointment);

    // DTO ➜ Entity
    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "doctor", ignore = true)
    Appointment toEntity(AppointmentDto dto);

    List<AppointmentDto> toDtoList(List<Appointment> appointments);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "appointmentId", ignore = true)
    void updateAppointmentFromDto(AppointmentDto dto, @MappingTarget Appointment entity);

}
