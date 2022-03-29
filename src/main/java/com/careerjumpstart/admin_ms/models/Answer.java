package com.careerjumpstart.admin_ms.models;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class Answer {
    @Id
    private Long id;

    private Question question;

    private String description;

    private Long userId;
}
