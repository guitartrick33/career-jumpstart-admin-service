package com.careerjumpstart.admin_ms.repository;

import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.models.SoftFactor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SoftFactorRepo extends JpaRepository<SoftFactor, Long> {
    @Override
    List<SoftFactor> findAll();

//    Optional<SoftFactor> findSoftFactorById(Long id);
    Optional<SoftFactor> findSoftFactorById(Long id);

    @Override
    <F extends SoftFactor> F save(F entity);
}
