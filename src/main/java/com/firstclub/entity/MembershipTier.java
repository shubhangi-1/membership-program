package com.firstclub.entity; 


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "membership_tier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MembershipTier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tierName;

    private Double discountPercent;

    private Boolean freeDelivery;

    private Boolean prioritySupport;
}