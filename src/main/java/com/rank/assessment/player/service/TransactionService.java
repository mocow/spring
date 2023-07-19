package com.rank.assessment.player.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rank.assessment.player.model.Transaction;
import com.rank.assessment.player.repository.TransactionRepository;

@Service
public class TransactionService implements ITransactionService
{
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public Transaction save(Transaction transaction)
	{
		transaction.setCreatedAt(LocalDateTime.now());
		transaction = transactionRepository.save(transaction);
		return transaction;
	}

	@Override
	public Transaction getTransactionById(long id)
	{
		return transactionRepository.getReferenceById((int) id);
	}

	@Override
	public List<Transaction> getTransactionsByPlayerId(long id)
	{
		return transactionRepository.findLastTransactionsByPlayerId(id, PageRequest.of(0,10));
	}
}
