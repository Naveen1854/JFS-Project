package com.project.service;

import com.project.dto.DepartmentDto;
import com.project.entity.Department;
import com.project.exception.DepartmentDeletionException;
import com.project.exception.DepartmentNotFoundException;
import com.project.mapper.DepartmentMapper;
import com.project.repository.DepartmentRepository;
import com.project.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    private final DoctorRepository  doctorRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = departmentMapper.toEntity(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return departmentMapper.toDto(savedDepartment);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departmentMapper.toDtoList(departments);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new DepartmentNotFoundException("Department with id: " + departmentId + " not found!"));
        return departmentMapper.toDto(department);
    }

    @Override
    public DepartmentDto updateDepartmentById(Long departmentId, DepartmentDto departmentDto) {
        Department existingDepartment = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new DepartmentNotFoundException("Department with id: " + departmentId + " not found!"));
        departmentMapper.updateDepartmentFromDto(departmentDto, existingDepartment);
        Department updatedDepartment = departmentRepository.save(existingDepartment);
        return departmentMapper.toDto(updatedDepartment);
    }

    @Override
    public DepartmentDto deleteDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new DepartmentNotFoundException("Department with id: " + departmentId + " not found!"));
        if (doctorRepository.existsByDepartmentDepartmentId(departmentId)) {
            throw new DepartmentDeletionException("Cannot delete department because doctors are assigned");
        }
        DepartmentDto deletedDto = departmentMapper.toDto(department);
        departmentRepository.deleteById(departmentId);
        return deletedDto;
    }

    @Override
    public List<DepartmentDto> getDepartmentsByName(String departmentName) {
        List<Department> department = departmentRepository.findByDepartmentName(departmentName);
        return departmentMapper.toDtoList(department);
    }

    @Override
    public List<DepartmentDto> getDepartmentsByLocation(String location) {
        List<Department> departments = departmentRepository.findByLocation(location);
        return departmentMapper.toDtoList(departments);
    }
}
