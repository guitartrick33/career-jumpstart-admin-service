package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Answer;
import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.repository.AnswerRepo;
import com.careerjumpstart.admin_ms.repository.QuestionRepo;

import java.util.List;
import java.util.Optional;

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
    public Optional<Answer> findById(Long id) {
        return answerRepo.findAnswerByAnswerId(id);
    }

    @Override
    public Optional<Answer> findByQuestionId(Long id) {
        return answerRepo.findAnswerByQuestionId_questionId(id);
    }

    @Override
    public Answer createA(Answer a) {
        return answerRepo.save(a);
    }

    @Override
    public Answer updateA(Long id, Answer a) {
        Optional<Answer> answer = findById(id);
        if(answer.isPresent()){
            answer.get().setContent(a.getContent());
            return answerRepo.save(answer.get());
        }
        else
        {
            return null;
        }
    }

    @Override
    public void deleteA(Long id) {
        answerRepo.deleteById(id);
    }
}
