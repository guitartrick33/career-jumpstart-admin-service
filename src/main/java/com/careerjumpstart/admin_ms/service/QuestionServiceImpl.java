package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.repository.QuestionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Question> findById(Long id) {
        return questionRepo.findQuestionByQuestionId(id);
    }

    @Override
    public Question createQ(Question q) {
        return questionRepo.save(q);
    }

    @Override
    public Question updateQ(Long id, Question q) {
        Optional<Question> question = findById(id);
        if(question.isPresent()){
            question.get().setContent(q.getContent());
            return questionRepo.save(question.get());
        }
        else
        {
            return null;
        }
    }

    @Override
    public void deleteQ(Long id) {
        questionRepo.deleteById(id);
    }


}
