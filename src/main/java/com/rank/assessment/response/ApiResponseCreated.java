package com.rank.assessment.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseCreated<T> extends  ResponseEntity<T>{

	public ApiResponseCreated(T body)
	{
		super(body, HttpStatus.CREATED);
	}
}
