package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
<<<<<<< HEAD
=======
import org.hibernate.annotations.CascadeType;
>>>>>>> 58ac144 (practice)
import umc.spring.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
=======
    private String name;

>>>>>>> 58ac144 (practice)
    private String address;

    private Float score;

<<<<<<< HEAD
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;


    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                ", region=" + (region != null ? region.getName() : "N/A") + // region의 이름 출력
                '}';
    }
=======
//    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
//    private List<Review> memberMissionList = new ArrayList<>();
>>>>>>> 58ac144 (practice)
}