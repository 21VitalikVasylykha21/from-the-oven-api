package com.from.the.oven.api.service;

import com.from.the.oven.api.dto.UserDTO;
import com.from.the.oven.api.entity.User;
import com.from.the.oven.api.exception.ValidationException;
import com.from.the.oven.api.repository.UserRepository;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/05/29
 */
@Service
public class AuthService {
	@Autowired
	private UserRepository userRepository;

	public User login(UserDTO userDTO) {
		Optional<User> adminOptional = userRepository.findByUsername(userDTO.getUsername());
		if (adminOptional.isEmpty()) {
			throw new ValidationException("Not valid login: " + userDTO.getUsername());
		}
		String sha256hex = Hashing.sha256()
				.hashString(userDTO.getPassword(), StandardCharsets.UTF_8)
				.toString();
		if (!adminOptional.get().getPassword().equals(sha256hex)) {
			throw new ValidationException("Not valid password: " + userDTO.getPassword());
		}
		return adminOptional.get();
	}
}
