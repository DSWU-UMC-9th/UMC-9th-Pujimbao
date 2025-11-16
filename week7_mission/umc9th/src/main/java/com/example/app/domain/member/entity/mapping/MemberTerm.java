package com.example.app.domain.member.entity.mapping;

import com.example.app.domain.member.entity.Member;
import com.example.app.domain.term.entity.Term;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member_term")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class MemberTerm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_term_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id", nullable = false)
    private Term term;
}
