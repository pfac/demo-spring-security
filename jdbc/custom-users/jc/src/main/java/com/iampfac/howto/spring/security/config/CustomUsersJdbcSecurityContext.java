package com.iampfac.howto.spring.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.iampfac.howto.spring.security.config.JdbcSecurityContext;
import com.iampfac.howto.spring.security.jdbc.CustomUsersJdbcUserDetailsService;

public class CustomUsersJdbcSecurityContext extends JdbcSecurityContext {

	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		CustomUsersJdbcUserDetailsService bean = new CustomUsersJdbcUserDetailsService();
		bean.setDataSource(dataSource);
		return bean;
	}

	@Bean
	public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
		DaoAuthenticationProvider bean = new DaoAuthenticationProvider();
		bean.setUserDetailsService(userDetailsService);
		return bean;
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth, AuthenticationProvider authenticationProvider) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}

}
