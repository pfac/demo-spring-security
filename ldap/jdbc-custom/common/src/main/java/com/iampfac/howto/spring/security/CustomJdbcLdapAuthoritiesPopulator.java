package com.iampfac.howto.spring.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.util.Assert;

public class CustomJdbcLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomJdbcLdapAuthoritiesPopulator.class);
	
	private ICustomLdapTemplate ldapTemplate;
	private JdbcUserDetailsService userDetailsService;

	public CustomJdbcLdapAuthoritiesPopulator(ICustomLdapTemplate ldapTemplate, JdbcUserDetailsService userDetailsService) {
		Assert.notNull(ldapTemplate);
		Assert.notNull(userDetailsService);

		setLdapTemplate(ldapTemplate);
		setUserDetailsService(userDetailsService);
	}

	@Override
	public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations userData, String username) {
		final String userDn = userData.getNameInNamespace();
		LOGGER.debug("Getting authorities for user {}", userDn);

		Set<String> groups = getGroupsDistinguishedNames(userDn, username);

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (String groupDn : groups) {
			final List<GrantedAuthority> groupAuthorities = userDetailsService.loadGroupAuthorities(groupDn);
			authorities.addAll(groupAuthorities);
		}

		return authorities;
	}

	public Set<String> getGroupsDistinguishedNames(final String userDn, final String username) {
		final String groupSearchBase = "ou=groups";
		final String groupSearchFilter = "(uniqueMember={0})";

		LOGGER.debug("Searching groups for user '{}', DN = '{}' with filter {} in search base '{}'", username, userDn, groupSearchFilter, groupSearchBase);
		final Object[] params = new String[] { userDn, username };
		Set<String> distinguishedNames = getLdapTemplate().searchForDistinguishedNames(groupSearchBase, groupSearchFilter, params);

		LOGGER.debug("DNs from search: {}", distinguishedNames.toString());

		return distinguishedNames;
	}

	public ICustomLdapTemplate getLdapTemplate() {
		return ldapTemplate;
	}

	public void setLdapTemplate(ICustomLdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	public void setUserDetailsService(JdbcUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
}
