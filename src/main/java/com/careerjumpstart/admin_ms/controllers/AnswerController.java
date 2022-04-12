package com.careerjumpstart.admin_ms.controllers;

import com.careerjumpstart.admin_ms.models.Answer;
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Answer> getAll(){
        return answerService.findAll();
    }

    @GetMapping(path = "{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Answer> getById(@PathVariable Long id){
        return answerService.findById(id);
    }

    @GetMapping(params = "questionId")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Answer> getByQuestionId(@RequestParam Long questionId){
        return answerService.findByQuestionId(questionId);
    }

    @PostMapping
    public Answer postAnswer(@RequestBody Answer answer){
        return answerService.createAnswer(answer);
    }

    @PutMapping(path="{id}")
    public Answer editAnswer(@RequestBody Answer answer, @PathVariable Long id){
        return answerService.updateAnswer(id,answer);
    }

    @DeleteMapping(path="{id}")
    public void deleteAnswer(@PathVariable Long id){
        answerService.deleteAnswer(id);
    }
}
