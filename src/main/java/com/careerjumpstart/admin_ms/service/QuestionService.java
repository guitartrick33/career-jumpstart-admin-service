package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> findAll();
    Optional<Question> findById(Long id);
    Optional <List<Question>> findBySfId(Long id);
    Question createQ(Question q);
    Question updateQ(Long id, Question q);
    void deleteQ(Long id);
}
