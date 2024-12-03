package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.User;
import umc.spring.domain.mapping.MissionAssigned;

import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Repository
public interface MissionAssignedRepository extends JpaRepository<MissionAssigned, Long> {

    Boolean existsByUserIdAndMissionId(Long userId, Long missionId);

    @Query("SELECT ma FROM MissionAssigned ma WHERE ma.user = :user " +
            "AND ma.dueDate > CURRENT_DATE " +
            "AND ma.isCompleted = false")
    Page<MissionAssigned> findAllByUser(User user, PageRequest pageRequest);

    Optional<MissionAssigned> findByUserIdAndMissionId(Long userId, Long missionId);

    @Query("SELECT ma FROM MissionAssigned ma WHERE ma.user = :user " +
            "AND ma.dueDate > CURRENT_DATE " +
            "AND ma.isCompleted = true")
    Page<MissionAssigned> findTrueByUser(User user, PageRequest pageRequest);

}
