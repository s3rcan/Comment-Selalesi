package com.commentselalesi.ws.selale;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.commentselalesi.ws.user.User;
import com.commentselalesi.ws.user.UserService;

@Service
public class SelaleService {
	
	SelaleRepository selaleRepository;
	
	UserService userService;

	public SelaleService(SelaleRepository selaleRepository, UserService userService) {
		super();
		this.selaleRepository = selaleRepository;
		this.userService = userService;
	}

	public void save(Selale selale, User user) {
		selale.setTimeStamp(new Date());
		selale.setUser(user);
		selaleRepository.save(selale);
	}

	public Page<Selale> getSelales(Pageable page) {		
		return selaleRepository.findAll(page);
	}

	public Page<Selale> getSelalesOfUser(String username, Pageable page) {
		User inDB = userService.getByUsername(username);
		return selaleRepository.findByUser(inDB, page);
	}
	public void deleteSelale(long id) {
		selaleRepository.deleteById(id);
	}
	
}
