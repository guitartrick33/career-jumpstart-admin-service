package com.careerjumpstart.admin_ms.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    private Long id;

    private String text;
    private Integer roleId;

    @ManyToOne
    private SoftFactor sfId;

    private QType type;

}
