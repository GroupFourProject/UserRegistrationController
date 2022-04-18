package com.controller;

public class GetUserrException extends RuntimeException{
	public GetUserrException() {
		super("User Id id not available");
	}
	
	@Override
	public String toString() {
		return "User Id is Not available";
	}
}
