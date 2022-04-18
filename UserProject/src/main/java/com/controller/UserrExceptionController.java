package com.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserrExceptionController {
	
	@ExceptionHandler(DeleteUserrException.class)
	public ResponseEntity<?> handleDeleteIdException(DeleteUserrException ex, WebRequest req){
		return new ResponseEntity<> (ex.toString(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AddUserrException.class)
	public ResponseEntity<?> handleAddUserrException(AddUserrException e, WebRequest req){
		return new ResponseEntity<> (e.toString(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UpdateUserrException.class)
	public ResponseEntity<?> handleUpdateException(UpdateUserrException ex, WebRequest req){
		return new ResponseEntity<> (ex.toString(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(GetUserrException.class)
	public ResponseEntity<?> handleGetException(GetUserrException ex, WebRequest req){
		return new ResponseEntity<> (ex.toString(), HttpStatus.NOT_FOUND);
	}
}
