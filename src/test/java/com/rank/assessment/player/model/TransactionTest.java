package com.rank.assessment.player.model;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rank.assessment.player.dto.TransactionDTO;
import com.rank.assessment.player.model.helper.TransactionType;

public class TransactionTest
{
	private Transaction transaction;
	
	@BeforeMethod
	public void initTestData()
	{
		transaction = new Transaction();
	}
	
	@Test
	public void testGetId()
	{
		Assert.assertNull(transaction.getId());
	}

	@Test
	public void setId()
	{
		//run
		transaction.setId(BigInteger.valueOf(13));
		//assert
		Assert.assertEquals(transaction.getId(), BigInteger.valueOf(13));
	}
	
	@Test
	public void testGetPlayerId()
	{
		Assert.assertNull(transaction.getPlayerId());
	}

	@Test
	public void testSetPlayerId()
	{
		//run
		transaction.setPlayerId(23);
		//assert
		Assert.assertEquals((int)transaction.getPlayerId(), 23);
	}

	@Test
	public void getTransactionType()
	{
		Assert.assertNull(transaction.getTransactionType());
	}

	@Test
	public void setTransactionType()
	{
		transaction.setTransactionType(TransactionType.WAGER);
		assertEquals(transaction.getTransactionType(), TransactionType.WAGER);
	}

	@Test
	public void getAmount()
	{
		assertEquals(transaction.getAmount(), 0.0);
	}

	@Test
	public void setAmount()
	{
		transaction.setAmount(22.4);
		assertEquals(transaction.getAmount(), 22.4);
	}

	@Test
	public void getCreatedAt()
	{
		assertNull(transaction.getCreatedAt());
	}

	@Test
	public void setCreatedAt()
	{
		LocalDateTime date = LocalDateTime.now();
		transaction.setCreatedAt(date);
		assertEquals(transaction.getCreatedAt(), date);
	}

	@Test
	public void getPlayer()
	{
		assertNull(transaction.getPlayer());
	}

	@Test
	public void setPlayer()
	{
		Player player = new Player("player1", "player");
		transaction.setPlayer(player);
		assertEquals(transaction.getPlayer(), player);
	}
	
	@Test
	public void getTransactionAmount_Wager_TransactionType()
	{
		transaction.setTransactionType(TransactionType.WAGER);
		transaction.setAmount(22.4);
		assertEquals(transaction.getTransactionAmount(), -22.4);
	}
	
	@Test
	public void getTransactionAmount_Win_TransactionType()
	{
		transaction.setTransactionType(TransactionType.WIN);
		transaction.setAmount(22.4);
		assertEquals(transaction.getTransactionAmount(), 22.4);
	}
	
	@Test
	public void isWin()
	{
		transaction.setTransactionType(TransactionType.WIN);
		assertTrue(transaction.isWin());
	}
	
	@Test
	public void isWager()
	{
		transaction.setTransactionType(TransactionType.WAGER);
		assertTrue(transaction.isWager());
	}
	
	@Test
	public void hydrate()
	{
		//setup
		transaction.setTransactionType(TransactionType.WIN);
		transaction.setAmount(22.4);
		transaction.setId(BigInteger.valueOf(12));
		//run
		TransactionDTO transactionDTO = transaction.hydrate();
		//assert
		Assert.assertEquals(transactionDTO.getAmount(), 22.4);
		Assert.assertEquals(transactionDTO.getTransactionType(), "WIN");
		Assert.assertEquals(transactionDTO.getTransactionId(), BigInteger.valueOf(12));
	}
}
