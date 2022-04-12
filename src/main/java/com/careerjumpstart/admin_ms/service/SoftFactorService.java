package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.models.SoftFactor;

import java.util.List;
import java.util.Optional;

public interface SoftFactorService {
    List<SoftFactor> findAll();
    Optional<SoftFactor> findById(Long id);
    SoftFactor createSoftFactor(SoftFactor s);
    SoftFactor updateSoftFactor(Long id, SoftFactor s);
    void deleteSoftFactor(Long id);
}
