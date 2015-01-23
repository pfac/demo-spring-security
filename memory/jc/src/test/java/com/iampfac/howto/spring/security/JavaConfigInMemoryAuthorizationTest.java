package com.iampfac.howto.spring.security;

import org.springframework.test.context.ContextConfiguration;

import com.iampfac.howto.spring.security.config.InMemorySecurityConfiguration;

@ContextConfiguration(classes = { InMemorySecurityConfiguration.class, TestContext.class })
public class JavaConfigInMemoryAuthorizationTest extends AuthorizationTest {

}
