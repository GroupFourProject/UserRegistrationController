package com.controller;

import com.model.Userr;

public class AddUserrException extends RuntimeException{
//	public Userr userr;
	
	public AddUserrException(Userr userr) {
		super("Invalid Mobile Number...");
//		this.userr = userr;
	}

	@Override
	public String toString() {
		return "Invalid Mobile Number...";
	}

	
	
}
