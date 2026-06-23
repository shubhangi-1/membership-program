package com.firstclub.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpgradeRequest {

    @NotNull(message = "UserId is required")
    private Long userId;

    @NotNull(message = "TierId is required")
    private Long tierId;
}
