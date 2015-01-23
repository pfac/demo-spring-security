package com.iampfac.howto.spring.security;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AuthenticationTest extends SecurityTest {

	/* it does not execute because no user has been authenticated */
	@Test(expected = AuthenticationCredentialsNotFoundException.class)
	public void itDoesNotExecuteBecauseNoUserHasBeenAuthenticated() {
		getService().getMessage();
	}

	/* it does not execute because user authenticated with wrong credentials */
	@Test(expected = BadCredentialsException.class)
	public void itDoesNotExecuteBecauseUserAuthenticatedWithWrongCredentials() {
		login("demo", "sercet");
		getService().getMessage();
	}

	/*
	 * it executes correctly when user authenticated successfully
	 */
	@Test
	public void itExecutesCorrectlyWhenUserAuthenticatedSuccessfully() {
		login("demo", "secret");
		
		final String message = getService().getMessage();
		Assert.assertTrue(StringUtils.isNotBlank(message));
	}

}
