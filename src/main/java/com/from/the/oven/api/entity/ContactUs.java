package com.from.the.oven.api.entity;

import com.from.the.oven.api.dto.ContactUsDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/05/19
 */

@Entity
@Table(name = "contact_us")
public class ContactUs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_us_id")
	private Long id;

	@NotBlank(message = "Name is required")
	@Size(max = 255, message = "Name must be less than or equal to 255 characters")
	@Column(name = "name")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Email is not valid")
	@Size(max = 255, message = "Email must be less than or equal to 255 characters")
	@Column(name = "email")
	private String email;

	@NotBlank(message = "Message is required")
	@Column(name = "message")
	private String message;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	public ContactUs() {
	}

	public ContactUs(ContactUsDTO contactUsDTO) {
		this.email = contactUsDTO.getEmail();
		this.name = contactUsDTO.getName();
		this.message = contactUsDTO.getMessage();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
}
