package com.project.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.util.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlePatientNotFound(PatientNotFoundException exception) {
		ErrorResponse error = new ErrorResponse(
				exception.getMessage(), 
				HttpStatus.NOT_FOUND.value(),
				LocalDateTime.now()
			);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleAppointmentNotFound(AppointmentNotFoundException exception) {
		ErrorResponse error = new ErrorResponse<>(
				exception.getMessage(), 
				HttpStatus.NOT_FOUND.value(),
				LocalDateTime.now()
						);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SlotAlreadyBookedException.class)
	public ResponseEntity<ErrorResponse> handleSlotAlreadyBooked(SlotAlreadyBookedException exception){
		ErrorResponse error = new ErrorResponse<>(
				exception.getMessage(),
				HttpStatus.CONFLICT.value(),
				LocalDateTime.now()
				);
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleDoctorNotFound(DoctorNotFoundException exception){
		ErrorResponse error = new ErrorResponse<>(
				exception.getMessage(),
				HttpStatus.NOT_FOUND.value(),
				LocalDateTime.now()
				);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
