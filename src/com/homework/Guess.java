package com.homework;

import java.util.Scanner;

public class Guess {
	
	private static int CORRECT_NUMBER = 100;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		boolean incorrectAnswer = true;
		int numberGuessed = 0;
		
		// Now loop until we have a good guess
		do {
			
			System.out.print("Try and guess the winning number.  Enter a number: ");
			numberGuessed = sc.nextInt();
			checkNum(numberGuessed);
			sc.nextLine();
			if (numberGuessed == CORRECT_NUMBER) {
				incorrectAnswer = false;
			}
			
		} while (incorrectAnswer);

	}
	
	public static void checkNum(int numberEntered) {
		if (numberEntered == CORRECT_NUMBER) {
			System.out.println("Number is correct");
		} else {
			System.out.println("Number is not correct");			
		}
	}

}
