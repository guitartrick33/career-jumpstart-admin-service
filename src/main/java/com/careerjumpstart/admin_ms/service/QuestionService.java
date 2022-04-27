package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> findAll();
    Optional<Question> findById(Long id);
    List<Question> findBySoftFactorId(Long softFactorId);
    List<Question> findAllBySoftFactorIdAndRoleId(Long softFactorId, Long roleId);
    Question createQuestion(Question q);
    Question updateQuestion(Long id, Question q);
    void deleteQuestion(Long id);
    boolean exists(Long id);
}
