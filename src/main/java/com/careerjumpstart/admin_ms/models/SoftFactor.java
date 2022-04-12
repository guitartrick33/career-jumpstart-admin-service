package com.careerjumpstart.admin_ms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
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

    @JsonIgnore
    @OneToMany(mappedBy = "sfId",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Question> questions;

}
