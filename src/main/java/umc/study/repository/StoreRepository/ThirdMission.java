package umc.study.repository.StoreRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.mapping.*;
/*
SELECT
    u.address,
    mp.user_id,
    mp.attainment_mission,
    mp.amends_mission,
    m.title,
    m.description,
    m.point,
    m.region_id,
    m.is_completed,
    m.deadline
FROM User AS u
JOIN MissionPoint AS mp ON mp.user_id = u.user_id
JOIN Mission AS m ON m.region_id = (
    SELECT region_id
    FROM Region
    WHERE Region.region_id = u.address
);
 */
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ThirdMission implements UserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QUser user = QUser.user;
    private final QMission_point missionPoint = QMission_point.mission_point;
    private final QMission mission = QMission.mission;

    @Override
    public List<User> fetchHomeScreenMissions(Long userId) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (userId != null) {
            predicate.and(user.id.eq(userId));
        }
        return jpaQueryFactory
                .select(user) // user 엔티티의 데이터를 선택
                .from(user) // user 테이블을 기준으로 쿼리를 시작
                .join(missionPoint).on(missionPoint.user.id.eq(user.id)) // user와 missionPoint를 사용자 ID로 조인
                .join(mission).on(mission.id.eq(missionPoint.id)) // missionPoint와 mission을 미션 ID로 조인
                .where(predicate) // 동적으로 생성한 조건을 쿼리에 적용
                .fetch(); // 쿼리를 실행하고 결과를 리스트로 반환
    }
}