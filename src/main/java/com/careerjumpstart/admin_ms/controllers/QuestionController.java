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

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RequestMapping("/admin/question")
public class QuestionController {

    private final QuestionService questionService;
    private final SoftFactorService sfService;

    @GetMapping(path="/")
    public List<Question> getQuestions(){
        return questionService.findAll();
    }

//    @PostMapping(path="/createinitial")
//    public Question save()
//    {
//        SoftFactor sf = new SoftFactor(1L,"Initial title");
//        sfService.createSF(sf);
//        Question q = new Question(1L,"The initial question",2L,sf, QType.OPEN);
//        System.out.println(q);
//        return questionService.createQ(q);
//    }
    @PostMapping(path="/create")
    public Question postQuestion(@RequestBody Question question){
        return questionService.createQ(question);
    }
}
