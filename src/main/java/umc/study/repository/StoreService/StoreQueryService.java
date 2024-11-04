package umc.study.repository.StoreService;

import umc.study.domain.mapping.Restaurant;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    Optional<Restaurant> findStore(Long id);
    List<Restaurant> findStoresByNameAndScore(String name, Float score);
}
