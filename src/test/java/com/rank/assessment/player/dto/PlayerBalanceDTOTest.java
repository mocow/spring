package com.rank.assessment.player.dto;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlayerBalanceDTOTest
{
	private PlayerBalanceDTO playerBalance;
	
	@BeforeMethod
	public void initTestData()
	{
		playerBalance = new PlayerBalanceDTO(12, 999.09);
	}
	
	@Test
	public void testGetPlayerId()
	{
		Assert.assertEquals((int)playerBalance.getPlayerId(), 12);
	}
	
	@Test
	public void setPlayerId()
	{
		//run
		playerBalance.setPlayerId(15);
		//assert
		Assert.assertEquals((int)playerBalance.getPlayerId(), 15);
	}
	
	@Test
	public void getBalance()
	{
		Assert.assertEquals(playerBalance.getBalance(), 999.09);
	}
	
	@Test
	public void setBalance()
	{
		//run
		playerBalance.setBalance(300);
		//assert
		Assert.assertEquals(playerBalance.getBalance(), 300.0);
	}
}
