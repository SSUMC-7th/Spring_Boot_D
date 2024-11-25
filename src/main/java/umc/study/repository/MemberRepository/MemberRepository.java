package umc.study.repository.MemberRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;
import umc.study.domain.Mission;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Page<Mission> findAllById(Member member, PageRequest pageRequest);
}
