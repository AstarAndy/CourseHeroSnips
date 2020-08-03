package com.homework;

public class ParentChildSuperMethodUsage {
	
	private static class Car {
		public void printData() {
			System.out.println("Class is Car and method is printData");
		}
	}
	
	private static class Toyota extends Car {
		public void printData() {
			// First call the parent's metod
			super.printData();
			// Now this class method
			System.out.println("Class is Toyota and method is printData");			
		}
	}

	public static void main(String[] args) {
		Toyota toy = new Toyota();
		toy.printData();
	}

}
