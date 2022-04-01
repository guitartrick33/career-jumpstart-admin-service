package com.careerjumpstart.admin_ms.repository;

import com.careerjumpstart.admin_ms.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question, Long> {
    List<Question> findAll();
    Question findQuestionByQuestionId(Long questionId);
    @Override
    <S extends Question> S save(S entity);
}
