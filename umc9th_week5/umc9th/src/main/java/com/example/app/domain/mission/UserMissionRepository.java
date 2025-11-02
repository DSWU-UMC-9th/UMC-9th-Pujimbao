package com.example.app.domain.mission;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    // 내가 완료/진행 중인 미션 조회 (미션 포인트, 성공 여부, 가게명 등)
    @Query("""
        SELECT um
        FROM UserMission um
        JOIN FETCH um.mission m
        JOIN FETCH m.store s
        WHERE um.user.id = :userId
        AND um.isComplete IN :statusList
        ORDER BY um.mission.id DESC
    """)
    List<UserMission> findUserMissionsWithStatus(
            @Param("userId") Long userId,
            @Param("statusList") List<MissionStatus> statusList,
            Pageable pageable
    );
}
