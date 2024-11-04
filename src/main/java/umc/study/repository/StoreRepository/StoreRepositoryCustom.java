package umc.study.repository.StoreRepository;

import umc.study.domain.mapping.Restaurant;

import java.util.List;


public interface StoreRepositoryCustom {
    List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score);
}