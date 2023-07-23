package com.rank.assessment.player.model;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountBalanceTest
{
	private AccountBalance balance;
	
	@BeforeMethod
	public void initTestData()
	{
		balance = new AccountBalance(12, 300.90);
	}
	
	@Test
	public void testGetId()
	{
		Assert.assertNull(balance.getId());
	}

	@Test
	public void setId()
	{
		//run
		balance.setId(13);
		//assert
		Assert.assertEquals((int)balance.getId(), 13);
	}
	
	@Test
	public void testGetPlayerId()
	{
		Assert.assertEquals((int)balance.getPlayerId(), 12);
	}

	@Test
	public void testSetPlayerId()
	{
		//run
		balance.setPlayerId(23);
		//assert
		Assert.assertEquals((int)balance.getPlayerId(), 23);
	}

	@Test
	public void testGetAmount()
	{
		Assert.assertEquals(balance.getAmount(), 300.9);
	}

	@Test
	public void testSetAmount()
	{
		///run
		balance.setAmount(330.9);
		//assert
		Assert.assertEquals(balance.getAmount(), 330.9);
	}

	@Test
	public void testGetPlayer()
	{
		Assert.assertNull(balance.getPlayer());
	}

	@Test
	public void setPlayer()
	{
		//set up
		Player player = new Player("player1", "player");
		//run
		balance.setPlayer(player);
		//assert
		Assert.assertEquals(balance.getPlayer(), player);
	}
}
