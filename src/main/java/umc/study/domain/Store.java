package umc.study.domain;

import jakarta.persistence.*;
import umc.study.domain.base.BaseEntity;
import umc.study.domain.mapping.Mission;
import umc.study.domain.mapping.Region;
import umc.study.domain.mapping.Review;

import java.util.ArrayList;
import java.util.List;

public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String res_address;

    private long distance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();
    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + res_address + '\'' +
                ", score=" + distance +
                ", region=" + (region != null ? region.getName() : "N/A") + // region의 이름 출력
                '}';
    }
}
