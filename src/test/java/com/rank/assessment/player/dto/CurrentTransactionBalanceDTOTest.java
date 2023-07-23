package com.rank.assessment.player.dto;

import java.math.BigInteger;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentTransactionBalanceDTOTest
{
	private CurrentTransactionBalanceDTO transaction;
	
	@BeforeMethod
	public void initTestData()
	{
		transaction = new CurrentTransactionBalanceDTO(BigInteger.valueOf(12), 299.29);
	}
	
	@Test
	public void testGetTransactionId()
	{
		Assert.assertEquals(transaction.getTransactionId(), BigInteger.valueOf(12));
	}
	
	@Test
	public void testSetTransactionId()
	{
		//run
		transaction.setTransactionId(BigInteger.valueOf(34));
		//assert
		Assert.assertEquals(transaction.getTransactionId(), BigInteger.valueOf(34));
	}
	
	@Test
	public void testGetBalance()
	{
		Assert.assertEquals((double)transaction.getBalance(), 299.29);
	}
	
	@Test
	public void testSetBalance()
	{
		//run
		transaction.setBalance(399.44);
		//assert
		Assert.assertEquals((double)transaction.getBalance(), 399.44);
	}
}
