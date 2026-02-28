package com.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId;
	private String departmentName;
	private String location;

    @OneToMany(mappedBy = "department")
    private List<Doctor> doctors;

    @OneToMany(mappedBy = "department")
    private List<Nurse> nurses;

}
