package com.iampfac.howto.spring.security;

import java.io.Console;
import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.iampfac.howto.spring.security.authentication.SampleAuthenticationManager;

public class App implements Runnable {

	private AuthenticationManager am = new SampleAuthenticationManager();

	public static void main(String[] args) {
		new App().run();
	}

	public void run() {
		Console console = System.console();

		do {
			String username = console.readLine("Username: ");
			char[] rawPassword = console.readPassword("Password: ");
			String password = new String(rawPassword);

			try {
				Authentication auth = new UsernamePasswordAuthenticationToken(username, password);
				auth = am.authenticate(auth);
				console.printf("Success: %s%s", auth.toString(), System.lineSeparator());
			} catch (AuthenticationException e) {
				console.printf("Authentication failed: %s%s", e.getMessage(), System.lineSeparator());
			}

			Arrays.fill(rawPassword, ' ');
		} while (true);
	}
}
