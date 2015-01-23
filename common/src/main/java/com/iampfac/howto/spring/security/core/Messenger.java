package com.iampfac.howto.spring.security.core;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;

/**
 * Example of a secure object interface to be used in samples.
 * 
 * @author Pedro Costa &lt;pedro.costa@vilt-group.com&gt;
 *
 */
public interface Messenger {

	/**
	 * Obtains the message if there is an authenticated user, otherwise
	 * (assuming security is correctly enabled), an exception will be thrown.
	 * 
	 * @return A message for known users.
	 * 
	 * @throws AuthenticationCredentialsNotFoundException
	 *             If no user has been authenticated.
	 * @throws BadCredentialsException
	 *             If the supplied username/password pair is not recognized.
	 */
	@PreAuthorize("authenticated")
	public String getMessage();

	/**
	 * Obtains the message if there is an authenticated user with the ROLE_ADMIN
	 * role, otherwise (assuming security is correctly enabled), an exception
	 * will be thrown.
	 * 
	 * @return A secret message just for &quot;administrators&quot;.
	 * 
	 * @throws AuthenticationCredentialsNotFoundException
	 *             If no user has been authenticated.
	 * @throws BadCredentialsException
	 *             If the supplied username/password pair is not recognized.
	 * @throws AccessDeniedException
	 *             If the authenticated user does not have the required role
	 *             (ROLE_ADMIN).
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String getSecretMessage();

}
