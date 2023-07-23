package com.rank.assessment.player.dto;

import java.math.BigInteger;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TransactionDTOTest
{
	private TransactionDTO transactionDTO;
	
	@BeforeMethod
	public void initTestData()
	{
		transactionDTO = new TransactionDTO("WIN", BigInteger.valueOf(12), 393.02);
	}
	
	@Test
	public void getTransactionType()
	{
		Assert.assertEquals(transactionDTO.getTransactionType(), "WIN");
	}

	@Test
	public void getTransactionId()
	{
		Assert.assertEquals(transactionDTO.getTransactionId(), BigInteger.valueOf(12));
	}

	@Test
	public void getAmount()
	{
		Assert.assertEquals(transactionDTO.getAmount(), 393.02);
	}
}
