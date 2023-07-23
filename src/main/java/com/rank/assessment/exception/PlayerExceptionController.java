package com.rank.assessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rank.assessment.player.dto.MessageDTO;

@ControllerAdvice
public class PlayerExceptionController
{
	@ExceptionHandler(value = PlayerBadRequestException.class)
	public ResponseEntity<Object> handleException(PlayerBadRequestException exception)
	{
		return new ResponseEntity<>(new MessageDTO(exception.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = PlayerTeaPotException.class)
	public ResponseEntity<Object> handleException(PlayerTeaPotException exception)
	{
		return new ResponseEntity<>(new MessageDTO(exception.getMessage()), HttpStatus.I_AM_A_TEAPOT);
	}
	
	@ExceptionHandler(value = Throwable.class)
	public ResponseEntity<Object> handleException(Throwable exception)
	{
		return new ResponseEntity<>(new MessageDTO("Something went wrong"), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
