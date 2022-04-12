package com.careerjumpstart.admin_ms.controllers;

import com.careerjumpstart.admin_ms.models.Answer;
import com.careerjumpstart.admin_ms.models.SoftFactor;
import com.careerjumpstart.admin_ms.service.SoftFactorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RequestMapping("/admin/softfactor")
public class SoftFactorController {

    private final SoftFactorService softFactorService;

    @GetMapping(path="/")
    @ResponseStatus(HttpStatus.OK)
    public List<SoftFactor> getAll(){
        return softFactorService.findAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<SoftFactor> getById(@PathVariable Long id){
        return softFactorService.findById(id);
    }



    @PostMapping(path="/create")
    public SoftFactor postSoftFactor(@RequestBody SoftFactor softFactor){
        return softFactorService.createS(softFactor);
    }

    @PutMapping(path="/edit/{id}")
    public SoftFactor editSoftFactor(@RequestBody SoftFactor softFactor, @PathVariable Long id){
        return softFactorService.updateS(id,softFactor);
    }

    @DeleteMapping(path="/delete/{id}")
    public void deleteSoftFactor(@PathVariable Long id){
        softFactorService.deleteS(id);
    }
}
