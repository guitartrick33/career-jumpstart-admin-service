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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "role_id")
    private Long roleId;

    @ManyToOne
    @Column(name = "sf_id")
    private SoftFactor sfId;

    @Column(name = "type")
    private QType type;

}
