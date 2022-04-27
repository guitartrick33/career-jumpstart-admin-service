package com.careerjumpstart.admin_ms.repository;

import com.careerjumpstart.admin_ms.models.Answer;
import com.careerjumpstart.admin_ms.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnswerRepo extends JpaRepository<Answer, Long> {
    List<Answer> findAll();
    Optional<Answer> findAnswerById(Long id);
    List<Answer> findAnswerByQuestionId(Long questionId);
    List<Answer> findAnswerByUsername(String username);
    Optional<Answer> findAnswerByUsernameAndQuestionId(String username, Long questionId);
}
