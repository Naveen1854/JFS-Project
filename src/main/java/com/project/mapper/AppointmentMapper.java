package com.project.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.project.dto.AppointmentDto;
import com.project.entity.Appointment;

public interface AppointmentMapper {

//    Entity ➜ DTO
    AppointmentDto toDto(Appointment appointment);

//    DTO ➜ Entity
    Appointment toEntity(AppointmentDto appointmentDto);

//    List<Entity> ➜ List<Dto>
    List<AppointmentDto> toDtoList(List<Appointment> appointments);

//    List<DTO> ➜ List<Entity>(optional)
    List<Appointment> toEntityList(List<AppointmentDto>  appointmentDtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAppointmentFromDto(AppointmentDto appointmentDto, @MappingTarget Appointment entity);
}



































    /**
     *  public static AppointmentDto mapToDto(Appointment appointment) {
     *         return new AppointmentDto(
     *                 appointment.getAppointmentId(),
     *                 appointment.getPatientId(),
     *                 appointment.getDoctorId(),
     *                 appointment.getAppointmentDate(),
     *                 appointment.getAppointmentTime(),
     *                 appointment.getStatus()
     *         );
     *     }
     *
     *     public static Appointment mapToAppointment(AppointmentDto appointmentDto) {
     *         return new Appointment(
     *                 appointmentDto.getAppointmentId(),
     *                 appointmentDto.getPatientId(),
     *                 appointmentDto.getDoctorId(),
     *                 appointmentDto.getAppointmentDate(),
     *                 appointmentDto.getAppointmentTime(),
     *                 appointmentDto.getStatus()
     *         );
     *     }
     */
