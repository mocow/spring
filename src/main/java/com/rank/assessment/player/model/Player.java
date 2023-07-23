package com.rank.assessment.player.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="players")
public class Player 
{
	@Id
	@GeneratedValue 
	private Integer id;
	
	private String name;
	
	@Column(unique = true, nullable = false, length = 50)
	private String username;
	
	@OneToMany(mappedBy="player")
    private Set<Transaction> transactions;
	
	@OneToOne(mappedBy="player")
    private AccountBalance accountBalance;

	public Player() 
	{
		
	}

	public Player(String name, String username)
	{
		this.name = name;
		this.username = username;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public Set<Transaction> getTransactions()
	{
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions)
	{
		this.transactions = transactions;
	}

	public AccountBalance getAccountBalance()
	{
		return accountBalance;
	}

	public void setAccountBalance(AccountBalance accountBalance)
	{
		this.accountBalance = accountBalance;
	}
	
}
