package com.from.the.oven.api.dto;

import com.from.the.oven.api.entity.ContactUs;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/05/19
 */
public class ContactUsDTO {

	private Long id;
	private String name;
	private String email;
	private String message;

	public ContactUsDTO(String name, String email, String message) {
		this.name = name;
		this.email = email;
		this.message = message;
	}

	public ContactUsDTO(ContactUs contactUs){
		this.id = contactUs.getId();
		this.email = contactUs.getEmail();
		this.name = contactUs.getName();
		this.message = contactUs.getMessage();
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
