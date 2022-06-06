package com.careerjumpstart.admin_ms.service;

import com.careerjumpstart.admin_ms.models.Answer;
import com.careerjumpstart.admin_ms.repository.AnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Answer> findByQuestionId(Long questionId) {
        return answerRepo.findAnswerByQuestionId(questionId);
    }

    @Override
    public List<Answer> findByUsername(String username) {
        return answerRepo.findAnswerByUsername(username);
    }

    @Override
    public Optional<Answer> findByUsernameAndQuestionId(String username, Long questionId) {
        return answerRepo.findAnswerByUsernameAndQuestionId(username, questionId);
    }

    @Override
    public List<Answer> saveAnswers(List<Answer> answers) {
        return answerRepo.saveAll(answers);
    }

    @Override
    public List<Answer> updateAnswers(List<Answer> answers) {
        List<Answer> answersToUpdate = new ArrayList<>();
        for(Answer answer : answers) {
            Optional<Answer> answerDB = findById(answer.getId());
            if(answerDB.isPresent()) {
                Answer answerToUpdate = answerDB.get();
                answerToUpdate.setContent(answer.getContent());
                answersToUpdate.add(answerToUpdate);
            }
        }
        return answerRepo.saveAll(answersToUpdate);
    }

    @Override
    public Answer updateAnswer(Long id, Answer a) {
        Optional<Answer> answer = findById(id);
        answer.get().setContent(a.getContent());
        return answerRepo.save(answer.get());
    }

    @Override
    public void deleteAnswer(Long id) {
        answerRepo.deleteById(id);
    }

    @Override
    public void deleteAnswers(List<Answer> answers) {
        List<Answer> answersToDelete = new ArrayList<>();
        for(Answer answer : answers) {
            Optional<Answer> answerDB = findById(answer.getId());
            if(answerDB.isPresent()) {
                answersToDelete.add(answerDB.get());
            }
        }
        answerRepo.deleteAll(answersToDelete);
    }

    @Override
    public boolean exists(Long id) {
        return answerRepo.existsById(id);
    }
}
