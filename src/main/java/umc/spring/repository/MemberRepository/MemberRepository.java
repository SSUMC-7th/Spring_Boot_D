package umc.spring.repository.MemberRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Page<Mission> findAllById(Member member, PageRequest pageRequest);
    Optional<Member> findByEmail(String email);
}
