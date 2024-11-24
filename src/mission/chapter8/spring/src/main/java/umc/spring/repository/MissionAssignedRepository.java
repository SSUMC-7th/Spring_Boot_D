package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.mapping.MissionAssigned;

@Repository
public interface MissionAssignedRepository extends JpaRepository<MissionAssigned, Long> {

    Boolean existsByUserIdAndMissionId(Long userId, Long missionId);

}
