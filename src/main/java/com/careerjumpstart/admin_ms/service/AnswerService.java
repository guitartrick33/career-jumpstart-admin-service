package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Answer;
import com.careerjumpstart.admin_ms.models.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    List<Answer> findAll();
    Optional<Answer> findById(Long id);
    Optional<Answer> findByQuestionId(Long id);
    Answer createA(Answer a);
    Answer updateA(Long id, Answer a);
    void deleteA(Long id);
}
