package com.example.app.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 마이페이지에서 사용자 정보 조회 (이름, 이메일, 전화번호, 포인트)
    @Query("SELECT u FROM User u WHERE u.id = :userId")
    Optional<User> findUserInfoById(@Param("userId") Long userId);
}
