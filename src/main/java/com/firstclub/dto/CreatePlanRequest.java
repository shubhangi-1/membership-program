
package com.firstclub.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class CreatePlanRequest {

    @NotBlank(message = "Plan name is required")
    private String name;

    @NotNull(message = "Duration is required")
    private Integer durationInDays;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    private Boolean active = true;

    // getters and setters
}
