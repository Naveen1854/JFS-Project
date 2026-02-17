package com.project.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

//	All Appointments of patient
	List<Appointment> findByPatientId(Long patientId);

//	All Appointments of a doctor
	List<Appointment> findByDoctorId(Long doctorId);

//	Appointments on a particular date
	List<Appointment> findByAppointmentDate(LocalDate appointmentDate);

//	By status (Booked / Cancelled / Completed)
	List<Appointment> findByStatus(String status);

//  Doctor schedule on a date (VERY COMMON)
	List<Appointment> findByDoctorIdAndAppointmentDate(Long doctorId, LocalDate date);

//  Prevent past booking
	boolean existsByDoctorIdAndAppointmentDateAndAppointmentTime(Long doctorId, LocalDate appointmentDate, LocalTime time);
}
