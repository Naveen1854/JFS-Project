package com.project.service;

import com.project.dto.PatientCareDto;

import java.time.LocalDate;
import java.util.List;

public interface PatientCareService {

    PatientCareDto getPatientCareById(Long careId);

    List<PatientCareDto> getAllPatientCares();

    PatientCareDto savePatientCare(PatientCareDto patientCareDto);

    PatientCareDto updatePatientCareById(Long careId, PatientCareDto patientCareDto);

    PatientCareDto deletePatientCareById(Long careId);

    // Extra query methods
    List<PatientCareDto> getPatientCaresByPatientId(Integer patientId);

    List<PatientCareDto> getPatientCaresByNurseId(Integer nurseId);

    List<PatientCareDto> getPatientCaresByStartDate(LocalDate startDate);
}
