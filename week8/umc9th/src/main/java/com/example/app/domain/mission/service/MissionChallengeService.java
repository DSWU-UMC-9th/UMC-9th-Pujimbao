package com.example.app.domain.mission.service;

import com.example.app.domain.member.entity.Member;
import com.example.app.domain.member.repository.MemberRepository;
import com.example.app.domain.mission.entity.Mission;
import com.example.app.domain.mission.entity.MissionStatus;
import com.example.app.domain.mission.entity.UserMission;
import com.example.app.domain.mission.repository.MissionRepository;
import com.example.app.domain.mission.repository.UserMissionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionChallengeService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    @Transactional
    public void challenge(Long memberId, Long missionId) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("Mission not found"));

        UserMission userMission = UserMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.ONGOING)
                .build();

        userMissionRepository.save(userMission);
    }
}
