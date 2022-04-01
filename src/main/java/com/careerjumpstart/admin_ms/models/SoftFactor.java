package com.careerjumpstart.admin_ms.models;

import javax.persistence.*;

@Entity
@Table(name = "soft_factors")
public class SoftFactor {

    @Id
    @Column(name = "sf_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sfId;

    @Column(name = "title")
    private String title;

}
