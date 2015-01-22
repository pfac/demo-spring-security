package com.iampfac.howto.spring.security;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({ "in-memory-security-context.xml", "test-context.xml" })
public class XmlInMemoryAuthenticationTest extends InMemoryAuthenticationTest {

}
