package com.project.dto;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
