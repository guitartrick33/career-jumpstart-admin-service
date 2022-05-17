package com.careerjumpstart.admin_ms;
import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.models.SoftFactor;
import com.careerjumpstart.admin_ms.repository.QuestionRepo;
import com.careerjumpstart.admin_ms.service.QuestionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuestionsTest {
    @InjectMocks
    private QuestionServiceImpl service;

    @Mock
    private QuestionRepo repository;

    @Test
    void serviceCreated(){
        assertThat(service).isNotNull();
    }

    @Test
    void findById(){
        Question question = createQuestion();
        when(repository.findQuestionById(question.getId())).thenReturn(Optional.of(question));
        Optional<Question> existingQuestion =service.findById(question.getId());
        assertThat(existingQuestion).isEqualTo(Optional.of(question));
    }

    @Test
    void findAllQuestions(){
        Question question = createQuestion();
        when(repository.findAll()).thenReturn(List.of(question));
        List<Question> existingQuestions = service.findAll();
        assertThat(existingQuestions).isEqualTo(List.of(question));
    }

    @Test
    void findBySoftFactorId(){
        Question question = createQuestion();
        when(repository.findAllBySoftFactorId(question.getSoftFactor().getId())).thenReturn(List.of(question));
        List<Question> existingQuestions = service.findBySoftFactorId(question.getSoftFactor().getId());
        assertThat(existingQuestions).isEqualTo(List.of(question));
    }

    @Test
    void findBySoftFactorAndRoleId(){
        Question question = createQuestion();
        when(repository.findAllBySoftFactorIdAndRoleId(question.getSoftFactor().getId(), question.getRoleId())).thenReturn(List.of(question));
        List<Question> existingQuestions = service.findAllBySoftFactorIdAndRoleId(question.getSoftFactor().getId(), question.getRoleId());
        assertThat(existingQuestions).isEqualTo(List.of(question));
    }

    private Question createQuestion(){
        SoftFactor softFactor = new SoftFactor();
        softFactor.setTitle("Test");

        Question question = new Question();
        question.setContent("Test");
        question.setRoleId(1L);
        question.setSoftFactor(softFactor);

        return question;
    }
}
