package com.rank.assessment.player.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rank.assessment.exception.PlayerBadRequestException;
import com.rank.assessment.exception.PlayerTeaPotException;
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
		Player player = playerRepository.findById(id).
		orElse(null);
		
		if(player == null)
		{
			throw new PlayerBadRequestException("Player with ID ("+id+") is not found.");
		}
		
		return player;
	}

	@Override
	public Player getPlayerByUsername(String username)
	{
		Player player =  playerRepository.findPlayerByUsername(username)
				.orElse(null);
		
		if(player == null)
		{
			throw new PlayerBadRequestException("Player with userame ("+username+") is not found.");
		}
		return player;
	}

	@Override
	@Transactional
	public Transaction updateBalance(Integer playerId, Transaction transaction)
	{
		if(transaction.getAmount() < 0)
		{
			throw new PlayerBadRequestException(("Error: amount is not suppose to be negative."));
		}
		
		if(!transaction.isWager() && !transaction.isWin())
		{
			throw new PlayerBadRequestException(("Expected transaction type to be WAGER or WIN "));
		}
		
		Player player = this.getPlayerById(playerId);
		
		if(transaction.isWager() && transaction.getAmount() >  player.getAccountBalance().getAmount())
		{
			throw new PlayerTeaPotException("You dont have enough funds.");
		}
		
		transaction.setPlayerId(playerId);
		transaction.setPlayer(player);
		transaction = transactionRepository.save(transaction);
		
		AccountBalance balance = transaction.getPlayer().getAccountBalance();
		balance.setAmount(balance.getAmount() + transaction.getTransactionAmount());
		accountBalanceRepository.save(balance);
		
		return transaction;
	}

	@Override
	public List<Transaction> getTransactionsByPlayerId(Integer id)
	{
		return transactionRepository.findLastTransactionsByPlayerId(id, PageRequest.of(0,10));
	}
}
