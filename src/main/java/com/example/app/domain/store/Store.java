package com.example.app.domain.store;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
import com.example.app.domain.mission.Mission;
import com.example.app.domain.review.Review;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 20)
    private String foodType;

    @Column(length = 20)
    private String address;

    @Column(length = 200)
    private String detailAddress;

    @Column(precision = 2, scale = 1)
    private Double rate = 0.0;

    @Column(nullable = false)
    private java.sql.Time openTime;

    @Column(nullable = false)
    private java.sql.Time closeTime;

    @OneToMany(mappedBy = "store")
    private List<Mission> missions = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Review> reviews = new ArrayList<>();
}
