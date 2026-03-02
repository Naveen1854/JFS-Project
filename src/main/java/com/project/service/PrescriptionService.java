package com.project.service;

import com.project.dto.PrescriptionDto;

import java.time.LocalDate;
import java.util.List;

public interface PrescriptionService {

    public PrescriptionDto getPrescriptionById(Long prescriptionId);

    public List<PrescriptionDto> getAllPrescriptions();

    public PrescriptionDto savePrescription(PrescriptionDto prescriptionDto);

    public PrescriptionDto updatePrescriptionById(Long prescriptionId, PrescriptionDto prescriptionDto);

    public PrescriptionDto deletePrescriptionById(Long prescriptionId);


    public List<PrescriptionDto> getPrescriptionsByPatientId(Integer patientId);

    public List<PrescriptionDto> getPrescriptionsByDoctorId(Integer doctorId);

    public List<PrescriptionDto> getPrescriptionsByDate(LocalDate prescriptionDate);

}