package com.iampfac.howto.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * Base class for configuring the security context in any of the samples.
 * 
 * @author Pedro Costa &lt;pedro.costa@vilt-group.com&gt;
 *
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public abstract class SecurityContext extends GlobalMethodSecurityConfiguration {

	/**
	 * Exposes the {@link AuthenticationManager} bean from
	 * {@link GlobalMethodSecurityConfiguration}, allowing it to be
	 * automatically linked with
	 * {@link org.springframework.beans.factory.annotation.Autowired}
	 * annotations.
	 */
	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
