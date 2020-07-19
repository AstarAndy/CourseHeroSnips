package com.homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PayrollTaxCalculator {
	
	// Holds the data from the data file
	

	public static void main(String[] args) {
		// See if they passed in a filename to process
		String fileName = "PayrollData.csv";
		if (args.length > 0) {
			fileName = args[0];
		}
		
		PayrollTaxCalculator ptc = new PayrollTaxCalculator();
		ptc.execute(fileName);

	}
	
	/**
	 * Main method of the program
	 * @param fileName
	 */
	public void execute(String fileName) {
		
		// Ok, first, load the file
		Stream<String> dataLines = loadPayrollData(fileName);
		// If we get a null return then exit 
		if (dataLines == null) {
			return;
		}
		
		// Next Load a list of initialized employees
		
		List<Associate> assocList = loadAssociates(dataLines);
		
		// Next compute all required taxes
		computeTaxes(assocList);
		
		// Finally, Print out the report and exit
		
		displayAssociateData(assocList);
		
		
		return;
		
	}
	
	
	/**
	 * We'll load the contents of the file into a
	 * stream of strings.  If we have any IO problems we'll 
	 * return an empty stream which will signal the caller
	 * that there is not data to process or we were unable
	 * to read the file
	 * @param fileName
	 * @return Stream of Strings wich each entry is a line in the file
	 */
	public Stream<String> loadPayrollData(String fileName) {
		
		try {
			return Files.lines(Paths.get(fileName));
		} catch (IOException e) {
			System.err.println("Unable to find or read file '" + fileName + "'");
		}
		
		// If we're here then we had an error.
		
		return null;
		
	}
	
	/**
	 * This will create a list of initialized employees with 
	 * an id and a taxable income value
	 * @param empData
	 */
	public List<Associate> loadAssociates(Stream<String> empData) {
		return empData
				.map(thisLine -> {
					return new Associate(thisLine);
				})
				.collect(Collectors.toList());
	}
	
	/**
	 * This method will compute the base tax plus
	 * assign an additional tax rate and amount as needed
	 * 
	 * This could have been done in the Employee constructor
	 * however the logic for the tax brackets should be in the main class
	 * @param empList
	 */
	public void computeTaxes(List<Associate> empList) {
		
		empList
			.forEach(thisEmp -> {
				// Simple decision tree to compute based on total income
				// The while statement to help keep the conditional block 
				// singular
				
				while (true) {
					// First, 75k or better
					if (thisEmp.getTaxableIncome() > 75000.00) {
						thisEmp.setBaseTaxAmt(28000.00);
						double bracketTaxAmt = ((thisEmp.getTaxableIncome() - 75000.00) * 0.75);
						thisEmp.setBracketTaxAmt(bracketTaxAmt);
						break;
					}
					
					// Next, 50k or better
					if (thisEmp.getTaxableIncome() > 50000.00) {
						thisEmp.setBaseTaxAmt(15500.00);
						double bracketTaxAmt = ((thisEmp.getTaxableIncome() - 50000.00) * 0.50);
						thisEmp.setBracketTaxAmt(bracketTaxAmt);
						break;
					}
					
					// Next, 30k or better
					if (thisEmp.getTaxableIncome() > 30000.00) {
						thisEmp.setBaseTaxAmt(7500.00);
						double bracketTaxAmt = ((thisEmp.getTaxableIncome() - 30000.00) * 0.40);
						thisEmp.setBracketTaxAmt(bracketTaxAmt);
						break;
					}

					// Next, 15k or better
					if (thisEmp.getTaxableIncome() > 15000.00) {
						thisEmp.setBaseTaxAmt(3000.00);
						double bracketTaxAmt = ((thisEmp.getTaxableIncome() - 15000.00) * 0.30);
						thisEmp.setBracketTaxAmt(bracketTaxAmt);
						break;
					}
					
					// This is the default for 20%
					double taxAmt = (thisEmp.getTaxableIncome() * 0.20);
					thisEmp.setBaseTaxAmt(taxAmt);
					thisEmp.setBracketTaxAmt(0.00);
					break;
					
				}


			});
		
	}
	
	// display the computed associate base pay taxes and such
	public void displayAssociateData(List<Associate> assocList) {
		String header = "%-6s %-15s %-15s";
		String body = "%-6s %13.2f %13.2f"; 
		
		System.out.println(String.format(header, "ID", "Taxable Income", "Taxes due"));
		System.out.println("-------------------------------------------------------");
		assocList.forEach(thisAssoc -> {
			System.out.println(String.format(body, thisAssoc.getId(), thisAssoc.getTaxableIncome(), thisAssoc.getTotalTax())
			);
		});
		System.out.println("-------------------------------------------------------");
		
		// Now compute the total pay and total taxes due
		
		Double totalPay = assocList
							.stream()
							.mapToDouble(Associate::getTaxableIncome)
							.sum();
		Double totalTax = assocList
				.stream()
				.mapToDouble(Associate::getTotalTax)
				.sum();
		
		System.out.println(String.format(body, "Total", totalPay, totalTax));
		

	}
	

}


class Associate {
	int id;
	double taxableIncome = 0.00;
	double baseTaxAmt = 0.00;
	double bracketTaxAmt = 0.00;
	public Associate(String inputData) {
		String fieldData[] = inputData.split(",");
		id = Integer.parseInt(fieldData[0]);
		taxableIncome = Double.parseDouble(fieldData[1]);
	}
	public double getBaseTaxAmt() {
		return baseTaxAmt;
	}
	public void setBaseTaxAmt(double baseTaxAmt) {
		this.baseTaxAmt = baseTaxAmt;
	}
	public double getBracketTaxAmt() {
		return bracketTaxAmt;
	}
	public void setBracketTaxAmt(double bracketTaxAmt) {
		this.bracketTaxAmt = bracketTaxAmt;
	}
	public int getId() {
		return id;
	}
	public double getTaxableIncome() {
		return taxableIncome;
	}
	public double getTotalTax() {
		return (baseTaxAmt + bracketTaxAmt);
	}
	@Override
	public String toString() {
		return "Associate [id=" + id + ", taxableIncome=" + taxableIncome + ", baseTaxAmt=" + baseTaxAmt
				+ ", bracketTaxAmt=" + bracketTaxAmt + ", totalTax=" + getTotalTax() + "]";
	}
	
	
}
