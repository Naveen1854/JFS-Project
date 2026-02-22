package com.project.mapper;

import com.project.dto.BillDto;
import com.project.entity.Bill;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillMapper {

    //    Entity ➜ DTO
    BillDto toDto(Bill bill);

    //    List<Entity> ➜ List<Dto>
    List<BillDto> toDtoList(List<Bill> bills);

    //    DTO ➜ Entity
    Bill toEntity(BillDto billDto);

    //    List<DTO> ➜ List<Entity>(optional)
    List<Bill> toEntityList(List<BillDto> billDtos);



























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
