//package umc.study.web.controller;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import umc.study.service.M9_API4_MissionService;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/missions")
//public class M9_API4_MissionController {
//
//    private final M9_API4_MissionService missionService;
//
//    @PostMapping("/complete/{missionId}")
//    @Operation(summary = "미션 완료", description = "진행중인 미션을 완료 처리합니다.")
//    @ApiResponses({
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "미션을 찾을 수 없음"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "서버 에러")
//    })
//    public ResponseEntity<String> completeMission(
//            @PathVariable Long missionId,
//            @RequestParam(name = "userId") Long userId) {
//        try {
//            missionService.completeMission(missionId, userId);
//            return ResponseEntity.ok("Mission completed successfully.");
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("Error completing mission.");
//        }
//    }
//}
