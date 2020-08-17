package com.homework;

import java.util.HashSet;
import java.util.Set;

/**
 * This simple class illustrates the use of interfaces
 * @author Student's name
 *
 */
public class Vehicel implements Loan, Insurance {
	
	// This will be used to help validate the vehicleType value
	private static Set<String> vTypesList = new HashSet<String>() {{
		add("2 wheeler");
		add("3 wheeler");
		add("4 wheeler");
	}};
	
	private String vehicleNumber;
    private String modelName;
    private String vehicleType; // Only "4 wheeler" or "3 wheeler" or "2 wheeler".
    private double price;
    
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Vehicel(String vehicleNumber, String modelName, String vehicleType, double price) throws Exception {
		super();
		this.vehicleNumber = vehicleNumber;
		this.modelName = modelName;
		this.vehicleType = vehicleType;
		this.price = price;
		if (!vTypesList.contains(vehicleType)) {
			throw new Exception("VehicleNumber" + vehicleNumber + " does not have a valid vehicle type.  Type: " + vehicleType + " is not valid");
		}
	}

	@Override
	public double takeInsurance() {
//		If the vehicle price is less than or equal to 150000 insurance amount is 3500.
//	      If the vehicle price is greater than 150000 and less than or equal to 300000 insurance amount is 4000.
//	      If the vehicle price is greater than 300000 insurance amount is 5000.
		if (price >= 300000.0) {
			return 5000.0;
		}
		
		if (price >= 150000.0) {
			return 4000.0;
		}
		
		return 3500.0;
	}

	@Override
	public double issueLoan() {
		
		double loanAmt = 0.0;
		switch (vehicleType) {
		case "4 wheeler":
			loanAmt = price * 0.80;
			break;
		case "3 wheeler":
			loanAmt = price * 0.75;
			break;
		default :
			loanAmt = price * 0.50;
		}
		return loanAmt;
	}
	
	
	
	@Override
	public String toString() {
		return "Vehicel [vehicleNumber=" + vehicleNumber + ", modelName=" + modelName + ", vehicleType=" + vehicleType
				+ ", price=" + price + ", takeInsurance()=" + takeInsurance() + ", issueLoan()=" + issueLoan() + "]";
	}


	/**
	 * Method to test-out the various wheeler types and price points
	 * @param args None
	 */
	public static void main(String[] args) {
		
		try {
			// 4 wheeler price level high
			Vehicel aVehicel = new Vehicel("12345", "4Runner", "4 wheeler", 420000.0);
			System.out.println("4 Wheeler type: " + aVehicel.toString());
			
			// 3 wheeler price level middle
			aVehicel = new Vehicel("54321", "Harley", "3 wheeler", 155000.0);			// 3 wheeler price level middle			
			System.out.println("3 Wheeler type: " + aVehicel.toString());
			
			// 2 wheeler price level low
			aVehicel = new Vehicel("98765", "Chopper", "2 wheeler", 40000.0);
			System.out.println("2 Wheeler type: " + aVehicel.toString());
			
			// Now this one should produce an error - Not a valid vehicel type
			aVehicel = new Vehicel("1000099", "UniCycle", "1 wheeler", 100.0);
			System.out.println("2 Wheeler type: " + aVehicel.toString());
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
}

interface Loan {
	double issueLoan();
}

interface Insurance {
	double takeInsurance();
}

