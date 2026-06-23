package com.firstclub.scheduler;

import com.firstclub.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ExpiryScheduler {

    private final SubscriptionRepository subscriptionRepository;

    /**
     * Runs every day at midnight
     * Expires all subscriptions whose expiryDate < today
     */
    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public void expireSubscriptions() {

        int updatedRows = subscriptionRepository.expireOldSubscriptions();

        System.out.println(
                "ExpiryScheduler executed. Rows updated: " + updatedRows
        );
    }
}
