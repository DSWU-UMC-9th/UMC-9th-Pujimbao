package com.example.app.domain.mission;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    // 홈화면 - 지역 기반 도전 가능한 미션 조회
    @Query("""
        SELECT m
        FROM Mission m
        JOIN m.store s
        LEFT JOIN UserMission um ON um.mission.id = m.id AND um.user.id = :userId
        WHERE s.address LIKE %:address%
        AND um.id IS NULL
        ORDER BY m.deadline ASC
    """)
    List<Mission> findAvailableMissions(
            @Param("userId") Long userId,
            @Param("address") String address,
            Pageable pageable
    );
}
