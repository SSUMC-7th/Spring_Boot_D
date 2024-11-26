package umc.study.repository;

import umc.study.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface M9_API4_MissionRepository extends JpaRepository<Mission, Long> {
    List<Mission> findCompletedMissionsByUserId(Long userId);
}
