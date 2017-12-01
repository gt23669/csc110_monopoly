package edu.neumont.csc110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUI {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Generates a console-based menu using the Strings in options as the menu
	 * items. Reserves the number 0 for the "quit" option when withQuit is true.
	 * 
	 * @param options
	 *            - Strings representing the menu options
	 * @param withQuit
	 *            - adds option 0 for "quit" when true
	 * @return the int of the selection made by the user
	 * @throws IOException
	 */
	static int promptForMenuSelection(String[] options, boolean withQuit) throws IOException {
		int arrayLen = options.length;
		int min = 1;
		
		if(withQuit) {
			System.out.println("0: Quit");
			min=0;
		}
		
		for (int i = 0; i < options.length; i++) {
			System.out.println((i + 1) + ": " + options[i]);
		}
		return promptForInt("Enter menu selection", min, arrayLen);
	}

	/**
	 * Generates a prompt that expects the user to enter one of two responses that
	 * will equate to a boolean value. The trueString represents the case
	 * insensitive response that will equate to true. The falseString acts
	 * similarly, but for a false boolean value. Example: Assume this method is
	 * called with a trueString argument of "yes" and a falseString argument of
	 * "no". If the enters "YES", the method returns true. If the user enters "no",
	 * the method returns false. All other inputs are considered invalid, the user
	 * will be informed, and the prompt will repeat.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param trueString
	 *            - the case insensitive value that will evaluate to true
	 * @param falseString
	 *            - the case insensitive value that will evaluate to false
	 * @return the boolean value
	 * @throws IOException
	 */
	static boolean promptForBool(String prompt, String trueString, String falseString) throws IOException {
		boolean result = false;
		boolean isValidInput = false;
		while (!isValidInput) {
			System.out.println(prompt);
			String input = in.readLine();
			if (input.equalsIgnoreCase(trueString)) {
				isValidInput = true;
				result = true;
			} else if (input.equalsIgnoreCase(falseString)) {
				isValidInput = true;
				result = false;
			}
		}
		return result;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a byte value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the byte value
	 * @throws IOException
	 */
	static byte promptForByte(String prompt, byte min, byte max) throws IOException {
		byte returnValue = 0;
		boolean isValidInput = false;
		while (!isValidInput) {
			System.out.println(prompt);
			String rawInput = in.readLine();
			try {
				returnValue = Byte.parseByte(rawInput);
				if (returnValue >= min && returnValue <= max) {
					isValidInput = true;
				}
			} catch (NumberFormatException ex) {
				System.out.println("You must give me a valid byte.");
			}

		}
		return returnValue;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a short value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the short value
	 * @throws IOException
	 */
	static short promptForShort(String prompt, short min, short max) throws IOException {
		short returnValue = 0;
		boolean isValidInput = false;
		while (!isValidInput) {
			System.out.println(prompt);
			String rawInput = in.readLine();
			try {
				returnValue = Short.parseShort(rawInput);
				if (returnValue >= min && returnValue <= max) {
					isValidInput = true;
				}
			} catch (NumberFormatException ex) {
				System.out.println("You must give me a valid short.");
			}

		}
		return returnValue;
	}

	/**
	 * Generates a prompt that expects a numeric input representing an int value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the int value
	 * @throws IOException
	 */
	static int promptForInt(String prompt, int min, int max) throws IOException {
		int returnValue = 0;
		boolean isValidInput = false;
		while (!isValidInput) {
			System.out.println(prompt);
			String rawInput = in.readLine();
			try {
				returnValue = Integer.parseInt(rawInput);
				if (returnValue >= min && returnValue <= max) {
					isValidInput = true;
				}else {
					System.out.println("You must give me a valid input");
				}
			} catch (NumberFormatException ex) {
				System.out.println("You must give me a valid int.");
			}

		}
		return returnValue;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a long value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the long value
	 * @throws IOException
	 */
	static long promptForLong(String prompt, long min, long max) throws IOException {

		long returnValue = 0;
		boolean isValidInput = false;
		while (!isValidInput) {
			System.out.println(prompt);
			String rawInput = in.readLine();
			try {
				returnValue = Long.parseLong(rawInput);
				if (returnValue >= min && returnValue <= max) {
					isValidInput = true;
				}
			} catch (NumberFormatException ex) {
				System.out.println("You must give me a valid Long.");
			}

		}
		return returnValue;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a float value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the float value
	 * @throws IOException
	 */
	static float promptForFloat(String prompt, float min, float max) throws IOException {

		float returnValue = 0;
		boolean isValidInput = false;
		while (!isValidInput) {
			System.out.println(prompt);
			String rawInput = in.readLine();
			try {
				returnValue = Float.parseFloat(rawInput);
				if (returnValue >= min && returnValue <= max) {
					isValidInput = true;
				}
			} catch (NumberFormatException ex) {
				System.out.println("You must give me a valid float.");
			}

		}
		return returnValue;
	}

	/**
	 * Generates a prompt that expects a numeric input representing a double value.
	 * This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the double value
	 * @throws IOException
	 */
	static double promptForDouble(String prompt, double min, double max) throws IOException {

		double returnValue = 0;
		boolean isValidInput = false;
		while (!isValidInput) {
			System.out.println(prompt);
			String rawInput = in.readLine();
			try {
				returnValue = Double.parseDouble(rawInput);
				if (returnValue >= min && returnValue <= max) {
					isValidInput = true;
				}
			} catch (NumberFormatException ex) {
				System.out.println("You must give me a valid double.");
			}

		}
		return returnValue;
	}

	/**
	 * Generates a prompt that allows the user to enter any response and returns the
	 * String. When allowEmpty is true, empty responses are valid. When false,
	 * responses must contain at least one character (including whitespace).
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user.
	 * @param allowEmpty
	 *            - when true, makes empty responses valid
	 * @return the input from the user as a String
	 * @throws IOException
	 */
	static String promptForInput(String prompt, boolean allowEmpty) throws IOException {

		String returnValue = "";
		boolean isValidInput = false;
		while (!isValidInput) {
			System.out.println(prompt);
			String rawInput = in.readLine();
			returnValue = rawInput;
			
			if (rawInput.length() >= 1 || allowEmpty) {
				isValidInput = true;
			} else {
				System.out.println("You must give me a valid string.");
			}
		}
		return returnValue;
	}

	/**
	 * Generates a prompt that expects a single character input representing a char
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the char value
	 * @throws IOException
	 */
	static char promptForChar(String prompt, char min, char max) throws IOException {
		char returnValue = 0;
		boolean isValidInput = false;
		while (!isValidInput) {
			System.out.println(prompt);
			String rawInput = in.readLine();

			returnValue = rawInput.charAt(0);
			if (returnValue >= min && returnValue <= max&&rawInput.length()==1) {
				isValidInput = true;
			} else {
				System.out.println("You must give me a valid char.");
			}

		}
		return returnValue;
	}
}