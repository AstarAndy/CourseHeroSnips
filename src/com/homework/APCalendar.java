package com.homework;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * APCalendar will take a start date and an end date, along with just some date value
 * and compute various values from the dates entered.  This class makes heavy use of java.time.LocalDate
 * Note that the dayOfWeek method returns a 0 and not the default 7 as called for in the assignment
 * @author Student's Name
 *
 */
public class APCalendar {

	
	private static Scanner keyInputter = null;

	public static void main(String[] args) {
		keyInputter = new Scanner(System.in);
		
		try {
			String strStartYear = getInputValue("Enter a year to start the test with: ");
			if (strStartYear.isEmpty()) {
				System.exit(0);
			}
			
			int startYear = Integer.parseInt(strStartYear);
			
			String strEndYear = getInputValue("Enter an ending year to end the test with: ");
			if (strEndYear.isEmpty()) {
				System.exit(0);
			}
			
			int endYear = Integer.parseInt(strEndYear);
			
			// Start cannot be before end
			
			if (endYear <= startYear) {
				System.err.println("Your end year must be greater than your start year.  Aborting");
				System.exit(0);
			}

			String strTestDate = getInputValue("Please enter any date in yyyy-mm-dd format ");
			if (strTestDate.isEmpty()) {
				System.exit(0);
			}

			LocalDate testDate = LocalDate.parse(strTestDate);
			
			// Now call some of the helper routines
			
			int nbrLeapYears = numberOfLeapYears(startYear, endYear);
			
			System.out.println(String.format("The number of leap years between %d and %d is %d", startYear, endYear, nbrLeapYears));
			System.out.println("Is " + startYear + " a leap year: " + isLeapYear(startYear));
			System.out.println("Is " + endYear + " a leap year: " + isLeapYear(endYear));
			System.out.println("First day of the week for year " + startYear + " is " + firstDayOfYear(startYear));
			System.out.println("First day of the week for year " + endYear + " is " + firstDayOfYear(endYear));
			
			// Now use the testDate value to test the other helper routines that take a month, day, and year value
			
			int testYear = testDate.getYear();
			int testMonth = testDate.getMonthValue();
			int testDay = testDate.getDayOfMonth();
			
			// Day of year
			System.out.println("The day of the year for " + strTestDate + " is " + dayOfYear(testMonth, testDay, testYear));
			System.out.println("The day of the week for test date " + strTestDate + " is " + dayOfWeek(testMonth, testDay, testYear));
			
		} catch (Exception e) {
			System.err.println("The value you entered is not in yyyy-mm-dd format or is an invalid date value");
		}
		

	}
	
	private static boolean isLeapYear(int year) {
		return LocalDate.of(year, 1, 1).isLeapYear();
	}

	public static int numberOfLeapYears(int year1, int year2) {
		int nbrYears = 0;
		for (int a = year1; a < year2; a++) {
			nbrYears += (isLeapYear(a) ? 1 : 0);
		}
		return nbrYears;
	}

	private static int firstDayOfYear(int year) {
		return dayOfWeek(1, 1, year);
	}

	private static int dayOfYear(int month, int day, int year) {
		return LocalDate.of(year, month, day).getDayOfYear();
	}

	public static int dayOfWeek(int month, int day, int year) {
		int rtnVal = LocalDate.of(year, month, day).getDayOfWeek().getValue();
		return (rtnVal == 7 ? 0 : rtnVal);
	}
	
	private static String getInputValue(String promptValue) {
		System.out.println(promptValue + ": ");
		return keyInputter.nextLine();
		
	}



}
