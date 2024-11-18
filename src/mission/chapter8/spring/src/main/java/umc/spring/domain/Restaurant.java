package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring.domain.base.BaseEntity;
import umc.spring.domain.enums.RestaurantCategory;
import umc.spring.domain.mapping.AnswerToReview;
import umc.spring.domain.mapping.UserTerms;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(15)")
    private RestaurantCategory category;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false)
    private Float rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<AnswerToReview> answerToReviewList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<OpenDayandTimeofRestaurant> openDayandTimeofRestaurantList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<RestaurantImage> restaurantImageList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rating=" + rating +
                ", region=" + (region != null ? region.getName() : "N/A") + // region의 이름 출력
                '}';
    }

    public void setRegion(Region region) {
        if (this.region != null) {
            this.region.getRestaurantList().remove(this);
        }

        this.region = region;
        region.getRestaurantList().add(this);  // 이 부분에서 add()를 사용해야 합니다.
    }

}
