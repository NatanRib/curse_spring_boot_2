package com.nataribeiro.cursospringboot2.resources.dto.user;

import java.io.Serializable;

import com.nataribeiro.cursospringboot2.entities.User;

public class GetUserDTO implements Serializable{
private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String name;
	private String email;
	private String phone;
	
	public GetUserDTO() {}

	public GetUserDTO(Long id, String username, String name, String email, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}
	
	public static GetUserDTO fromUser(User u) {
		return new GetUserDTO(u.getId(), u.getUsername(), u.getName(), u.getEmail(), u.getPhone());
	}
}
