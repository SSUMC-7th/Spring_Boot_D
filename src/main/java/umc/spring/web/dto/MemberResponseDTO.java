package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO {
        Long memberId;
        LocalDateTime createdAt;
    }

    //나의 리뷰 목록
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class myReviewPreViewListDTO {
        List<myReviewPreViewDTO> myReviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class myReviewPreViewDTO {
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }

    //나의 미션 목록
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class myMissionPreViewListDTO {
        List<myMissionPreViewDTO> myMissionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class myMissionPreViewDTO {
        String storeName;
        Integer reward;
        String missionSpec;
        LocalDate deadline;
    }
}