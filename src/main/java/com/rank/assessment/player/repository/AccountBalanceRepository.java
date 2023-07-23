package com.rank.assessment.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rank.assessment.player.model.AccountBalance;


@Repository
public interface AccountBalanceRepository extends JpaRepository<AccountBalance, Integer>
{
	
}
