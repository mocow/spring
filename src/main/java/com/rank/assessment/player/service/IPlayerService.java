package com.rank.assessment.player.service;

import java.util.List;

import com.rank.assessment.player.model.Player;
import com.rank.assessment.player.model.Transaction;

public interface IPlayerService {
	
	public Player getPlayerById(Integer id);
	
	public Player getPlayerByUsername(String username);
	
	public Transaction updateBalance(Transaction trans);
	
	public Transaction save(Transaction transaction);
	
	public Transaction getTransactionById(Integer id);
	
	public List<Transaction> getTransactionsByPlayerId(Integer id);
}
