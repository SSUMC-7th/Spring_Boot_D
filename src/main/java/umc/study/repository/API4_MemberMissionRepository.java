package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.MemberMission;

public interface API4_MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
