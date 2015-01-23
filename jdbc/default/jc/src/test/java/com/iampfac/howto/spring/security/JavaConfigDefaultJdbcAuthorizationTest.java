package com.iampfac.howto.spring.security;

import org.springframework.test.context.ContextConfiguration;

import com.iampfac.howto.spring.security.config.JdbcSecurityContext;

@ContextConfiguration(classes = { JdbcSecurityContext.class, TestContext.class })
public class JavaConfigDefaultJdbcAuthorizationTest extends AuthorizationTest {

}
