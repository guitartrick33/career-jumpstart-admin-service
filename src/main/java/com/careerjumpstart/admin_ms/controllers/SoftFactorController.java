package com.careerjumpstart.admin_ms.controllers;

import com.careerjumpstart.admin_ms.models.SoftFactor;
import com.careerjumpstart.admin_ms.payload.response.ResponseWithMessage;
import com.careerjumpstart.admin_ms.service.SoftFactorService;
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
@RequestMapping("/admin/softfactor")
public class SoftFactorController {

    @Autowired
    private SoftFactorService softFactorService;

    @GetMapping
    public ResponseEntity<ResponseWithMessage<List<SoftFactor>>> getAll(){
        // TODO: Authorize the user who is requesting this action is registered (& logged in)
        List<SoftFactor> results;
        try {
            results = softFactorService.findAll();
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Soft factors repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(results.isEmpty()) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "No soft factors found"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseWithMessage<>(results, null), HttpStatus.OK);
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ResponseWithMessage<Optional<SoftFactor>>> getById(@PathVariable Long id){
        // TODO: Authorize the user who is requesting this action is registered (& logged in)
        Optional<SoftFactor> result;
        try {
            result = softFactorService.findById(id);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Soft factors repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(result.isEmpty()) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Soft factor not found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ResponseWithMessage<>(result, null), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<ResponseWithMessage<SoftFactor>> postSoftFactor(@RequestBody SoftFactor softFactor){
        // TODO: Authorize the user who is requesting this action has role admin
        try {
            SoftFactor newSoftFactor = softFactorService.createSoftFactor(softFactor);
            return new ResponseEntity<>(new ResponseWithMessage<>(newSoftFactor, "Soft factor successfully created"), HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Soft factors repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path="{id}")
    public ResponseEntity<ResponseWithMessage<SoftFactor>> editSoftFactor(@RequestBody SoftFactor softFactor, @PathVariable Long id){
        // TODO: Authorize the user who is requesting this action has role admin
        try {
            if(softFactorService.exists(id)) {
                SoftFactor updatedSoftFactor = softFactorService.updateSoftFactor(id, softFactor);
                return new ResponseEntity<>(new ResponseWithMessage<>(updatedSoftFactor, "Soft factor successfully updated"), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseWithMessage<>(null, "Soft factor not found"), HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Soft factors repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path="{id}")
    public ResponseEntity<ResponseWithMessage<SoftFactor>> deleteSoftFactor(@PathVariable Long id){
        // TODO: Authorize the user who is requesting this action has role admin
        try {
            if(softFactorService.exists(id)) {
                softFactorService.deleteSoftFactor(id);
                return new ResponseEntity<>(new ResponseWithMessage<>(null, "Soft factor successfully deleted"), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseWithMessage<>(null, "Soft factor not found"), HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Soft factors repository not responding"), HttpStatus.SERVICE_UNAVAILABLE);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ResponseWithMessage<>(null, "Something went wrong..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
