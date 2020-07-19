package com.homework;

import java.util.Scanner;

public class Fraction {
	
	private int numerator = 0;
	private int denomanator = 0;
	
	
	public Fraction(int num, int denom) {
		numerator = num;
		denomanator = denom;
		if (numerator == 0 || denomanator == 0) {
			System.err.println("Can't create the Fraction object.");
			throw new RuntimeException("You cannot have a zero for a numerator or a denomanator");
		}
	}
	
	public void performDivision() {
		System.out.println(numerator + " divided by " + denomanator + " = " + (numerator / denomanator));
	}

	public static void main(String[] args) {
		
		// first, test the error handling for the Fraction object
		// This should produce an error
		try {
			Fraction badFraction = new Fraction(0, 5);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		// Now let's do a good one.  I know there is no error so
		// I won't bother to check for one
		
		Fraction goodFraction = new Fraction(100, 2);
		goodFraction.performDivision();
		
		// Now get some numbers manually;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter your numerator value: ");
		double numerator = sc.nextDouble();
		
		System.out.print("Please enter your denomanator value: ");
		double denomanator = sc.nextDouble();
		
		// Test them
		if (numerator == 0 || denomanator == 0) {
			System.err.println("You cannot have a zero for a numerator or a denomanator");
		} else {
			System.out.println(numerator + " / " + denomanator + " is " + (numerator / denomanator));
		}

		

	}

}
