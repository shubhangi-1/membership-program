package com.firstclub.repository;

import com.firstclub.entity.MembershipStatus;
import com.firstclub.entity.UserMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserMembershipRepository
        extends JpaRepository<UserMembership, Long> {

   @Lock(LockModeType.PESSIMISTIC_WRITE)
   @Query("""
                SELECT m
                FROM UserMembership m
                WHERE m.id = :id
        """)
        Optional<UserMembership> findByIdForUpdate(Long id);

    Optional<UserMembership> findByUserIdAndStatus(
            Long userId,
            MembershipStatus status);

    List<UserMembership> findByStatus(
            MembershipStatus status);

    boolean existsByUserIdAndStatus(
            Long userId,
            MembershipStatus status);
}
