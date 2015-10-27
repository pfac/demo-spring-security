package com.iampfac.demo.spring.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import com.iampfac.demo.spring.security.jdbc.CustomJdbcUserDetailsService;
import com.iampfac.demo.spring.security.ldap.CustomLdapAuthoritiesPopulator;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends GlobalMethodSecurityConfiguration {

	private DataSource dataSource;

	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		CustomJdbcUserDetailsService customJdbcUserDetailsService = new CustomJdbcUserDetailsService();
		customJdbcUserDetailsService.setDataSource(dataSource);

		DaoAuthenticationProvider customJdbcProvider = new DaoAuthenticationProvider();
		customJdbcProvider.setUserDetailsService(customJdbcUserDetailsService);

		CustomLdapAuthoritiesPopulator customLdapAuthoritiesPopulator = new CustomLdapAuthoritiesPopulator(customJdbcUserDetailsService);

		auth.jdbcAuthentication().dataSource(dataSource);
		auth.inMemoryAuthentication().withUser("memdemo").password("secret").roles("USER").and().withUser("memadmin").password("53cr37").roles("ADMIN");
		auth.authenticationProvider(customJdbcProvider);
		auth.ldapAuthentication().userDnPatterns("uid={0},ou=users").groupSearchBase("ou=groups").groupRoleAttribute("ou").contextSource()
				.ldif("classpath:com/iampfac/howto/spring/security/users.ldif").root("dc=example,dc=org");

		auth.ldapAuthentication().ldapAuthoritiesPopulator(customLdapAuthoritiesPopulator).userDnPatterns("uid={0},ou=users").contextSource()
				.ldif("classpath:com/iampfac/howto/spring/security/mix.ldif").root("dc=example,dc=org");
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
