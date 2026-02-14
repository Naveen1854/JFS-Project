package com.project.mapper;

import com.project.dto.NurseDto;
import com.project.entity.Nurse;

public class NurseMapper {

    public static NurseDto mapToDto(Nurse nurse) {
        return new NurseDto(
                nurse.getNurseId(),
                nurse.getNurseName(),
                nurse.getPhoneNumber(),
                nurse.getEmailId()
        );
    }

    public static Nurse mapToNurse(NurseDto nurseDto) {
        return new Nurse(
                nurseDto.getNurseId(),
                nurseDto.getNurseName(),
                nurseDto.getPhoneNumber(),
                nurseDto.getEmailId()
        );
    }
}
