package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.API1_StoreService;
import umc.study.web.dto.API1_StoreRequestDTO;
import umc.study.web.dto.API1_StoreResponseDTO;

@RestController
@RequestMapping("/api1/regions")
@RequiredArgsConstructor
public class API1_RegionController {

    private final API1_StoreService storeService;

    @PostMapping(value = "/{regionId}/stores", consumes = "application/json", produces = "application/json")
    public ResponseEntity<API1_StoreResponseDTO> addStore(
            @PathVariable Long regionId,
            @RequestBody API1_StoreRequestDTO request) {
        API1_StoreResponseDTO response = storeService.addStore(regionId, request);
        return ResponseEntity.ok(response);

    }
}

