package com.homework;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class will 
 * 	1.  Continuously ask for an employee name, hourly rate, and hours worked until
 * 		quit is entered into the name field then.
 * 	2.	For each employee it will compute gross wages, taxes withheld, and net wages
 * 	3.	Print everything to the console
 *  
 * @author Student's Name
 *
 */
public class Payroll {

	private static final String STUDENT_ID = "YOUR ID here";
	private static final String STUDENT_NAME = "YOUR NAME here";
	
	// This will hold the list of the employees entered
	List<Employee> empList = new ArrayList<>();
	
	// This is just a global data input object
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Payroll pr = new Payroll();
		pr.execute();
	}
	
	/**
	 * This is the main part of the program.  It will
	 * 1. Collected the input for each employee
	 * 2. When done, print-out each employee 
	 * 3. Print totals.
	 */
	public void execute() {
		gatherEmployeeData();
		displayReportSummary();
		
	}
	
	/**
	 * Collect employee data from the end-user until
	 * they enter a blank name or Q for name
	 */
	public void gatherEmployeeData() {
		
		Employee newEmp = null;
		String empName = null;
		Double hourlyRate = 0.00;
		Double hoursWorked = 0.0;
		
		System.out.println("Hello " + STUDENT_NAME + " (" + STUDENT_ID + ")");
		System.out.println("Thank you for using the sytem.  Let's get started.");
		System.out.println("Start entering employee names, hourly rates, and hours worked.");
		
		do {
			
			// Get the employee data
			System.out.print("\nEnter the employee's name or Q to quit: ");
			empName = sc.nextLine();
			
			// If they don't enter anything we'll take that as a Q
			if (empName == null || empName.isEmpty() || empName.equalsIgnoreCase("Q")) {
				break;
			}
			
			// Now get the hourly rate and hours worked.  Any bad inputs
			// will be treated just like a zero was entered
			
			try {
				System.out.print("What is " + empName + "'s hourly rate: ");
				hourlyRate = sc.nextDouble();
			} catch (Exception e) {
				System.out.println("Not a valid numeric entry so using zero");
				hourlyRate = 0.0;
			}
			
			try {
				System.out.print("And how many hours did " + empName + " work: ");
				hoursWorked = sc.nextDouble();
			} catch (Exception e) {
				System.out.println("Not a valid numeric entry so using zero");
				hoursWorked = 0.0;
			}
			
			// Now make a new employee, add it to the list and do it again
			
			newEmp = new Employee(empName, hourlyRate, hoursWorked);
			empList.add(newEmp);

			// Finally, clear the inputter for the next loop
			sc.nextLine();
			
		} while (true);
		
		return;
		
	}
	
	/**
	 * Now just print out the list of data along with the totals
	 * 
	 */
	public void displayReportSummary() {
		System.out.println("***************************************************************");
		System.out.println("Thanks again for using the system.");
		System.out.println(STUDENT_NAME + " ID: " + STUDENT_ID);
		
		System.out.println("Here's a list of all the employee data entered and calculated\n");
				
		empList.forEach(System.out::println);
		 
		Double hoursWorked = empList
								.stream()
								.mapToDouble(thisEmp -> {
									return thisEmp.getHoursWorked().doubleValue();
								})
								.sum();

		Double grossPay = empList
				.stream()
				.mapToDouble(thisEmp -> {
					return thisEmp.getGrossPay().doubleValue();
				})
				.sum();

		Double taxWithheld = empList
				.stream()
				.mapToDouble(thisEmp -> {
					return thisEmp.getTaxesWithheld().doubleValue();
				})
				.sum();
		
		Double netPay = empList
				.stream()
				.mapToDouble(thisEmp -> {
					return thisEmp.getNetPay().doubleValue();
				})
				.sum();

		System.out.println("Total Hours Worked is: " + hoursWorked);
		System.out.println("Total Gross Pay is: " + grossPay);
		System.out.println("Tax Withheld is: " + taxWithheld);
		System.out.println("Net pay is: " + netPay);
		System.out.println("***************************************************************");
		
	}

}

/**
 * This class holds an employee.  It will store the name and associated
 * payroll information.  also, there are only get methods for the fields
 * as the constructor must be used to set the values and do the computations
 * @author Student's name
 *
 */
class Employee {
	private String name;
	private BigDecimal hourlyRate = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_UP);
	private BigDecimal hoursWorked = new BigDecimal(0.0).setScale(0, RoundingMode.FLOOR);
	private BigDecimal grossPay = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_UP);
	private Double taxRate = 0.10;
	private BigDecimal taxesWithheld = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_UP);
	private BigDecimal netPay = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_UP);
	/**
	 * @param hourlyRate
	 * @param hoursWorked
	 */
	public Employee(String empName, Double hourlyRate, Double hoursWorked) {
		super();
		this.name = empName;
		this.hourlyRate = BigDecimal.valueOf(hourlyRate).setScale(2, RoundingMode.HALF_UP);
		this.hoursWorked = BigDecimal.valueOf(hoursWorked).setScale(2, RoundingMode.HALF_UP);
		// Now compute gross pay
		grossPay = this.hourlyRate.multiply(this.hoursWorked).setScale(2, RoundingMode.HALF_UP);
		// Now compute the taxes
		// Use a while to simplify the conditional if logic

		while (true) {
			if (grossPay.doubleValue() > 800.00) {
				taxRate = 0.18;
				break;
			}
			if (grossPay.doubleValue() > 500.00) {
				taxRate = 0.16;
				break;
			}
			if (grossPay.doubleValue() > 300.00) {
				taxRate = 0.13;
				break;
			}
			
			// Just do 10% and get out
			
			break;
						
		}
		
		taxesWithheld = grossPay.multiply(BigDecimal.valueOf(taxRate).setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
		
		// Finally, compute net pay
		
		netPay = grossPay.subtract(taxesWithheld).setScale(2, RoundingMode.HALF_UP);
		
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", hourlyRate=" + hourlyRate + ", hoursWorked=" + hoursWorked + ", grossPay="
				+ grossPay + ", taxRate=" + taxRate + ", taxesWithheld=" + taxesWithheld + ", netPay=" + netPay + "]";
	}

	public String getName() {
		return name;
	}
	public BigDecimal getHourlyRate() {
		return hourlyRate;
	}
	public BigDecimal getHoursWorked() {
		return hoursWorked;
	}
	public BigDecimal getTaxesWithheld() {
		return taxesWithheld;
	}
	public BigDecimal getGrossPay() {
		return grossPay;
	}
	public BigDecimal getNetPay() {
		return netPay;
	}
	
}
