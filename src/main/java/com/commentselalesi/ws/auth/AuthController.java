package com.commentselalesi.ws.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commentselalesi.ws.shared.CurrentUser;
import com.commentselalesi.ws.user.User;
import com.commentselalesi.ws.user.UserRepository;
import com.commentselalesi.ws.user.vm.UserVM;



@RestController
public class AuthController {

	@Autowired
	UserRepository userRepository;
	
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	@PostMapping("/api/1.0/auth")
	UserVM handleAuthentication(@CurrentUser User user) {
		return new UserVM(user);
	}
	
}
	

