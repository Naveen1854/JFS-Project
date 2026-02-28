package com.project.service;

import java.time.LocalDate;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.project.dto.AppointmentDto;
import com.project.entity.Appointment;
import com.project.exception.AppointmentNotFoundException;
import com.project.exception.DoctorNotFoundException;
import com.project.exception.SlotAlreadyBookedException;
import com.project.mapper.AppointmentMapper;
import com.project.repository.AppointmentRepository;
import com.project.repository.DoctorRepository;

import jakarta.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	private  final AppointmentRepository appointmentRepository;
	private final AppointmentMapper appointmentMapper;
	private final DoctorRepository doctorRepository;

	/**
	 * save the Appointment into database
	 */
	@Override
	public AppointmentDto saveAppointment(AppointmentDto appointmentDto) {
		// 1. Prevent past booking
		if (appointmentDto.getAppointmentDate().isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("Appointment date cannot be in the past");
		}
		// 2. Prevent double booking
		boolean exists = appointmentRepository.existsByDoctorDoctorIdAndAppointmentDateAndAppointmentTime(
				appointmentDto.getDoctorId(), appointmentDto.getAppointmentDate(), appointmentDto.getAppointmentTime());
		if (exists) {
			throw new SlotAlreadyBookedException("Doctor already booked for this time slot");
		}
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
	public AppointmentDto getAppointmentById(Long appointmentId) {
		Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(
				() -> new AppointmentNotFoundException("Appointment with id: " + appointmentId + " not found!"));
		return appointmentMapper.toDto(appointment);
	}

	@Override
	public List<AppointmentDto> getAllAppointments() {
		List<Appointment> dbAppointments = appointmentRepository.findAll();
		return appointmentMapper.toDtoList(dbAppointments);
	}

	@Override
	public AppointmentDto updateAppointmentById(Long appointmentId, AppointmentDto appointmentDto) {
		Appointment dbAppointment = appointmentRepository.findById(appointmentId).orElseThrow(
				() -> new AppointmentNotFoundException("Appointment with id: " + appointmentId + " not found!"));
		appointmentMapper.updateAppointmentFromDto(appointmentDto, dbAppointment);
		Appointment updatedAppointment = appointmentRepository.save(dbAppointment);
		return appointmentMapper.toDto(updatedAppointment);
	}

	@Override
	public AppointmentDto deleteAppointmentById(Long appointmentId) {
		Appointment dbAppointment = appointmentRepository.findById(appointmentId).orElseThrow(
				() -> new AppointmentNotFoundException("Appointment with id: " + appointmentId + " not found!"));
		AppointmentDto deletedDto = appointmentMapper.toDto(dbAppointment);
		appointmentRepository.deleteById(appointmentId);
		return deletedDto;
	}

	/**
	 * Search Options
	 */
	@Override
	public List<AppointmentDto> getAppointmentsByPatientId(Long patientId) {
		List<Appointment> dbAppointments = appointmentRepository.findByPatientPatientId(patientId);
		return appointmentMapper.toDtoList(dbAppointments);
	}

	@Override
	public List<AppointmentDto> getAppointmentsByDoctorId(Long doctorId) {
		List<Appointment> dbAppointments = appointmentRepository.findByDoctorDoctorId(doctorId);
		return appointmentMapper.toDtoList(dbAppointments);
	}

	@Override
	public List<AppointmentDto> getAppointmentsByDate(LocalDate appointmentDate) {
		List<Appointment> dbAppointments = appointmentRepository.findByAppointmentDate(appointmentDate);
		return appointmentMapper.toDtoList(dbAppointments);
	}

	@Override
	public List<AppointmentDto> getAppointmentsByStatus(String status) {
		List<Appointment> dbAppointments = appointmentRepository.findByStatus(status);
		return appointmentMapper.toDtoList(dbAppointments);
	}

	@Override
	public List<AppointmentDto> getDoctorSchedule(Long doctorId, LocalDate appointmentDate) {
		
//		Optional<Doctor> doctor = doctorRepository.findById(doctorId);
//		System.out.println("Doctor present? " + doctor.isPresent());
		
		doctorRepository.findById(doctorId)
		.orElseThrow(() -> new DoctorNotFoundException("Doctor not found with Id: " + doctorId));
		List<Appointment> dbAppointments = appointmentRepository.findByDoctorDoctorIdAndAppointmentDate(doctorId, appointmentDate);
		return appointmentMapper.toDtoList(dbAppointments);
	}

}
