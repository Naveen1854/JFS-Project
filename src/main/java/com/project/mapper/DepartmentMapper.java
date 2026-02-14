package com.project.mapper;

import com.project.dto.DepartmentDto;
import com.project.entity.Department;

public class DepartmentMapper {

    public static DepartmentDto mapToDto(Department department) {
        return new DepartmentDto(
                department.getDepartmentId(),
                department.getDepartmentName(),
                department.getLocation()
        );
    }

    public static Department mapToDepartment(DepartmentDto departmentDto) {
        return new Department(
                departmentDto.getDepartmentId(),
                departmentDto.getDepartmentName(),
                departmentDto.getLocation()
        );
    }
}
