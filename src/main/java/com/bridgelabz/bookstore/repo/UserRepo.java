package com.bridgelabz.bookstore.repo;

import java.util.List;

import com.bridgelabz.bookstore.model.User;

public interface UserRepo {
	public void addUser(User user);

	public User findByUserId(Long id);

	public List<User> getUser();

	public User update(User user, Long id);

	public void delete(Long id);

	public List<User> findByEmail(String email);

	public void verify(Long id);
}
