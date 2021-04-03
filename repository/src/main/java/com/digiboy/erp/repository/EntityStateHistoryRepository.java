package com.digiboy.erp.repository;

import com.digiboy.erp.to.EntityStateHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityStateHistoryRepository extends JpaRepository<EntityStateHistory, Long> {
}
