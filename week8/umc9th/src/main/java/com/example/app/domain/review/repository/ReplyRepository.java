package com.example.app.domain.review.repository;

import com.example.app.domain.review.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    List<Reply> findByReview_Id(Long reviewId); // 댓글 목록
}
