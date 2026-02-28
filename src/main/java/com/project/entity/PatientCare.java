package com.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patientCare")
public class PatientCare {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long careId;
	private String careType;
	private LocalDate careStartDate;
	private LocalDate careEndDate;

    @ManyToOne
    @JoinColumn(name = "nurse_id")
    private Nurse nurse;

    @ManyToOne
    @JoinColumn(name = "patient_id")
	private Patient patient;
}
