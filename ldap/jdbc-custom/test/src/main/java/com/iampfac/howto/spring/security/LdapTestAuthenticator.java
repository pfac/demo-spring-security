package com.iampfac.howto.spring.security;

public class LdapTestAuthenticator extends TestAuthenticator {

	public static final String ADMIN_USERNAME = "admin";
	public static final String ADMIN_PASSWORD = "53cr37";
	public static final String DEMO_USERNAME = "demo";
	public static final String DEMO_PASSWORD = "secret";

	@Override
	protected void loginAsAdmin() {
		login(ADMIN_USERNAME, ADMIN_PASSWORD);
	}

	@Override
	protected void loginAsDemo() {
		login(DEMO_USERNAME, DEMO_PASSWORD);
	}

	@Override
	protected void loginWithWrongPassword() {
		login(DEMO_USERNAME, ADMIN_PASSWORD);
	}
	
}
