package com.acf.samples;

public class Example {

	
	public static void main(String[] args) {
	
		Example ex = new Example();
		ex.sequenceOfStatements();
		ex.selectionPrincipal();
		ex.repetationPrincipal();
		
	}
	
	/**
	 * Example of SEQUENCE in Java
	 * The basics of all computer programs the SEQUENCE principal simply
	 * means that a program executes lines of code from top-to-bottom, left-to-right
	 */
	public void sequenceOfStatements() {
		Integer firstNum = 1;
		Integer secondNum = firstNum + 5;
		Integer sumOfNum = (firstNum + secondNum);
		System.out.println("Example of SEQUENCE principal");
		System.out.println("sumOfNum = " + sumOfNum);
	}
	
	/**
	 * The SELECTION principal refers to conditional
	 * statements in a program.  A conditional statement
	 * evaluates a condition and then perform whatever the logic
	 * is when the condition is true or false.
	 * In Java if/then/else, switch, and while statements illustrate this principal
	 */
	public void selectionPrincipal() {
		
		System.out.println("\nExample of SELECTION principal");
		Integer aNum = 5;
		Integer bNum = 8;
		
		if (aNum < bNum) {
			System.out.println("aNum " + aNum + " is less than bNum: " + bNum);
		} else {
			System.out.println("bNum " + bNum + " is less than aNum: " + aNum);
		}
		
		Integer optionSelected = 3;
		
		switch (optionSelected) {
		case 1: 
			System.out.println("Option Selected is: 1");
			break;
		case 2: 
			System.out.println("Option Selected is: 2");
			break;
		case 3: 
			System.out.println("Option Selected is: 3");
			break;
		default: System.out.println("I don't know what the value of optionSelected is??");
		}
		
	}
	
	/**
	 * The REPETATION principal is another staple of computing it
	 * represents the ability for a computer program to perform
	 * repetitive tasks at very high speed.
	 */
	public void repetationPrincipal() {
		System.out.println("\nExamples of REPETITION in Computer programming");
		
		// For 
		for (int a = 1; a < 5; a++) {
			System.out.println("\tFor/Next Loop number: " + a);
		}
		
		Integer howMany = 3;
		while (howMany > 0) {
			System.out.println("\tWhile loop number: " + howMany);
			howMany -= 1;
		}
		
		
		do {
			System.out.println("\tDo loop number: " + howMany);
			howMany += 1;
		} while (howMany < 3);
		
		
	}

}
