package com.homework;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public abstract class Currency {
	
	private String name;
	public abstract Double convert(Double rupeesToConvert);

	public Currency(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Currency [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Main entry point to test classes
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Double rupeesToConvert = null;
		
		try {
			System.out.print("Please enter how many Rupee Dollars you want to convert.  Must be between 50 and 1000 ");
			rupeesToConvert = sc.nextDouble();
			// Validate the input
			if (rupeesToConvert == null || rupeesToConvert < 50.0 || rupeesToConvert > 1000.00) {
				throw new Exception(rupeesToConvert + " is not a valid value.  Must be between 50 and 1000");
			}
			
			// Now test each class of currency
			Dollar thisDollar = new Dollar("US Dollar");
			Double convertedAmt = thisDollar.convert(rupeesToConvert);

			Euro thisEuro = new Euro("Euro");
			convertedAmt = thisEuro.convert(rupeesToConvert);

			Yen thisYen = new Yen("Japanese Yen");
			convertedAmt = thisYen.convert(rupeesToConvert);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

/**
 * This will convert India rupees into US Dollars
 * Note: The conversion rate changes each day so,
 * for the purposes of this exercise we'll use the rate
 * set on 2020-05-01 of .013
 * @author Student's name
 *
 */
class Dollar extends Currency {

	public Dollar(String name) {
		super(name);
	}

	@Override
	public Double convert(Double rupeesToConvert) {
		Double returnValue = (rupeesToConvert * 0.013);
		System.out.println(rupeesToConvert + " Rupee Dollars is " + BigDecimal.valueOf(returnValue).setScale(2, RoundingMode.HALF_UP) + " in " + getName());		
		return returnValue;
	}
	
	
}

/**
 * This will convert India rupees into Euros
 * Note: The conversion rate changes each day so,
 * for the purposes of this exercise we'll use the rate
 * set on 2020-05-01 of .012
 * @author Student's name
 *
 */
class Euro extends Currency {

	public Euro(String name) {
		super(name);
	}

	@Override
	public Double convert(Double rupeesToConvert) {
		Double returnValue = (rupeesToConvert * 0.012);
		System.out.println(rupeesToConvert + " Rupee Dollars is " + BigDecimal.valueOf(returnValue).setScale(2, RoundingMode.HALF_UP) + " in " + getName());
		return returnValue;
	}
	
	
}

/**
 * This will convert India rupees into Japanese yen
 * Note: The conversion rate changes each day so,
 * for the purposes of this exercise we'll use the rate
 * set on 2020-05-01 of 1.41
 * @author Student's name
 *
 */
class Yen extends Currency {

	public Yen(String name) {
		super(name);
	}

	@Override
	public Double convert(Double rupeesToConvert) {
		Double returnValue = (rupeesToConvert * 1.41);
		System.out.println(rupeesToConvert + " Rupee Dollars is " + BigDecimal.valueOf(returnValue).setScale(2, RoundingMode.HALF_UP) + " in " + getName());
		return returnValue;
	}
	
	
}
