//package umc.study.repository.StoreRepository;
//
//import com.querydsl.core.BooleanBuilder;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//import umc.study.domain.mapping.QMission;
//import umc.study.domain.mapping.QUsermission;
//import umc.study.domain.mapping.Usermission;
///*
//SELECT
//um.mission_id,
//m.title
//m.description
//m.point
//m.region_id,
//um.is_completed,
//FROM UserMission AS um
//JOIN Mission AS m ON um.mission_id = m.id
//WHERE um.user_id = {user.id}
//
//LIMIT 15;
// */
//import java.util.List;
//import static umc.study.domain.mapping.QUsermission.usermission;
//
//@Repository
//@RequiredArgsConstructor
//public class FirstMission implements UserMissionRepositoryCustom {
//
//    private final JPAQueryFactory jpaQueryFactory;
//    private final QUsermission userMission = usermission;
//    private final QMission mission = QMission.mission;
//
//    @Override
//    public List<Usermission> findUserMissions(Long userId, int limit) {
//        BooleanBuilder predicate = new BooleanBuilder();
//
//        if (userId != null) {
//            predicate.and(userMission.user.id.eq(userId));
//        }
//        return jpaQueryFactory
//                .selectFrom(userMission) // userMission 테이블에서 데이터를 선택
//                .join(usermission.mission, mission) // userMission과 관련된 mission을 조인
//                .fetchJoin() // fetch join을 통해 mission을 함께 로드하여 성능을 최적화
//                .where(predicate) // 동적으로 생성한 조건을 적용
//                .limit(limit) // 반환할 결과의 최대 개수를 제한
//                .fetch(); // 쿼리를 실행하여 결과를 리스트로 반환
//    }
//}
