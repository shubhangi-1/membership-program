package com.firstclub.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class CreateTierRequest {

    @NotBlank(message = "Tier name is required")
    private String tierName; // SILVER, GOLD, PLATINUM

    @NotNull(message = "Minimum orders is required")
    @Min(value = 0, message = "Minimum orders cannot be negative")
    private Integer minOrders;

    @NotNull(message = "Minimum order value is required")
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal minOrderValue;

    private String cohort; // optional (e.g. premium users, region-based)

    @NotNull(message = "Discount percent is required")
    @Min(value = 0)
    @Max(value = 100)
    private Integer discountPercent;

    private Boolean freeDelivery = false;

    private Boolean prioritySupport = false;

    // getters and setters
}
