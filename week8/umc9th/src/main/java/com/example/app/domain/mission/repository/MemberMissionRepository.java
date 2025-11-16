package com.example.app.domain.mission.repository;

import com.example.app.domain.member.entity.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    Page<MemberMission> findByMember_Id(Long memberId, Pageable pageable);

    Page<MemberMission> findByMember_IdAndIsComplete(Long memberId, Boolean isComplete, Pageable pageable);
}
