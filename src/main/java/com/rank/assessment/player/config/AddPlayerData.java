package com.rank.assessment.player.config;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rank.assessment.player.model.AccountBalance;
import com.rank.assessment.player.model.Player;
import com.rank.assessment.player.repository.AccountBalanceRepository;
import com.rank.assessment.player.repository.PlayerRepository;

@Configuration
public class AddPlayerData
{
	@Bean
	CommandLineRunner addFakedPlayers(PlayerRepository playerRepository, AccountBalanceRepository accountBalanceRepository)
	{
		return arg -> {
			ArrayList<Player> players = new ArrayList<Player>();
			
			players.add(new Player("Player 1", "player1"));  
			players.add(new Player("Player 2", "player2"));  
			playerRepository.saveAll(players);
			
			ArrayList<AccountBalance> accounts = new ArrayList<AccountBalance>();
			accounts.add(new AccountBalance(playerRepository.findPlayerByUsername("player1").get().getId(), 0.0));
			accounts.add(new AccountBalance(playerRepository.findPlayerByUsername("player2").get().getId(), 0.0));
			accountBalanceRepository.saveAll(accounts);
			
		};		
	}
}
