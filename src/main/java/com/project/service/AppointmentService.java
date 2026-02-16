package com.project.service;

import com.project.dto.AppointmentDto;
import com.project.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    public AppointmentDto saveAppointment(AppointmentDto appointmentDto);

    public AppointmentDto findAppointmentById(Long appointmentId);

    public List<AppointmentDto> getAllAppointments();

    public AppointmentDto updateAppointmentById(Long appintmwentId, AppointmentDto appointmentDto);

    public AppointmentDto deleteAppointmentById(Long appointmentId);


}
