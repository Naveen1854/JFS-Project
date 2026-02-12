package com.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "patientCare")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientCare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long careId;
    private String careType;
    private LocalDate careStartDate;
    private LocalDate careEndDate;
 
    private Long nurseId;
    private Long patientId;
}
