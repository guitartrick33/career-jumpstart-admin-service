package com.careerjumpstart.admin_ms.controllers;

import com.careerjumpstart.admin_ms.models.Answer;
import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @GetMapping(path="/")
    @ResponseStatus(HttpStatus.OK)
    public List<Answer> getAll(){
        return answerService.findAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Answer> getById(@PathVariable Long id){
        return answerService.findById(id);
    }

    @GetMapping(path = "/question/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Answer> getByQuestionId(@PathVariable Long id){
        return answerService.findByQuestionId(id);
    }

    @PostMapping(path="/create")
    public Answer postAnswer(@RequestBody Answer answer){
        return answerService.createA(answer);
    }

    @PutMapping(path="/edit/{id}")
    public Answer editAnswer(@RequestBody Answer answer, @PathVariable Long id){
        return answerService.updateA(id,answer);
    }

    @DeleteMapping(path="/delete/{id}")
    public void deleteAnswer(@PathVariable Long id){
        answerService.deleteA(id);
    }
}
