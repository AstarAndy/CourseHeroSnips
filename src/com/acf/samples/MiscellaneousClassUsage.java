package com.acf.samples;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class MiscellaneousClassUsage {
	
	class BadAccountInputException extends Exception {
		public BadAccountInputException(String theEntryError) {
			super(theEntryError);
		}
	}

	public static void main(String[] args) {
		
		MiscellaneousClassUsage mcu = new MiscellaneousClassUsage();
		
		System.out.println("Today's day of week number is: " + (LocalDate.of(2020, 4, 25).getDayOfWeek().getValue() - 0));
		
		//mcu.predicateGames(25);
		//mcu.predicateGames(10);
		//mcu.stringExtractionGames("John Doe,25,Boston");
		//mcu.variousTests();
		//mcu.computeAverages();
			
		
		//mcu.randomNumbers();
		/*
		 * try { mcu.checkName(" St. James"); System.out.println("Names checked ok"); }
		 * catch (BadAccountInputException e) { // TODO Auto-generated catch block
		 * System.err.println(e.getMessage()); }
		 */
	}
	
	
	public void accrueScores() {
		List<Double> scores = Arrays.asList(10.0, 5.0, 1.0, 0.0, 14.0, 38.0);
		
		Double min;
		Double max;
		Double AverageScore;
		
		min = scores
				.stream()
				.min(Comparator.comparing(Double::longValue))
				.get();
		
		max = scores
				.stream()
				.max(Comparator.comparing(Double::longValue))
				.get();
		AverageScore = scores
						.stream()
						.mapToDouble(Double::longValue)
						.average()
						.getAsDouble();
		
	}
	
	public void randomNumbers() {
		
		Random useRandClass = new Random();
		
		// Between 0 and (max - 1)
		// So the sample between 0 and 9
		
		int max = 10;
		int someRandInt = useRandClass.nextInt(max);
		System.out.println("The number generated is: " + someRandInt);
		
	}
	
	public void timeUnitGames() {
		try {
			TimeUnit.MILLISECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkName(String testName) throws BadAccountInputException {
		
		// First, be sure it is not null
		if ((testName == null) || (testName.isEmpty())) {
			throw new BadAccountInputException("The entry cannot be NULL or blank");
		}
		
		// Next if we have any illegal characters then also abort
		if(!testName.matches("[a-zA-Z .'-]+")) {
			throw new BadAccountInputException("The entry can only contain upper/lower characters, a space, a ', a -, or a .");			
		}

		// Now, do we even have any of the special case characters?  If not just return true 
		// cause the entry is value
		
		if (!(testName.contains(" ") || testName.contains(".") || testName.contains("'") || testName.contains("-") )) {
			return true;
		}
		
		// If we are here then we need to see if the char is at the beginning of the string, or at the end and
		// if so, throw the error else return true as a valid entry
		
		String firstLetter = testName.substring(0, 1);
		String lastLetter = testName.substring(testName.length()-1, testName.length());
		
		// Now check that it is not the first byte
		if (firstLetter.equals(" ") || firstLetter.equals("'") || firstLetter.equals("-") || firstLetter.equals(".")) {
			throw new BadAccountInputException("The entry can only contain upper/lower characters, a space, a ', a -, or a .");						
		}
		
		// Finally check the last letter 
		if (lastLetter.equals(" ") || lastLetter.equals("'") || lastLetter.equals("-") || lastLetter.equals(".")) {
			throw new BadAccountInputException("The entry can only contain upper/lower characters, a space, a ', a -, or a .");						
		}		
		
		// If we're here then the entry is good
		return true;
	}
	
	public void predicateGames(Integer forWhichNumber) {
		Predicate<Integer> isAnEvenNumber = numberToCheck -> ((numberToCheck % 2) == 0);
		Predicate<Integer> isAnOddNumber = numberToCheck -> ((numberToCheck % 2) != 0);
		
		Boolean isEven = isAnEvenNumber.test(forWhichNumber);
		Boolean isOdd = isAnOddNumber.test(forWhichNumber);
		System.out.println("The number, " + forWhichNumber + " evaluates as Even: " + isEven + " and Odd: " + isOdd );
		
		//range 1 to 80 inclusive but not an even integer in the range 30 to 60 
		
		int n = 90;		
		boolean testIt = (( (n >= 1 && n <= 80) && ( ( n >= 30 && n <= 60) && (n % 2 == 0) ) ) ? true : false);
		System.out.println("Value of " + n + " is: " + testIt);
		
		Predicate<Integer> inRangeAndNotEven = nbrToTest -> {
			// First, it must be between 1 and 80
			if (nbrToTest >= 1 && nbrToTest <= 80) {
				// Next it must be between 30 & 60)
				if (nbrToTest >= 30 && nbrToTest <= 60) {
					// Finally, it's gotta be an even number
					return (nbrToTest % 2 == 0 ? true:false);
				}
			}
			return false;
		};
				
	}
	
	public void stringExtractionGames(String stringToSearch) {
		
		// So, the variable stringToSearch is equal "John Doe,25,Boston"
		// Also remember when the first character of a string starts at zero (0).
		
		// Given the sample string we are using we need to know the position
		// of the first and last comma.  If either one returns -1 then we have an error
		
		int firstPos = stringToSearch.indexOf(",");
		int lastPos = stringToSearch.lastIndexOf(",");
		
		// for error handling if either firstPos or lastPos = -1 then they didn't enter 2 commas and that's an error
		if (firstPos == -1 || lastPos == -1) {
			System.out.println("You must enter a name,age,city.  You did not enter all 3 values separated with a ,");
			return;
		}
		
		// now we can pull-out the pieces and all pieces must have a value...no blanks
		
		String name = stringToSearch.substring(0, firstPos);
		if (name == null || name.isEmpty()) {
			System.out.println("You did not enter a name value");
			return;
		}
		
		System.out.println(stringToSearch);
		System.out.println(String.format("First comma position: %d, Name: %s, Length: %d", firstPos, name, name.length()));
		
		// Now get John's age and convert it to an integer
		
		String strAge = "";
		int age = -1;
		
		// We will use the try/except block to trap for any errors and handle them
		try {
			strAge = stringToSearch.substring(firstPos+1, lastPos);
			if (strAge == null || strAge.isEmpty()) {
				throw new Exception("You did not enter an age value");
			}
			// Ok, if they did not enter a numeric value for age then 
			// the next line will cause an error
			age = Integer.parseInt(strAge);
			
			// We are here to the age value is good
			System.out.println(String.format("Second comma position: %d, age: %d", lastPos, age));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
		// Now 10 years from now:
		System.out.println(String.format("You will be %d in 10 years from now", age+10));
		
		// Finally get the city value.  Same thing...they must enter a city 
		// or we have an issue
		
		String city = stringToSearch.substring(lastPos+1);
		if (city == null || city.isEmpty()) {
			System.out.println("You did not enter a city value");
		}
		
		System.out.println(String.format("City: %s, Length: %d", city, city.length()));
		
		return;
		
	}
	
	public void variousTests() {
//		a. "y" + 2 + 3
		
		String a = "y" + 2 + 3;
		System.out.println("a = " + a);
//
//		b. "y" + (3 + 4)
		String b = "y" + (3 + 4);
		System.out.println("b = " + b);
//
//		c. 2 + 3 + "y"
		String c = 2 + 3 + "y";
		System.out.println("c = " + c);
//
//		d. 2 + (3 + "y")
		String d = 2 + (3 + "y");
		System.out.println("d = " + d);
//
//		e. "y" + (2 + 3) + "z"
		String e = "y" + (2 + 3) + "z";
		System.out.println("e = " + e);
//
//		f. "y" + 2 + 3 + "z"
		String f = "y" + 2 + 3 + "z";
		System.out.println("f = " + f);
		
		System.out.println("2g = " + " Luct ".charAt(3));
		System.out.println("2j = " + " Luct ".substring(1, 3));
		System.out.println("2k = " + " Luct ".substring(2));
		System.out.println("2l = " + " Luct ".equalsIgnoreCase("luct"));
		
		String t1 = "Luct".substring(1);
		String t2 = "Luct".substring(1, "Luct".length());
		System.out.println("t1 is " + t1 + " and t2 is " + t2);
//
//		g. "Luct".length( )
//
//		h. " Luct ".charAt(3)
//
//		i. " Luct ".replace('u', 'k')
//
//		j. " Luct ".substring(1, 3)
//
//		k. " Luct ".substring(2)
//
//		l. " Luct ".equalsIgnoreCase("luct")
//
//		2. Explain how the implementation of substring(int beginIndex) would
//
//		take advantage of substring(int beginIndex, int endIndex).
	}
	
	public void computeAverages() {
		
		double sum = 1987;
		double tripsTaken = 21;
		BigDecimal average = new BigDecimal(sum / tripsTaken).setScale(2, RoundingMode.HALF_UP);
		System.out.println("987 / 21 is: " + average.toString());
		double justADouble = (sum / tripsTaken);
		System.out.println("Just a double is: " + justADouble);
		
		sum = 1773;
		tripsTaken = 37;
		average = new BigDecimal(sum / tripsTaken).setScale(2, RoundingMode.HALF_UP);
		System.out.println("1773 / 37 is: " + average.toString());
		justADouble = (sum / tripsTaken);
		System.out.println("Just a double is: " + justADouble);
		
	}

	
}
