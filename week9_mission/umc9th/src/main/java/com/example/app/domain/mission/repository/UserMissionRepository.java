package com.example.app.domain.mission.repository;

import com.example.app.domain.mission.entity.UserMission;
import com.example.app.domain.mission.entity.MissionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    // 특정 멤버의 진행 중인 미션 페이징 조회
    Page<UserMission> findByMember_IdAndStatus(Long memberId, MissionStatus status, Pageable pageable);

    // 필요시: 멤버의 모든 미션 페이징 조회
    Page<UserMission> findByMember_Id(Long memberId, Pageable pageable);

}
