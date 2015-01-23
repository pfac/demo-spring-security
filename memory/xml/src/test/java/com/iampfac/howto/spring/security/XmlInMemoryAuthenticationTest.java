package com.iampfac.howto.spring.security;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({ "in-memory-security-context.xml", "in-memory-test-context.xml" })
public class XmlInMemoryAuthenticationTest extends AuthenticationTest {

}
