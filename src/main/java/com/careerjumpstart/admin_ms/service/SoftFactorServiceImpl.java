package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.models.SoftFactor;
import com.careerjumpstart.admin_ms.repository.QuestionRepo;
import com.careerjumpstart.admin_ms.repository.SoftFactorRepo;

import java.util.List;

public class SoftFactorServiceImpl implements SoftFactorService{

    private final SoftFactorRepo softFactorRepo;

    public SoftFactorServiceImpl(SoftFactorRepo softFactorRepo) {
        this.softFactorRepo = softFactorRepo;
    }

    @Override
    public List<SoftFactor> findAll() {
        return softFactorRepo.findAll();
    }

    @Override
    public SoftFactor findById(Long id) {
        return softFactorRepo.findSoftFactorBySfId(id);
    }
}
