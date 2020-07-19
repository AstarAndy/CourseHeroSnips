package com.homework;

/**
 * An Interface is simply a set of method signatures, but
 * not implementations.  Then ANY class can IMPLEMENT an interface.
 * When a class implements an interface, each method signature in the interface
 * must be implements.  Classes can, and often do, implement more than one interface
 * @author Student's name
 *
 */
public class InterfaceExamples {
	
	// Simple interface with 1 method
	static interface Interface1 {
		public void action1(int howFar);
	}
	
	/// Simple interface with 1 method
	static interface Interface2 {
		public void action2(String displayThisMessage);
	}
	
	/**
	 * This class implements Interface2
	 * @author Student's name
	 *
	 */
	static class ClassA implements Interface2 {
		@Override
		public void action2(String displayThisMessage) {
			System.out.println("Inside ClassA - Interface2 - action2 method.  Value to display is: " + displayThisMessage);	
		}
		
		/** 
		 * Since classes implement interfaces you can just 
		 * create an instance of the class and then call the method defined in the interface
		 */
		public void accessInterface1Method() {
			ClassB bValue = new ClassB();
			bValue.action1(200);
		}
	}
	
	// Another class that implements Interface1
	static class ClassB implements Interface1 {
		@Override
		public void action1(int someNumber) {
			System.out.println("We are in ClassA - Implemented Interface1-action1 method.  The number value is: " + someNumber);
		}
		public void accessInterface2Method() {
			ClassA aValue = new ClassA();
			aValue.action2("Accessed from ClassA instance");
		}
	}
	
	static class ClassAB implements Interface1, Interface2 {

		@Override
		public void action2(String displayThisMessage) {
			System.out.println("Inside ClassAB - Interface2 - action2 method.  Message to display is: " + displayThisMessage);
		}

		@Override
		public void action1(int howFar) {
			System.out.println("Inside ClassAB - Interface1 = action1 method.  Number is: " + howFar);	
		}
		
	}
	
	
	/**
	 * Used to test each class and interface
	 * @param args
	 */
	public static void main(String[] args) {
		ClassA aVal = new ClassA();
		aVal.action2("Class that implements Interface2");
		aVal.accessInterface1Method();
		
		ClassB bVal = new ClassB();
		bVal.action1(1);
		bVal.accessInterface2Method();
		
		ClassAB abVal = new ClassAB();
		abVal.action1(2);
		abVal.action2("Access to both interfaces");
		

	}

}
