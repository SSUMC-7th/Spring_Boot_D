package umc.spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
<<<<<<< HEAD
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.Terms;
=======
import umc.spring.domain.Store;
>>>>>>> 58ac144 (practice)
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.MissionStatus;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;
<<<<<<< HEAD

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
=======
>>>>>>> 58ac144 (practice)
}
