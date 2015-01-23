package com.iampfac.howto.spring.security;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AuthorizationTest extends SecurityTest {

	/*
	 * it does not execute because authenticated user does not have the required
	 * role
	 */
	@Test(expected = AccessDeniedException.class)
	public void itDoesNotExecuteBecauseUserDoesNotHaveRequiredRole() {
		loginAsDemo();
		getService().getSecretMessage();
	}

	/*
	 * it executes correctly when user authenticated successfully and has the
	 * required role
	 */
	@Test
	public void itExecutesCorrectlyWhenUserAuthenticatedSuccessfullyAndHasTheRequiredRole() {
		loginAsAdmin();

		final String secretMessage = getService().getSecretMessage();
		Assert.assertTrue(StringUtils.isNotBlank(secretMessage));
	}

}
