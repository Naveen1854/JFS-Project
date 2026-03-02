package com.project.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDto {

	private Long prescriptionId;
	private String medicineName;
	private String dosage;
	private LocalDate prescriptionDate;
	private Long patientId;
	private Long doctorId;
}
