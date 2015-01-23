package com.iampfac.howto.spring.security;

import org.springframework.test.context.ContextConfiguration;

import com.iampfac.howto.spring.security.config.DefaultJdbcSecurityContext;

@ContextConfiguration(classes = { DefaultJdbcSecurityContext.class, DefaultJdbcTestContext.class })
public class JavaConfigDefaultJdbcAuthenticationTest extends AuthenticationTest {

}
