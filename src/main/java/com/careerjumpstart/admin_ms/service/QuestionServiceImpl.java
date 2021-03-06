package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
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
        return questionRepo.findQuestionById(id);
    }

    @Override
    public List<Question> findBySoftFactorId(Long softFactorId) {
        return questionRepo.findAllBySoftFactorId(softFactorId);
    }

    @Override
    public List<Question> findAllBySoftFactorIdAndRoleId(Long softFactorId, Long roleId){
        return questionRepo.findAllBySoftFactorIdAndRoleId(softFactorId, roleId);
    }

    @Override
    public Question createQuestion(Question q) {
        return questionRepo.save(q);
    }

    @Override
    public Question updateQuestion(Long id, Question q) {
        Optional<Question> question = findById(id);
        if(question.isPresent()){
            question.get().setContent(q.getContent());
//            question.get().setRoleId(q.getRoleId());
//            question.get().setSoftFactor(q.getSoftFactor());
//            question.get().setType(q.getType());
            return questionRepo.save(question.get());
        }
        else
        {
            return null;
        }
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepo.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return questionRepo.existsById(id);
    }


}
