package com.homework;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Assignment1 {

	/**
	 * Main entry point for Assignment1 program
	 * @param args No runtime arguments
	 */
	public static void main(String[] args) throws IOException {
		
		// First, declare an array of 5 cars
		Car cars[] = new Car[5];
		
		// Next call the setup method to create each of the cars in the array
		setupCars(cars);
		
		// Now build the output file
		writeCarDetailsToFile(cars);
		
		// Now, print-out the fuel status before we start moving the cars
		System.out.println("Cars as start of simulation");
		printCars(cars);
		
		// Now start driving the cars until one of them
		// runs out of gas
		
		int milesTraveled = 0;
		boolean fuelRemaining = true;
		Car whichCarIsEmpty = null;
		
		while (fuelRemaining) {
			milesTraveled++;
			for (int i = 0; i < cars.length; i++) {
				cars[i].updateFuel(milesTraveled);
				if (cars[i].getFuelGuage().getGallons() == 0) {
					whichCarIsEmpty = cars[i];
					fuelRemaining = false;
					break;
				}
			}
		}
		
		// Now print the fuel status after running the cars
		System.out.println("\nCars as end of simulation");
		printCars(cars);

		// Finally, who ran out of gas
		System.out.println(whichCarIsEmpty.getOwner() + " ran out of gas after " + milesTraveled + " miles traveled.");		

	}
	
	/**
	 * Using the data provided in the assignment, create the 5
	 * cars and initialize them based on the data provided
	 * Important: Arrays in java start at 0 NOT 1.
	 * @param cars
	 */
	public static void setupCars(Car[] cars) {
		
		// Remember arrays in java start at 0 not 1
		Car newCar = new Car("Shrek", "Toyota Tundra", 15.0, 6);
		cars[0] = newCar;
		
		// We don't have to declare newCar as a Car anymore but we can reuse the variable
		newCar = new Car("Fiona", "Audi Q7", 21.0, 10);
		cars[1] = newCar;

		newCar = new Car("Donkey", "Jeep CJ5", 14.0, 5);
		cars[2] = newCar;

		newCar = new Car("Farquaad", "Smart Car", 42.0, 4);
		cars[3] = newCar;
		
		// last one
		newCar = new Car("Dragon", "Chevy Subarban", 12.0, 30);
		cars[4] = newCar;

		// In java methods don't require a return when the 
		// return type is void but we'll do it anyway
		
		return;
		
	}
	
	/**
	 * This will display a fuel status for each car
	 * @param cars
	 */
	public static void printCars(Car[] cars) {
		
		String header = "%-20s %-20s %-15s %-15s";
		String body = "%-20s %-20s %10.2f %20.2f"; 
	
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(String.format(header, "Owner", "Brand", "Fuel Economy", "Current Gallons"));
		System.out.println("---------------------------------------------------------------------------");
		for (int i = 0; i < cars.length; i++) {
			System.out.println(
				String.format(body,
				cars[i].getOwner(),
				cars[i].getBrand(),
				cars[i].getFuelEconomy(),
				cars[i].getFuelGuage().getGallons()
			));
		}
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("\n");
		

	}
	
	/**
	 * This will output all our file objects to an Assignment1 file
	 * @param cars array of 5 cars
	 * @throws IOException
	 */
	public static void writeCarDetailsToFile(Car[] cars) throws IOException {
		// The File object is a pointer to a new file in the current directory
		File fileName = new File("Assigment1");
		// The PrintWriter class allows for simple file output
		PrintWriter resultsFile = new PrintWriter(fileName);
		
		// Loop thru the array
		for (int i = 0; i < cars.length; i++) {
			resultsFile.println(cars[i].getOwner());
			resultsFile.println(cars[i].getBrand());
			resultsFile.println(cars[i].getFuelEconomy());
			resultsFile.println(cars[i].getFuelGuage().getGallons());
			resultsFile.println();
		}
		
		// All opened files should be closed
		resultsFile.close();
		
	}

} // end of Assignment1 class


class Car {
	
	private String owner;
	private String brand;
	private double fuelEconomy;
	private FuelGuage fuelGuage;
	
	/**
	 * Constructor - Use this to create a new Car
	 * @param owner
	 * @param brand
	 * @param fuelEconomy
	 * @param gallons
	 */
	public Car(String owner, String brand, double fuelEconomy, double gallons) {
		super();
		this.owner = owner;
		this.brand = brand;
		this.fuelEconomy = fuelEconomy;
		this.fuelGuage = new FuelGuage();
		this.fuelGuage.setGallons(gallons);
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getFuelEconomy() {
		return fuelEconomy;
	}
	public void setFuelEconomy(double fuelEconomy) {
		this.fuelEconomy = fuelEconomy;
	}
	public FuelGuage getFuelGuage() {
		return fuelGuage;
	}
	public void setFuelGuage(FuelGuage fuelGuage) {
		this.fuelGuage = fuelGuage;
	}
	
	public void updateFuel(double milesTraveled) {
		double gallonsUsed = (milesTraveled / fuelEconomy);
		fuelGuage.decermentGallons(gallonsUsed);
	}
	
	
}

class FuelGuage {
	private double gallons;

	public double getGallons() {
		return gallons;
	}

	public void setGallons(double gallons) {
		this.gallons = gallons;
	}
	
	public void decermentGallons(double gallonsUsed) {
		if (gallonsUsed <= gallons) {
			gallons = gallons - gallonsUsed;
		} else {
			gallons = 0;
		}
	}
}
