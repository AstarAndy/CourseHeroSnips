package com.homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class GenerateDateBasedFileNames {

	private static Scanner keyInputter = null;
	private static LocalDate useDate = null;
	private static LocalDate baseDate = null;
	private static int howManyDays = 1;
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

	public static void main(String...args) {

		keyInputter = new Scanner(System.in);

		// Put your code here
		
		String strStaringDate = getInputValue("Enter the starting date in MM-DD-YYYY format ");
		String strHowManyDays = getInputValue("Enter how many days you want to generate file names for ");
		
		/*
		 * We can't assume they will enter the proper value so, if they
		 * don't we're going to tell them their input is bad and abort the
		 * program
		 * 
		 */
		try {
			useDate = LocalDate.parse(strStaringDate, dateFormatter);
			baseDate = LocalDate.parse(strStaringDate, dateFormatter);
			howManyDays = Integer.parseInt(strHowManyDays);
		} catch (NumberFormatException e) {
			System.out.println("There was a problem with the data you entered.  The error type is " +
					e.getClass().getName() + " and the actual problem was: " + e.getMessage());
			System.exit(-1);
		}
		
		
		
		String lastFileName = "";
		while (lastFileName != null) {
			lastFileName = makeNextFileName();
			// If you want to execute and check, then
			// uncomment out the lines below
			
			 if (lastFileName != null) { 
				 System.out.println("The next file name is: " + lastFileName); 
			 }
			 	
		}
				
		keyInputter.close();
	}
	
	/**
	 * Returns a string of MM-DD-YYYY.csv for the global useDate variable
	 * @return String 
	 */
	public static String makeNextFileName() {
		
		long daysBetween = ChronoUnit.DAYS.between(baseDate, useDate) + 1;
		if (daysBetween > howManyDays) {
			return null;
		}
		
		String returnValue = useDate.format(dateFormatter) + ".csv";
		useDate = useDate.plusDays((long)1);
		return returnValue;
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
