package umc.study.service.StoreService;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository.StoreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> fileterdStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        fileterdStores.forEach(store -> System.out.println("Store : "+ store));

        return fileterdStores;
    }
}
