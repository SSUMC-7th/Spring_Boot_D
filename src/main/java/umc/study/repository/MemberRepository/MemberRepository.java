package umc.study.repository.MemberRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;
import umc.study.domain.Mission;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Page<Mission> findAllById(Member member, PageRequest pageRequest);
    Optional<Member> findByEmail(String email);

}