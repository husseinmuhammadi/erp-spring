package com.digiboy.erp.repository;

import com.digiboy.erp.to.DeductionPayStubItem;
import com.digiboy.erp.to.PayStubItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeductionPayStubItemRepository extends JpaRepository<DeductionPayStubItem, Long> {
}
