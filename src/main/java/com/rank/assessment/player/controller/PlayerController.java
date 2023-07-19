package com.rank.assessment.player.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rank.assessment.player.model.Player;
import com.rank.assessment.player.model.Transaction;
import com.rank.assessment.player.service.IPlayerService;
import com.rank.assessment.player.service.ITransactionService;

@RestController
public class PlayerController
{
	@Autowired
	private ITransactionService transactionService;
	@Autowired
	private IPlayerService playerService;
	
	@GetMapping(value="/player/{playerId}/balance")
	public ResponseEntity<Object> getPlayerBalance(@PathVariable("playerId") Integer playerId)
	{
		return new ResponseEntity<>(playerService.getPlayerById(playerId), HttpStatus.OK);
	}
	
	//'PATCH /player/{playerid}/balance' would have been better
	@PostMapping(value="/player/{playerid}/balance/update")
	public ResponseEntity<Transaction> updatePlayerBalance(@PathVariable("playerId") Integer playerId, @RequestBody Transaction transaction)
	{
		Player player = playerService.getPlayerById(playerId);
		if(player == null)
		{
			//error
		}
		transaction.setPlayer(player);
		transaction = transactionService.save(transaction);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}
	
	//'GET /players/{username}/transactions' would have been better
	@PostMapping(value="/admin/player/transactions")
	public ResponseEntity<Object> getPlayerTransactions(@RequestBody Player playerRequest)
	{
		Player player = playerService.getPlayerByUsername(playerRequest.getUsername());
		if(player == null)
		{
			//error
		}
		return new ResponseEntity<>(transactionService.getTransactionsByPlayerId(player.getId()), HttpStatus.OK);
	}

}
