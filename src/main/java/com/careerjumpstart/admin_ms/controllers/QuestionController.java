package com.careerjumpstart.admin_ms.controllers;

import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping(path="/")
    @ResponseStatus(HttpStatus.OK)
    public List<Question> getAll(){
        return questionService.findAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Question> getById(@PathVariable Long id){
        return questionService.findById(id);
    }

    @GetMapping(path = "/", params = "softFactorId")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional <List<Question>> getQuestionsBySoftFactorId(@RequestParam Long softFactorId){
        return questionService.findBySoftFactorId(softFactorId);
    }

    @PostMapping(path="/")
    public Question postQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    @PutMapping(path="/{id}")
    public Question editQuestion(@RequestBody Question question, @PathVariable Long id){
        return questionService.updateQuestion(id,question);
    }

    @DeleteMapping(path="/{id}")
    public void deleteQuestion(@PathVariable Long id){
       questionService.deleteQuestion(id);
    }
}
