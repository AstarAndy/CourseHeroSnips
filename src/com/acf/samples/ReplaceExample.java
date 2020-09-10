package com.acf.samples;

public class ReplaceExample {

	public static void main(String[] args) {
		
		System.out.println(replaceWithAsterisk(""));
		System.out.println(replaceWithAsterisk("hello"));
		System.out.println(replaceWithAsterisk("To*day!"));
		System.out.println(replaceWithAsterisk("Just a Sanity%$)$*   end"));

	}
	
	public static String replaceWithAsterisk(String pwIn) {
		if (pwIn == null) {
			return "";
		}
		
		return pwIn.replaceAll(".", "*");
		
	}

}
