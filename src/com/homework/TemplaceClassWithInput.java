package com.homework;

import java.util.Scanner;

public class TemplaceClassWithInput {

	private static Scanner keyInputter = null;

	public static void main(String...args) {

		keyInputter = new Scanner(System.in);

		// Put your code here
		
		String somevalue = getInputValue("Enter a double numeric value:");
		
		Double someDouble = Double.valueOf(somevalue);
		Integer someInteger = Integer.valueOf(somevalue);
		
		System.out.println("Original Value: " + somevalue);
		System.out.println("Converted Double value is " + someDouble);
		System.out.println("Converted Integer value is " + someInteger);
		
		keyInputter.close();
	}
	
	/**
	 * Use this to prompt for input and return the entered
	 * value as a String.  This will only query for the input and
	 * the caller is responsible for any input validation
	 * @param promptValue A string value to prompt the user as to what to enter
	 * @return String the value entered.
	 */
	private static String getInputValue(String promptValue) {
		System.out.println(promptValue + ": ");
		return keyInputter.nextLine();
		
	}
	
	
}
