package com.firstclub.service.impl;

import com.firstclub.dto.CreatePlanRequest;
import com.firstclub.dto.CreateTierRequest;
import com.firstclub.entity.MembershipPlan;
import com.firstclub.entity.MembershipTier;
import com.firstclub.repository.MembershipPlanRepository;
import com.firstclub.repository.MembershipTierRepository;
import com.firstclub.repository.SubscriptionRepository;
import com.firstclub.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final MembershipPlanRepository planRepository;
    private final MembershipTierRepository tierRepository;
    private final SubscriptionRepository subscriptionRepository;

    @Override
    @Transactional
    public MembershipPlan createPlan(CreatePlanRequest request) {

        MembershipPlan plan = new MembershipPlan();

        plan.setName(request.getName());
        plan.setDurationInDays(request.getDurationInDays());
        plan.setPrice(request.getPrice());
        plan.setActive(request.getActive() != null ? request.getActive() : true);

        return planRepository.save(plan);
    }

    @Override
    @Transactional
    public MembershipTier createTier(CreateTierRequest request) {

        MembershipTier tier = new MembershipTier();

        tier.setTierName(request.getTierName());
        tier.setMinOrders(request.getMinOrders());
        tier.setMinOrderValue(request.getMinOrderValue());
        tier.setCohort(request.getCohort());
        tier.setDiscountPercent(request.getDiscountPercent());
        tier.setFreeDelivery(
                request.getFreeDelivery() != null ? request.getFreeDelivery() : false
        );
        tier.setPrioritySupport(
                request.getPrioritySupport() != null ? request.getPrioritySupport() : false
        );

        return tierRepository.save(tier);
    }
}
