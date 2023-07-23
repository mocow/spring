package com.rank.assessment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestApiClient
{	
	private String url;
	
	public TestApiClient(String url)
	{
		super();
		this.url = url;
	}

	public Response sendPostRequest(String endpoint, Map<String, Object> body, Map<String, Object> pathParams, Map<String, Object> queryParams) throws MalformedURLException
	{		
		RequestSpecification requestSpecification = intRequestt(endpoint,body,pathParams,queryParams);
		
		return requestSpecification.post(new URL(url + endpoint));
	}
	
	public Response sendGetRequest(String endpoint, Map<String, Object> body, Map<String, Object> pathParams, Map<String, Object> queryParams) throws MalformedURLException
	{		
		RequestSpecification requestSpecification = intRequestt(endpoint,body,pathParams,queryParams);
				
		return requestSpecification.get(new URL(url + endpoint));
	}
	
	private RequestSpecification intRequestt(String endpoint, Map<String, Object> body, Map<String, Object> pathParams, Map<String, Object> queryParams)
	{		
		RequestSpecification requestSpecification = RestAssured
						.given()
						.config(RestAssured.config())
						.contentType(ContentType.JSON).accept(ContentType.JSON);
		
		if(body != null && !body.isEmpty())
		{
			requestSpecification.body(body);
		}
		if(pathParams != null && !pathParams.isEmpty())
		{
			requestSpecification.pathParams(pathParams);
		}
		if(queryParams != null && !queryParams.isEmpty())
		{
			requestSpecification.queryParams(queryParams);
		}
		return requestSpecification.when();	
	}

}
