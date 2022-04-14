package com.careerjumpstart.admin_ms.repository;

import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.models.SoftFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepo extends JpaRepository<Question, Long> {

    @Override
    List<Question> findAll();

//    Optional<Question> findQuestionById(Long id);
    Optional<Question> findQuestionById(Long id);

    Optional <List<Question>> findAllBySoftFactorId(Long softFactorId);
    //Optional <List<Question>> findQuestionBySoftFactor_IOrderBySfId(Long id);
    Optional <List<Question>> findAllBySoftFactorIdAndRoleId(Long softFactorId, Long roleId);

    @Override
    <S extends Question> S save(S entity);
}
