package com.firstclub.service.impl;

import com.firstclub.dto.SubscribeRequest;
import com.firstclub.entity.*;
import com.firstclub.repository.*;
import com.firstclub.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MembershipServiceImpl
        implements MembershipService {

    private final UserRepository userRepository;

    private final MembershipPlanRepository planRepository;

    private final MembershipTierRepository tierRepository;

    private final UserMembershipRepository membershipRepository;

    @Override
    public List<MembershipPlan> getAllPlans() {

        return planRepository.findAll();
    }

    @Override
    @Transactional
    public UserMembership subscribe(
            SubscribeRequest request) {

        if (membershipRepository
                .existsByUserIdAndStatus(
                        request.getUserId(),
                        MembershipStatus.ACTIVE)) {

            throw new RuntimeException(
                    "User already has an active membership");
        }

        User user = userRepository
        .findByIdForUpdate(request.getUserId())
        .orElseThrow(() -> new RuntimeException("User not found"));
            
        // User user = userRepository.findById(
        //         request.getUserId())
        //         .orElseThrow(() ->
        //                 new RuntimeException("User not found"));

        MembershipPlan plan = planRepository
                .findById(request.getPlanId())
                .orElseThrow(() ->
                        new RuntimeException("Plan not found"));

        MembershipTier tier = tierRepository
                .findById(request.getTierId())
                .orElseThrow(() ->
                        new RuntimeException("Tier not found"));

        UserMembership membership =
                UserMembership.builder()
                        .user(user)
                        .plan(plan)
                        .tier(tier)
                        .startDate(LocalDate.now())
                        .expiryDate(
                                LocalDate.now().plusDays(
                                        plan.getValidityDays()))
                        .status(MembershipStatus.ACTIVE)
                        .build();

        return membershipRepository.save(membership);
    }

    @Override
    @Transactional
    public UserMembership upgradeTier(
            Long membershipId,
            Long tierId) {

        UserMembership membership =
                membershipRepository.findById(
                        membershipId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Membership not found"));

        MembershipTier tier =
                tierRepository.findById(tierId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Tier not found"));

        membership.setTier(tier);

        return membershipRepository.save(
                membership);
    }

    @Override
    @Transactional
    public void cancelMembership(
            Long membershipId) {

        UserMembership membership =
                membershipRepository.findById(
                        membershipId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Membership not found"));

        membership.setStatus(
                MembershipStatus.CANCELLED);

        membershipRepository.save(membership);
    }

    @Override
    public UserMembership getMembership(
            Long userId) {

        return membershipRepository
                .findByUserIdAndStatus(
                        userId,
                        MembershipStatus.ACTIVE)
                .orElseThrow(() ->
                        new RuntimeException(
                                "No active membership found"));
    }
}
