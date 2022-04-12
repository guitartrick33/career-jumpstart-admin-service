package com.careerjumpstart.admin_ms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
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
    private SoftFactor sfId;

    @Column(name = "type")
    private QType type;

    @JsonIgnore
    @OneToMany(mappedBy = "questionId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Answer> answers;
}
