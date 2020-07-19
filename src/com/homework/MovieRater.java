package com.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MovieRater {

	private static Scanner keyInputter = null;

	public static void main(String...args) {

		keyInputter = new Scanner(System.in);

		// This map will be used to keep a tally of each of star votes 1 thru 4
		
		Map<Integer, Integer> ratings = new HashMap<Integer, Integer>() {{
			put(0, 0);
			put(1, 0);
			put(2, 0);
			put(3, 0);
			put(4, 0);
		}};
		
		List<String> ratingsList = new ArrayList<String>() {{
			add("Bowling would have been a better choice.");
			add("Not a Good movie choice.");
			add("Good movie choice!");
			add("Great movie choice!");
		}};
		
		int thisRating = 0;
		String thisResponse = "";
		String promptValue = "Enter a movie rating from 0 (horrible) to 4 (great), or -1 to exit ";
		Integer newCount = null;
		Integer mapKey = 0;
		
		while (thisRating > -1) {
			try {
				thisResponse = getInputValue(promptValue);
				thisRating = Integer.parseInt(thisResponse);
				if (thisRating < -1 || thisRating > 4) {
					throw new Exception("Bad value entered.");
				}
			} catch (Exception e) {
				System.out.println(String.format("The value you entered '%s' is NOT valid!.  You can only enter a number between -1 and 4.", thisResponse));
				continue;
			}
			
			if (thisRating > -1 ) {
				switch (thisRating) {
				case 0:
					break;
				case 1:
					mapKey = 1;
					break;
				case 2:
					mapKey = 2;
					break;
				case 3:
					mapKey = 3;
					break;
				case 4:
					mapKey = 4;
				}
				newCount = ratings.get(mapKey) + 1;
				ratings.replace(mapKey, newCount);
			}
			
		}
		
		// Print everything out
		
		System.out.println("Tally of all scores\n");
		System.out.println("NbrStars\tCount");
		for (Integer key : ratings.keySet()) {
			System.out.println(key + "\t\t" + ratings.get(key));
		}
		
		// Now get the average rating, but remove the 
		// zero entry as, technically, that means zero stars awarded
		
		ratings.remove(0);
		
		// Now get the average
		
		Double averageScore = ratings.values()
								.stream()
								.mapToInt(Integer::intValue)
								.average()
								.orElse(0);
		
		System.out.println("The average rating is: " + averageScore);
		
		// Finally, display the final rating based on the average
		
		if (averageScore.intValue() < 1.0) {
			averageScore = 1.0;
		}
		
		String ratingDesc = "";
		if (averageScore >= 3.0) {
			ratingDesc = ratingsList.get(3);
		}
		
		if (averageScore >= 2.0 && averageScore <= 2.99) {
			ratingDesc = ratingsList.get(2);
		}
		
		if (averageScore >= 1.0 && averageScore <= 1.99) {
			ratingDesc = ratingsList.get(1);
		}
		
		if (ratingDesc.isEmpty()) {
			ratingDesc = ratingsList.get(0);
		}
		
		System.out.println(ratingDesc);
		
		keyInputter.close();
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
