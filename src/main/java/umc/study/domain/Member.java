package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.SocialType;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer age;

    private String address;

    private String spec_address;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    private LocalDateTime inactive_date;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String email;

    private Integer point;
}
