package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
