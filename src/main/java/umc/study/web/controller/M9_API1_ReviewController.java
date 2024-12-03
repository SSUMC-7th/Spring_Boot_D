//package umc.study.web.controller;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import umc.study.service.M9_API1_ReviewService;
//import umc.study.validation.annotation.M9_API1_CheckPage;
//import umc.study.web.dto.M9_API1_ReviewResponseDTO;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/reviews")
//public class M9_API1_ReviewController {
//
//    private final M9_API1_ReviewService reviewService;
//
//    @GetMapping("/store")
//    @Operation(summary = "내가 작성한 리뷰 목록", description = "내가 작성한 리뷰 목록을 페이징 처리하여 조회합니다.")
//    @ApiResponses({
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "가게를 찾을 수 없음"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "서버 에러")
//    })
//    public ResponseEntity<Page<M9_API1_ReviewResponseDTO>> getStoreReviews(
//            @RequestParam(name = "userId") Long userId,
//            @RequestParam(name = "page", defaultValue = "0") @M9_API1_CheckPage Integer page) {
//
//        Page<M9_API1_ReviewResponseDTO> reviews = reviewService.getReviewList(userId, page);
//
//        return ResponseEntity.ok(reviews);
//    }
//}
