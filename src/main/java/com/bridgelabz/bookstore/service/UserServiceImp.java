package com.bridgelabz.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstore.config.WebSecurityConfig;
import com.bridgelabz.bookstore.model.User;
import com.bridgelabz.bookstore.model.dto.RegistrationDTO;
import com.bridgelabz.bookstore.repo.UserRepo;

@Service
@Transactional
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private WebSecurityConfig encrypt;

	@Override
	public boolean registerUser(RegistrationDTO user) {
		List<User> maybeUser = userRepo.findByEmail(user.getEmail());
		if (maybeUser == null) {
			return false;
		}
		userRepo.addUser(new User(user.setPassword(encrypt.bCryptPasswordEncoder().encode(user.getPassword()))));
		return true;
	}

	@Override
	public User findById(Long id) {
		return userRepo.findById(id);
	}

	@Override
	public List<User> getUser() {
		return userRepo.getUser();
	}

	@Override
	public void deleteUserById(Long id) {
		userRepo.delete(id);
	}

	@Override
	public User update(User user, Long id) {
		return userRepo.update(user, id);
	}

}
