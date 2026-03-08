package com.project.service;

import com.project.dto.NurseDto;

import java.util.List;

public interface NurseService {

    NurseDto saveNurse(NurseDto nurseDto);

    List<NurseDto> getAllNurses();

    NurseDto getNurseById(Long nurseId);

    NurseDto updateNurseById(Long nurseId, NurseDto nurseDto);

    NurseDto deleteNurseById(Long nurseId);

    NurseDto getNurseByEmailId(String emailId);

    List<NurseDto> getNursesByName(String nurseName);

    List<NurseDto> getNursesByDepartmentId(Long departmentId);
}
