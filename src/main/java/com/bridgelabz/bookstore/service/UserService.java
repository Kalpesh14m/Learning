package com.bridgelabz.bookstore.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bridgelabz.bookstore.exception.UserNotFoundException;
import com.bridgelabz.bookstore.model.User;
import com.bridgelabz.bookstore.model.dto.LoginDTO;
import com.bridgelabz.bookstore.model.dto.RegistrationDTO;
import com.bridgelabz.bookstore.response.Response;

public interface UserService {
	ResponseEntity<Response> login(LoginDTO logindto) throws UserNotFoundException;

	ResponseEntity<Response> verify(String token);

	public boolean registerUser(RegistrationDTO user);

	public User findById(Long id);

	public List<User> getUser();

	public User update(User user, Long id);

	public void deleteUserById(Long id);
}
