package com.iampfac.howto.spring.security;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iampfac.howto.spring.security.config.InMemorySecurityConfiguration;
import com.iampfac.howto.spring.security.core.Messenger;
import com.iampfac.howto.spring.security.core.SimpleMessenger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { InMemorySecurityConfiguration.class, JavaConfigInMemoryAuthenticationTest.TestContext.class })
public class JavaConfigInMemoryAuthenticationTest extends InMemoryAuthenticationTest {

	@Configuration
	protected static class TestContext {

		@Bean
		public Messenger messenger() {
			return new SimpleMessenger();
		}

	}

}
