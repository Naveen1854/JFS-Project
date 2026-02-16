package com.project.service;

import com.project.dto.AppointmentDto;
import com.project.entity.Appointment;
import com.project.exception.AppointmentNotFoundException;
import com.project.mapper.AppointmentMapper;
import com.project.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private AppointmentMapper appointmentMapper;

	/**
	 * save the Appointment into database
	 */
	@Override
	public AppointmentDto saveAppointment(AppointmentDto appointmentDto) {
		// DTO ➜ Entity
		Appointment appointment = appointmentMapper.toEntity(appointmentDto);
		Appointment saved = appointmentRepository.save(appointment);
		// DTO ➜ Entity
		return appointmentMapper.toDto(saved);
	}

	/**
	 * find the Appointment by using patient id
	 */
	@Override
	public AppointmentDto findAppointmentById(Long appointmentId) {
		Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(
				() -> new AppointmentNotFoundException("Appointment with id: " + appointmentId + " not found!"));
		return appointmentMapper.toDto(appointment);
	}

	@Override
	public List<AppointmentDto> getAllAppointments() {
		return List.of();
	}

	@Override
	public AppointmentDto updateAppointmentById(Long appintmwentId, AppointmentDto appointmentDto) {
		return null;
	}

	@Override
	public AppointmentDto deleteAppointmentById(Long appointmentId) {
		return null;
	}
}
