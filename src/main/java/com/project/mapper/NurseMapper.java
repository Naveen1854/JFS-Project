package com.project.mapper;

import com.project.dto.NurseDto;
import com.project.entity.Nurse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NurseMapper {


    //    Entity ➜ DTO
    NurseDto toDto(Nurse nurse);

    //    List<Entity> ➜ List<Dto>
    List<NurseDto> toDtoList(List<Nurse> nurses);

    //    DTO ➜ Entity
    Nurse toEntity(NurseDto nurseDto);

    //    List<DTO> ➜ List<Entity>(optional)
    List<Nurse> toEntityList(List<NurseDto> nurses);


























    /**
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
     */
}
