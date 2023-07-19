package com.rank.assessment.player.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rank.assessment.player.model.Player;
import com.rank.assessment.player.repository.PlayerRepository;

@Service
public class PlayerService implements IPlayerService
{
	@Autowired
	private final PlayerRepository playerRepository;
	
	public PlayerService(PlayerRepository playerRepository)
	{
		this.playerRepository = playerRepository;
	}
	
	@Override
	public Player getPlayerById(int id)
	{
		return playerRepository.getReferenceById(id);
	}

	@Override
	public Player getPlayerByUsername(String username)
	{
		Optional<Player> player = playerRepository.findPlayerByUsername(username);
		if(player.isPresent())
		{
			//throw exption;
		}
		return player.get();
	}
}
