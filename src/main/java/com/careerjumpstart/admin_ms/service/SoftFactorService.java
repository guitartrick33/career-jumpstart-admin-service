package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.models.SoftFactor;

import java.util.List;

public interface SoftFactorService {
    List<SoftFactor> findAll();
    SoftFactor findById(Long id);
}
