package com.homework;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

public class ColumbusDay {

	public static void main(String[] args) {
		ColumbusDay cd = new ColumbusDay();
		Date columbusDay = cd.discoverColumbusDay(2003);
		//cd.oldLangSynch(DayOfWeek.SUNDAY);

	}
	
	private Date discoverColumbusDay(int whichYear) {
		
		// First build-out a full year October 1 + the whichYear parameter
		LocalDate febFirst = LocalDate.of(whichYear, 10, 1);
		// Now, what day of the week is the febFirst date? 1 = Monday, 2 Tuesday and so on
		int firstDayOfWeekNbr = febFirst.getDayOfWeek().getValue();
		// Now we know the day of the week the 1st starts on.
		int secondMondayInMonth = 0;

		// Now we can just add the number of days to get to the second Monday In the month
		if (firstDayOfWeekNbr == 1) {
			secondMondayInMonth = 8;
		} else {
			secondMondayInMonth = (9 - firstDayOfWeekNbr) + 7;
		}

		// Now try and compute the 2nd Monday
		LocalDate secondMonday = LocalDate.of(whichYear, 10, secondMondayInMonth);
		
		System.out.println("second Monday came to: " + secondMonday.getDayOfWeek() + ": " + secondMonday.toString() + " (" + secondMonday.getDayOfMonth() + ")");

		
		
		return Date.from(secondMonday.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
	}
	
	/**
	   * Computes and returns the next year - beginning with 2021 - in which
	   * New Year's Day will fall on a specified day of the week
	   * @param java.time.DayOfWeek dayOfWeek the day of the week (Monday is 0; Sunday is 6)
	   * @return the year in which New Year's Day will fall on dayOfWeek
	   */
	private int oldLangSynch(DayOfWeek forWhichDayOfWeek) {
		
		int testYear = 2021;
		LocalDate testDate = LocalDate.of(testYear, Month.JANUARY, 1);
		while (testDate.getDayOfWeek() != forWhichDayOfWeek) {
			testYear += 1;
			testDate = LocalDate.of(testYear,Month.JANUARY, 1);
			if ((testDate.getYear() % 100) == 0) {
				System.out.println("just checked another 100 years.  Now on" + testDate.getYear());
			}
		}
				
		System.out.println(String.format("The next year, starting with 2021; that the new year falls on a %s is %s", forWhichDayOfWeek, testDate));
		
		return testDate.getYear();
		
	}

}
