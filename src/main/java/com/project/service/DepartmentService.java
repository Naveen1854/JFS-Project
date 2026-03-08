package com.project.service;

import com.project.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto getDepartmentById(Long departmentId);

    DepartmentDto updateDepartmentById(Long departmentId, DepartmentDto departmentDto);

    DepartmentDto deleteDepartmentById(Long departmentId);

    List<DepartmentDto> getDepartmentsByName(String departmentName);

    List<DepartmentDto> getDepartmentsByLocation(String location);
}
