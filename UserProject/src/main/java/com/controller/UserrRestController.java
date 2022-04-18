package com.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.dao.UserrService;

import com.model.Userr;

@RestController
public class UserrRestController {

	@Autowired
	UserrService service;
	
	@GetMapping("/getuserr")
	public List<Userr> getAllUserr()
	{
		return service.findAll();
	}
	
	@GetMapping("getuserr/{id}")
	public ResponseEntity<?> getUserr(@PathVariable int id){
		Userr userr = service.find(id);
		
		if(userr == null) {
			throw new GetUserrException();
		}
		service.find(id);
		return ResponseEntity.ok("User Displayed Successfully");
	}
	
	@PostMapping("/adduserr")  // Adding the data of users 
	public ResponseEntity<?> addUserr(@RequestBody Userr userr) throws AddUserrException
	{
		if(userr.getMobileNo().length() > 11 || userr.getMobileNo().length() < 10) {
			throw new AddUserrException(userr);
		}
		
		service.add(userr);
		return ResponseEntity.ok("User added successfully");
	}
	
	@DeleteMapping("/deleteuserr/{id}")
	public ResponseEntity<?> deleteUserr(@PathVariable int id) throws DeleteUserrException{
		Userr userr = service.find(id);
		
		if(userr == null) {
			throw new DeleteUserrException(id);
		}
		
		service.delete(id);
		return ResponseEntity.ok("User Deleted Successfully");
	}
	
	@PatchMapping("/updateuserr")
	public ResponseEntity<?> updateUserr(@RequestBody Userr userr) throws UpdateUserrException{
		Userr userr1 = service.find(userr.getUserrId());
		
		if(userr1 == null) {
			throw new UpdateUserrException(userr1);
		}
		
		service.upadte(userr);
		return ResponseEntity.ok("User Updated Successfully");
	}
	
	
	
}
