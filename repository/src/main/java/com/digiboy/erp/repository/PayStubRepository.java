package com.digiboy.erp.repository;

import com.digiboy.erp.to.PayStub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayStubRepository extends JpaRepository<PayStub, Long> {
    // fixme change to employee and pay date
    List<PayStub> findAllByEmployeeCodeAndPayDate(String employeeCode, String payDate);
}
