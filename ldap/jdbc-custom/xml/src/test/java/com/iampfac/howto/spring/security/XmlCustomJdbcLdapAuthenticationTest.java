package com.iampfac.howto.spring.security;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({ "custom-jdbc-ldap-authentication-context.xml", "ldap-test-context.xml" })
public class XmlCustomJdbcLdapAuthenticationTest extends AuthenticationTest {

}
