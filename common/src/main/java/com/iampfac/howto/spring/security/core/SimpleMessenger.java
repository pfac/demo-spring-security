package com.iampfac.howto.spring.security.core;

public class SimpleMessenger implements Messenger {

	public String getMessage() {
		return "Hello World!";
	}

	public String getSecretMessage() {
		return "007, you have a new assignment.";
	}

}
