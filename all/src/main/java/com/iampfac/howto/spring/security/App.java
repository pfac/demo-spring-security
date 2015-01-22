package com.iampfac.howto.spring.security;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import com.iampfac.howto.spring.security.core.Messenger;
import com.iampfac.howto.spring.security.io.AbstractConsole;
import com.iampfac.howto.spring.security.io.ConsoleFactory;

public class App implements Runnable {

	private ApplicationContext context = new AnnotationConfigApplicationContext("com.iampfac.howto.spring.security.config");

	public static void main(String[] args) {
		new App(args).run();
	}

	public App(String[] args) {
	}

	public void run() {
		AuthenticationManager am = context.getBean(AuthenticationManager.class);
		Messenger messenger = context.getBean(Messenger.class);
		AbstractConsole console = new ConsoleFactory().createConsole();

		do {
			String username = console.readLine("Username: ");
			char[] rawPassword = console.readPassword("Password: ");
			String password = new String(rawPassword);

			try {
				Authentication auth = new UsernamePasswordAuthenticationToken(username, password);
				auth = am.authenticate(auth);
				SecurityContextHolder.getContext().setAuthentication(auth);
				String msg = messenger.getMessage();
				console.printfln("%s %s", msg, auth.toString());
			} catch (AuthenticationException e) {
				console.printfln("Authentication failed: %s", e.getMessage());
			} catch (AccessDeniedException e) {
				console.printfln("Access denied: %s", e.getMessage());
			}

			Arrays.fill(rawPassword, ' ');

		} while (!"n".equals(console.readLine("Continue? Y/n [Y]")));
	}
}
