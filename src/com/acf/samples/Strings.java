package com.acf.samples;

import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter some text with extra spaces throughout the phrase you enter: ");
		String origValue = sc.nextLine();
		String strippedValue = origValue.trim().replaceAll("\\s+", "");
		
		System.out.println("Orig Val: " + origValue);
		System.out.println("New  Val: " + strippedValue);

	}

}
