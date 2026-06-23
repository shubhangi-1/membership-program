package com.firstclub.event;

import com.firstclub.entity.Subscription;

public class MembershipCreatedEvent {

    private final Long userId;
    private final Long subscriptionId;
    private final String planName;
    private final String tierName;

    public MembershipCreatedEvent(Subscription subscription) {
        this.userId = subscription.getUserId();
        this.subscriptionId = subscription.getId();
        this.planName = subscription.getPlan().getName();
        this.tierName = subscription.getTier().getTierName();
    }

    public Long getUserId() {
        return userId;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public String getPlanName() {
        return planName;
    }

    public String getTierName() {
        return tierName;
    }
}
