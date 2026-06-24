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

    private String tierName; // Silver, Gold, Platinum

    private Integer minOrders;

    private BigDecimal minOrderValue;

    private String cohort;

    private Integer discountPercentage;

    private Boolean freeDelivery;

    private Boolean prioritySupport;

    @OneToMany(mappedBy = "tier")
    private List<Benefit> benefits;

}
