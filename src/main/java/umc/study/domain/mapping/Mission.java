package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.base.BaseEntity;
import umc.study.domain.enums.Attainment_Mission;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "VARCHAR(50)")
    private String title;
    @Column(columnDefinition = "VARCHAR(200)")
    private String description;
    private long region_id;
    private long point;
    private long deadline;
    private long division_number;
    private boolean isCompleted;
    @Enumerated(EnumType.STRING)
    private Attainment_Mission attainmentMission;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mission_point> missionPoints = new ArrayList<>();
}

