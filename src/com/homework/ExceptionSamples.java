package com.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * This class illustrates how, or when, some kinds of exceptions would happen
 * Please see the comments above each test method for the specifics
 * @author Student
 *
 */
public class ExceptionSamples {

	/**
	 * In this method, if the developer assumes the Integer object
	 * was created and then attempts to use one of the object's 
	 * methods you will get a NullPointerException
	 * @see java.exception.NullPointerExceptipn
	 * @param testNumber Integer (this is the OBJECT version of an int)
	 */
	public void possibleNullPointerException(Integer testNumber) {
		Integer anotherNumber = new Integer(25);
		if (testNumber.equals(anotherNumber)) { // (If testNumber is null you get an err0r)
			// do somethig
		}
	}
	
	/**
	 * If the developer doesn't first check for nullness and also
	 * the current size of the array of strings passed-in, and then
	 * attempts to access an element in the array that is larger than
	 * the size of the array, you'll get an ArrayIndexOutOfBounds error
	 * 
	 * Note: This would also be true for an ArgumentOutOfRangeException.  These errors are one in the same
	 * 
	 * @param strings An array of string values
	 * @see java.exception.ArrayIndexOutOfBoundsException
	 */
	public void possibleIndexOutOfRangeException(String...strings ) {
		if (strings[20].equals("Another Value")) { // If 20 is too big you'll get an error
			// do something
		}
	}
	
	/**
	 * Classic example of a bug that will produce a stack overflow error
	 * In this case we recursively call ourselves until the stack fills-up
	 * @param aStringValue
	 * @param String Just a test string value
	 * @see java.exception.StackOverflowException
	 */
	public void stackOverflowError(String aStringValue) {
		
		String junk = "This is just a test";
		while (true) {
			stackOverflowError(junk);
		}
		
	}
	
	/**
	 * Again, similar to a stack overflow, if you just keep adding
	 * data you will, eventually, run out of memory and produce
	 * an OutOfMemory error
	 * @see java.exception.OutOfMemoryExcpetion
	 */
	public void outOfMemoryError() {
		List<String> myList = new ArrayList<>();
		while (true) {
			myList.add("Just adding strings until we fill memory");
		}
	}
	
	/**
	 * If you attempt to cast, or force one object type to another when
	 * the objects types are no compatible, you get a CastException.
	 * @param myTestSet This is a SET object with Integers.  If we try and cast that to a List we'll get a CastException
	 */
	public void invalidCastException(Set<Integer> myTestSet) {
		List<Integer> myIntList = (List<Integer>)myTestSet;
	}
	
	/**
	 * Basic math stuff here.  If you attempt to divide a number by zero
	 * you'll get a DivideByZeroException
	 * @param denomitor An integer to divide with.  In this sample its value is 0
	 */
	public void divideByZeroException(int denomitor) {
		double result = (29832 / denomitor);
	}
	
	/**
	 * An illegal argument exception is normally used, or happens, because a value
	 * is not of the expected type or is out of range.  In the example we will
	 * test and if an integer value is > 500 we'll force this error
	 * @param aValue An integer test value
	 * @see java.lang.IllegalArgumentException
	 */ 
	public void illegalArgumentException(int aValue) {
		 if (aValue > 500) {
			 throw new IllegalArgumentException("The value you supplied cannot be > 500");
		 }
		
	}
	
	/**
	 * In java a "system" error is called a RuntimeException.  They are rare
	 * but can be illustrated with a lambda expression
	 * @see java.lang.RuntimeException
	 */
	public void systemException() {
		
		// When doing lambda expressions if there are any error then 
		// java will cause a runtime excpetion
		
		List<Integer> myIntList = new ArrayList<>();
		myIntList.add(1);
		myIntList.add(2);
		myIntList.add(null);
		myIntList.add(4);
		
		int sumOfNumbers = myIntList
							.stream()
							.mapToInt(Integer::intValue)  // since the 3rd entry is null this will produce a rutime error
							.sum();
		
	}

}
