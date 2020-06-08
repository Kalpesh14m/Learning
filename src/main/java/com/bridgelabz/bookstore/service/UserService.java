package com.bridgelabz.bookstore.service;

import java.util.List;

import com.bridgelabz.bookstore.model.User;
import com.bridgelabz.bookstore.model.dto.RegistrationDTO;

public interface UserService {
	public boolean registerUser(RegistrationDTO user);

	public User findById(Long id);

	public List<User> getUser();

	public User update(User user, Long id);

	public void deleteUserById(Long id);
}
