//package umc.study.repository.StoreRepository;
//
//import com.querydsl.core.types.dsl.CaseBuilder;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//import umc.study.domain.mapping.QInquiry;
//import umc.study.domain.mapping.QMission_point;
//import umc.study.domain.mapping.QReview;
//import umc.study.domain.mapping.QUser;
///*
//SELECT
//u.nickname
//u.phone
//CASE
//WHEN u.phone IS NULL THEN '미인증'
//
//ELSE '인증'
//END AS phone_status,
//
//COALESCE(SUM(mp.attainment_mission), 0)
//COUNT(Review.id) AS review_count,//
//COUNT(Inquiry.id) AS inquiry_count//
//FROM
//User AS u
//LEFT JOIN MissionPoint ON u.id = MissionPoint.user_id
//LEFT JOIN Review ON u.id = Review.user_id
//LEFT JOIN Inquiry ON u.id = Inquiry.user_id
//WHERE u.id = 1
//GROUP BY u.id;
// */
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class FourthMission {
//
//    private final JPAQueryFactory jpaQueryFactory;
//
//    public List<Object[]> fetchUserProfile(Long userId) {
//        QUser user = QUser.user;
//        QMission_point mission_point = QMission_point.mission_point;
//        QReview review = QReview.review;
//        QInquiry inquiry = QInquiry.inquiry;
//
//        return jpaQueryFactory
//                .select(
//                        user.nickname, // 사용자 닉네임 선택
//                        user.phone, // 사용자 전화번호 선택
//                        new CaseBuilder() // CASE WHEN 구문을 사용하여 인증 상태를 설정
//                                .when(user.phone.isNull()).then("미인증") // 전화번호가 null이면 "미인증" 반환
//                                .otherwise("인증"), // 그렇지 않으면 "인증" 반환
//                        mission_point.attainment_mission.sum().coalesce(0L), // 미션 성취 합계 (null일 경우 0으로 대체)
//                        review.id.count(), // 작성한 리뷰 개수
//                        inquiry.id.count() // 1:1 문의 개수
//                )
//                .from(user) // user 테이블을 기준으로 쿼리를 시작합니다.
//                .leftJoin(mission_point).on(mission_point.user.id.eq(user.id)) // user와 mission_point를 사용자 ID로 조인
//                .leftJoin(review).on(review.user.id.eq(user.id)) // user와 review를 사용자 ID로 조인
//                .leftJoin(inquiry).on(inquiry.user.id.eq(user.id)) // user와 inquiry를 사용자 ID로 조인
//                .where(user.id.eq(userId)) // 주어진 userId와 일치하는 사용자만 선택
//                .groupBy(user.id) // user ID로 그룹화하여 각 사용자의 집계 정보를 가져옴
//                .fetch() // 쿼리를 실행하여 결과를 List로 반환
//
//                // fetch한 결과를 Object[] 배열 형태로 변환
//                .stream()
//                .map(tuple -> new Object[]{
//                        tuple.get(user.nickname), // 닉네임
//                        tuple.get(user.phone), // 전화번호
//                        tuple.get(new CaseBuilder().when(user.phone.isNull()).then("미인증").otherwise("인증")), // 인증 상태
//                        tuple.get(mission_point.attainment_mission.sum().coalesce(0L)), // 성취 미션 합계
//                        tuple.get(review.id.count()), // 리뷰 개수
//                        tuple.get(inquiry.id.count()) // 문의 개수
//                })
//                .toList(); // 최종적으로 Object[] 형태의 리스트로 반환
//    }
//}
