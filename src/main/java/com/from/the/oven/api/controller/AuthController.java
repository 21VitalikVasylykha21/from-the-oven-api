package com.from.the.oven.api.controller;

import com.from.the.oven.api.dto.ApiResponse;
import com.from.the.oven.api.dto.UserDTO;
import com.from.the.oven.api.exception.ValidationException;
import com.from.the.oven.api.service.AuthService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/05/29
 */
@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class AuthController {
	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	private ApiResponse<UserDTO> login(@RequestBody UserDTO userDTO) {
		try {
			return new ApiResponse<>(List.of(new UserDTO(authService.login(userDTO))));
		} catch (ValidationException validationException) {
			return new ApiResponse<>(HttpStatus.BAD_REQUEST, validationException);
		}
	}
}
