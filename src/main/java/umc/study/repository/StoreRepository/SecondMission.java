//package umc.study.repository.StoreRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//import umc.study.domain.mapping.Review;
//import umc.study.domain.mapping.User;
///*
//INSERT INTO REVIEW (writer, score, details, created_at, user_id)
//VALUES (‘닉네임1234’, 5, ‘음 너무 맛있어요…..’, NOW( ), 1)
// */
//import javax.persistence.EntityManager;
//
//@Repository
//@RequiredArgsConstructor
//public class SecondMission {
//    private final EntityManager entityManager;
//    @Transactional
//    public void insertReview(String writer, int score, String details, User user) {
//        Review review = Review.builder()
//                .writer(writer) // 작성자 이름 설정
//                .score(score) // 리뷰 점수 설정
//                .details(details) // 리뷰 상세 내용 설정
//                .user(user) // 리뷰 작성자(User 엔티티) 설정
//                .build();
//        entityManager.persist(review);
//    }
//}
