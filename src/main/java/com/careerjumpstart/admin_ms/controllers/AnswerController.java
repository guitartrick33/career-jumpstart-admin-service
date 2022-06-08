package com.careerjumpstart.admin_ms.controllers;

import com.careerjumpstart.admin_ms.Client;
import com.careerjumpstart.admin_ms.models.Answer;
import com.careerjumpstart.admin_ms.payload.response.ResponseWithMessage;
import com.careerjumpstart.admin_ms.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://careerjumpapp.com"}, maxAge = 3600, allowCredentials = "true")

@RequiredArgsConstructor

@RequestMapping("/admin/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @Autowired
    private Client client;


    @GetMapping(path = "testrabbitmq")
    @ResponseStatus(HttpStatus.OK)
    public String testRabbitMqOnly(@CookieValue(name="bezkoder") String cookie){
        Object response = client.sendMessageAndReceiveResponse(cookie, "test");
        return response.toString();
    }

    @GetMapping(path = "testdbrabbitmq")
    @ResponseStatus(HttpStatus.OK)
    public String testRabbitMqWithDatabase(@CookieValue(name="bezkoder") String cookie){
        Object response = client.sendMessageAndReceiveResponse(cookie, "roytuts");
        return response.toString();
    }

    @GetMapping
    public ResponseEntity<ResponseWithMessage<List<Answer>>> getAll(){
        // TODO: Authorize the user who is requesting this action has role admin or job matcher
        List<Answer> results;
        try {
            results = answerService.findAll();
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Answers repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(results.isEmpty()) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "No answers found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ResponseWithMessage<>(results, null), HttpStatus.OK);
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ResponseWithMessage<Optional<Answer>>> getById(@PathVariable Long id){
        // TODO: Authorize the user who is requesting this action is the corresponding user, has role admin or job matcher
        Optional<Answer> result;
        try {
            result = answerService.findById(id);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Answer repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(result.isEmpty()) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Answer not found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ResponseWithMessage<>(result, null), HttpStatus.OK);
        }
    }

    @GetMapping(params = "questionId")
    public ResponseEntity<ResponseWithMessage<List<Answer>>> getByQuestionId(@RequestParam Long questionId){
        // TODO: Authorize the user who is requesting this action has role admin or job matcher
        List<Answer> results;
        try {
            results = answerService.findByQuestionId(questionId);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Answers repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(results.isEmpty()) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "No answers found for this question"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ResponseWithMessage<>(results, null), HttpStatus.OK);
        }
    }

    @GetMapping(params = "username")
    public ResponseEntity<ResponseWithMessage<List<Answer>>> getByUsername(@RequestParam String username){
        // TODO: Change this request to take the username from the cookie (case: corresponding user) or user has role admin
        List<Answer> results;
        try {
            results = answerService.findByUsername(username);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Answers repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(results.isEmpty()) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "No answers found for this user"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ResponseWithMessage<>(results, null), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<ResponseWithMessage<List<Answer>>> postAnswers(@CookieValue(name="bezkoder") String cookie, @RequestBody List<Answer> answers){
        try {
            String username = (String) client.sendMessageAndReceiveResponse(cookie, "roytuts");
            if(username == null) {
                return new ResponseEntity<>(new ResponseWithMessage<>(null, "You are unauthorized for this action"), HttpStatus.UNAUTHORIZED);
            }
            answers.forEach(a -> a.setUsername(username));
            List<Answer> newAnswers = answerService.saveAnswers(answers);
            if(newAnswers.isEmpty()){
                return new ResponseEntity<>(new ResponseWithMessage<>(null, "Answers not filled"), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(new ResponseWithMessage<>(newAnswers, "Answers successfully saved"), HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Answers repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path="{id}")
    public ResponseEntity<ResponseWithMessage<Answer>> editAnswer(@RequestBody Answer answer, @PathVariable Long id){
        // TODO: Authorize the user who created the answer is the same as this one requesting this action & exists in the database
        try {
            if(answerService.exists(id)) {
                Answer updatedAnswer = answerService.updateAnswer(id, answer);
                return new ResponseEntity<>(new ResponseWithMessage<>(updatedAnswer, "Answer successfully updated"), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseWithMessage<>(null, "Answer not found"), HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Answers repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<ResponseWithMessage<List<Answer>>> editAnswers(@RequestBody List<Answer> answers){
        // TODO: Authorize the user who created the answer is the same as this one requesting this action & exists in the database
        try {
            List<Answer> updatedAnswers = answerService.updateAnswers(answers);
            return new ResponseEntity<>(new ResponseWithMessage<>(updatedAnswers, "Answers successfully updated"), HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Answers repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path="{id}")
    public ResponseEntity<ResponseWithMessage<Answer>> deleteAnswer(@PathVariable Long id){
        // TODO: Authorize the user who created the answer is the same as this one requesting this action & exists in the database
        try {
            if(answerService.exists(id)) {
                answerService.deleteAnswer(id);
                return new ResponseEntity<>(new ResponseWithMessage<>(null, "Answer successfully deleted"), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseWithMessage<>(null, "Answer not found"), HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Answers repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping()
    public ResponseEntity<ResponseWithMessage<List<Answer>>> deleteAnswers(@RequestBody List<Answer> answers){
        // TODO: Authorize the user who created the answer is the same as this one requesting this action & exists in the database
        try {
            answerService.deleteAnswers(answers);
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Answers successfully deleted"), HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Answers repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
