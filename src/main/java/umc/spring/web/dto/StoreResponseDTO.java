package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


public class StoreResponseDTO {


//    가게 리뷰 목록
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO {
        List<ReviewPreViewDTO> reviewList;
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
    public static class ReviewPreViewDTO {
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }

        @Builder
        @Getter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class StoreMissionPreViewListDTO {
            List<StoreMissionPreViewDTO> missionList;
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
        public static class StoreMissionPreViewDTO {
            String storeName;
            Integer reward;
            String missionSpec;
            LocalDate deadline;
        }
}
