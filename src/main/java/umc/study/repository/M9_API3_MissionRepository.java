package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Mission;

import java.time.LocalDate;

public interface M9_API3_MissionRepository extends JpaRepository<Mission, Long> {
    // MemberMission을 통해 userId와 조건을 추가하여 mission을 필터링
    Page<Mission> findAllByMemberMissionList(Long userId, LocalDate now, Pageable pageable);
}

