package com.careerjumpstart.admin_ms.models;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @Column(name = "question_id")
    private Question questionId;

    @Column(name = "user_id")
    private Long userId;
}
