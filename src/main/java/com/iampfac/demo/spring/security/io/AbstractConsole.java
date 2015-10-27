package com.iampfac.demo.spring.security.io;

public abstract class AbstractConsole {

	public abstract void printf(String format, Object... args);

	public void printfln(String format, Object... args) {
		int newArgsLength = args.length + 1;
		Object[] newArgs = new Object[newArgsLength];
		for (int i = 0; i < args.length; ++i) {
			newArgs[i] = args[i];
		}
		newArgs[args.length] = System.lineSeparator();
		printf(format + "%s", newArgs);
	}

	public abstract String readLine(String format, Object... args);

	public abstract char[] readPassword(String format, Object... args);

}
