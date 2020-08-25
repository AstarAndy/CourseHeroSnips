package com.homework.swing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

public class JOptionPaneSamples {

	private void computeInsuranceCosts() {
		
		String enteredValue = JOptionPane.showInputDialog("Enter your age to compute the costs of the insuurance");
		
		try {
			if (enteredValue.isEmpty()) {
				enteredValue = "0";
			}
			int actualAge = Integer.parseInt(enteredValue);
			Double insAmt = null;
			if (actualAge <= 50) {
				insAmt = (actualAge * 2.5);
			} else {
				insAmt = (actualAge * 10.0);
			}
			JOptionPane.showMessageDialog(null, String.format("For age %d, your insurance cost is %.2f", actualAge, insAmt));
		} catch (NumberFormatException e) {
			JOptionPane
				.showMessageDialog(null, 
						String.format("The value you entered, %s , is not a number.  Can't compute costs", enteredValue), 
						"Not a valid age", 
						JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void computeLowestValue() {
		String enteredValue = JOptionPane.showInputDialog("Please enter 3 numbers separated by a comma");
		if (enteredValue.isEmpty()) {
			enteredValue = "0,0,0";
		}
		
		String[] values = enteredValue.split(",");
		
		try {
			List<Integer> numbersList = new ArrayList<>();
			Arrays.asList(values)
				.forEach(thisVal -> numbersList.add(Integer.parseInt(thisVal)));
			Integer min =
					numbersList
					.stream()
					.min(Comparator.comparing(Integer::intValue))
					.orElse(0);
			JOptionPane.showMessageDialog(null, String.format("The smallest number you entered out of the set %s was: %d", numbersList,min));			
		} catch (Exception e) {
			JOptionPane
			.showMessageDialog(null, 
					String.format("One, or more of, the values you entered, %s , is not a number.  Can't compute smallest number", Arrays.asList(values)), 
					"Not valid numbers", 
					JOptionPane.ERROR_MESSAGE);
			
		}
		
		
		
	}
	
	public static void main(String[] args) {
		JOptionPaneSamples jops = new JOptionPaneSamples();
		jops.computeInsuranceCosts();
		jops.computeLowestValue();
	}

}
