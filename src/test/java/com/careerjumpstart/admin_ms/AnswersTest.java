package com.careerjumpstart.admin_ms;
import com.careerjumpstart.admin_ms.models.Answer;
import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.repository.AnswerRepo;
import com.careerjumpstart.admin_ms.service.AnswerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnswersTest {
    @InjectMocks
    private AnswerServiceImpl service;

    @Mock
    private AnswerRepo repository;

    @Test
    void serviceCreated(){
        assertThat(service).isNotNull();
    }

    @Test
    void findById(){
        Answer answer = createAnswer();
        when(repository.findAnswerById(answer.getId())).thenReturn(Optional.of(answer));
        Optional<Answer> existingAnswer = service.findById(answer.getId());
        assertThat(existingAnswer).isEqualTo(Optional.of(answer));
    }

    @Test
    void findAllAnswers(){
        Answer answer = createAnswer();
        when(repository.findAll()).thenReturn(List.of(answer));
        List<Answer> existingAnswers = service.findAll();
        assertThat(existingAnswers).isEqualTo(List.of(answer));
    }

    @Test
    void findAnswersByQuestionId(){
        Answer answer = createAnswer();
        when(repository.findAnswerByQuestionId(answer.getQuestion().getId())).thenReturn(List.of(answer));
        List<Answer> existingAnswers = service.findByQuestionId(answer.getQuestion().getId());
        assertThat(existingAnswers).isEqualTo(List.of(answer));
    }

    @Test
    void findAnswersByNickname(){
        Answer answer = createAnswer();
        when(repository.findAnswerByUsername(answer.getUsername())).thenReturn(List.of(answer));
        List<Answer> existingAnswers = service.findByUsername(answer.getUsername());
        assertThat(existingAnswers).isEqualTo(List.of(answer));
    }

    @Test
    void findAnswerByUsernameAndQuestionId(){
        Answer answer = createAnswer();
        when(repository.findAnswerByUsernameAndQuestionId(answer.getUsername(), answer.getQuestion().getId())).thenReturn(Optional.of(answer));
        Optional<Answer> existingAnswer = service.findByUsernameAndQuestionId(answer.getUsername(), answer.getQuestion().getId());
        assertThat(existingAnswer).isEqualTo(Optional.of(answer));
    }

    private Answer createAnswer(){
        Question question = new Question();
        question.setContent("Test");
        question.setRoleId(1L);

        Answer answer = new Answer();
        answer.setContent("Test");
        answer.setUsername("Test");
        answer.setQuestion(question);
        return answer;
    }

}
