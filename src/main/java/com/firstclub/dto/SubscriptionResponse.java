package com.firstclub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionResponse {

    private Long userId;

    private String planName;

    private String tierName;

    private LocalDate startDate;

    private LocalDate expiryDate;

    private String status;
}
