package org.example.projectspringfalling.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Query("SELECT p FROM Payment p JOIN FETCH p.user JOIN FETCH p.subscription WHERE p.transactionId = :transactionId")
    Optional<Payment> findByTransactionId(@Param("transactionId") String transactionId);

    @Query("SELECT p FROM Payment p JOIN FETCH p.user JOIN FETCH p.subscription WHERE p.user.id = :userId")
    Optional<Payment> findByUserId(@Param("userId") Integer userId);

    @Query("SELECT p FROM Payment p JOIN FETCH p.user WHERE p.user.id = :userId AND p.status ='paid' ORDER BY p.createdAt DESC")
    List<Payment> findByUserIdForRefund(@Param("userId") Integer userId);
}
