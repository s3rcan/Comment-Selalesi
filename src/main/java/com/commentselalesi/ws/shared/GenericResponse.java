package com.commentselalesi.ws.shared;

public class GenericResponse {
	private String message;

	public GenericResponse(String string) {
		this.message = string;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}