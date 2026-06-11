package com.firstclub.service;

import com.firstclub.dto.SubscribeRequest;
import com.firstclub.entity.MembershipPlan;
import com.firstclub.entity.UserMembership;

import java.util.List;

public interface MembershipService {

    List<MembershipPlan> getAllPlans();

    UserMembership subscribe(SubscribeRequest request);

    UserMembership upgradeTier(Long membershipId,
                               Long tierId);

    void cancelMembership(Long membershipId);

    UserMembership getMembership(Long userId);
}