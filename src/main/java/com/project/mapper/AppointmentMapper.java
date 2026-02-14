package com.project.mapper;

import com.project.dto.AppointmentDto;
import com.project.entity.Appointment;

public class AppointmentMapper {

    public static AppointmentDto mapToDto(Appointment appointment) {
        return new AppointmentDto(
                appointment.getAppointmentId(),
                appointment.getPatientId(),
                appointment.getDoctorId(),
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime(),
                appointment.getStatus()
        );
    }

    public static Appointment mapToAppointment(AppointmentDto appointmentDto) {
        return new Appointment(
                appointmentDto.getAppointmentId(),
                appointmentDto.getPatientId(),
                appointmentDto.getDoctorId(),
                appointmentDto.getAppointmentDate(),
                appointmentDto.getAppointmentTime(),
                appointmentDto.getStatus()
        );
    }
}
