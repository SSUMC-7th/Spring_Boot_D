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
import umc.spring.converter.MissionConverter;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.service.RestaurantService.RestaurantQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistRestaurant;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
@Validated
public class RestaurantController {

    private final MissionCommandService missionCommandService;

    private final RestaurantQueryService restaurantQueryService;

    @PostMapping("/{restaurantId}/missions")
    public ApiResponse<MissionResponseDTO.JoinResultDTO> join(@RequestBody @Valid MissionRequestDTO.JoinDto request, @PathVariable @ExistRestaurant Long restaurantId) {
        Mission mission = missionCommandService.joinMission(request, restaurantId);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }

    @GetMapping("/{restaurantId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API 이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH005", description = "access 토큰 모양이 이상합니다.", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDTO> getPreviewList(@ExistRestaurant @PathVariable(name = "restaurantId") Long restaurantId, @RequestParam(name = "page") Integer page) {
        Page<Review> reviewList = restaurantQueryService.getReviewList(restaurantId, page);
        return ApiResponse.onSuccess(RestaurantConverter.reviewPreviewListDTO(reviewList));
    }

    @GetMapping("/{restaurantId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션들의 목록을 조회하는 API 이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH005", description = "access 토큰 모양이 이상합니다.", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.MissionPreviewListDTO> getMissionPreviewList(@ExistRestaurant @PathVariable(name = "restaurantId") Long restaurantId, @CheckPage @RequestParam(name = "page") Integer page) {
        Page<Mission> missionList = restaurantQueryService.getMissionList(restaurantId, page-1);
        return ApiResponse.onSuccess(RestaurantConverter.missionPreviewListDTO(missionList));
    }

}
