package com.iampfac.demo.spring.security.io;

import java.io.Console;

public class DefaultConsole extends AbstractConsole {

	private Console console;

	public DefaultConsole() {
		this(System.console());
	}

	protected DefaultConsole(Console console) {
		this.console = console;
	}

	@Override
	public void printf(String format, Object... args) {
		console.printf(format, args);
	}

	@Override
	public String readLine(String format, Object... args) {
		return console.readLine(format, args);
	}

	@Override
	public char[] readPassword(String format, Object... args) {
		return console.readPassword(format, args);
	}

}
