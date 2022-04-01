package com.careerjumpstart.admin_ms.repository;

import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.models.SoftFactor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoftFactorRepo extends JpaRepository<SoftFactor, Long> {
    List<SoftFactor> findAll();
    SoftFactor findSoftFactorBySfId(Long sfId);
}
