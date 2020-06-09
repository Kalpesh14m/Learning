package com.bridgelabz.bookstore.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.bridgelabz.bookstore.model.dto.RegistrationDTO;
import com.bridgelabz.bookstore.utils.DateUtility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class User {
	@GenericGenerator(name = "user_id", strategy = "increment")
	@GeneratedValue(generator = "userid")
	@Id
	private Long id;

	@Column(name = "first_name", nullable = false)
	@Size(min = 3)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	@Size(min = 3)
	private String lastName;

	@Column
	private String userName;

	@Column(name = "email", unique = true, nullable = false)
	@Email
	private String email;

	@Column(name = "password", nullable = false)
	@Size(min = 3)
	private String password;

	@Column(name = "city", nullable = false)
	@Size(min = 3)
	private String city;

	@Column(name = "mobile_number", length = 10, unique = true)
	@NotNull
	private Long mobileNumber;

	@Column(name = "is_verify")
	@NotNull
	private boolean isVerify;

	@Column(name = "is_deleted")
	@NotNull
	private boolean isDeleted;

	@Column(name = "registration_date_time")
	@NotNull
	private LocalDateTime registrationDateTime;

	@Column(name = "update_date_time")
	@NotNull
	private LocalDateTime updateDateTime;

	public User() {
	}

	public User(RegistrationDTO req) {
		this.firstName = req.getFirstName();
		this.lastName = req.getLastName();
		this.email = req.getEmail();
		this.password = req.getPassword();
		this.city = req.getCity();
		this.mobileNumber = req.getMoblieNumber();
		this.isVerify = false;
		this.isDeleted = false;
		this.registrationDateTime = DateUtility.today();
		this.updateDateTime = DateUtility.today();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isVerify() {
		return isVerify;
	}

	public void setVerify(boolean isVerify) {
		this.isVerify = isVerify;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public LocalDateTime getRegistrationDateTime() {
		return registrationDateTime;
	}

	public void setRegistrationDateTime(LocalDateTime registrationDateTime) {
		this.registrationDateTime = registrationDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}
