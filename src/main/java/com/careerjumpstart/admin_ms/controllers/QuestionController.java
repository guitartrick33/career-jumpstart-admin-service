package com.careerjumpstart.admin_ms.controllers;

import com.careerjumpstart.admin_ms.models.QType;
import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.models.SoftFactor;
import com.careerjumpstart.admin_ms.service.QuestionService;
import com.careerjumpstart.admin_ms.service.SoftFactorService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.InjectService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RequestMapping("/admin/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping(path="/")
    public List<Question> getQuestions(){
        return questionService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Question> getById(@PathVariable Long id){
        return questionService.findById(id);
    }

    @PostMapping(path="/create")
    public Question postQuestion(@RequestBody Question question){
        return questionService.createQ(question);
    }
}
