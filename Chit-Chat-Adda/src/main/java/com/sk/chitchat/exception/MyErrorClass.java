package com.sk.chitchat.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyErrorClass {
	
	private LocalDateTime timeStamp;
	private String message;
	private String uri;
	

}
