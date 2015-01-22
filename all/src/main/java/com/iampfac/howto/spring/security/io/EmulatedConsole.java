package com.iampfac.howto.spring.security.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmulatedConsole extends AbstractConsole {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmulatedConsole.class);

	private BufferedReader in;

	public EmulatedConsole() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void printf(String format, Object... args) {
		final String msg = String.format(format, args);
		System.out.print(msg);
	}

	@Override
	public String readLine(String format, Object... args) {
		String line = null;

		printf(format, args);
		try {
			line = in.readLine();
		} catch (IOException e) {
			LOGGER.error("A problem ocurred while trying to read a line of user input:", e);
		}
		return line;
	}

	@Override
	public char[] readPassword(String format, Object... args) {
		LOGGER.warn("Password input will not be hidden. Change to a proper console for that.");
		return readLine(format, args).toCharArray();
	}

}
