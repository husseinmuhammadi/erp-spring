package com.digiboy.erp.repository;

import com.digiboy.erp.to.Employee;
import com.digiboy.erp.to.PayStub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayStubRepository extends JpaRepository<PayStub, Long> {
}
