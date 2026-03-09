package com.project.repository;

import com.project.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    // Get all bills of a particular patient
    List<Bill> findByPatientPatientId(Long patientId);

    // Get bills by payment status (PAID, PENDING, etc.)
    List<Bill> findByPaymentStatus(String paymentStatus);
}
