package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();
    Question findById(Long id);
    Question createQ(Question q);
}
