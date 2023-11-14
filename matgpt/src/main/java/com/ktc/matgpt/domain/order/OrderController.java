package com.ktc.matgpt.domain.order;

import com.ktc.matgpt.security.UserPrincipal;
import com.ktc.matgpt.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order/save")
    public ResponseEntity<?> saveOrder(@AuthenticationPrincipal UserPrincipal userPrincipal,
                                       @RequestBody OrderRequest orderRequest) {
        Long orderId = orderService.save(userPrincipal.getId(), orderRequest);
        return ResponseEntity.ok(ApiUtils.success(orderId));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getOrder(@AuthenticationPrincipal UserPrincipal userPrincipal,
                                      @RequestParam Long orderId) {
        OrderResponse orderResponse = orderService.getOrder(userPrincipal.getId(), orderId);
        return ResponseEntity.ok(ApiUtils.success(orderResponse));
    }
}
