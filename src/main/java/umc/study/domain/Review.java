package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Float score;
    @ManyToOne
    @JoinColumn(name = "member_id") // 외래 키 이름을 지정합니다.
    private Member member;

    @ManyToOne
    @JoinColumn(name = "store_id") // store_id는 Review 테이블의 외래 키 이름입니다
    private Store store;

}