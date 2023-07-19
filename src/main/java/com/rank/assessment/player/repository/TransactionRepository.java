package com.rank.assessment.player.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rank.assessment.player.model.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>
{

	@Query("SELECT t FROM Transaction t WHERE t.playerId = ?1 ORDER BY tcreatedAt DESC")
	List<Transaction> findLastTransactionsByPlayerId(long playerId,  Pageable pageable);
	
}
