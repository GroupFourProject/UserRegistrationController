package com.controller;

import com.model.Userr;

public class UpdateUserrException extends RuntimeException{
	private int id;
	
	public UpdateUserrException(Userr userr) {
		super("User Id is not available in Database to update");
		this.id = id;
	}

	@Override
	public String toString() {
		return "User Id "+id+" is not available in Database to update";
	}
	
}
