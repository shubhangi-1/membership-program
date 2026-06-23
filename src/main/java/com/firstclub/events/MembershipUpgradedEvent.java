package com.firstclub.event;

import com.firstclub.entity.Subscription;

public class MembershipUpgradedEvent {

    private final Long userId;
    private final Long subscriptionId;
    private final String oldTier;
    private final String newTier;
    private final String planName;

    public MembershipUpgradedEvent(Subscription subscription,
                                   String oldTier,
                                   String newTier) {

        this.userId = subscription.getUserId();
        this.subscriptionId = subscription.getId();
        this.planName = subscription.getPlan().getName();
        this.oldTier = oldTier;
        this.newTier = newTier;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public String getOldTier() {
        return oldTier;
    }

    public String getNewTier() {
        return newTier;
    }

    public String getPlanName() {
        return planName;
    }
}
