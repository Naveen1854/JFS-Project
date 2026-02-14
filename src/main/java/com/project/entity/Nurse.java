package com.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nurses")
public class Nurse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nurseId;
	private String nurseName;
	private String phoneNumber;
	private String emailId;


//	@ManyToOne
//    @JoinColumn(name = "department_department_id")
//    private Department department;

}
