package com.rank.assessment.player.dto;

import java.math.BigInteger;

public class CurrentTransactionBalanceDTO
{
	private BigInteger transactionId;
	private double balance;
	
	
	public CurrentTransactionBalanceDTO(BigInteger transactionId, double balance)
	{
		this.transactionId = transactionId;
		this.balance = balance;
	}
	
	public BigInteger getTransactionId()
	{
		return transactionId;
	}
	
	public void setTransactionId(BigInteger transactionId)
	{
		this.transactionId = transactionId;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
}
