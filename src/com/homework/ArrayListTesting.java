package com.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListTesting {

	public static void main(String[] args) {
		// Create an empty list
		List<Integer> listOfInts = new ArrayList<>();
		// Populate the list
		for (int a = 0; a < 25; a++) {
			listOfInts.add(-1);
		}
		
		// Now set 1st, 2nd, and 5th element to 133
		// Remember the array starts a 0
		
		listOfInts.set(0, 133);
		listOfInts.set(1,  133);
		listOfInts.set(4,  133);
		
		Double sumOfInts = getAverageListValue(listOfInts);
		System.out.println("The sum of the int values is: " + sumOfInts);
				
	}
	
	public static Double getAverageListValue(List<Integer> listToAverage) {
		return listToAverage
				.stream()
				.collect(Collectors.averagingInt(Integer::intValue));
	}

}
