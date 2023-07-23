package com.rank.assessment.player.service;

import java.util.List;

import com.rank.assessment.player.model.Player;
import com.rank.assessment.player.model.Transaction;

public interface IPlayerService {
	
	public Player getPlayerById(Integer id);
	
	public Player getPlayerByUsername(String username);
	
	public Transaction updateBalance(Integer playerId, Transaction trans);
			
	public List<Transaction> getTransactionsByPlayerId(Integer id);
}
