package com.iampfac.howto.spring.security.core;

/**
 * A simple implementation of
 * {@link com.iampfac.howto.spring.security.core.Messenger}.
 * 
 * The methods in this class always return the same message.
 * 
 * @author Pedro Costa &lt;pedro.costa@vilt-group.com&gt;
 *
 */
public class SimpleMessenger implements Messenger {

	/**
	 * {@inheritDoc}
	 */
	public String getMessage() {
		return "Hello World!";
	}

	/**
	 * {@inheritDoc}
	 */
	public String getSecretMessage() {
		return "007, you have a new assignment.";
	}

}
