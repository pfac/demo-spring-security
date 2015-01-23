package com.iampfac.howto.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * Base class for configuring the security context in any of the samples.
 * 
 * Any subclass inherits
 * {@link org.springframework.context.annotation.Configuration}, enables method
 * security (including annotations like
 * {@link org.springframework.security.access.prepost.PreAuthorize}) and exposes
 * the {@link AuthenticationManager} as a public bean.
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
