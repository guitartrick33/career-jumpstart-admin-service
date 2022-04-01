package com.careerjumpstart.admin_ms.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "soft_factors")
@AllArgsConstructor
@NoArgsConstructor
public class SoftFactor {

    @Id
    @Column(name = "sf_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sfId;

    @Column(name = "title")
    private String title;

}
