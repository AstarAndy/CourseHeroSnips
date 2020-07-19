package com.homework;

import java.util.Scanner;

public class ArraySwap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int list[] = {9, 7, 2, 3, 4};
		
		System.out.println("Please enter a number between 1 and 4: ");
		int swapPos = sc.nextInt();
		if (swapPos < 1 || swapPos > 4) {
			System.out.println("Sorry, only a number from 1 to 4 is acceptable");
			System.exit(-1);
		}
		
		swapPositions(list, swapPos);
		
	}
	
	public static void swapPositions(int list[], int whichPos) {

		// First print the before array
		System.out.println("Before Swap");
		for (int a = 0; a < list.length; a++) {
			System.out.print(list[a] + " ");
		}
		
		// Now get the zero entry and swap it with whichPos
		
		int firstEntry = list[0];
		// now swap it
		list[0] = list[whichPos];
		list[whichPos] = firstEntry;
		
		// Now display the after
		System.out.println("\nAfter Swap");
		for (int a = 0; a < list.length; a++) {
			System.out.print(list[a] + " ");
		}		
		
	}

}
