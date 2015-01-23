package com.iampfac.howto.spring.security;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;

public abstract class AuthenticationTest extends SecurityTest {

	/* it does not execute because no user has been authenticated */
	@Test(expected = AuthenticationCredentialsNotFoundException.class)
	public void itDoesNotExecuteBecauseNoUserHasBeenAuthenticated() {
		getService().getMessage();
	}

	/* it does not execute because user authenticated with wrong credentials */
	@Test(expected = BadCredentialsException.class)
	public void itDoesNotExecuteBecauseUserAuthenticatedWithWrongCredentials() {
		loginWithWrongPassword();
		getService().getMessage();
	}

	/*
	 * it executes correctly when user authenticated successfully
	 */
	@Test
	public void itExecutesCorrectlyWhenUserAuthenticatedSuccessfully() {
		loginAsDemo();
		
		final String message = getService().getMessage();
		Assert.assertTrue(StringUtils.isNotBlank(message));
	}

}
