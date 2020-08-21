package com.homework.swing;

import java.util.Random;

import javax.swing.JOptionPane;

public class Misc {

	public static void main(String[] args) {
		Random rand = new Random();
		JOptionPane.showMessageDialog(null, "Consider a number from 1 to 10.  Click Ok to check your guess");
		int answer = rand.nextInt(10) + 1;
		JOptionPane.showMessageDialog(null, "The actual number is: " + answer);

	}

}
