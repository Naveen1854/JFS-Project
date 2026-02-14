package com.project.mapper;

import com.project.dto.BillDto;
import com.project.entity.Bill;

public class BillMapper {

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
}
