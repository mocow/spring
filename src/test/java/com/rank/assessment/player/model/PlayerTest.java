package com.rank.assessment.player.model;

import static org.testng.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlayerTest
{
	private Player player;
	
	@BeforeMethod
	public void initTestData()
	{
		player = new Player("player1", "player");
	}
	
	@Test
	public void getId()
	{
		Assert.assertNull(player.getId());
	}

	@Test
	public void setId()
	{
		//run
		player.setId(13);
		//assert
		Assert.assertEquals((int)player.getId(), 13);
	}

	@Test
	public void getName()
	{
		Assert.assertEquals(player.getName(), "player1");
	}

	@Test
	public void setName()
	{
		player.setName("player 1");
		Assert.assertEquals(player.getName(), "player 1");
	}

	@Test
	public void getUsername()
	{
		Assert.assertEquals(player.getUsername(), "player");
	}

	@Test
	public void setUsername()
	{
		player.setUsername("rank");
		Assert.assertEquals(player.getUsername(), "rank");
	}

	@Test
	public void getTransactions()
	{
		Assert.assertNull(player.getTransactions());
	}

	@Test
	public void setTransactions()
	{
		Set<Transaction> trans = new HashSet<Transaction>();
		trans.add(new Transaction());
		trans.add(new Transaction());
		player.setTransactions(trans);
		//assert
		assertEquals(player.getTransactions().size(), 2);
	}

	@Test
	public void getAccountBalance()
	{
		Assert.assertNull(player.getAccountBalance());
	}

	@Test
	public void setAccountBalance()
	{
		//set up
		AccountBalance balance = new AccountBalance(12, 300.90);
		balance.setPlayer(player);
		//run
		player.setAccountBalance(balance);
		//assert
		assertEquals(player.getAccountBalance(), balance);
	}
	
	
}
