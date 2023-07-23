package com.rank.assessment.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseBadRequest<T> extends  ResponseEntity<T>{

	public ApiResponseBadRequest(T body)
	{
		super(body, HttpStatus.BAD_REQUEST);
	}
}
