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
    List<Answer> saveAnswers(List<Answer> answers);
    Answer updateAnswer(Long id, Answer a);
    List<Answer> updateAnswers(List<Answer> answers);
    void deleteAnswer(Long id);
    void deleteAnswers(List<Answer> answers);
    boolean exists(Long id);
}
