package com.project.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDto {

    private Long paymentId;
    private double billAmount;
    private LocalDate billDate;
    private String paymentStatus;

    private Long patientId;

}
