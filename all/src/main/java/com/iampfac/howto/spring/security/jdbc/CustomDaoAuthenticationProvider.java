package com.iampfac.howto.spring.security.jdbc;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomDaoAuthenticationProvider extends DaoAuthenticationProvider {

	@Override
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		super.setUserDetailsService(userDetailsService);
	}

}
