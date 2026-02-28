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
	List<Appointment> findByPatientPatientId(Long patientId);

//	All Appointments of a doctor
	List<Appointment> findByDoctorDoctorId(Long doctorId);

//	Appointments on a particular date
	List<Appointment> findByAppointmentDate(LocalDate appointmentDate);

//	By status (Booked / Cancelled / Completed)
	List<Appointment> findByStatus(String status);

//  Doctor schedule on a date (VERY COMMON)
List<Appointment> findByDoctorDoctorIdAndAppointmentDate(Long doctorId, LocalDate appointmentDate);

//  Prevent past booking
boolean existsByDoctorDoctorIdAndAppointmentDateAndAppointmentTime(
        Long doctorId,
        LocalDate appointmentDate,
        LocalTime appointmentTime);
}
