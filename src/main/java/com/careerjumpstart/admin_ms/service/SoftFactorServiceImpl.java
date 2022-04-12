package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.SoftFactor;
import com.careerjumpstart.admin_ms.repository.SoftFactorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoftFactorServiceImpl implements SoftFactorService{

    @Autowired
    private final SoftFactorRepo softFactorRepo;

    public SoftFactorServiceImpl(SoftFactorRepo softFactorRepo) {
        this.softFactorRepo = softFactorRepo;
    }

    @Override
    public List<SoftFactor> findAll() {
        return softFactorRepo.findAll();
    }

    @Override
    public Optional<SoftFactor> findById(Long id) {
        return softFactorRepo.findSoftFactorById(id);
    }

    @Override
    public SoftFactor createSoftFactor(SoftFactor softFactor) {
        return softFactorRepo.save(softFactor);
    }

    @Override
    public SoftFactor updateSoftFactor(Long id, SoftFactor s) {
        Optional<SoftFactor> softFactor = findById(id);
        if(softFactor.isPresent()){
            softFactor.get().setTitle(s.getTitle());
            return softFactorRepo.save(softFactor.get());
        }
        else
        {
            return null;
        }
    }

    @Override
    public void deleteSoftFactor(Long id) {
        softFactorRepo.deleteById(id);
    }
}
