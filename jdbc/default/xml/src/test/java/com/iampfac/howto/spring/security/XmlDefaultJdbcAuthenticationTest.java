package com.iampfac.howto.spring.security;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({ "jdbc-security-context.xml", "test-context.xml" })
public class XmlDefaultJdbcAuthenticationTest extends AuthenticationTest {

}
