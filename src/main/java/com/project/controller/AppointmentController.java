package com.project.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AppointmentDto;
import com.project.service.AppointmentService;
import com.project.util.SuccessResponse;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@PostMapping
	public ResponseEntity<SuccessResponse<AppointmentDto>> saveAppointment(@RequestBody AppointmentDto appointmentDto) {
		AppointmentDto savedAppointment = appointmentService.saveAppointment(appointmentDto);
		SuccessResponse<AppointmentDto> response = new SuccessResponse<>("Appointment Saved Successfully",
				HttpStatus.CREATED.value(), savedAppointment);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<SuccessResponse<List<AppointmentDto>>> getAllAppointments() {
		List<AppointmentDto> appointments = appointmentService.getAllAppointments();
		SuccessResponse<List<AppointmentDto>> response = new SuccessResponse<>("Appointments fetched Successfully",
				HttpStatus.OK.value(), appointments);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{appointmentId}")
	public ResponseEntity<SuccessResponse<AppointmentDto>> findAppointmentById(@PathVariable Long appointmentId) {
		AppointmentDto dbAppointment = appointmentService.findAppointmentById(appointmentId);
		SuccessResponse<AppointmentDto> response = new SuccessResponse<>("Appointment fetched Successfuly",
				HttpStatus.OK.value(), dbAppointment);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{appointmentId}")
	public ResponseEntity<SuccessResponse<AppointmentDto>> updateAppointmentById(@PathVariable Long appointmentId,
			@RequestBody AppointmentDto newAppointmentDto) {
		AppointmentDto updated = appointmentService.updateAppointmentById(appointmentId, newAppointmentDto);
		SuccessResponse<AppointmentDto> response = new SuccessResponse<>("Appointment updated Successfully",
				HttpStatus.OK.value(), updated);
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{appointmentId}")
	public ResponseEntity<SuccessResponse<AppointmentDto>> deleteAppointmentById(@PathVariable Long appointmentId){
		AppointmentDto deleted = appointmentService.deleteAppointmentById(appointmentId);
		SuccessResponse<AppointmentDto> response = new SuccessResponse<>(
				"Appointment Deleted Successfully",
				HttpStatus.OK.value(),
				deleted);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/search/patient/{patientId}")
	public ResponseEntity<SuccessResponse<List<AppointmentDto>>> getAppointmentsByPatientId(@PathVariable Long patientId){
		List<AppointmentDto> appointmentsById = appointmentService.getAppointmentsByPatientId(patientId);
		SuccessResponse<List<AppointmentDto>> response = new SuccessResponse<>(
				"Appointments fetched by patient id successfully",
				HttpStatus.OK.value(),
				appointmentsById);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/search/doctor/{doctorId}")
	public ResponseEntity<SuccessResponse<List<AppointmentDto>>> getAppointmentsByDoctorId(@PathVariable Long doctorId){
		List<AppointmentDto> appointmentsById =  appointmentService.getAppointmentsByDoctorId(doctorId);
		SuccessResponse<List<AppointmentDto>> response = new SuccessResponse<>(
				"Appointments fetched by doctor id successfully",
				HttpStatus.OK.value(),
				appointmentsById
				);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/search/by-date")
	public ResponseEntity<SuccessResponse<List<AppointmentDto>>> getAppointmentsByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate appointmentDate){
		List<AppointmentDto> appointmentsByDate = appointmentService.getAppointmentsByDate(appointmentDate);
		SuccessResponse<List<AppointmentDto>> response = new SuccessResponse<>(
				"Appointments fetched by date successfully",
				HttpStatus.OK.value(),
				appointmentsByDate
				);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/search/status")
	public ResponseEntity<SuccessResponse<List<AppointmentDto>>> getAppointmentsByStatus(@RequestParam String status){
		List<AppointmentDto> appointmentsByStatus = appointmentService.getAppointmentsByStatus(status);
		SuccessResponse<List<AppointmentDto>> response = new SuccessResponse<>(
				"Appointments fetched by status successfully",
				HttpStatus.OK.value(),
				appointmentsByStatus
				);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/doctors/{doctorId}/schedule")
	public ResponseEntity<SuccessResponse<List<AppointmentDto>>> getDoctorSchedule(@PathVariable Long doctorId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
		List<AppointmentDto> doctorSchedule = appointmentService.getDoctorSchedule(doctorId, date);
		SuccessResponse<List<AppointmentDto>> response = new SuccessResponse<>(
				"Doctor schedule retrieved successfully",
				HttpStatus.OK.value(),
				doctorSchedule
				);
		return ResponseEntity.ok(response);
	}
}
