package com.firstclub.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "benefits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Benefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String benefitKey;

    private String benefitValue;

    @ManyToOne
    @JoinColumn(name = "tier_id")
    private MembershipTier tier;

    // getters setters

}
