package com.from.the.oven.api.service;

import com.from.the.oven.api.dto.ContactUsDTO;
import com.from.the.oven.api.entity.ContactUs;
import com.from.the.oven.api.exception.EntityNotFoundException;
import com.from.the.oven.api.exception.LimitApiRequestException;
import com.from.the.oven.api.repository.ContactUsRepository;
import com.from.the.oven.api.validator.Validator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/05/19
 */

@Service
public class ContactUsService {
	@Autowired
	private ContactUsRepository contactUsRepository;

	public List<ContactUs> getAll(Integer limit) throws LimitApiRequestException {
		if (limit <= 0) {
			throw new LimitApiRequestException();
		}
		return contactUsRepository.findAll(PageRequest.of(0, limit)).getContent();
	}

	public ContactUs findById(Long id) throws EntityNotFoundException {
		Optional<ContactUs> contactUs = contactUsRepository.findById(id);
		if (contactUs.isEmpty()) {
			throw new EntityNotFoundException(ContactUs.class, id);
		}
		return contactUs.get();
	}

	public ContactUs create(ContactUsDTO contactUsDTO) {
		ContactUs contactUs = new ContactUs(contactUsDTO);
		Validator.validate(contactUs);
		return contactUsRepository.save(contactUs);
	}

	public ContactUs delete(Long id) {
		ContactUs deleteContactUs = findById(id);
		contactUsRepository.delete(deleteContactUs);
		return deleteContactUs;
	}
}
