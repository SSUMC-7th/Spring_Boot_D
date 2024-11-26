package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.MissionAssigned;
import umc.spring.web.dto.MissionAssignedResponseDTO;
import umc.spring.web.dto.ReviewResponseDTO;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDto request) {
        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return User.builder()
                .nickname(request.getNickname())
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .userPreferredFoodList(new ArrayList<>())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review) {
        return ReviewResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getUser().getNickname())
                .score(review.getRating())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getContent())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO(Page<Review> reviewList) {

        List<ReviewResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewList.stream()
                .map(UserConverter::reviewPreviewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDTOList.size())
                .reviewList(reviewPreviewDTOList)
                .build();
    }

    public static MissionAssignedResponseDTO.MissionAssignedPreviewDTO missionAssignedPreviewDTO(MissionAssigned missionAssigned) {
        return MissionAssignedResponseDTO.MissionAssignedPreviewDTO.builder()
                .userName(missionAssigned.getUser().getNickname())
                .content(missionAssigned.getMission().getContent())
                .point(missionAssigned.getMission().getGetPoint())
                .dueDate(missionAssigned.getDueDate())
                .build();
    }

    public static MissionAssignedResponseDTO.MissionAssignedPreviewListDTO missionAssignedPreviewListDTO(Page<MissionAssigned> missionAssignedList) {

        List<MissionAssignedResponseDTO.MissionAssignedPreviewDTO> missionAssignedPreviewDTOList = missionAssignedList.stream()
                .map(UserConverter::missionAssignedPreviewDTO).collect(Collectors.toList());

        return MissionAssignedResponseDTO.MissionAssignedPreviewListDTO.builder()
                .isLast(missionAssignedList.isLast())
                .isFirst(missionAssignedList.isFirst())
                .totalPage(missionAssignedList.getTotalPages())
                .totalElements(missionAssignedList.getTotalElements())
                .listSize(missionAssignedPreviewDTOList.size())
                .missionAssignedList(missionAssignedPreviewDTOList)
                .build();
    }

}