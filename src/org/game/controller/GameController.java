/*
    Java Project
    Deminer
    Package : org.game.controller

    Created by adrylen on 08/03/17.
*/

package org.game.controller;

class GameController {
	private static boolean quitGame = false;

	private static boolean isInput(String command) {
		return command.length() > 0;
	}

	private static boolean isShowCommand(String command) {
		String[] args = command.split(" ");
		return args.length == 3 && args[0] == "d";
	}

	private static boolean isMarkCommand(String command) {
		String[] args = command.split(" ");
		return args.length == 4 && args[0] == "m";
	}

	private static boolean isOtherCommand(String command) {
		return command.equals("q");
	}

	private static void updateModel(String command, boolean b) {
		try {
			if (b) {

			} else {

			}
		} catch(NumberFormatException e) {
			System.out.println("Problème");
		}
	}

	private static void quitGameCommand() {
		GameController.quitGame = true;
	}

	public static boolean gameIsClosed() {
		return GameController.quitGame;
	}

	public static void manageInput(String command) {
		if(isInput(command)) {
			if(isShowCommand(command)) {
				updateModel(command, true);
			} else if(isMarkCommand(command)) {
				updateModel(command, false);
			} else if(isOtherCommand(command)) {
				quitGameCommand();
			}
		}
	}
}
