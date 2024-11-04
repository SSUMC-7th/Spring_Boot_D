package umc.study.repository.StoreService;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.mapping.Restaurant;
import umc.study.repository.StoreRepository.StoreRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{
    private final StoreRepository storeRepository;
    @Override
    public Optional<Restaurant> findStore(Long id) {
        return storeRepository.findById(id);
    }
    @Override
    public List<Restaurant> findStoresByNameAndScore(String name, Float distance) {
        List<Restaurant> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, distance);

        filteredStores.forEach(store -> System.out.println("Distance: " + distance));

        return filteredStores;
    }
}
