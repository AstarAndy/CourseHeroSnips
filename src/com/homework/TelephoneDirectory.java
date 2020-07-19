package com.homework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TelephoneDirectory {

	private Map<Person, String> phoneBook = new HashMap<>();
	
	public List<String> getListOfPhoneNumbers(String firstName) {
		return phoneBook
				.keySet()
				.stream()
				.filter(thisPerson -> {
					return (thisPerson.getFirstName().startsWith(firstName) ? true : false);
				})
				.map(thisPerson -> phoneBook.get(thisPerson))
				.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		TelephoneDirectory td = new TelephoneDirectory();
		Person aPerson = new Person("William", "James");
		td.phoneBook.put(aPerson, "123456789");
		aPerson = new Person("James", "Smith");
		td.phoneBook.put(aPerson, "2345678901");
		aPerson = new Person("Rindy", "Adams");
		td.phoneBook.put(aPerson, "3456789012");
		aPerson = new Person("Randy", "Harrison");
		td.phoneBook.put(aPerson, "4567891234");
		
		List<String> numbersStartWithZA = td.getListOfPhoneNumbers("Za");
		System.out.println("List of all number's whose first name start with Za");
		System.out.println(numbersStartWithZA.toString());
		
		List<String> numbersStartWithR = td.getListOfPhoneNumbers("R");
		System.out.println("List of all number's whose first name start with R");
		System.out.println(numbersStartWithR.toString());
		
		// Now let's build-out the reverse directory
		
		ReverseDirectory rd = new ReverseDirectory(td.phoneBook);
		
		// First a negative look-up
		Optional<Person> thisPerson = Optional.ofNullable(rd.getPerson("9999999999"));
		System.out.println("\n\nThe person with phone number 9999999999 is " + thisPerson.orElse(new Person("Not in ", "Directory")).toString());
		
		// Now a good lookup
		thisPerson = Optional.ofNullable(rd.getPerson("4567891234"));
		System.out.println("The person with phone number 4567891234 is " + thisPerson.orElse(new Person("Not in ", "Directory")).toString());
			
		
	}

}

class Person {
	private String firstName;
	private String lastName;
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}

class ReverseDirectory {
	private Map<String, Person> phoneBook = new HashMap<>();

	public ReverseDirectory(Map<Person, String> personBook) {
		super();
		personBook
			.forEach((thisPerson, thisPhone) -> {
				phoneBook.put(thisPhone, thisPerson);
			});
	}
	public Person getPerson(String telephoneNumber) {
		return phoneBook.get(telephoneNumber);
	}
	
}
