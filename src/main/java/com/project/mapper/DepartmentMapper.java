package com.project.mapper;

import com.project.dto.DepartmentDto;
import com.project.entity.Department;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {


    //    Entity ➜ DTO
    DepartmentDto toDto(Department department);

    //    List<Entity> ➜ List<Dto>
    List<DepartmentDto> toDtoList(List<Department> departments);

    //    DTO ➜ Entity
    Department toEntity(DepartmentDto departmentDto);

    //    List<DTO> ➜ List<Entity>(optional)
    List<Department> toEntityList(List<DepartmentDto>  departmentDtos);

    @Mapping(target = "departmentId", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDepartmentFromDto(DepartmentDto dto, @MappingTarget Department entity);




























    /**
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
     */
}
