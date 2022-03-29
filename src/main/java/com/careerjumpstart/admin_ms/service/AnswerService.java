package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Answer;
import com.careerjumpstart.admin_ms.models.Question;

import java.util.List;

public interface AnswerService {
    List<Answer> findAll();
    Answer findById(Long id);
}
