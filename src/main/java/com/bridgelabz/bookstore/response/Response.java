package com.bridgelabz.bookstore.response;

import java.time.LocalDateTime;

public class Response {
	private int status;
	private String message;
	private LocalDateTime now;

	public LocalDateTime getNow() {
		return now;
	}

	public void setNow(LocalDateTime now) {
		this.now = now;
	}

	public Response() {
		super();
	}

	public Response(String message) {
		super();
		this.message = message;
	}

	public Response(String message, int status) {
		this.message = message;
		this.status = status;
	}

	public Response(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Response(LocalDateTime now, int status, String message) {
		this.now = now;
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", message=" + message + "]";
	}

}