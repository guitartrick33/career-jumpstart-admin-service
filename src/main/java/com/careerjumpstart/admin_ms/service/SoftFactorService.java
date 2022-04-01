package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.models.SoftFactor;

import java.util.List;
import java.util.Optional;

public interface SoftFactorService {
    List<SoftFactor> findAll();
    Optional<SoftFactor> findById(Long id);
    SoftFactor createS(SoftFactor s);
    SoftFactor updateS(Long id, SoftFactor s);
    void deleteS(Long id);
}
