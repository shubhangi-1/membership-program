package com.firstclub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User who owns subscription
    private Long userId;

    // Membership Plan (Monthly/Quarterly/Yearly)
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private MembershipPlan plan;

    // Current Tier (Silver/Gold/Platinum)
    @ManyToOne
    @JoinColumn(name = "tier_id")
    private MembershipTier tier;

    private LocalDate startDate;

    private LocalDate expiryDate;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

        if (this.status == null) {
            this.status = SubscriptionStatus.ACTIVE;
        }

        if (this.startDate == null) {
            this.startDate = LocalDate.now();
        }
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
