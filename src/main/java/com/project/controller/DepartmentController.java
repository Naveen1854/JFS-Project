package com.project.controller;

import com.project.dto.DepartmentDto;
import com.project.entity.Department;
import com.project.service.DepartmentService;
import com.project.util.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<SuccessResponse<DepartmentDto>> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        SuccessResponse<DepartmentDto> response = new SuccessResponse<>(
                "Department saved successfully",
                HttpStatus.CREATED.value(),
                savedDepartment
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<SuccessResponse<List<DepartmentDto>>> getAllDepartments(){
       List<DepartmentDto> departments = departmentService.getAllDepartments();
       SuccessResponse<List<DepartmentDto>> response = new SuccessResponse<>(
               "All departments fetched successfully",
               HttpStatus.OK.value(),
               departments
       );
       return ResponseEntity.ok(response);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<SuccessResponse<DepartmentDto>> getDepartmentById(@PathVariable Long departmentId){
        DepartmentDto department = departmentService.getDepartmentById(departmentId);
        SuccessResponse<DepartmentDto> response = new SuccessResponse<>(
                "Department fetched successfully by id",
                HttpStatus.OK.value(),
                department
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<SuccessResponse<DepartmentDto>> updateDepartmentById(@PathVariable Long departmentId, @RequestBody DepartmentDto departmentDto){
        DepartmentDto updatedDepartment = departmentService.updateDepartmentById(departmentId, departmentDto);
        SuccessResponse<DepartmentDto> response = new SuccessResponse<>(
                "Department updated successfully by id",
                HttpStatus.OK.value(),
                updatedDepartment
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<SuccessResponse<DepartmentDto>> deleteDepartmentById(@PathVariable Long departmentId){
        DepartmentDto deletedDepartment = departmentService.deleteDepartmentById(departmentId);
        SuccessResponse<DepartmentDto> response = new SuccessResponse<>(
                "Department deleted successfully by id",
                HttpStatus.OK.value(),
                deletedDepartment
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/name/{departmentName}")
    public ResponseEntity<SuccessResponse<List<DepartmentDto>>> getDepartmentsByName(String departmentName){
        List<DepartmentDto> departments = departmentService.getDepartmentsByName(departmentName);
        SuccessResponse<List<DepartmentDto>> response = new SuccessResponse<>(
                "Departments fetched successfully by name",
                HttpStatus.OK.value(),
                departments
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/location/{location}")
    public ResponseEntity<SuccessResponse<List<DepartmentDto>>> getDepartmentByLocation(String location){
        List<DepartmentDto> departments = departmentService.getDepartmentsByLocation(location);
        SuccessResponse<List<DepartmentDto>> response = new SuccessResponse<>(
                "Departments fetched successfully by location",
                HttpStatus.OK.value(),
                departments
        );
        return ResponseEntity.ok(response);
    }
}
