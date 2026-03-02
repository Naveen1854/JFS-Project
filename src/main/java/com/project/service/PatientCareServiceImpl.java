package com.project.service;

import com.project.dto.PatientCareDto;
import com.project.entity.Nurse;
import com.project.entity.Patient;
import com.project.entity.PatientCare;
import com.project.exception.NurseNotFoundException;
import com.project.exception.PatientCareNotFoundException;
import com.project.exception.PatientNotFoundException;
import com.project.mapper.PatientCareMapper;
import com.project.repository.NurseRepository;
import com.project.repository.PatientCareRepository;
import com.project.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Transactional
@Service
public class PatientCareServiceImpl implements PatientCareService {

    private final PatientCareRepository patientCareRepository;
    private final PatientCareMapper patientCareMapper;
    private final PatientRepository patientRepository;
    private final NurseRepository nurseRepository;

    @Override
    public PatientCareDto getPatientCareById(Long careId) {
        PatientCare patientCare = patientCareRepository.findById(careId)
                .orElseThrow(() -> new PatientCareNotFoundException("PatientCare not found with ID: " + careId));
        return patientCareMapper.toDto(patientCare);
    }

    @Override
    public List<PatientCareDto> getAllPatientCares() {
        List<PatientCare> patientCares = patientCareRepository.findAll();
        if (patientCares.isEmpty()) {
            throw new PatientCareNotFoundException("No PatientCare records found");
        }
        return patientCareMapper.toDtoList(patientCares);
    }

    @Override
    public PatientCareDto savePatientCare(PatientCareDto patientCareDto) {
        PatientCare patientCare = patientCareMapper.toEntity(patientCareDto);
        Patient patient = patientRepository.findById(patientCareDto.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + patientCareDto.getPatientId()));
        Nurse nurse = nurseRepository.findById(patientCareDto.getNurseId())
                .orElseThrow(() -> new NurseNotFoundException("Nurse not found with id: " +  patientCareDto.getNurseId()));
        patientCare.setPatient(patient);
        patientCare.setNurse(nurse);
        PatientCare saved = patientCareRepository.save(patientCare);
        return patientCareMapper.toDto(saved);
    }

    @Override
    public PatientCareDto updatePatientCareById(Long careId, PatientCareDto patientCareDto) {
        PatientCare existing = patientCareRepository.findById(careId)
                .orElseThrow(() -> new PatientCareNotFoundException("PatientCare not found with ID: " + careId));
        patientCareMapper.updatePatientCareFromDto(patientCareDto, existing);
        PatientCare updated = patientCareRepository.save(existing);
        return patientCareMapper.toDto(updated);
    }

    @Override
    public PatientCareDto deletePatientCareById(Long careId) {
        PatientCare patientCare = patientCareRepository.findById(careId)
                .orElseThrow(() -> new PatientCareNotFoundException("PatientCare not found with ID: " + careId));
        patientCareRepository.delete(patientCare);
        return patientCareMapper.toDto(patientCare);
    }

    @Override
    public List<PatientCareDto> getPatientCaresByPatientId(Integer patientId) {
        List<PatientCare> patientCares = patientCareRepository.findByPatient_PatientId(patientId);
        if (patientCares.isEmpty()) {
            throw new PatientCareNotFoundException("No PatientCare records found for patient ID: " + patientId);
        }
        return patientCareMapper.toDtoList(patientCares);
    }

    @Override
    public List<PatientCareDto> getPatientCaresByNurseId(Integer nurseId) {
        List<PatientCare> patientCares = patientCareRepository.findByNurse_NurseId(nurseId);
        if (patientCares.isEmpty()) {
            throw new PatientCareNotFoundException("No PatientCare records found for nurse ID: " + nurseId);
        }
        return patientCareMapper.toDtoList(patientCares);
    }

    @Override
    public List<PatientCareDto> getPatientCaresByStartDate(LocalDate startDate) {
        List<PatientCare> patientCares = patientCareRepository.findByCareStartDate(startDate);
        if (patientCares.isEmpty()) {
            throw new PatientCareNotFoundException("No PatientCare records found for Start Date" + startDate);
        }
        return patientCareMapper.toDtoList(patientCares);
    }
}