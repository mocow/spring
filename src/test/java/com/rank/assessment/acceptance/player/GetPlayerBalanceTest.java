package com.rank.assessment.acceptance.player;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.rank.assessment.Config;
import com.rank.assessment.TestApiClient;

import io.restassured.response.Response;

public class GetPlayerBalanceTest
{
	private TestApiClient client;
	private String endpoint = "/player/{playerId}/balance";
	
	@BeforeSuite
	public void initResources()
	{
		client = new TestApiClient(Config.getUrl());
	}
	
	@Test
	public void lookUpForPlayerNotExisting() throws Exception
	{
		//set up
		Map<String, Object> pathParams = new HashMap<String, Object>();
		pathParams.put("playerId", 7);
		//run
		Response response = client.sendGetRequest(endpoint, null, pathParams, null);
		response.then().assertThat().statusCode(400);
	}
	
	@Test
	public void lookUpForPlayerExisting() throws Exception
	{
		//set up
		Map<String, Object> pathParams = new HashMap<String, Object>();
		pathParams.put("playerId", 1);
		//run
		Response response = client.sendGetRequest(endpoint, null, pathParams, null);
		response.then().assertThat().statusCode(200);
	}
}
