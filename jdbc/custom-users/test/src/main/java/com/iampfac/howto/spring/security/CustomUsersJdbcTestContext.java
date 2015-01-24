package com.iampfac.howto.spring.security;

import org.springframework.context.annotation.Bean;

public class CustomUsersJdbcTestContext extends TestContext {

	@Bean
	@Override
	public TestAuthenticator authenticator() {
		return new CustomUsersJdbcTestAuthenticator();
	}

}
