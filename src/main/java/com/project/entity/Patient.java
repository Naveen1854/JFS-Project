package com.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;
	private String patientName;
	private int age;
	private String gender;
	private String contactNumber;
	private String address;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment>  appointments;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Prescription>   prescriptions;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Bill> bills;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<PatientCare> patientCares;
}
