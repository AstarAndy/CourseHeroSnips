package com.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestConversation {

	private Scanner keyInputter = new Scanner(System.in);
	private Map<String, String> configItems = new HashMap<>();
	

	public static void main(String...args) {

		TestConversation tc = new TestConversation();
		
		tc.startConversation();
				
	}
	
	private void startConversation() {
		
		// Get a few configItems in there
		
		configItems.put("MEMORY", "1000");
		configItems.put("CPU", "I4");
		configItems.put("MONITOR", "3");

		String response = null;
		String newValue = null;
		String prompt = "What new value do you want? ";
		
		// Now we loop until they enter nothing and then we'll quit
		
		while (true) {
			prompt = "Item\tValue\n" + toString() + "\n Which one woud you like to change? Enter no value to stop";
			response = getInputValue(prompt);
			if (response.isEmpty()) {
				System.out.println("\nAppreciate your time.  Goodbye");
				break;
			}
			
			if (configItems.containsKey(response.toUpperCase())) {
				System.out.println("\n Enter the new value for '" + response + "'\n");
				newValue = keyInputter.nextLine();
				configItems.replace(response.toUpperCase(), newValue);
			} else {
				System.out.println("Sorry the value you entered: '" + response + "' is NOT one of the config items.  Try again. \n\n");
			}
			
			
		}
		
		keyInputter.close();
		return;
	}
	
	
	/**
	 * Use this to prompt for input and return the entered
	 * value as a String.  This will only query for the input and
	 * the caller is responsible for any input validation
	 * @param promptValue A string value to prompt the user as to what to enter
	 * @return String the value entered.
	 */
	private String getInputValue(String promptValue) {
		System.out.println(promptValue + ": ");
		return keyInputter.nextLine();
		
	}

	/**
	 * This will build a string of the contents of the map
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		configItems.forEach((key, value) -> {
			result.append(key + "\t" + value + "\n");
		});
		
		return result.toString();
		
	}
	
	
}
