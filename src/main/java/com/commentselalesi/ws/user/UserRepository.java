package com.commentselalesi.ws.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

		User findByUsername(String username);
		//username sütununa bakacak bir query oluşturuyoruz burada
		Page<User> findByUsernameNot(String username, Pageable page);
}
