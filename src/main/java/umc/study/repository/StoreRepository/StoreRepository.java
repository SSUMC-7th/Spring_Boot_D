package umc.study.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.Restaurant;

public interface StoreRepository extends JpaRepository<Restaurant, Long>, StoreRepositoryCustom {
}
