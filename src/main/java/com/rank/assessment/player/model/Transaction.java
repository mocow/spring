package com.rank.assessment.player.model;

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

import com.rank.assessment.player.model.helper.TransactionType;


@Entity
@Table(name="transactions")
public class Transaction
{	
	private @Id @GeneratedValue Long id;
	
	@Column(name = "playerId", nullable=false)
	private Long playerId;
	@ManyToOne(optional=false)
	@JoinColumn(name = "playerId", insertable=false, updatable=false)
	private Player player;
	
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	private double amount;
	private LocalDateTime createdAt;
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
	
	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId)
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
}
