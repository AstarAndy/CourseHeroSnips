package com.homework;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Formattable;
import java.util.Formatter;

public class FormattableBankAccount implements Formattable {
	
	private double balance = 0.00;

	@Override
	public void formatTo(Formatter formatter, int flags, int width, int precision) {
		Appendable appender = formatter.out();
		
		// First convert the balance to a string.  It is ASSUMED balance is a valid double value.
		
		String strBalance = Double.toString(balance);
		
		// First, just print the balance with a format that pads the balance to a specific width
		
		try {
			appender.append(String.format("%12s", strBalance));
			
			// For the extra credit use a BigDecimal object to set the precision and the toString 
			// to output to the appender
			
			BigDecimal bd = new BigDecimal(strBalance, new MathContext(precision));
			
			appender.append(bd.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	

}
