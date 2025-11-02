package com.example.app.domain.user;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.example.app.domain.mission.Mission;
import com.example.app.domain.mission.UserMission;
import com.example.app.domain.review.Review;
import com.example.app.domain.term.UserTerm;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sex sex;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(length = 20)
    private String address;

    @Column(length = 200)
    private String detailAddress;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PreferFood preferFood;

    @Column(nullable = false)
    private Integer point = 0;

    @Column(length = 20)
    private String email;

    @Column(length = 50)
    private String socialUid;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SocialType socialType;

    @Column(length = 20)
    private String phoneNumber;

    // 연관관계
    @OneToMany(mappedBy = "user")
    private List<Mission> missions = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserMission> userMissions = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserTerm> userTerms = new ArrayList<>();
}
