package app.confectionery.modules.user.controller;

import app.confectionery.modules.order.model.DTO.OrderDetailsDTO;
import app.confectionery.modules.order.service.OrderService;
import app.confectionery.modules.user.model.AccountStatus;
import app.confectionery.modules.user.model.DTO.UserStatusUpdateRequest;
import app.confectionery.modules.user.model.DTO.UserSummaryDTO;
import app.confectionery.modules.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/admin/users")
@RequiredArgsConstructor
public class AdminUserController {

    private final UserService userService;
    private final OrderService orderService;

    @GetMapping("")
    public ResponseEntity<List<UserSummaryDTO>> getUserSummaries() {
        List<UserSummaryDTO> userSummaries = userService.getAllUserSummaries();
        return ResponseEntity.ok(userSummaries);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<OrderDetailsDTO>> getUserOrders(@PathVariable UUID userId) {
        List<OrderDetailsDTO> orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{userId}/status")
    public ResponseEntity<UserSummaryDTO> updateUserStatus(@PathVariable UUID userId, @RequestBody UserStatusUpdateRequest userStatusUpdateRequest) {
        AccountStatus accountStatus = AccountStatus.valueOf(userStatusUpdateRequest.getNewStatus());
        UserSummaryDTO updatedUser = userService.updateUserStatus(userId, accountStatus);
        return ResponseEntity.ok(updatedUser);
    }

}
