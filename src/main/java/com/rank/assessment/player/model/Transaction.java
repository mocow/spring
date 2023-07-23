package com.rank.assessment.player.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rank.assessment.player.dto.TransactionDTO;
import com.rank.assessment.player.model.helper.TransactionType;


@Entity
@Table(name="transactions")
public class Transaction
{	
	@Id
	@GeneratedValue 
	private BigInteger id;
	
	@Column(name = "playerId", nullable=false)
	private Integer playerId;
	@ManyToOne(optional=false)
	@JoinColumn(name = "playerId", insertable=false, updatable=false)
	private Player player;
	
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	private double amount;
	private LocalDateTime createdAt;
	
	public BigInteger getId()
	{
		return id;
	}

	public void setId(BigInteger id)
	{
		this.id = id;
	}
	
	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId)
	{
		this.playerId = playerId;
	}


	public TransactionType getTransactionType()
	{
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType)
	{
		this.transactionType = transactionType;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	public LocalDateTime getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt)
	{
		this.createdAt = createdAt;
	}

	public Player getPlayer()
	{
		return player;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}
	
	public double getTransactionAmount()
	{
		if(isWin())
		{
			return amount;
		}
		
		return (-1) * amount;
	}
	
	public boolean isWin()
	{
		return TransactionType.WIN.equals(transactionType);
	}
	
	public boolean isWager()
	{
		return TransactionType.WAGER.equals(transactionType);
	}
	
	public TransactionDTO hydrate()
	{
		return new TransactionDTO(transactionType.toString(), id, amount);
	}
	
	
}
