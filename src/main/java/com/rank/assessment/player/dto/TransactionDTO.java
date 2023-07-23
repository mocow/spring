package com.rank.assessment.player.dto;

import java.math.BigInteger;

public class TransactionDTO
{
	private String transactionType;
	private BigInteger transactionId;
	private double amount;
	
	public TransactionDTO(String transactionType, BigInteger transactionId, double amount)
	{
		this.transactionType = transactionType;
		this.transactionId = transactionId;
		this.amount = amount;
	}

	public String getTransactionType()
	{
		return transactionType;
	}

	public BigInteger getTransactionId()
	{
		return transactionId;
	}

	public double getAmount()
	{
		return amount;
	}
}
