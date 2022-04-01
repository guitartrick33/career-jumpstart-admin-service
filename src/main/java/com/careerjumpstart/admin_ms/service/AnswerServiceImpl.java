package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Answer;
import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.repository.AnswerRepo;
import com.careerjumpstart.admin_ms.repository.QuestionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepo answerRepo;

    public AnswerServiceImpl(AnswerRepo answerRepo) {
        this.answerRepo = answerRepo;
    }

    @Override
    public List<Answer> findAll() {
        return answerRepo.findAll();
    }

    @Override
    public Answer findById(Long id) {
        return answerRepo.findAnswerByAnswerId(id);
    }
}
