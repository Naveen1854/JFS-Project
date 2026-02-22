package com.project.mapper;

import com.project.dto.PrescriptionDto;
import com.project.entity.Prescription;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrescriptionMapper {


    //    Entity ➜ DTO
    PrescriptionDto toDto(Prescription prescription);

    //    List<Entity> ➜ List<Dto>
    List<PrescriptionDto> toDtoList(List<Prescription> prescriptions);

    //    DTO ➜ Entity
    Prescription toEntity(PrescriptionDto prescriptionDto);

    //    List<DTO> ➜ List<Entity>(optional)
    List<Prescription> toEntityList(List<PrescriptionDto> prescriptionDtos);



























    /**
    public static PrescriptionDto mapToDto(Prescription prescription) {
        return new PrescriptionDto(
                prescription.getPrescriptionId(),
                prescription.getMedicineName(),
                prescription.getDosage(),
                prescription.getPrescriptionDate(),
                prescription.getPatientId(),
                prescription.getDoctorId()
        );
    }

    public static Prescription mapToPrescription(PrescriptionDto prescriptionDto) {
        return new Prescription(
                prescriptionDto.getPrescriptionId(),
                prescriptionDto.getMedicineName(),
                prescriptionDto.getDosage(),
                prescriptionDto.getPrescriptionDate(),
                prescriptionDto.getPatientId(),
                prescriptionDto.getDoctorId()
        );
    }
     */
}
