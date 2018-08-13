package com.web.service.adduser;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.dao.AddUserDao;
import com.web.model.User;

/**
 * 
 * Rest Controller of Spring Boot.
 * 
 * @author Muhammad Tariq
 *
 */
@RestController
@RequestMapping("contactapi/")
public class AddUserController {

	@Autowired
	private AddUserDao adduserDao;

	@PostMapping("/user/add")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User input) {
		try {
			adduserDao.addUser(input);
			return new ResponseEntity<>(String.format("%s user has been successfully added.", input.getUsername()), HttpStatus.CREATED);
		} catch (Exception e) {
			if (e instanceof DuplicateKeyException) {
				return new ResponseEntity<>(String.format("%s user name already exist, please try with another user name.", input.getUsername()),
						HttpStatus.CONFLICT);
			} else {
				return new ResponseEntity<>("Internal application error", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
}
