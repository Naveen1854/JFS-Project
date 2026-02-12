package com.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

	private Long patientId;
	private String patientName;
	private int age;
	private String gender;
	private String contactNumber;
	private String address;
}
