package com.model;

import javax.annotation.Generated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

//import org.hibernate.validator.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class Userr {

	@Id
	@GeneratedValue
	private int userrId;
	
	@NotNull
	@Column(name="userrName")
	private String userrName; 
	
	
	@Column(name="userrType")
	private char userrType;
	
	@Size(min=10,max=11)
	@Column(name="mobileNo")
	private String mobileNo;
	
	@Email
	@Column(name="emailId")
	private String emailId;
	
	private String dateOfBirth;
	
	@Size(min=4,max=4)
	private String password;	
	
	public Userr() {}

	public int getUserrId() {
		return userrId;
	}


	public void setUserrId(int userrId) {
		this.userrId = userrId;
	}


	public String getUserrName() {
		return userrName;
	}


	public void setUserrName(String userrName) {
		this.userrName = userrName;
	}


	public char getUserrType() {
		return userrType;
	}


	public void setUserrType(char userrType) {
		this.userrType = userrType;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
