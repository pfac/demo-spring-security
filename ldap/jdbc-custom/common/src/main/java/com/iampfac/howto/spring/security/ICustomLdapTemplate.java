package com.iampfac.howto.spring.security;

import java.util.Set;

public interface ICustomLdapTemplate {

	public Set<String> searchForDistinguishedNames(final String base, final String filter, final Object[] params);

}