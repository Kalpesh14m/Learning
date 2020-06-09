package com.bridgelabz.bookstore.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bridgelabz.bookstore.response.Response;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(UserException.class)
	public ResponseEntity<Response> handleUserException(UserException ex) {
		Response customErrorDetails = new Response(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				ex.getLocalizedMessage());

		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Response> handleUserNotFoundException(UserNotFoundException ex) {
		Response customErrorDetails = new Response(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				ex.getLocalizedMessage());

		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(TokenNotFoundException.class)
	public ResponseEntity<Response> handleTokenNotFoundException(TokenNotFoundException ex) {
		Response customErrorDetails = new Response(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				ex.getLocalizedMessage());

		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);

	}
}