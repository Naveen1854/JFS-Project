package com.project.mapper;

import com.project.dto.BillDto;
import com.project.entity.Bill;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillMapper {

    //    Entity ➜
    @Mapping(source = "patient.patientId", target = "patientId")
    BillDto toDto(Bill bill);

    //    List<Entity> ➜ List<Dto>
    List<BillDto> toDtoList(List<Bill> bills);

    //    DTO ➜ Entity
    @Mapping(source = "patientId", target = "patient.patientId")
    Bill toEntity(BillDto billDto);

    //    List<DTO> ➜ List<Entity>(optional)
    List<Bill> toEntityList(List<BillDto> billDtos);

    @Mapping(target = "paymentId", ignore = true)
    @Mapping(target = "patient", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBillFromDto(BillDto dto, @MappingTarget Bill entity);


























    /**
    public static BillDto mapToDto(Bill bill) {
        return new BillDto(
                bill.getPaymentId(),
                bill.getBillAmount(),
                bill.getBillDate(),
                bill.getPaymentStatus(),
                bill.getPatientId()
        );
    }

    public static Bill mapToBill(BillDto billDto) {
        return new Bill(
                billDto.getPaymentId(),
                billDto.getBillAmount(),
                billDto.getBillDate(),
                billDto.getPaymentStatus(),
                billDto.getPatientId()
        );
    }
     */
}
