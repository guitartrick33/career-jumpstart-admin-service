package com.careerjumpstart.admin_ms.models;

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

    @OneToMany(mappedBy = "softFactor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SoftFactor> softFactors;

}
