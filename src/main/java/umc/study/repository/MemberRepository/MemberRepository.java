package umc.study.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
