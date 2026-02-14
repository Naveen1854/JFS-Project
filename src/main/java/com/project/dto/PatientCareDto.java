package com.project.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientCareDto {

	private Long careId;
	private String careType;
	private LocalDate careStartDate;
	private LocalDate careEndDate;

	private Long nurseId;
	private Long patientId;
}
