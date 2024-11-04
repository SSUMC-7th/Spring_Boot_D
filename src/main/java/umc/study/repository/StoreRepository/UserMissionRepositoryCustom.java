package umc.study.repository.StoreRepository;

import umc.study.domain.mapping.Usermission;

import java.util.List;

public interface UserMissionRepositoryCustom {
    List<Usermission> findUserMissions(Long userId, int limit);
}
