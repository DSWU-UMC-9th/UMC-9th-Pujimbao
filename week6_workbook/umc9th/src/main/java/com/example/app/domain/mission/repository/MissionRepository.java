package com.example.app.domain.mission.repository;

import com.example.app.domain.mission.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findByStore_Location_NameContaining(String locationName, Pageable pageable);
}
