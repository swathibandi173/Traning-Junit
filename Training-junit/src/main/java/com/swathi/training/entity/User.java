package com.swathi.training.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity	
public class User {
	@Id
	@Size(min=6,max=6, message="User Id must be six lettered Alphanumeric")
	private Integer id;
	@Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	private String address;
	@NotNull(message="Email cannot be Empty")
	@Email
	private String emailId;
	public User() {
		super();
	}
	public User(@Size(min = 6, max = 6, message = "User Id must be six lettered Alphanumeric") Integer id,
			@Size(min = 2, message = "Name should have atleast 2 characters") String name, String address,
			@NotNull(message = "Email cannot be Empty") @Email String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.emailId = emailId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", emailId=" + emailId + "]";
	}
	
	
	
		

}
