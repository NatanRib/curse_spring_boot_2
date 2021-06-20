package com.nataribeiro.cursospringboot2.resources.dto.user;

import java.io.Serializable;

import com.nataribeiro.cursospringboot2.entities.User;

public class UpdateUserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private String phone;
	private String password;
	
	public UpdateUserDTO() {}

	public UpdateUserDTO(String name, String email, String phone, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User toUser() {
		return new User(null, null, name, email, phone, password);
	}
}
