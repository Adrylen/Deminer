/*
    Java Project
    Deminer
    Package : org.game.controller

    Created by adrylen on 10/03/17.
*/

package org.game.controller;

class InputController {
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