package com.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RhinoCensus {

	class Rhino {
		String name;
		Integer age;
		Rhino(String theName, Integer itsAge) {
			name = theName;
			age = itsAge;
		}
		
		public String getName() {
			return name;
		}
		public Integer getAge() {
			return age;
		}

		@Override
		public String toString() {
			return "Rhino [name=" + name + ", age=" + age + "]";
		}
		
	}
	
	private Scanner keyInputter = new Scanner(System.in);
	private Map<Integer, List<Rhino>> rhinoPopulation = new HashMap<>();	

	public static void main(String...args) {

		RhinoCensus tc = new RhinoCensus();
		
		tc.startConversation();
		tc.displayPopulationStats();
				
	}

	/**
	 * This method captures, validates, and stores all the required 
	 * input from the end-user.
	 */
	private void startConversation() {
		
		// Control counts
		Integer nbrHerds = 0;
		Integer population = 0;
		String tempEntry;

		// First get the number of herds to manage:
		
		while (nbrHerds < 1) {
			tempEntry = getInputValue("How many herds to you want to manage?  Your entry must be greater than 0: ");
			try {
				nbrHerds = Integer.parseInt(tempEntry);
				if (nbrHerds < 1) {
					throw new Exception("Value must be greater than 0");
				}
			} catch (Exception e) {
				// This means they entered an invalid value (non numeric, or < 1)
				System.out.println("Your entry: " + tempEntry + " must be a number and greater then 0.  Please try again");
				nbrHerds = 0;
			}
		}
		
		// Now they have to enter a number of animals in EACH herd then a name & age for each
		
		// This loop controls how many herds we have to collect data for
		// Note, for end-user readability, we are starting herd number 1 and not 0
		for (int herdNbr = 1; herdNbr <= nbrHerds; herdNbr++) {
			population = -1;
			while (population < 0) {
				tempEntry = getInputValue(String.format("How many Rhinos are in herd number %d?  Your entry must be greater than -1: ", herdNbr));
				try {
					population = Integer.parseInt(tempEntry);
				} catch (Exception e) {
					// This means they entered an invalid value (non numeric, or < 1)
					System.out.println("Your entry: " + tempEntry + " must be a number and greater then -1.  Please try again");
					population = -1;
				}
				
				// Now we have to add the list of animals in herd# herdNbr to our total population map
				List<Rhino> thisHerd = new ArrayList<>();
				rhinoPopulation.put(herdNbr, thisHerd);
				
				
				// Now we do an inner loop, ask for, and store, the name & age of the animal
				String fmtTemplate1 = "For herd number %d, enter a rhino's name: ";
				String fmtTemplate2 = "How old is %s (must be greater than 0: ";
				String rhinoName = "";
				Integer rhinoAge = 0;	
				Rhino thisRhino = null;
				
				for (int popNbr = 1; popNbr <= population; popNbr++) {
					rhinoName = "";
					rhinoAge = 0;
							
					while (rhinoAge < 1) {
						try {
							rhinoName = getInputValue(String.format(fmtTemplate1, popNbr));
							// Must have a name
							if (rhinoName.isEmpty()) {
								throw new Exception("Rhino's name cannot be blank.  Please enter a non-blank name: ");
							}
							// Now get the age of the animal
							tempEntry = getInputValue(String.format(fmtTemplate2, rhinoName));
							rhinoAge = Integer.parseInt(tempEntry);
							if (rhinoAge < 1) {
								throw new Exception("Rhino's age must be greater than 0.  Please try again.");
							}
							
							// At this point we have an animal's name and ago so create a Rhino and add it to the list for this population
							thisRhino = new Rhino(rhinoName, rhinoAge);
							thisHerd.add(thisRhino);
						} catch (Exception e) {
							// This means they entered an invalid value (non numeric, or < 1)
							System.out.println(e.getMessage());
							rhinoAge = 0;
						}
					}					
				}
				
			}
			
		}
		
		keyInputter.close();
		return;
	}
	
	
	/**
	 * Use this to prompt for input and return the entered
	 * value as a String.  This will only query for the input and
	 * the caller is responsible for any input validation
	 * @param promptValue A string value to prompt the user as to what to enter
	 * @return String the value entered.
	 */
	private String getInputValue(String promptValue) {
		System.out.print(promptValue + ": ");
		return keyInputter.nextLine();
		
	}
	
	/**
	 * This method will accumulate various stats about the Rhino
	 * population and display the results to the console.
	 */
	private void displayPopulationStats() {
		
		// First produce a report of the youngest, oldest, and average herd age for each herd
		// key = the herd number
		// value = the List of Rhinos in
		// Also each list will be built out holding the youngest and olders of each herd 
		// and will be used to compute population oldest and youngest
		
		List<Rhino> allRhinos = new ArrayList<>();
		Rhino popYoungest = new Rhino("", 9999);
		Rhino popOldest = new Rhino("", 0);

		
		rhinoPopulation.forEach((key, value) -> {
			// If a herd is empty we can just skip it
			Rhino youngest = new Rhino("", 9999);
			Rhino oldest = new Rhino("", 0);
			if (!value.isEmpty()) {
				
				/*
				 * 	Old school way - look past these comments to see full streaming
				 
				value.forEach(thisRhino -> {
					if (thisRhino.age < youngest.age) {
						youngest.name = thisRhino.name;
						youngest.age  = thisRhino.age;
					}
					if (thisRhino.age > oldest.age) {
						oldest.name = thisRhino.name;
						oldest.age  = thisRhino.age;
					}
					// Now check for the overall oldest and youngest
					if (thisRhino.age < popYoungest.age) {
						popYoungest.name = thisRhino.name;
						popYoungest.age  = thisRhino.age;
					}
					if (thisRhino.age > popOldest.age) {
						popOldest.name = thisRhino.name;
						popOldest.age  = thisRhino.age;
					}
				
					// Add this guy to the global pop.  This will be used later to average
					// the overall age
					allRhinos.add(thisRhino);
			
				});
				*/
				
				// Full Streaming way
				
				// First add this herd to the total population
				allRhinos.add((Rhino)value);
				
				// Now get the youngest one of the herd				
				youngest = value
							.stream()
							.min(Comparator.comparing(Rhino::getAge))
							.orElse(new Rhino("", 0));
							
				// Now the oldest of the herd				
				oldest = value
							.stream()
							.max(Comparator.comparing(Rhino::getAge))
							.orElse(new Rhino("", 0));
			}
						
			// We will now get the average for this herd
			
			Double herdAverage = value
				.stream()
					.mapToInt(Rhino::getAge)
					.average()
					.orElse(new Double(0.0));
			
			/*
			 * We now have the oldest, the youngest, and the average age
			 * for herd number so we'll print that out
			 */
			
			System.out.println("Statistics for herd# " + key);
			System.out.println("\tYoungest: " + youngest.name + "is " + youngest.age + " years old");
			System.out.println("\tOldest: " + oldest.name + "is " + oldest.age + " years old");
			System.out.println("\tAverage Herd Age is: " + herdAverage.toString());			
			
		});

		// Ok, now dump-out the statistics for the entire population but			
		// first get the average for total population
		
		Double popAverage = allRhinos
			.stream().mapToInt(Rhino::getAge)
				.average()
				.orElse(new Double(0.0));
		
		// Ok print all statistics
		
		System.out.println("\n\nTotal Population Statistics");
		System.out.println("\tYoungest: " + popYoungest.name + "is " + popYoungest.age + " years old");
		System.out.println("\tOldest: " + popOldest.name + "is " + popOldest.age + " years old");
		System.out.println("\tAverage Herd Age is: " + popAverage.toString());
		
	}

}
