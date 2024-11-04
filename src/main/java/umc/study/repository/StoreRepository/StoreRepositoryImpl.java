package umc.study.repository.StoreRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.mapping.QRestaurant;
import umc.study.domain.mapping.Restaurant;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QRestaurant store = QRestaurant.restaurant;

    @Override
    public List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();
        if (store.name != null) {
            predicate.and(store.name.eq(name));
        }

        if (store.distance != null) {
            predicate.and(store.distance.goe(4.0f));
        }

        return jpaQueryFactory
                .selectFrom(store)
                .where(predicate)
                .fetch();
    }
}

