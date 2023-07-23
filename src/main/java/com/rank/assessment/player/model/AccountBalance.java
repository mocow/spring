package com.rank.assessment.player.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="acount_balance")
public class AccountBalance
{	
	@Id
	@GeneratedValue 
	private Integer id;
	
	@Column(name = "playerId", nullable=false)
	private Integer playerId;
	@OneToOne(optional=false)
	@JoinColumn(name = "playerId", insertable=false, updatable=false)
	private Player player;
	
	private Double amount;
	
	public AccountBalance()
	{
		
	}
	
	public AccountBalance(Integer playerId, Double amount)
	{
		super();
		this.playerId = playerId;
		this.amount = amount;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public Integer getPlayerId()
	{
		return playerId;
	}

	public void setPlayerId(Integer playerId)
	{
		this.playerId = playerId;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	public Player getPlayer()
	{
		return player;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}
}
