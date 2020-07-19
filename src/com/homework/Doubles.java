package com.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Doubles {

	/**
	 * Used to test the averageOfDoubles method.
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Create an array of double values and notice the 0.0 entry.
		Double doublesArray[] = new Double[] {1.2, 3.5, 6.25, 7.98, 1.19, 2.6, 0.0, 129.0};
		
		Double averageValue = averageOfDoubles(doublesArray);

	}
	
	/**
	 * This method will: 1 accept an array of doubles, 2 - convert it to a list to make it 
	 * easy to filer and compute sums and averages, build another list that does not include
	 * any values after the first value of 0.0; and then sums and averages them
	 * @param doublesArray
	 * @return
	 */
	public static Double averageOfDoubles(Double[] doublesArray) {
		// First requirement is to only include those values up, but not including, the first
		// zero entry and also ignore any values after the 0.0 value
		
		List<Double> filteredValues = new ArrayList<>();
		for (int a = 0; a < doublesArray.length; a++) {
			if (doublesArray[a] == 0.0) {
				break;
			}
			filteredValues.add(doublesArray[a]);
		}
		
		// make sure we have at least 1 double value to add up
		if (filteredValues.isEmpty()) {
			return 0.0;
		}
		
		// Now use Java 8 streaming to quickly compute the sum and averages
		
		// First, get the sum
		Double sumOfValue = filteredValues
				.stream()
				.collect(Collectors.summingDouble(Double::doubleValue));
		// Now get the average.
		Double averageOfValues = filteredValues
				.stream()
				.collect(Collectors.averagingDouble(Double:: doubleValue));
		
		// Now print-out all the values used.
		
		System.out.println("Original Array of Doubles was: ");
		System.out.println(Arrays.asList(doublesArray));
		System.out.println("Filtered everything out after the first zero is:");
		System.out.println(filteredValues);
		
		System.out.println("The sum of the filtered values is: " + sumOfValue);
		System.out.println("The the average of the filtered values is: " + averageOfValues);
		
		
		
		return averageOfValues;
		
	}

}
