package com.acf.samples;

import java.util.Scanner;

/**
 * This java class will ask the user for a 
 * grade value between 1 and 16 and then print to
 * the default output console a translated education level
 * 
 * @author student
 *
 */
public class SchoolGrades {

	/**
	 * This is the main entry point of all java programs
	 * @param args An array of command-line arguments, if any
	 */
	public static void main(String[] args) {
		
		try {

			// If they don't enter a number it will cause an error.  In that
			// case we will just stop the program.  The try/catch in java is
			// the basic way to handle an error.  If we did not do this then
			// a non-numeric entry would cause a program crash.
			
			// The Scanner object is the basic way to get input from a user
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the grade in school you are in.");
			System.out.println("0 means just to stop.  Otherwise enter a number between 1 and 16");
			int gradeLevel = sc.nextInt();
			if (gradeLevel >= 0) {
				if (gradeLevel > 16) {
					System.exit(0);
				}
			}
			
			// So they entered a good number between 1 and 16 so 
			// now we'll translate to a education level
			
			switch (gradeLevel) {
				case 16:
				case 15:
				case 14:
				case 13:
					System.out.println("You are attending college.");
					break;
				case 12:
				case 11:
				case 10:
				case 9:
					System.out.println("You are attending high school");
					break;
				case 0:
					break;
				default:
					System.out.println("You are in elementary school");
			}
			
		} catch (Exception e) {
			// Don't care if they entered a non-numeric so just exit
			System.exit(0);
		}

	}

}
