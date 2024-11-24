package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.domain.User;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);

    Page<Review> findAllByUser(User user, PageRequest pageRequest);

}
