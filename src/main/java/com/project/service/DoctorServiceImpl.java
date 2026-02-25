package com.project.service;

import com.project.dto.DoctorDto;
import com.project.entity.Doctor;
import com.project.exception.DoctorNotFoundException;
import com.project.mapper.DoctorMapper;
import com.project.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    /*
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorMapper doctorMapper;
     */


    @Override
    public DoctorDto saveDoctor(DoctorDto doctorDto) {
        Doctor doctor = doctorMapper.toEntity(doctorDto);
        Doctor saved = doctorRepository.save(doctor);
        return doctorMapper.toDto(saved);
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> dbDoctors = doctorRepository.findAll();
        return doctorMapper.toDtoList(dbDoctors);
    }

    @Override
    public DoctorDto getDoctorById(Long doctorId) {
        Doctor dbDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor Not Found with ID: " + doctorId));
        return doctorMapper.toDto(dbDoctor);
    }

    @Override
    public DoctorDto updateDoctorById(Long doctorId, DoctorDto newDoctorDto) {
        Doctor dbDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor Not Found with ID: " + doctorId));
        doctorMapper.updateDoctorFromDto(newDoctorDto, dbDoctor);
        Doctor updatedDoctor = doctorRepository.save(dbDoctor);
        return doctorMapper.toDto(updatedDoctor);
    }

    @Override
    public DoctorDto deleteDoctorById(Long doctorId) {
        Doctor dbDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor Not Found with ID: " + doctorId));
        DoctorDto dto = doctorMapper.toDto(dbDoctor);
        doctorRepository.delete(dbDoctor);
        return dto;
    }
}
