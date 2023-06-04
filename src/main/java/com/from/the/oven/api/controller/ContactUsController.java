package com.from.the.oven.api.controller;

import com.from.the.oven.api.dto.ApiResponse;
import com.from.the.oven.api.dto.ContactUsDTO;
import com.from.the.oven.api.exception.EntityNotFoundException;
import com.from.the.oven.api.exception.LimitApiRequestException;
import com.from.the.oven.api.exception.ValidationException;
import com.from.the.oven.api.service.ContactUsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/05/19
 */

@CrossOrigin
@RestController
@RequestMapping("api/v1/contacts")
public class ContactUsController {
	@Autowired
	private ContactUsService contactUsService;

	@GetMapping
	public ApiResponse<ContactUsDTO> getAllCustoms(@RequestParam(name = "limit", defaultValue = "20") Integer limit) {
		try {
			return new ApiResponse<>(
					contactUsService.getAll(limit).stream()
							.map(ContactUsDTO::new)
							.toList()
			);
		} catch (LimitApiRequestException exception) {
			return new ApiResponse<>(HttpStatus.BAD_REQUEST, exception);
		}
	}

	@GetMapping("/{id}")
	public ApiResponse<ContactUsDTO> findCustomUsById(@PathVariable Long id) {
		try {
			return new ApiResponse<>(List.of(new ContactUsDTO(contactUsService.findById(id))));
		} catch (EntityNotFoundException exception) {
			return new ApiResponse<>(HttpStatus.BAD_REQUEST, exception);
		}
	}

	@PostMapping
	public ApiResponse<ContactUsDTO> createContactUs(@RequestBody ContactUsDTO contactUsDTO) {
		try {
			return new ApiResponse<>(HttpStatus.CREATED, List.of(new ContactUsDTO(contactUsService.create(contactUsDTO))));
		} catch (ValidationException validationException) {
			return new ApiResponse<>(HttpStatus.BAD_REQUEST, validationException);
		}
	}

	@DeleteMapping("/{id}")
	public ApiResponse<ContactUsDTO> deleteContactUs(@PathVariable Long id) {
		try {
			return new ApiResponse<>(List.of(new ContactUsDTO(contactUsService.delete(id))));
		} catch (EntityNotFoundException exception) {
			return new ApiResponse<>(HttpStatus.BAD_REQUEST, exception);
		}
	}
}
