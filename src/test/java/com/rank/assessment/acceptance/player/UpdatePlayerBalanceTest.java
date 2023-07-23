package com.rank.assessment.acceptance.player;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.rank.assessment.Config;
import com.rank.assessment.TestApiClient;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdatePlayerBalanceTest
{
	private TestApiClient client;
	private String endpoint = "/player/{playerId}/balance/update";
	
	@BeforeSuite
	public void initResources()
	{
		client = new TestApiClient(Config.getUrl());
	}
	
	@Test
	public void updatePlayerNotExisting() throws Exception
	{
		//set up
		Map<String, Object> pathParams = new HashMap<String, Object>();
		pathParams.put("playerId", 7);
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("amount", 300.09);
		body.put("transactionType", "WIN");
		//run
		Response response = client.sendPostRequest(endpoint, body, pathParams, null);
		//aasert
		response.then().assertThat().statusCode(400);
		// Get error message 
		JsonPath jsonPathEvaluator = response.jsonPath();
		String firstName = jsonPathEvaluator.get("message");
		Assert.assertTrue(firstName.equalsIgnoreCase("Player with ID (7) is not found."));
	}
	
	@Test
	public void updatePlayerWithWagerTransaction() throws Exception
	{
		//set up
		Map<String, Object> pathParams = new HashMap<String, Object>();
		pathParams.put("playerId", 1);
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("amount", 9999.09);
		body.put("transactionType", "WAGER");
		//run
		Response response = client.sendPostRequest(endpoint, body, pathParams, null);
		//aasert
		response.then().assertThat().statusCode(418);
		JsonPath jsonPathEvaluator = response.jsonPath();
		String firstName = jsonPathEvaluator.get("message");
		Assert.assertTrue(firstName.equalsIgnoreCase("You dont have enough funds."));
	}
	
	@Test
	public void updatePlayerWinTransacton() throws Exception
	{
		//set up
		Map<String, Object> pathParams = new HashMap<String, Object>();
		pathParams.put("playerId", 1);
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("amount", 300.09);
		body.put("transactionType", "WIN");
		//run
		Response response = client.sendPostRequest(endpoint, body, pathParams, null);
		//aasert
		response.then().assertThat().statusCode(200);
	}
	
	@Test
	public void updatePlayerAmountNegative() throws Exception
	{
		//set up
		Map<String, Object> pathParams = new HashMap<String, Object>();
		pathParams.put("playerId", 1);
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("amount", -300.09);
		body.put("transactionType", "WIN");
		//run
		Response response = client.sendPostRequest(endpoint, body, pathParams, null);
		//aasert
		response.then().assertThat().statusCode(400);
		JsonPath jsonPathEvaluator = response.jsonPath();
		String firstName = jsonPathEvaluator.get("message");
		Assert.assertTrue(firstName.equalsIgnoreCase("Error: amount is not suppose tto be negative."));
	}
	
}
