package com.iampfac.howto.spring.security;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.directory.SearchControls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.core.ContextMapper;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapEncoder;
import org.springframework.util.Assert;

public class CustomLdapTemplate extends LdapTemplate implements ICustomLdapTemplate {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomLdapTemplate.class);

	private SearchControls searchControls = new SearchControls();

	public CustomLdapTemplate(ContextSource contextSource) {
		Assert.notNull(contextSource, "ContextSource cannot be null");
		setContextSource(contextSource);

		searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
	}

	public Set<String> searchForDistinguishedNames(final String base, final String filter, final Object[] params) {
		Object[] encodedParams = new String[params.length];
		for (int i = 0; i < params.length; ++i) {
			final String param = params[i].toString();
			encodedParams[i] = LdapEncoder.filterEncode(param);
		}

		final String formattedFilter = MessageFormat.format(filter, encodedParams);
		LOGGER.debug("Searching for distinguished names in '{}' with filter '{}'", base, formattedFilter);

		List<String> distinguishedNames = search(base, formattedFilter, searchControls, new ContextMapper<String>() {

			@Override
			public String mapFromContext(Object paramObject) throws NamingException {
				DirContextAdapter adapter = (DirContextAdapter) paramObject;
				return adapter.getNameInNamespace();
			}

		});
		LOGGER.debug("Found DN's: {}", distinguishedNames.toString());

		return new HashSet<String>(distinguishedNames);
	}

}
