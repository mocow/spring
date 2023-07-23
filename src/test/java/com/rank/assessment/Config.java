package com.rank.assessment;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config
{	
	public static String getUrl()
	{
		Properties prop = load();
		return prop.getProperty("server.api.url");
	}

	private static Properties load()
	{
		Properties prop = new Properties();
		try
		{
			InputStream input = new FileInputStream("src/main/resources/application.properties");
			prop.load(input);
        }
		catch (IOException ex)
		{
			//log the exception
            ex.printStackTrace();
        }
		return prop;
	}
}
