package com.iampfac.howto.spring.security;

import org.springframework.context.annotation.Bean;

public class InMemoryTestContext extends TestContext {

	@Bean
	public TestAuthenticator authenticator() {
		return new InMemoryTestAuthenticator();
	}

}
