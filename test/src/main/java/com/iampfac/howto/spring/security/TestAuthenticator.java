package com.iampfac.howto.spring.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class TestAuthenticator {

	protected void login(String username, String password) {
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	protected abstract void loginAsAdmin();

	protected abstract void loginAsDemo();

	protected abstract void loginWithWrongPassword();

}
