package com.rank.assessment.player.dto;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MessageDTOTest
{
	private MessageDTO message;
	
	@BeforeMethod
	public void initTestData()
	{
		message = new MessageDTO("You have no funds");
	}
	
	@Test
	public void testGetMessage()
	{
		//assert
		Assert.assertEquals(message.getMessage(), "You have no funds");
	}

}
