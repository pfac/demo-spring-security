package com.iampfac.howto.spring.security;

import org.springframework.test.context.ContextConfiguration;

import com.iampfac.howto.spring.security.config.InMemorySecurityConfiguration;

@ContextConfiguration(classes = { InMemorySecurityConfiguration.class, InMemoryTestContext.class })
public class JavaConfigInMemoryAuthenticationTest extends AuthenticationTest {

}
