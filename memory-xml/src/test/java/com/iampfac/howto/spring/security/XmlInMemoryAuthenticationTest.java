package com.iampfac.howto.spring.security;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iampfac.howto.spring.security.core.Messenger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "in-memory-security-context.xml", "test-context.xml" })
public class XmlInMemoryAuthenticationTest {

	@Autowired
	private Messenger service;

	@After
	public void tearDown() {
		SecurityContextHolder.clearContext();
	}

	/* it does not execute because no user has been authenticated */
	@Test(expected = AuthenticationCredentialsNotFoundException.class)
	public void itDoesNotExecuteBecauseNoUserHasBeenAuthenticated() {
		service.getMessage();
	}

	/* it does not execute because user authenticated with wrong credentials */
	@Test(expected = BadCredentialsException.class)
	public void itDoesNotExecuteBecauseUserAuthenticatedWithWrongCredentials() {
		login("user", "sercet");
		service.getMessage();
	}

	/*
	 * it executes correctly when user authenticated successfully
	 */
	public void itExecutesCorrectlyWhenUserAuthenticatedSuccessfully() {
		login("user", "secret");
		service.getMessage();
	}

	/*
	 * it does not execute because authenticated user does not have the required
	 * role
	 */
	@Test(expected = AccessDeniedException.class)
	public void itDoesNotExecuteBecauseUserDoesNotHaveRequiredRole() {
		login("user", "secret");
		service.getSecretMessage();
	}

	/*
	 * it executes correctly when user authenticated successfully and has the
	 * required role
	 */
	public void itExecutesCorrectlyWhenUserAuthenticatedSuccessfullyAndHasTheRequiredRole() {
		login("admin", "53cr37");
		Assert.assertTrue(StringUtils.isNotBlank(service.getSecretMessage()));
	}

	protected void login(String username, String password) {
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

}
