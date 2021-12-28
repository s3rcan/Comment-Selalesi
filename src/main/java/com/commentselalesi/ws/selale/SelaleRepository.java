package com.commentselalesi.ws.selale;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.commentselalesi.ws.user.User;

public interface SelaleRepository extends JpaRepository<Selale, Long>{
	
	Page<Selale> findByUser(User user, Pageable page);
	
}
