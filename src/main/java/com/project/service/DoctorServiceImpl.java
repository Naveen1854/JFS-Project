package com.project.service;

import com.project.dto.DoctorDto;
import com.project.dto.PrescriptionDto;
import com.project.entity.Doctor;
import com.project.entity.Prescription;
import com.project.exception.DoctorNotFoundException;
import com.project.exception.PrescriptionNotFoundException;
import com.project.mapper.DoctorMapper;
import com.project.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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


    @Override
    public List<DoctorDto> getByDoctorName(String doctorName) {
        List<Doctor> dbDoctors = doctorRepository.findByDoctorName(doctorName);
        if (dbDoctors.isEmpty()) {
            throw new DoctorNotFoundException("Doctor Not Found with name: " + doctorName);
        }
        return doctorMapper.toDtoList(dbDoctors);
    }

    @Override
    public List<DoctorDto> getBySpeciality(String speciality) {
        List<Doctor> dbDoctors = doctorRepository.findBySpeciality(speciality);
        if (dbDoctors.isEmpty()) {
            throw new DoctorNotFoundException("Doctor Not Found with speciality: " + speciality);
        }
        return doctorMapper.toDtoList(dbDoctors);
    }

    @Override
    public DoctorDto getByEmailId(String emailId) {
        Doctor dbDoctor = doctorRepository.findByEmailId(emailId);
        if (dbDoctor == null) {
            throw new DoctorNotFoundException("Doctor Not Found with emailId: " + emailId);
        }
        return doctorMapper.toDto(dbDoctor);
    }

    @Override
    public DoctorDto getByPhoneNumber(String phoneNumber) {
        Doctor dbDoctor = doctorRepository.findByPhoneNumber(phoneNumber);
        if (dbDoctor == null) {
            throw new DoctorNotFoundException("Doctor Not Found with phoneNumber: " + phoneNumber);
        }
        return doctorMapper.toDto(dbDoctor);
    }

    @Override
    public List<DoctorDto> getByDepartmentDepartmentId(Long departmentId) {
        List<Doctor> dbDoctors = doctorRepository.findByDepartmentDepartmentId(departmentId);
        if (dbDoctors.isEmpty()) {
            throw new DoctorNotFoundException("Doctor Not Found with departmentId: " + departmentId);
        }
        return doctorMapper.toDtoList(dbDoctors);
    }

    @Override
    public List<DoctorDto> getByDoctorNameAndSpeciality(String doctorName, String speciality) {
        List<Doctor> dbDoctors = doctorRepository.findByDoctorNameAndSpeciality(doctorName, speciality);
        if (dbDoctors.isEmpty()) {
            throw new DoctorNotFoundException("Doctor Not Found with speciality: " + speciality + " and doctorName: " + doctorName);
        }
        return doctorMapper.toDtoList(dbDoctors);
    }

    @Override
    public List<DoctorDto> getBySpecialityAndDepartmentDepartmentId(String speciality, Long departmentId) {
        List<Doctor> dbDoctors = doctorRepository.findBySpecialityAndDepartmentDepartmentId(speciality, departmentId);
        if (dbDoctors.isEmpty()) {
            throw new DoctorNotFoundException(
                    "Doctor Not Found with speciality: " + speciality + " and departmentId: " + departmentId
            );
        }
        return doctorMapper.toDtoList(dbDoctors);
    }
}
