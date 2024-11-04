package umc.study.repository.StoreRepository;

import umc.study.domain.mapping.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> fetchHomeScreenMissions(Long userId);
}
