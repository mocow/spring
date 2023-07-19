package com.rank.assessment.player.service;

import java.util.List;

import com.rank.assessment.player.model.Transaction;

public interface ITransactionService {
	
	public Transaction save(Transaction transaction);
	
	public Transaction getTransactionById(long id);
	
	public List<Transaction> getTransactionsByPlayerId(long id);
	

}
