package com.example.jdbc.project_spring_jdbc.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoomAlreadyExistsException extends RuntimeException {

	public RoomAlreadyExistsException(String message) {
		super(message);
		
	}

}
