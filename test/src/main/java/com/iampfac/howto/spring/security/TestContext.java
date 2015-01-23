package com.iampfac.howto.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.iampfac.howto.spring.security.core.Messenger;
import com.iampfac.howto.spring.security.core.SimpleMessenger;

/**
 * Test context for tests in samples configured programatically.
 * 
 * Exposes a {@link com.iampfac.howto.spring.security.core.Messenger} bean to be
 * auto-wired into the test classes.
 * 
 * @author Pedro Costa &lt;pedro.costa@vilt-group.com&gt;
 *
 */
@Configuration
public class TestContext {

	/**
	 * Exposes a {@link com.iampfac.howto.spring.security.core.Messenger} bean.
	 * 
	 * @return a new instance of
	 *         {@link com.iampfac.howto.spring.security.core.SimpleMessenger}.
	 */
	@Bean
	public Messenger messenger() {
		return new SimpleMessenger();
	}

}
