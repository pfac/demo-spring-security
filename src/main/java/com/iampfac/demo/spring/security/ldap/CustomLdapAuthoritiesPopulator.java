package com.iampfac.demo.spring.security.ldap;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

import com.iampfac.demo.spring.security.jdbc.CustomJdbcUserDetailsService;

public class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomLdapAuthoritiesPopulator.class);

	private CustomJdbcUserDetailsService service;

	public CustomLdapAuthoritiesPopulator(CustomJdbcUserDetailsService service) {
		this.service = service;
	}

	public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations user, String username) {
		LOGGER.debug("Getting authorities for user %s", user.getNameInNamespace());;
		
		final String email = user.getStringAttribute("mail");
		Collection<GrantedAuthority> roles = service.loadUserAuthorities(email);

		return roles;
	}

}
