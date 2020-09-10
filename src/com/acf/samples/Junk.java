package com.acf.samples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Junk {
	

	public static void main(String[] args) {
		
		Scanner stdIn = new Scanner (System.in);
        int pain; //pain level variable
        char hurt; // yes or no if hurting today
        System.out.print("Are you in pain today? (y or n): "); // asks user if in pain
        hurt = stdIn.next().charAt(0); // assigns input to hurt
       if (hurt == 'y') { // if statement to determine level of pain if there is pain

             System.out.print("What is your pain scale today? (1-10): "); // asks user for pain level
             pain = stdIn.nextInt(); // assigns user input to pain
             
             if (pain < 6) {
                 System.out.println("Get up and walk around!");            	 
             }
             if (pain < 8) {
            	 System.out.println("Do your streches and use ice.");
             }
             if (pain < 11) {
            	 System.out.println("Take another set of pills and rest.");
             } else {
            	 System.out.println("You entered a number greater than 10.");
             }

       } else {
    	   System.out.println("Enjoy not being in pain!"); // if no pain produces this ouput	
       }
       
	}
	
	   /**
	    * This static method will take an input string, remove all 
	    * extra spaces, and return the result
	    * @param inValue
	    * @return
	    */
	   public static String removeExtraneousSpaces(String inValue) {
		   if (inValue == null) {
			   inValue = "";
		   }
		   return inValue.trim().replaceAll("\\s+", " ");
		 
	   }
	   
	   
	   public static int sum(int[] a, int left, int right) {
		   if (a.length > 0 && left > -1 && right > -1) {
			   if ((left < right) && (left <= a.length) && (right <= a.length)) {
				   int result = 0;
				   for (int start = left; start == right; start++) {
					   result += a[start];
				   }
				   return result;
			   }
		   }
		   return 0;
	   }
	   
	   /**
	    * This will reverse a string
	    * @param inValue
	    * @return
	    */
	   public static String reverseThisString(String inValue) {
		   if (inValue == null) {
			   inValue = "";
		   }
		   
		   StringBuilder sb = new StringBuilder(inValue);
		   sb.append(inValue);
		   sb = sb.reverse();
		   return sb.toString();
		   
	   }
	   
	   /**
	    * This will read a file of lines of Strings
	    * If the data lines are Integers or Doubles (floats) then
	    * just change String to Integer or Double
	    * @return the sorted list
	    */
	   private List<String> readFile() {
		   String fileName = "./YourFileNameHere.txt";
			// Java 7 beauty..
			List<String> content = null;
			
			try {
				content = Files.readAllLines(Paths.get(fileName));
				// Now just sort the list
				Collections.sort(content);
				
			} catch (IOException e) {
				System.err.println("Unable to open, or read; file " + fileName);
			}
			
			return content;

	   }
	   
	   private void stuff() {
		   int cents = 0;
		   
		   if (cents == 1) {
			   System.out.println("Cent.");
		   } else {
			   if (cents == 5) {
				   System.out.println("Nickle.");
			   } else {
				   if (cents == 10) {
					   System.out.println("Dime.");
				   } else {
					   if (cents == 25) {
						   System.out.println("Quarter.");
					   } else {
						   System.out.println("Not a valid value.");
					   }
				   }
			   }
		   }
		   
	   }
	   
	   private void dateAndTimeGames() {
		   Instant rightNow = Instant.ofEpochMilli(System.currentTimeMillis());
		   List<String> junk = new ArrayList<>();
		   for (String thisVal : junk) {
			  thisVal.length();
		   }
	   }
	   
	   
	   public static int test( int x, int y) {

	          if ( x==y)

	               return x;

	           else if ( x> y)

	               return ( x + y);

	           else

	               return test ( x +1, y-1);

	 

	  }
	
	
}
