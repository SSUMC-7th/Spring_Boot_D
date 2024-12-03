package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.converter.UserConverter;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.domain.mapping.MissionAssigned;
import umc.spring.service.UserService.UserCommandService;
import umc.spring.service.UserService.UserQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistRestaurant;
import umc.spring.validation.annotation.ExistUser;
import umc.spring.web.dto.MissionAssignedResponseDTO;
import umc.spring.web.dto.ReviewResponseDTO;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Validated
public class UserController {

    private final UserCommandService userCommandService;

    private final UserQueryService userQueryService;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request) {
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

    @GetMapping("/{userId}/reviews")
    @Operation(summary = "특정 유저의 리뷰 목록 조회 API", description = "특정 유저의 리뷰들의 목록을 조회하는 API 이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요. 실제 구현 시 userId는 accessToken 에서 추출하여 얻을 수 있습니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH005", description = "access 토큰 모양이 이상합니다.", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDTO> getPreviewList(@ExistUser @PathVariable(name = "userId") Long userId, @CheckPage @RequestParam(name = "page") Integer page) {

        Page<Review> reviewList = userQueryService.getReviewList(userId, page-1);
        return ApiResponse.onSuccess(UserConverter.reviewPreviewListDTO(reviewList));
    }

    @GetMapping("/{userId}/assignedMissions")
    @Operation(summary = "특정 유저의 진행 중인 미션 목록 조회 API", description = "특정 유저의 진행 중인 미션들의 목록을 조회하는 API 이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요. 실제 구현 시 userId는 accessToken 에서 추출하여 얻을 수 있습니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH005", description = "access 토큰 모양이 이상합니다.", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionAssignedResponseDTO.MissionAssignedPreviewListDTO> getMissionAssignedPreviewList(@ExistUser @PathVariable(name = "userId") Long userId, @CheckPage @RequestParam(name = "page") Integer page) {

        Page<MissionAssigned> missionAssignedList = userQueryService.getMissionAssignedList(userId, page-1);
        return ApiResponse.onSuccess(UserConverter.missionAssignedPreviewListDTO(missionAssignedList));
    }

    @GetMapping("/{userId}/completedAssignedMissions")
    @Operation(summary = "특정 유저의 완료된 미션 목록 조회 API", description = "특정 유저의 완료된 미션들의 목록을 조회하는 API 이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요. 실제 구현 시 userId는 accessToken 에서 추출하여 얻을 수 있습니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH005", description = "access 토큰 모양이 이상합니다.", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionAssignedResponseDTO.MissionAssignedPreviewListDTO> getCompletedMissionAssignedPreviewList(@ExistUser @PathVariable(name = "userId") Long userId, @CheckPage @RequestParam(name = "page") Integer page) {

        Page<MissionAssigned> missionAssignedList = userQueryService.getCompletedMissionAssignedList(userId, page-1);
        return ApiResponse.onSuccess(UserConverter.missionAssignedPreviewListDTO(missionAssignedList));
    }

}
