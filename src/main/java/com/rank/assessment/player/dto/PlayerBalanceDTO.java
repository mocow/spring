package com.rank.assessment.player.dto;

public class PlayerBalanceDTO
{
	private Integer playerId;
	private double balance;
	
	public PlayerBalanceDTO(Integer playerId, double balance)
	{
		this.playerId = playerId;
		this.balance = balance;
	}
	
	public Integer getPlayerId()
	{
		return playerId;
	}
	
	public void setPlayerId(Integer playerId)
	{
		this.playerId = playerId;
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
