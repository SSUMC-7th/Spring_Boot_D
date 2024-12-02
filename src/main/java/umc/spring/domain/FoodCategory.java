package umc.spring.domain;

<<<<<<< HEAD
import jakarta.persistence.*;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
>>>>>>> 58ac144 (practice)
import lombok.*;
import umc.spring.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(nullable = false, length = 15)
=======
>>>>>>> 58ac144 (practice)
    private String name;


}