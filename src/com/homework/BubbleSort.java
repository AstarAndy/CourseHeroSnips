package com.homework;

import java.util.Arrays;

/**
 * Simple <code>manual</code> bubble sort of
 * an array
 * @author Student's name
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		bs.execute();

	}
	
	/**
	 * Main starting point
	 */
	public void execute() {
		
		// First create an unordered array of ints
		int unOrderedArray[] = {30, 80, 5, 50, 40, 90, 70, 60, 100, 20};
		int orderedArray[] = sort(unOrderedArray);
		int foundAt = search(60, orderedArray);
		
		System.out.println("The unordered array is:");
		printArray(unOrderedArray);
		System.out.println("The ordered array is:");
		printArray(orderedArray);
		System.out.println("Located value 60 at position " + foundAt + " in the reordered array" );
		
	}
	
	/**
	 * This will make a copy of the input array, so as to not change
	 * the original array; and then sort the new array with a simple
	 * bubble sort
	 * @param arrayToSort
	 * @return sortedArray
	 */
	private int[] sort(int[] arrayToSort) {
		// Don't change the original array
		// make a copy of it
		int[] result = Arrays.copyOf(arrayToSort, arrayToSort.length);
		// Now do a simple bubble sort
		
		boolean finishedSorting = false;
		while (!finishedSorting) {
			finishedSorting = true;
			for (int a = 0; a < (result.length - 1); a++) {
				if (result[a+1] < result[a]) {
					int thisVal = result[a];
					result[a] = result[a+1];
					result[a+1] = thisVal;
					finishedSorting = false;
				}
			}
		}
		
		return result;

	}
	
	/**
	 * Search a sorted array for the supplied value
	 * and return the position of the array the value
	 * is located at or -1 if the value was not in the array.
	 * Going to use a simple split search and either start at the begining
	 * or the middle of the array
	 * @param searchValue int what value to look for
	 * @param arrayToSearch The integer array to search
	 * @return foundAt int The position in the array the value was found it
	 */
	private int search(int searchValue, int[] arrayToSearch) {
		int foundAt = -1;
		
		int startAt = (arrayToSearch.length / 2);
		// if the value in the middle of the array is < the
		// search value then we'll start at the beginning or
		// we'll start at the computed value
		
		if (searchValue < arrayToSearch[startAt]) {
			startAt = 0;
		}
		
		for (int a = startAt; a < arrayToSearch.length-1; a++) {
			if (searchValue == arrayToSearch[a]) {
				foundAt = a;
				break;
			}
		}
		
		return foundAt;
		
	}
	
	public void printArray(int[] arrayToPrint) {
		StringBuffer sb = new StringBuffer();
		for (int a = 0; a < arrayToPrint.length; a++) {
			sb.append(arrayToPrint[a] + " ");
		}
		System.out.println(sb.toString());
	}

}
