package com.firstclub.service.impl;

import com.firstclub.entity.MembershipTier;
import com.firstclub.entity.User;
import com.firstclub.repository.MembershipTierRepository;
import com.firstclub.service.TierEvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TierEvaluationServiceImpl
        implements TierEvaluationService {

    private final MembershipTierRepository tierRepository;

    @Override
    public MembershipTier evaluateTier(User user) {

        // Cohort-based rule
        if ("VIP".equalsIgnoreCase(user.getCohort())) {
            return tierRepository.findByTierName("PLATINUM")
                    .orElseThrow(() ->
                            new RuntimeException("Platinum tier not found"));
        }

        // Order value rule
        if (user.getMonthlyOrderValue() != null
                && user.getMonthlyOrderValue() >= 50000) {

            return tierRepository.findByTierName("PLATINUM")
                    .orElseThrow(() ->
                            new RuntimeException("Platinum tier not found"));
        }

        // Order count/value rule
        if ((user.getMonthlyOrderCount() != null
                && user.getMonthlyOrderCount() >= 20)
                ||
                (user.getMonthlyOrderValue() != null
                        && user.getMonthlyOrderValue() >= 10000)) {

            return tierRepository.findByTierName("GOLD")
                    .orElseThrow(() ->
                            new RuntimeException("Gold tier not found"));
        }

        return tierRepository.findByTierName("SILVER")
                .orElseThrow(() ->
                        new RuntimeException("Silver tier not found"));
    }
}
