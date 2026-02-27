package com.project.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.util.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ErrorResponse> buildErrorResponse(String message, HttpStatus status) {
        ErrorResponse error = new ErrorResponse(
                message,
                status.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(status).body(error);
    }


	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlePatientNotFound(PatientNotFoundException exception) {
//		ErrorResponse error = new ErrorResponse(
//				exception.getMessage(),
//				HttpStatus.NOT_FOUND.value(),
//				LocalDateTime.now()
//			);
		return buildErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleAppointmentNotFound(AppointmentNotFoundException exception) {
		return buildErrorResponse(
                exception.getMessage(),
                HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SlotAlreadyBookedException.class)
	public ResponseEntity<ErrorResponse> handleSlotAlreadyBooked(SlotAlreadyBookedException exception){
		return buildErrorResponse(
                exception.getMessage(),
                HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleDoctorNotFound(DoctorNotFoundException exception){
		return buildErrorResponse(
                exception.getMessage(),
                HttpStatus.NOT_FOUND);
	}

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResponse> handleValidationException(
//            MethodArgumentNotValidException ex) {
//        String message = ex.getBindingResult()
//                .getFieldError()
//                .getDefaultMessage();
//        return buildErrorResponse(message, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception exception) {
        return buildErrorResponse(
                "Something went wrong. Please try again later.",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
