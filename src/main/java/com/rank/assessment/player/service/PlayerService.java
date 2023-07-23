package com.rank.assessment.player.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rank.assessment.player.model.AccountBalance;
import com.rank.assessment.player.model.Player;
import com.rank.assessment.player.model.Transaction;
import com.rank.assessment.player.repository.AccountBalanceRepository;
import com.rank.assessment.player.repository.PlayerRepository;
import com.rank.assessment.player.repository.TransactionRepository;

@Service
public class PlayerService implements IPlayerService
{
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private final PlayerRepository playerRepository;
	
	@Autowired
	AccountBalanceRepository accountBalanceRepository;
	
	public PlayerService(PlayerRepository playerRepository)
	{
		this.playerRepository = playerRepository;
	}
	
	@Override
	public Player getPlayerById(Integer id)
	{
		return playerRepository.findById(id).
				orElse(null);
	}

	@Override
	public Player getPlayerByUsername(String username)
	{
		return playerRepository.findPlayerByUsername(username)
				.orElse(null);
		
	}

	@Override
	public Transaction updateBalance(Transaction trans)
	{
		trans = transactionRepository.save(trans);
		AccountBalance balance = trans.getPlayer().getAccountBalance();
		balance.setAmount(balance.getAmount() + trans.getTransactionAmount());
		accountBalanceRepository.save(balance);
		return trans;
	}
	
	@Override
	public Transaction save(Transaction transaction)
	{
		transaction.setCreatedAt(LocalDateTime.now());
		transaction = transactionRepository.save(transaction);
		return transaction;
	}

	@Override
	public Transaction getTransactionById(Integer id)
	{
		return transactionRepository.getReferenceById(id);
	}

	@Override
	public List<Transaction> getTransactionsByPlayerId(Integer id)
	{
		return transactionRepository.findLastTransactionsByPlayerId(id, PageRequest.of(0,10));
	}
}
