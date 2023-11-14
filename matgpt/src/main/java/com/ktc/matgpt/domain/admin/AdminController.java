package com.ktc.matgpt.domain.admin;

import com.ktc.matgpt.domain.review.ReviewService;
import com.ktc.matgpt.domain.review.dto.ReviewRequest;
import com.ktc.matgpt.domain.store.StoreRequest;
import com.ktc.matgpt.domain.store.StoreService;
import com.ktc.matgpt.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin")
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final StoreService storeService;
    private final ReviewService reviewService;

    @PostMapping("/stores")
    public ResponseEntity<?> addStore(@RequestBody StoreRequest.AddStoreDto addStoreDto) {
        storeService.addStore(addStoreDto);
        return ResponseEntity.ok(ApiUtils.success("success"));
    }

    @PutMapping("/stores/{storeId}/name")
    public ResponseEntity<?> updateStoreName(@PathVariable Long storeId,
                                             @RequestBody StoreRequest.UpdateStoreNameDto updateStoreNameDto) {
        storeService.updateStoreName(storeId, updateStoreNameDto);
        return ResponseEntity.ok(ApiUtils.success("success"));
    }

    @PutMapping("/stores/{storeId}/image")
    public ResponseEntity<?> updateStoreImageUrl(@PathVariable Long storeId,
                                                 @RequestBody StoreRequest.UpdateStoreImageDto updateStoreImageDto) {
        storeService.updateStoreImageUrl(storeId, updateStoreImageDto);
        return ResponseEntity.ok(ApiUtils.success("success"));
    }
}
