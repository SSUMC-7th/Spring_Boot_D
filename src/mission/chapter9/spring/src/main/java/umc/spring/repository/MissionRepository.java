package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);

}
