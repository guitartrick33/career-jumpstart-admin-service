package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.models.SoftFactor;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> findAll();
    Optional<Question> findById(Long id);
    Optional <List<Question>> findBySoftFactorId(Long softFactorId);
//    Optional <List<Question>> findAllByRoleIdAndBySoftFactor_SoftFactorId(Long roleId, Long sfId);

//    Optional <List<Question>> findAllBySoftFactorAndAndRoleId(Long softFactor, Long roleId);

    Optional <List<Question>> findAllBySoftFactorIdAndRoleId(Long softFactorId, Long roleId);

    Question createQuestion(Question q);
    Question updateQuestion(Long id, Question q);
    void deleteQuestion(Long id);
}
