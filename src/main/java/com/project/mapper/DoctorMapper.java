package com.project.mapper;

import com.project.dto.DoctorDto;
import com.project.entity.Doctor;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    //    Entity ➜ DTO
    DoctorDto toDto(Doctor doctor);

    //    List<Entity> ➜ List<Dto>
    List<DoctorDto> toDtoList(List<Doctor>  doctors);

    //    DTO ➜ Entity
    Doctor toEntity(DoctorDto doctorDto);

    //    List<DTO> ➜ List<Entity>(optional)
    List<Doctor> toEntityList(List<DoctorDto>  doctorDtos);


    void updateDoctorFromDto(DoctorDto dto, @MappingTarget Doctor entity);

























    /**
    public static DoctorDto mapToDto(Doctor doctor) {
        return new DoctorDto(
                doctor.getDoctorId(),
                doctor.getDoctorName(),
                doctor.getSpeciality(),
                doctor.getPhoneNumber(),
                doctor.getEmailId()
        );
    }

    public static Doctor mapToDoctor(DoctorDto doctorDto) {
        return new Doctor(
                doctorDto.getDoctorId(),
                doctorDto.getDoctorName(),
                doctorDto.getSpeciality(),
                doctorDto.getPhoneNumber(),
                doctorDto.getEmailId()
        );
    }
     */
}
