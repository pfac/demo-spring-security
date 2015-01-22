package com.iampfac.howto.spring.security.core;

import org.springframework.security.access.prepost.PreAuthorize;

public interface Messenger {

	@PreAuthorize("authenticated")
	public String getMessage();

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String getSecretMessage();

}
