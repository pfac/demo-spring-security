package com.iampfac.howto.spring.security;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({ "custom-users-jdbc-security-context.xml", "custom-users-jdbc-test-context.xml" })
public class XmlCustomUsersJdbcAuthenticationTest extends AuthenticationTest {

}
