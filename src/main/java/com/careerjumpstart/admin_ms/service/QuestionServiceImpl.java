package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.repository.QuestionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepo questionRepo;

    public QuestionServiceImpl(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @Override
    public List<Question> findAll() {
       return questionRepo.findAll();
    }

    @Override
    public Question findById(Long id) {
        return questionRepo.findQuestionByQuestionId(id);
    }
}
