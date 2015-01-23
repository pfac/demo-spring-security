package com.iampfac.howto.spring.security;

import org.springframework.test.context.ContextConfiguration;

import com.iampfac.howto.spring.security.config.CustomUsersJdbcSecurityContext;

@ContextConfiguration(classes = { CustomUsersJdbcSecurityContext.class, CustomUsersJdbcTestContext.class })
public class JavaConfigCustomUsersJdbcAuthenticationTest extends AuthenticationTest {

}
