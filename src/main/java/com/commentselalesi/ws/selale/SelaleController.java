package com.commentselalesi.ws.selale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commentselalesi.ws.selale.vm.SelaleVM;
import com.commentselalesi.ws.shared.CurrentUser;
import com.commentselalesi.ws.shared.GenericResponse;
import com.commentselalesi.ws.user.User;

@RestController
@RequestMapping("/api/1.0")
public class SelaleController {
	
	@Autowired
	SelaleService selaleService;
	
	@PostMapping("/selales")
	GenericResponse saveSelale(@Valid @RequestBody Selale selale, @CurrentUser User user) {
		selaleService.save(selale, user);
		return new GenericResponse("Selale is saved!");
	}
	
	@GetMapping("/selales")
	Page<SelaleVM> getSelales(@PageableDefault(sort = "id", direction = Direction.DESC) Pageable page) {
		return selaleService.getSelales(page).map(SelaleVM::new);
	}
	
	@GetMapping("/users/{username}/selales")
	Page<SelaleVM> getUserSelales(@PathVariable String username, @PageableDefault(sort = "id", direction = Direction.DESC) Pageable page) {
		return selaleService.getSelalesOfUser(username, page).map(SelaleVM::new);
	}
	@DeleteMapping("/selales/{id}")
	GenericResponse deleteSelale(@PathVariable long id) {
		selaleService.deleteSelale(id);
		return new GenericResponse("Comment Removed");
	}
}
 