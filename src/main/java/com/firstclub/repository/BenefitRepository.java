package com.firstclub.repository;

import com.firstclub.entity.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BenefitRepository extends JpaRepository<Benefit, Long> {

    /**
     * Find benefit by name (useful for admin config)
     */
    Optional<Benefit> findByName(String name);

    /**
     * Check if benefit exists by name
     */
    boolean existsByName(String name);
}
