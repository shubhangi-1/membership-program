package com.firstclub.repository;

import com.firstclub.entity.Subscription;
import com.firstclub.entity.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    /**
     * Find subscription by userId (active subscription)
     */
    Optional<Subscription> findByUserId(Long userId);

    /**
     * Find subscriptions by status
     */
    List<Subscription> findByStatus(SubscriptionStatus status);

    /**
     * Find active subscriptions
     */
    List<Subscription> findByStatusAndExpiryDateAfter(
            SubscriptionStatus status,
            LocalDate date
    );

    /**
     * Find expired subscriptions
     */
    List<Subscription> findByExpiryDateBefore(LocalDate date);

    /**
     * Check if user has active subscription
     */
    boolean existsByUserIdAndStatus(Long userId, SubscriptionStatus status);

    /**
     * Get all subscriptions expiring soon (for notifications)
     */
    List<Subscription> findByExpiryDateBetween(
            LocalDate start,
            LocalDate end
    );

    /**
     * Bulk update: expire subscriptions (used by scheduler)
     */
    @Modifying
    @Query("""
        update Subscription s
        set s.status = 'EXPIRED'
        where s.status = 'ACTIVE'
        and s.expiryDate < CURRENT_DATE
    """)
    int expireOldSubscriptions();
}
