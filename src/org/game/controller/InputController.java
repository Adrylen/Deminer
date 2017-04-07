package org.game.controller;

/* This is the Input Manager for the Terminal
* version of the Deminor
*/
class InputController {
	static int MIN_VALUE = 10;
	static int getInit(String arg, int min, int max) {
		int number = Integer.parseInt(arg);
		return (number <= max) ? (number >= min) ? number : min : max;
	}

	boolean isInput(String command) {
		return command.length() > 0;
	}

	boolean isShowCommand(String[] args) {
		return args.length == 3 && args[0].equals("d");
	}

	boolean isMarkCommand(String[] args) {
		return args.length == 4 && args[0].equals("m");
	}

	boolean isOtherCommand(String command) {
		return command.equals("q") || command.equals("x");
	}
}
