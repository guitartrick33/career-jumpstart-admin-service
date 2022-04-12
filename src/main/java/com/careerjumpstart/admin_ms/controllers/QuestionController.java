package com.careerjumpstart.admin_ms.controllers;

import com.careerjumpstart.admin_ms.models.Answer;
import com.careerjumpstart.admin_ms.models.QType;
import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.models.SoftFactor;
import com.careerjumpstart.admin_ms.service.QuestionService;
import com.careerjumpstart.admin_ms.service.SoftFactorService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RequestMapping("/admin/question")
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

    @GetMapping(path = "/softfactor/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional <List<Question>> getByQuestionId(@PathVariable Long id){
        return questionService.findBySfId(id);
    }

    @PostMapping(path="/create")
    public Question postQuestion(@RequestBody Question question){
        return questionService.createQ(question);
    }

    @PutMapping(path="/edit/{id}")
    public Question editQuestion(@RequestBody Question question, @PathVariable Long id){
        return questionService.updateQ(id,question);
    }

    @DeleteMapping(path="/delete/{id}")
    public void deleteQuestion(@PathVariable Long id){
       questionService.deleteQ(id);
    }
}
