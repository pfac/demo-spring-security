package com.iampfac.howto.spring.security;

import org.springframework.test.context.ContextConfiguration;

import com.iampfac.howto.spring.security.config.CustomJdbcLdapSecurityConfiguration;

@ContextConfiguration(classes = { CustomJdbcLdapSecurityConfiguration.class, LdapTestContext.class })
public class JavaConfigCustomJdbcLdapAuthenticationTest extends AuthenticationTest {

}
