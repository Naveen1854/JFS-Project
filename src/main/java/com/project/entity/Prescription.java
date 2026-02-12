package com.project.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;
    private String medicineName;
    private String dosage;
    private LocalDate prescriptionDate;
    private Integer patientId;
	private Integer doctorId;
}
