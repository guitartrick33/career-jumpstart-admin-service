package com.careerjumpstart.admin_ms.models;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @Column(name = "answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne(optional = false, targetEntity = Question.class)
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private Question questionId;


    @Column(name = "user_id")
    private Long userId;
}
