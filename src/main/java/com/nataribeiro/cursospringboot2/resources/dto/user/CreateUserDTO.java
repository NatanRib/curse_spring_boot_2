package com.nataribeiro.cursospringboot2.resources.dto.user;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.nataribeiro.cursospringboot2.entities.User;

public class CreateUserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Field 'name' cannot be empty")
	private String name;
	private String email;
	private String phone;
	@NotEmpty(message="Field 'username' cannot be empty")
	private String username;
	@NotEmpty(message="Field 'password' cannot be empty")
	private String password;
		
	public CreateUserDTO() {}

	public CreateUserDTO(String name, String email, String phone, String username, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.username = username;
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User toUser() {
		return new User(null, username, name, email, phone, password);
	}
}
