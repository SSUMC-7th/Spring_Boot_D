package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.domain.Review;
import umc.study.domain.Store;

@Repository
public interface M9_API1_ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStore(Store store, Pageable pageable);
}
