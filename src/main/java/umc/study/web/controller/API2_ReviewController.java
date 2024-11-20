package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.API2_ReviewService;
import umc.study.web.dto.API2_ReviewRequestDTO;
import umc.study.web.dto.API2_ReviewResponseDTO;

@RestController
@RequestMapping("/api2/stores")
@RequiredArgsConstructor
public class API2_ReviewController {

    private final API2_ReviewService reviewService;

    @PostMapping(value = "/{storeId}/reviews", consumes = "application/json", produces = "application/json")
    public ResponseEntity<API2_ReviewResponseDTO> addReview(
            @PathVariable Long storeId,
            @RequestBody @Valid API2_ReviewRequestDTO request) {
        API2_ReviewResponseDTO response = reviewService.addReview(storeId, request);
        return ResponseEntity.ok(response);
    }
}

