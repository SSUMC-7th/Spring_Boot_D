package umc.study.web.dto;

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
    public static class JoinResultDTO{
        Long memberId;
        LocalDateTime createdAt;
        Integer gender;
        Integer age;
        String address;
        String specAddress;
        String name;
        String email;
        String phone;
        List<Long> memberPreferList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyOngoingMissionPreviewListDTO{
        List<MyOngoingMissionPreviewDTO> myOngoingMissionList;
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
    public static class MyOngoingMissionPreviewDTO{
        String storeName;
        Long storeId;
        Long missionId;
        String description;
        String status;
        Integer reward;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyReviewPreviewListDTO{
        List<MyReviewPreviewDTO> myreviewPreviewList;
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
    public static class MyReviewPreviewDTO{
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }
}
