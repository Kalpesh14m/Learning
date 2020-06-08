package com.bridgelabz.bookstore.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegistrationDTO {
	@NotEmpty(message = "Enter First Name - Registration DTO")
	@Size(min = 3)
	private String firstName;

	@NotEmpty(message = "Enter Last Name - Registration DTO")
	@Size(min = 3)
	private String lastName;

	@NotEmpty(message = "Enter Email ID - Registration DTO")
	@Email
	private String email;

	@NotEmpty(message = "Enter Password - Registration DTO")
	@Size(min = 3)
	private String password;

	@NotEmpty(message = "Enter City - Registration DTO")
	private String city;

	@NotEmpty(message = "Enter City - Registration DTO")
	private Long moblieNumber;

	public RegistrationDTO() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public RegistrationDTO setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getMoblieNumber() {
		return moblieNumber;
	}

	public void setMoblieNumber(Long moblieNumber) {
		this.moblieNumber = moblieNumber;
	}

}
