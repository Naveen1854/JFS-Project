package com.project.mapper;

import com.project.dto.PrescriptionDto;
import com.project.entity.Prescription;

public class PrescriptionMapper {

    public static PrescriptionDto mapToDto(Prescription prescription) {
        return new PrescriptionDto(
                prescription.getPrescriptionId(),
                prescription.getMedicineName(),
                prescription.getDosage(),
                prescription.getPrescriptionDate(),
                prescription.getPatientId(),
                prescription.getDoctorId()
        );
    }

    public static Prescription mapToPrescription(PrescriptionDto prescriptionDto) {
        return new Prescription(
                prescriptionDto.getPrescriptionId(),
                prescriptionDto.getMedicineName(),
                prescriptionDto.getDosage(),
                prescriptionDto.getPrescriptionDate(),
                prescriptionDto.getPatientId(),
                prescriptionDto.getDoctorId()
        );
    }
}
