package com.example.app.domain.member.entity.mapping;

import com.example.app.domain.member.entity.Member;
import jakarta.persistence.*;

public class MemberFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 1:N 관계에서 이 엔티티가 1임을 정의
    @JoinColumn(name = "member_id") // FK의 주인을 설정
    private Member member;
}
