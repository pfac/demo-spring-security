package com.iampfac.howto.spring.security;

public class CustomUsersJdbcTestAuthenticator extends TestAuthenticator {

	private static final String ADMIN_EMAIL = "admin@example.com";
	private static final String ADMIN_SECRET = "53cr37";
	private static final String DEMO_EMAIL = "demo@example.com";
	private static final String DEMO_SECRET = "secret";

	@Override
	protected void loginAsAdmin() {
		login(ADMIN_EMAIL, ADMIN_SECRET);
	}

	@Override
	protected void loginAsDemo() {
		login(DEMO_EMAIL, DEMO_SECRET);
	}

	@Override
	protected void loginWithWrongPassword() {
		login(ADMIN_EMAIL, DEMO_SECRET);
	}

}
