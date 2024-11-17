package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Review;

public interface API2_ReviewRepository extends JpaRepository<Review, Long> {
}
