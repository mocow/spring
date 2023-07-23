package com.rank.assessment.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseSuccess<T> extends  ResponseEntity<T>{

	public ApiResponseSuccess(T body)
	{
		super(body, HttpStatus.OK);
	}
}
