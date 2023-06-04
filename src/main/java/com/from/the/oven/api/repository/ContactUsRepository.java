package com.from.the.oven.api.repository;

import com.from.the.oven.api.entity.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/05/19
 */
public interface ContactUsRepository extends JpaRepository<ContactUs, Long> {
}
