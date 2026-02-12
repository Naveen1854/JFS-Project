package com.project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patient")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String patientName;
    private int age;
    private String gender;
    private String contactNumber;
    private String address;

}
