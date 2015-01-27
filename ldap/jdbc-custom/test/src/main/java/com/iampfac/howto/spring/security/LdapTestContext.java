package com.iampfac.howto.spring.security;

import org.springframework.context.annotation.Bean;

public class LdapTestContext extends TestContext {

	@Bean
	public TestAuthenticator authenticator() {
		return new LdapTestAuthenticator();
	}

}
