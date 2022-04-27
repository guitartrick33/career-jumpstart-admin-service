package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Answer;
import com.careerjumpstart.admin_ms.models.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    List<Answer> findAll();
    Optional<Answer> findById(Long id);
    List<Answer> findByQuestionId(Long questionId);
    List<Answer> findByUsername(String username);
    Optional<Answer> findByUsernameAndQuestionId(String username, Long questionId);
    Answer createAnswer(Answer a);
    Answer updateAnswer(Long id, Answer a);
    void deleteAnswer(Long id);
    boolean exists(Long id);
}
