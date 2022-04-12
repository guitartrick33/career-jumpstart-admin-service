package com.careerjumpstart.admin_ms.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "answers")
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @Column(name = "answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(name = "content")
    private String content;

    @ManyToOne(optional = false, targetEntity = Question.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private Question questionId;

    @Column(name = "user_id")
    private Long userId;
}
