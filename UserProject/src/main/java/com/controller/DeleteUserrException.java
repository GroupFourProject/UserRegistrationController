package com.controller;

public class DeleteUserrException extends RuntimeException {
	private int id;
	
	public DeleteUserrException(int id) {
		super("User with id "+id+" is not available");
		this.id = id;
	}

	@Override
	public String toString() {
		return "Id "+id+" is not available";
	}
	
}
