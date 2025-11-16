package com.example.app.domain.mission.entity;

import com.example.app.domain.member.entity.Member;
import com.example.app.domain.mission.entity.Mission;
import com.example.app.domain.mission.entity.MissionStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Mission mission;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;
}
