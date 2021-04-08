package com.digiboy.erp.repository;

import com.digiboy.erp.to.PayStubItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayStubItemRepository extends JpaRepository<PayStubItem, Long> {
}
