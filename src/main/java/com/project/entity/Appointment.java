package com.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appointmentId;

	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	private String status;

    @ManyToOne
    @JoinColumn(name="patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_id", nullable = false)
    private Doctor doctor;

}
