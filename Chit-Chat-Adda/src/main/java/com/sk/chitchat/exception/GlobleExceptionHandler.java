package com.sk.chitchat.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class GlobleExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorClass> noHandlerFoundException(NoHandlerFoundException ex, WebRequest wr){
		
		MyErrorClass ef = new MyErrorClass(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<>(ef, HttpStatus.NOT_FOUND);
	}

}
