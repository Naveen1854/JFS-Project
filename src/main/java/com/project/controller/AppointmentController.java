package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AppointmentDto;
import com.project.service.AppointmentService;
import com.project.util.ErrorResponse;
import com.project.util.SuccessResponse;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@PostMapping
	public ResponseEntity<SuccessResponse<AppointmentDto>> saveAppointment(@RequestBody AppointmentDto appointmentDto) {
		AppointmentDto savedAppointment = appointmentService.saveAppointment(appointmentDto);
		SuccessResponse<AppointmentDto> response = new SuccessResponse<>(
				"Appointment Saved Successfully",
				HttpStatus.CREATED.value(), 
				savedAppointment
				);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<SuccessResponse<List<AppointmentDto>>> getAllAppointments(){
		List<AppointmentDto> appointments = appointmentService.getAllAppointments();
		SuccessResponse<List<AppointmentDto>> response = new SuccessResponse<>(
				"Appointments fetched Successfully",
				HttpStatus.OK.value(),
				appointments
				);
		return ResponseEntity.ok(response);
	}

    @GetMapping("/{appointmentId}")
    public ResponseEntity<SuccessResponse<AppointmentDto>> findAppointmentById(Long appointmentId){
        AppointmentDto dbAppointment = appointmentService.findAppointmentById(appointmentId);
        SuccessResponse<AppointmentDto> response = new SuccessResponse<>(
                "Appointment fetched Successfuly",
                HttpStatus.OK.value(),
                dbAppointment
        );
        return ResponseEntity.ok(response);
    }
}




























