package com.from.the.oven.api.dto;

import com.from.the.oven.api.entity.User;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/05/29
 */
public class UserDTO {
	private Long id;

	private String username;

	private String password;

	private String email;

	public UserDTO() {
	}

	public UserDTO(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.username = user.getUsername();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
