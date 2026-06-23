package com.firstclub.repository;

import com.firstclub.entity.MembershipPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipPlanRepository
        extends JpaRepository<MembershipPlan, Long> {

    Optional<MembershipPlan> findByPlanName(String planName);

    boolean existsByPlanName(String planName);

}
