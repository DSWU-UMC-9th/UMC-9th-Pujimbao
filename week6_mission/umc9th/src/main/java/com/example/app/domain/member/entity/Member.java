package com.example.app.domain.member.entity; // 이 클래스가 어떤 패키지에 속해 있는지 명시

import com.example.app.domain.member.enums.Gender;
import com.example.app.domain.member.enums.PreferFood;
import com.example.app.domain.member.enums.SocialType;

import com.example.app.global.entity.BaseEntity;
import jakarta.persistence.*; // JPA 관련 어노테이션(@Entity, @Id 등)을 사용하기 위해 import
import lombok.*; // Lombok 라이브러리에서 제공하는 자동 코드 생성(@Getter, @Builder 등)을 위해 import
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity // 이 클래스가 JPA의 엔티티임을 의미. JPA가 이 클래스를 관리하게 됨
@Builder // 객체 생성 시 빌더 패턴을 자동으로 만들어줌.
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자 자동으로 생성. (JPA 엔티티는 기본 생성자 필수)
@AllArgsConstructor(access = AccessLevel.PRIVATE) // 모든 필더를 받는 생성자를 자동 생성
@Getter // 모든 필드에 대한 getter 메서드를 자동 생성 (getId(), getName() 등)
@Table(name = "member") // DB의 테이블을 정의. 이 엔티티가 DB의 member 테이블과 매핑된다는 뜻
public class Member extends BaseEntity {

    @Id // 이 필드가 기본 키(PK)임을 나타냄.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 생성 방식 지정. IDENTITY인 경우, DB가 자동 증가(auto_increment)
    private Long id;

    @Column(name = "name") // 해당 필드가 DB의 컬럼과 매핑됨을 의미. 즉, DB의 member 테이블에 name이라는 컬럼이 생김.
    private String name;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING) // Enum 타입을 DB에 STRING 형태로 저장하도록 지정
    @Builder.Default // 초기값을 지정
    private Gender gender = Gender.NONE; // 요청으로 성별을 안 받는 경우, 자동으로 NONE이 들어감

    @Column(name = "birth")
    private String birth;  // 날짜라면 LocalDate 타입 권장

    @Column(name = "address", length = 20)
    private String address;

    @Column(name = "detail_address", length = 200)
    private String detailAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "prefer_food")
    private PreferFood preferFood;

    @Column(name = "point")
    private Integer point;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "social_uid", nullable = false)
    private String socialUid;

    @Enumerated(EnumType.STRING)
    @Column(name = "social_type", nullable = false)
    private SocialType socialType;

    @Column(name = "phone_number")
    private String phoneNumber;
}
