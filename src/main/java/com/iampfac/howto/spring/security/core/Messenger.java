package com.iampfac.howto.spring.security.core;

import org.springframework.security.access.prepost.PreAuthorize;

public interface Messenger {

	@PreAuthorize("hasRole('ROLE_USER')")
	public String getMessage();

}
