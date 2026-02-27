package com.project.service;

import com.project.dto.AppointmentDto;
import com.project.entity.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

	public AppointmentDto saveAppointment(AppointmentDto appointmentDto);

	public AppointmentDto getAppointmentById(Long appointmentId);

	public List<AppointmentDto> getAllAppointments();

	public AppointmentDto updateAppointmentById(Long appointmentId, AppointmentDto appointmentDto);

	public AppointmentDto deleteAppointmentById(Long appointmentId);

	
	
	
	/**
	 * Search Operations
	 */

	List<AppointmentDto> getAppointmentsByPatientId(Long patientId);

	List<AppointmentDto> getAppointmentsByDoctorId(Long doctorId);

	List<AppointmentDto> getAppointmentsByDate(LocalDate appointmentDate);

	List<AppointmentDto> getAppointmentsByStatus(String status);
	
	List<AppointmentDto> getDoctorSchedule(Long doctorId, LocalDate date);
	
}
