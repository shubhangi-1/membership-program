package com.firstclub.controller;

import com.firstclub.dto.CreatePlanRequest;
import com.firstclub.dto.CreateTierRequest;
import com.firstclub.dto.SubscriptionResponse;
import com.firstclub.entity.MembershipPlan;
import com.firstclub.entity.MembershipTier;
import com.firstclub.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    /**
     * Create Membership Plan
     */
    @PostMapping("/plans")
    public MembershipPlan createPlan(
            @Valid @RequestBody CreatePlanRequest request) {

        return adminService.createPlan(request);
    }

    /**
     * Get All Plans
     */
    @GetMapping("/plans")
    public Page<MembershipPlan> getAllPlans(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return adminService.getAllPlans(page, size);
    }

    /**
     * Create Tier
     */
    @PostMapping("/tiers")
    public MembershipTier createTier(
            @Valid @RequestBody CreateTierRequest request) {

        return adminService.createTier(request);
    }

    /**
     * Get All Tiers
     */
    @GetMapping("/tiers")
    public Page<MembershipTier> getAllTiers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return adminService.getAllTiers(page, size);
    }

    /**
     * Update Tier Configuration
     */
    @PutMapping("/tiers/{tierId}")
    public MembershipTier updateTier(
            @PathVariable Long tierId,
            @Valid @RequestBody CreateTierRequest request) {

        return adminService.updateTier(tierId, request);
    }

    /**
     * Delete Tier
     */
    @DeleteMapping("/tiers/{tierId}")
    public void deleteTier(@PathVariable Long tierId) {

        adminService.deleteTier(tierId);
    }

    /**
     * Get All Active Subscriptions
     */
    @GetMapping("/subscriptions")
    public Page<SubscriptionResponse> getSubscriptions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return adminService.getSubscriptions(page, size);
    }

    /**
     * Force Upgrade User Tier
     */
    @PutMapping("/users/{userId}/upgrade/{tier}")
    public SubscriptionResponse forceUpgrade(
            @PathVariable Long userId,
            @PathVariable String tier) {

        return adminService.forceUpgrade(userId, tier);
    }

    /**
     * Force Cancel Membership
     */
    @DeleteMapping("/users/{userId}/membership")
    public void cancelMembership(
            @PathVariable Long userId) {

        adminService.cancelMembership(userId);
    }

    /**
     * Membership Analytics
     */
    @GetMapping("/analytics")
    public MembershipAnalyticsResponse analytics() {

        return adminService.getAnalytics();
    }
}