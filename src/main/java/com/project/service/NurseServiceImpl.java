package com.project.service;

import com.project.dto.NurseDto;
import com.project.entity.Department;
import com.project.entity.Nurse;
import com.project.exception.DepartmentNotFoundException;
import com.project.exception.NurseNotFoundException;
import com.project.mapper.NurseMapper;
import com.project.repository.DepartmentRepository;
import com.project.repository.NurseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class NurseServiceImpl implements NurseService {

    private final NurseRepository nurseRepository;
    private final NurseMapper nurseMapper;
    private final DepartmentRepository departmentRepository;


    @Override
    public NurseDto saveNurse(NurseDto nurseDto) {
        Nurse nurse = nurseMapper.toEntity(nurseDto);
        if (nurseDto.getDepartmentId() != null) {
            Department department = departmentRepository.findById(nurseDto.getDepartmentId())
                    .orElseThrow(() -> new DepartmentNotFoundException("Department not found with Id " + nurseDto.getDepartmentId()));
            nurse.setDepartment(department);
        }
        Nurse savedNurse = nurseRepository.save(nurse);
        return nurseMapper.toDto(savedNurse);
    }

    @Override
    public List<NurseDto> getAllNurses() {
        List<Nurse> nurses = nurseRepository.findAll();
        return nurseMapper.toDtoList(nurses);
    }

    @Override
    public NurseDto getNurseById(Long nurseId) {
        Nurse nurse = nurseRepository.findById(nurseId)
                .orElseThrow(() -> new NurseNotFoundException("Nurse not found with Id " + nurseId));
        return nurseMapper.toDto(nurse);
    }

    @Override
    public NurseDto updateNurseById(Long nurseId, NurseDto nurseDto) {
        Nurse existingNurse = nurseRepository.findById(nurseId)
                .orElseThrow(() -> new NurseNotFoundException("Nurse not found with Id " + nurseId));
        nurseMapper.updateNurseFromDto(nurseDto, existingNurse);
        if (nurseDto.getDepartmentId() != null) {
            Department department = departmentRepository.findById(nurseDto.getDepartmentId())
                    .orElseThrow(() -> new DepartmentNotFoundException("Department not found with ID: " + nurseDto.getDepartmentId()));
            existingNurse.setDepartment(department);
        }
        Nurse updatedNurse = nurseRepository.save(existingNurse);
        return nurseMapper.toDto(updatedNurse);
    }

    @Override
    public NurseDto deleteNurseById(Long nurseId) {
        Nurse nurse = nurseRepository.findById(nurseId)
                .orElseThrow(() -> new NurseNotFoundException("Nurse not found with Id " + nurseId));
        NurseDto deletedNurse = nurseMapper.toDto(nurse);
        nurseRepository.delete(nurse);
        return deletedNurse;
    }

    @Override
    public NurseDto getNurseByEmailId(String emailId) {
        Nurse nurse = nurseRepository.findByEmailId(emailId)
                .orElseThrow(() -> new NurseNotFoundException("Nurse not found with email: " + emailId));
        return nurseMapper.toDto(nurse);
    }

    @Override
    public List<NurseDto> getNursesByName(String nurseName) {
        return nurseMapper.toDtoList(nurseRepository.findByNurseName(nurseName));
    }

    @Override
    public List<NurseDto> getNursesByDepartmentId(Long departmentId) {
        return nurseMapper.toDtoList(nurseRepository.findByDepartmentDepartmentId(departmentId));
    }
}
