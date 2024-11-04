package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.base.BaseEntity;
import umc.study.domain.enums.AttachPhoto;
import umc.study.domain.enums.Attainment_Mission;
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Inquiry extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "VARCHAR(50)")
    private String title;
    @Column(columnDefinition = "VARCHAR(200)")
    private String details;
    private Attainment_Mission attainmentMission;
    @Enumerated(EnumType.STRING)
    private AttachPhoto photo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
