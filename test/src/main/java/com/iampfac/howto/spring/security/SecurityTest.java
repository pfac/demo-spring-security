package com.iampfac.howto.spring.security;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iampfac.howto.spring.security.core.Messenger;

@RunWith(SpringJUnit4ClassRunner.class)
public abstract class SecurityTest {

	@Autowired
	private TestAuthenticator authenticator;

	@Autowired
	private Messenger service;

	@After
	public void tearDown() {
		SecurityContextHolder.clearContext();
	}

	protected Messenger getService() {
		return service;
	}

	protected void loginAsAdmin() {
		authenticator.loginAsAdmin();
	}

	protected void loginAsDemo() {
		authenticator.loginAsDemo();
	}

	protected void loginWithWrongPassword() {
		authenticator.loginWithWrongPassword();
	}

}
