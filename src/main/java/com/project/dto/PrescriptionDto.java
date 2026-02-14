package com.project.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDto {

	private Long prescriptionId;
	private String medicineName;
	private String dosage;
	private LocalDate prescriptionDate;
	private Integer patientId;
	private Integer doctorId;
}
