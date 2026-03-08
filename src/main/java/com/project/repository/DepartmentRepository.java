package com.project.repository;

import com.project.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    List<Department> findByDepartmentName(String departmentName);

    List<Department> findByLocation(String location);

}
