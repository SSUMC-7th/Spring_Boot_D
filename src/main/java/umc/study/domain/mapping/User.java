package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.AccessLevel;
import umc.study.domain.base.BaseEntity;
import umc.study.domain.enums.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    @Column(columnDefinition = "VARCHAR(50)")
    private String social;
    @Column(columnDefinition = "VARCHAR(50)")
    private String name;
    @Column(columnDefinition = "VARCHAR(50)")
    private String nickname;
    private int phone;
    @Column(columnDefinition = "VARCHAR(200)")
    private String address;
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Favorite_Food favoriteFood;
    @Enumerated(EnumType.STRING)
    private IsActive isActive;
    @Enumerated(EnumType.STRING)
    private IsSecession isSecession;
    @Enumerated(EnumType.STRING)
    private Status Status;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Mission_point> missionpointList = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Inquiry> inquiryList = new ArrayList<>();

}