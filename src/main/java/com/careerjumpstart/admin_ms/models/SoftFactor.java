package com.careerjumpstart.admin_ms.models;

import javax.persistence.*;

@Entity
@Table(name = "soft_factors")
public class SoftFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

}
