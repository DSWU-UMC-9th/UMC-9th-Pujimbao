package com.example.app.domain.term.entity;

import com.example.app.domain.term.enums.TermType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "term")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "term_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TermType name;
}
