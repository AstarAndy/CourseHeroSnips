package com.acf.samples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

public class ScratchPadOnly {
	
	public static void main(String[] args) { 

		// Just to parse the input into an Integer
		int yearsOld = Integer.parseInt(JOptionPane.showInputDialog("How Old Are You?"));
		
		// If you want to print-out the integer to the console you can do this
		System.out.println("You are " + Integer.parseInt(JOptionPane.showInputDialog("How Old Are You?")) + " old!");

	}
		
}
