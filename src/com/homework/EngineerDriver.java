package com.homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Will maintain a list of up to 10 engineers
 * @author Student's name
 *
 */
public class EngineerDriver {
	
	private Engineer engineers[] = new Engineer[10];
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		EngineerDriver ed = new EngineerDriver();
		ed.startUp();

	}
	/**
	 * Main program loop
	 */
	public void startUp() {
		
		int opt = -1;
		
		while (opt != 5) {
			opt = selectOption();
			sc.nextLine();
			switch (opt) {
			case 1:
				addEngineer();
				break;
			case 2:
				System.out.println("Engineer List\n\n" + toString());
				break;
			case 3:
			case 4:
				updateEngineer(opt);
				break;
			case 5:
				break;
			default:
				System.out.println("You must enrter a value between 1 and 5.");
			}
		}
		
		return;
		
	}
	
	/**
	 * Display menu and return an option
	 * @return
	 */
	public int selectOption() {
		
		String menu = "\n***WELCOME***\n" +
						"*Choose an option*\n" +
						"1 Add one Engineer\n" +
	 					"2 View all Engineers\n" +
	 					"3 Modify Engineer\n" +
	 					"4 Delete Engineer\n" +
	 					"5 Exit ";
		System.out.print(menu);
		
		try {
			return sc.nextInt();
		} catch (Exception e) {
			return 11;
		}
		
	}
	
	/**
	 * Used to add one engineer
	 */
	public void addEngineer() {

		int nextSlot = findNextSlot();
		if (nextSlot == 11) {
			System.out.println("You cannot add any additional engineers at this time.");
			return;
		}
		
		System.out.print("Please enter the engineer's name: ");
		String name = sc.nextLine();
		if (name == null || name.isEmpty()) {
			return;
		}
		
		Meter meters[] = new Meter[2];
		VoltMeter vm = new VoltMeter(5);
		FlowMeter fm = new FlowMeter(2.3);
		meters[0] = vm;
		meters[1] = fm;
		Engineer newEng = new Engineer(name, meters);
		engineers[(nextSlot - 1)] = newEng;
		
		
	}
	
	/**
	 * This will look for a null spot in the engineer's array and return
	 * that number
	 * @return int The slot number in the array that is available (ie null)
	 * 
	 */
	public int findNextSlot() {
		int result = 11;
		for (int a = 0; a < engineers.length; a++) {
			if (engineers[a] == null) {
				result = (a + 1);
				break;
			}
		}
		return result;
	}
	
	/**
	 * This will update an engineer's name on option 3 or
	 * delete that engineer IF the name search is successful
	 * @param opt int 3 if update or 4 if delete
	 * @return true if updated (or deleted) or false
	 */
	public boolean updateEngineer(int opt) {
		
		String prompt = (opt == 3 ? "modify" : "delete");
		
		
		System.out.print("Enter engineer's name to " + prompt + ": ");
		String whichName = sc.nextLine();
		if (whichName == null || whichName.isEmpty()) {
			return false;
		}
		
		// Now find the engineer without case
		
		boolean updatedEngineer = false;
		
		for (int a = 0; a < engineers.length; a++) {
			if (engineers[a] != null && engineers[a].getName().equalsIgnoreCase(whichName)) {
				if (opt == 3) {
					System.out.print("Please enter an updated name: ");
					String newName = sc.nextLine();
					engineers[a].setName(newName);
				} else {
					engineers[a] = null;
				}
				updatedEngineer = true;
				break;
			}
		}
		
		if (!updatedEngineer) {
			System.out.println("There is no engineer on file with the name: " + whichName);
		}
		
		return updatedEngineer;
		
	}

	@Override
	public String toString() {
		return "EngineerDriver [engineers=" + Arrays.toString(engineers) + "]";
	}
	
	

}

/**
 * Primary engineer class to hold name and meters
 * @author Student's name
 *
 */
class Engineer {
	private static int nextId = 0;
	int id;
	String name;
	Meter meters[] = new Meter[2];
	public Engineer(String name, Meter[] meters) {
		super();
		id = ++nextId;
		this.name = name;
		this.meters = meters;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public Meter[] getMeters() {
		return meters;
	}
	@Override
	public String toString() {
		return "Engineer [id=" + id + ", name=" + name + ", meters=" + Arrays.toString(meters) + "]";
	}
	
}

/**
 * Base meter class
 * @author Student's name
 *
 */
class Meter {

	public Meter() {
		super();
	}
	
}

/**
 * Flow Meter 
 * @author Student's name
 *
 */
class FlowMeter extends Meter {
	private double flowAmount;

	public FlowMeter(double flowAmount) {
		super();
		this.flowAmount = flowAmount;
	}

	public double getFlowAmount() {
		return flowAmount;
	}

	public void setFlowAmount(double flowAmount) {
		this.flowAmount = flowAmount;
	}

	@Override
	public String toString() {
		return "FlowMeter [flowAmount=" + flowAmount + "]";
	}
	
}

/**
 * Volt Meter
 * @author Student's name
 *
 */
class VoltMeter extends Meter {
	private int voltage;

	public VoltMeter(int voltage) {
		super();
		this.voltage = voltage;
	}

	public int getVoltage() {
		return voltage;
	}

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	@Override
	public String toString() {
		return "VoltMeter [voltage=" + voltage + "]";
	}
	
}
