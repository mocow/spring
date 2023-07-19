package com.rank.assessment.player.service;

import com.rank.assessment.player.model.Player;

public interface IPlayerService {
	
	public Player getPlayerById(int id);
	
	public Player getPlayerByUsername(String username);
	
}
