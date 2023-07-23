package com.rank.assessment.player.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rank.assessment.player.dto.CurrentTransactionBalanceDTO;
import com.rank.assessment.player.dto.PlayerBalanceDTO;
import com.rank.assessment.player.dto.TransactionDTO;
import com.rank.assessment.player.model.Player;
import com.rank.assessment.player.model.Transaction;
import com.rank.assessment.player.service.IPlayerService;
import com.rank.assessment.response.ApiResponseSuccess;

@RestController
public class PlayerController
{
	@Autowired
	private IPlayerService playerService;
	
	@GetMapping(value="/player/{playerId}/balance")
	public ResponseEntity<?> getPlayerBalance(@PathVariable("playerId") Integer playerId)
	{
		Player player = playerService.getPlayerById(playerId);	
		return new ApiResponseSuccess<>((new PlayerBalanceDTO(player.getId(), player.getAccountBalance().getAmount())));
	}
	
	//'PATCH /player/{playerid}/balance' would have been better
	@PostMapping(value="/player/{playerId}/balance/update")
	public ResponseEntity<?> updatePlayerBalance(@PathVariable("playerId") Integer playerId, @RequestBody Transaction transaction)
	{
		transaction = playerService.updateBalance(playerId, transaction);	
		return new ApiResponseSuccess<CurrentTransactionBalanceDTO>((new CurrentTransactionBalanceDTO(transaction.getId(), transaction.getPlayer().getAccountBalance().getAmount())));
	}
	
	//'GET /players/{username}/transactions' would have been better
	@PostMapping(value="/admin/player/transactions")
	public ResponseEntity<?> getPlayerTransactions(@RequestBody Player playerRequest)
	{
		Player player = playerService.getPlayerByUsername(playerRequest.getUsername());
		
		List<Transaction>  transactions = playerService.getTransactionsByPlayerId(player.getId());
		List<TransactionDTO>  results = transactions.stream().map(tran -> tran.hydrate()).collect(Collectors.toList());
		
		return new ApiResponseSuccess<>(results);
	}
}
