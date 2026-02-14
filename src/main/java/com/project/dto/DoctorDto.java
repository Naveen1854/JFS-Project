package com.project.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

	private Long doctorId;
	private String doctorName;
	private String speciality;
	private String phoneNumber;
	private String emailId;

}
