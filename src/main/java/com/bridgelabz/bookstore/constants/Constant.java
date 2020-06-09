package com.bridgelabz.bookstore.constants;

import java.time.LocalDateTime;

import com.bridgelabz.bookstore.utils.DateUtility;

public class Constant {

	private Constant() {

	}

	public static final String EMAIL_ID = "rameshaanji535@gmail.com";
	public static final String SECRET_KEY = "secret";
	public static final String EMAIL = "email";
	public static final String VERIFY_ADDRESS = "http://localhost:8080/user/verify?token=";
	public static final String ISSUER = "Bridgelabz";
	public static final String SUBJECT = "authentication";
	public static final long LOGIN_EXP = 24 * 60 * 60 * 10000000;
	public static final int OK_RESPONSE_CODE = 200;
	public static final int CREATED_RESPONSE_CODE = 201;
	public static final int ALREADY_EXIST_EXCEPTION_STATUS = 208;
	public static final int NOTE_NOT_FOUND_EXCEPTION_STATUS = 300;
	public static final int BAD_REQUEST_RESPONSE_CODE = 400;
	public static final int USER_AUTHENTICATION_EXCEPTION_STATUS = 401;
	public static final int NOT_FOUND_RESPONSE_CODE = 404;
	public static final int BAD_GATEWAY_RESPONSE_CODE = 502;
	public static final String LOGIN_SUCCESSFULL_MESSAGE = "Login Successfull";
	public static final String PASSWORD_UPTATION_SUCCESSFULLY_MESSAGE = "Password Updated Successfully";
	public static final String VALID_INPUT_MESSAGE = "Give Valid Password";
	public static final String LOGIN_FAILED_MESSAGE = "Login Failed";
	public static final String USER_VERIFIED_SUCCESSFULLY_MEAASGE = "User Verified Successfully";
	public static final String USER_NOT_FOUND_EXCEPTION_MESSAGE = "User not found!";
	public static final String USER_ALREADY_VERIFIED_MESSAGE = "User Already Verified";
	public static final LocalDateTime LOCAL_DATE_TIME = DateUtility.today();
	public static final String USER_ALREADY_REGISTER_MESSAGE = "User Already register";
	public static final String REGISTRATION_SUCCESSFULL_MESSAGE = "Registration Sucessfull";
	public static final String REPLAY_MAILID = "no_replay@gmail.com";
	public static final String MESSAGEING_RESPONSE = "No-Reply";
	public static final String VERIFICATION = "Verification";
	public static final long REGISTER_EXP = 3 * 60 * 60 * 1000;

}