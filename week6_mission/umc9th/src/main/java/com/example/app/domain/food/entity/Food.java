package com.example.app.domain.food.entity;

import com.example.app.domain.food.enums.PreferFood;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "food")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private PreferFood name;
}
