package com.careerjumpstart.admin_ms.controllers;

import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.payload.response.ResponseWithMessage;
import com.careerjumpstart.admin_ms.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600, allowCredentials = "true")
@RequiredArgsConstructor
@RequestMapping("/admin/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<ResponseWithMessage<List<Question>>> getAll(){
        // TODO: Authorize the user who is requesting this action is registered (& logged in)
        List<Question> results;
        try {
            results = questionService.findAll();
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Questions repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(results.isEmpty()) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "No questions found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ResponseWithMessage<>(results, null), HttpStatus.OK);
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ResponseWithMessage<Optional<Question>>> getById(@PathVariable Long id){
        // TODO: Authorize the user who is requesting this action is registered (& logged in)
        Optional<Question> result;
        try {
            result = questionService.findById(id);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Question repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(result.isEmpty()) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Question not found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ResponseWithMessage<>(result, null), HttpStatus.OK);
        }
    }

    @GetMapping(params = "softFactorId")
    public ResponseEntity<ResponseWithMessage<List<Question>>> getQuestionsBySoftFactorId(@RequestParam Long softFactorId){
        // TODO: Authorize the user who is requesting this action is registered (& logged in)
        List<Question> results;
        try {
            results = questionService.findBySoftFactorId(softFactorId);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Questions repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(results.isEmpty()) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "No questions found for this soft factor"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseWithMessage<>(results, null), HttpStatus.OK);
        }
    }

    @GetMapping(params = {"softFactorId", "roleId"})
    public ResponseEntity<ResponseWithMessage<List<Question>>> getQuestionsByRoleId(@RequestParam Long softFactorId, @RequestParam Long roleId){
        // TODO: Authorize the user who is requesting this action is registered (& logged in)
        List<Question> results;
        try {
            results = questionService.findAllBySoftFactorIdAndRoleId(softFactorId, roleId);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Questions repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(results.isEmpty()) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "No questions found for this soft factor and role"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ResponseWithMessage<>(results, null), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<ResponseWithMessage<Question>> postQuestion(@RequestBody Question question){
        // TODO: Authorize the user who is requesting this action has role admin
        try {
            Question newQuestion = questionService.createQuestion(question);
            return new ResponseEntity<>(new ResponseWithMessage<>(newQuestion, "Question successfully created"), HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Questions repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path="{id}")
    public ResponseEntity<ResponseWithMessage<Question>> editQuestion(@RequestBody Question question, @PathVariable Long id){
        // TODO: Authorize the user who is requesting this action has role admin
        try {
            if(questionService.exists(id)) {
                Question updatedQuestion = questionService.updateQuestion(id, question);
                return new ResponseEntity<>(new ResponseWithMessage<>(updatedQuestion, "Question successfully updated"), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseWithMessage<>(null, "Question not found"), HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Questions repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path="{id}")
    public ResponseEntity<ResponseWithMessage<Question>> deleteQuestion(@PathVariable Long id){
        // TODO: Authorize the user who is requesting this action has role admin
        try {
            if(questionService.exists(id)) {
                questionService.deleteQuestion(id);
                return new ResponseEntity<>(new ResponseWithMessage<>(null, "Question successfully deleted"), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseWithMessage<>(null, "Question not found"), HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Questions repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
