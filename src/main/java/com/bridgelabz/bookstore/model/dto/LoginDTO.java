package com.bridgelabz.bookstore.model.dto;

import org.springframework.stereotype.Component;

@Component
public class LoginDTO {

	private String loginId;
	private String password;

	public String getloginId() {
		return loginId;
	}

	public void setloginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
