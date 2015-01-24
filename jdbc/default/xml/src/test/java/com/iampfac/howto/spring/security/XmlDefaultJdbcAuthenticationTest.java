package com.iampfac.howto.spring.security;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({ "default-jdbc-security-context.xml", "default-jdbc-test-context.xml" })
public class XmlDefaultJdbcAuthenticationTest extends AuthenticationTest {

}
