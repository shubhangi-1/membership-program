package com.firstclub.repository;

import com.firstclub.entity.Order;
import com.firstclub.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * Find all orders of a user
     */
    List<Order> findByUserId(Long userId);

    /**
     * Find orders by status
     */
    List<Order> findByStatus(OrderStatus status);

    /**
     * Find orders of a user in a time range (used for tier calculation)
     */
    List<Order> findByUserIdAndCreatedAtBetween(
            Long userId,
            LocalDateTime start,
            LocalDateTime end
    );

    /**
     * Count total orders of a user
     */
    long countByUserId(Long userId);

    /**
     * Sum total spending of a user
     */
    @Query("SELECT COALESCE(SUM(o.totalAmount), 0) FROM Order o WHERE o.userId = :userId")
    double getTotalSpentByUser(Long userId);

    /**
     * Bulk update (useful for analytics or cleanup)
     */
    @Modifying
    @Query("""
        update Order o
        set o.status = 'CANCELLED'
        where o.status = 'PLACED'
        and o.createdAt < :cutoff
    """)
    int cancelOldOrders(LocalDateTime cutoff);
}
