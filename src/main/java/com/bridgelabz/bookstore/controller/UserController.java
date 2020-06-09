package com.bridgelabz.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstore.exception.UserNotFoundException;
import com.bridgelabz.bookstore.model.User;
import com.bridgelabz.bookstore.model.dto.LoginDTO;
import com.bridgelabz.bookstore.model.dto.RegistrationDTO;
import com.bridgelabz.bookstore.response.Response;
import com.bridgelabz.bookstore.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = { "/user" })
@Api(value = "User Controller")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/verify")
	public ResponseEntity<Response> userVerification(@RequestParam("token") String token) {
		return userService.verify(token);
	}

	@PostMapping("/login")
	public ResponseEntity<Response> userLogin(@RequestBody LoginDTO logindto) throws UserNotFoundException {
		return userService.login(logindto);
	}

	@PostMapping(value = "/register", headers = "Accept=application/json")
	public ResponseEntity<Void> register(@RequestBody RegistrationDTO request) {
		HttpHeaders headers = new HttpHeaders();
		if (userService.registerUser(request))
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		return new ResponseEntity<Void>(headers, HttpStatus.ALREADY_REPORTED);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping(value = "/get", headers = "Accept=application/json")
	public List<User> getAllUser() {
		List<User> tasks = userService.getUser();
		return tasks;
	}

	@PutMapping(value = "/update", headers = "Accept=application/json")
	public ResponseEntity<String> updateUser(@RequestBody User currentUser) {
		User user = userService.findById(currentUser.getId());
		if (user == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		userService.update(currentUser, currentUser.getId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}
