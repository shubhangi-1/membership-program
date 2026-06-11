package com.firstclub.service;

import com.firstclub.entity.MembershipTier;
import com.firstclub.entity.User;

public interface TierEvaluationService {

    MembershipTier evaluateTier(User user);
}