package com.careerjumpstart.admin_ms.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(name = "content")
    private String content;

    @Column(name = "role_id")
    private Long roleId;

    @ManyToOne(optional = false, targetEntity = SoftFactor.class)
    @JoinColumn(name = "sf_id", referencedColumnName = "sf_id")
    private SoftFactor softFactor;

    @Column(name = "type")
    private QType type;

}
