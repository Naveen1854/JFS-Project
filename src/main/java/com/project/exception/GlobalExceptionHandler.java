package com.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.util.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<ErrorResponse<String>> handlePatientNotFound(PatientNotFoundException ex) {
		ErrorResponse<String> errorResponse = new ErrorResponse<>(
				ex.getMessage(),
				HttpStatus.NOT_FOUND.value(),
				null
			);

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}
}
