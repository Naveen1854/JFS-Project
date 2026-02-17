package com.project.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
