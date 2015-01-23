package com.iampfac.howto.spring.security;

public class CustomUsersJdbcTestContext extends TestContext {

	@Override
	public TestAuthenticator authenticator() {
		return new CustomUsersJdbcTestAuthenticator();
	}

}
