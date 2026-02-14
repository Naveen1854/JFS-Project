package com.project.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NurseDto {

	private Long nurseId;
	private String nurseName;
	private String phoneNumber;
	private String emailId;

//	private Department department;
}
