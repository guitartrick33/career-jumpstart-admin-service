package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Answer;
import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.repository.AnswerRepo;
import com.careerjumpstart.admin_ms.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
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
        return answerRepo.findAnswerById(id);
    }

    @Override
    public Optional<Answer> findByQuestionId(Long questionId) {
        return answerRepo.findAnswerByQuestionId(questionId);
    }

    @Override
    public Answer createAnswer(Answer a) {
        return answerRepo.save(a);
    }

    @Override
    public Answer updateAnswer(Long id, Answer a) {
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
    public void deleteAnswer(Long id) {
        answerRepo.deleteById(id);
    }
}
