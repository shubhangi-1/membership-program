package com.firstclub.controller;

import com.firstclub.dto.SubscribeRequest;
import com.firstclub.entity.MembershipPlan;
import com.firstclub.entity.UserMembership;
import com.firstclub.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memberships")
@RequiredArgsConstructor
public class MembershipController {

    private final MembershipService membershipService;

    /**
     * Get all available plans
     */
    @GetMapping("/plans")
    public List<MembershipPlan> getPlans() {
        return membershipService.getAllPlans();
    }

    /**
     * Subscribe to a membership
     */
    @PostMapping("/subscribe")
    public UserMembership subscribe(
            @RequestBody SubscribeRequest request) {

        return membershipService.subscribe(request);
    }

    /**
     * Upgrade/Downgrade Tier
     */
    @PutMapping("/{membershipId}/tier/{tierId}")
    public UserMembership changeTier(
            @PathVariable Long membershipId,
            @PathVariable Long tierId) {

        return membershipService.changeTier(
                membershipId,
                tierId);
    }

    /**
     * Cancel Membership
     */
    @DeleteMapping("/{membershipId}")
    public String cancelMembership(
            @PathVariable Long membershipId) {

        membershipService.cancelMembership(membershipId);

        return "Membership cancelled successfully";
    }

    /**
     * Get Current Membership
     */
    @GetMapping("/user/{userId}")
    public UserMembership getMembership(
            @PathVariable Long userId) {

        return membershipService.getActiveMembership(userId);
    }

    /**
     * Check Expiry
     */
    @GetMapping("/{membershipId}/expiry")
    public String getExpiryDate(
            @PathVariable Long membershipId) {

        UserMembership membership =
                membershipService.getMembership(membershipId);

        return "Membership expires on : "
                + membership.getExpiryDate();
    }
}