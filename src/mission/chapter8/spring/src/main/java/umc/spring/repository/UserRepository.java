package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
