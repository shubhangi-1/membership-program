package com.firstclub.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SubscribeRequest {

    @NotNull(message = "UserId is required")
    private Long userId;

    @NotNull(message = "PlanId is required")
    private Long planId;

    @NotNull(message = "TierId is required")
    private Long tierId;
}
