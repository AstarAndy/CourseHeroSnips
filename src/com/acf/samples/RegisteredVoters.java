package com.acf.samples;

import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Keeps a list of the registered voters for any given street address
 * @author student's name
 *
 */
public class RegisteredVoters {
	
	// The map of voters per street number
	// ordered by the street number and the names
	// will also be ordered alphabetically 
	
	public static SortedMap<Integer, SortedSet<String>> voterMap = new TreeMap<>();

	/**
	 * Main entry point to test with
	 * @param args
	 */
	public static void main(String[] args) {

		SortedSet<String> namesList = new TreeSet<>();
		namesList.add("Tom Jones");
		namesList.add("Andrew King");
		namesList.add("Jane Ann");
		voterMap.put(5, namesList);
		
		namesList = new TreeSet<>();
		namesList.add("Steve Adams");
		namesList.add("Charlie Williams");
		namesList.add("Bill Williams");
		voterMap.put(1, namesList);
		
		// Now display everything and it 
		// all be in proper order
		
		voterMap.forEach((key, value) -> System.out.println("Street#: " + key + " - voters: " + value));
	
	}

}
