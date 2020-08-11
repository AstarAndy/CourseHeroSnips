package com.coursehero.challange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorseCodeGuesser {

	/*
	 * This test will use all letters of the alphabet
	 * that can be represented by 1, 2, or 3 morse
	 * code signals.  When any of the 3 signals are 
	 * ? then we'll spin thru and check if that could be a . or a _
	 * and, if yes, we'll GUESS it could be that character
	 */
	
	// A map of dots n dashes for 3 character letters.  3 signal letters ONLY, NOT all letters
	// To be able to leverage the string match method and use regx for pattern matching.
	// We can't actually have a . in the search string as that is actually a wildcard for
	// regx so we'll use an x instead of a . in the map.
	
	private static final Map<String, String> signalMap = new HashMap<String, String>() {{
		put("x-", "A");
		put("-xx", "D");
		put("x", "E");
		put("--x", "G");
		put("xx", "I");
		put("-x-", "K");
		put("--", "M");	 	
		put("-x", "N");
		put("---", "O");
		put("x-x", "R");
		put("xxx", "S");
		put("-", "T"); 
		put("xx-", "U");
		put("x--", "W");
	}};
	
	/**
	 * Takes a string of consisting of the dot/dash sequence for
	 * a single letter, and then attempts to return either the 
	 * exact letter or a guess based on any parts of the signal that
	 * are a ?
	 * @param signals String such as ".", "?.", or "?."
	 * @return
	 */
	public static List<String> possibilities(String signals) {    
        
        // First if signals is null or empty then just get out
        if (signals == null || signals.isEmpty()) {
        	return Collections.EMPTY_LIST;
        }
        
        /*
         * We're going to use the match method with a regx string.
         * Since a . is a reserved character, actually the wildcard
         * character for regx, we'll replace each . with an x and then
         * each ? with a regx .
         */
        
        String regx = signals.replace(".", "x");
        regx = regx.replace("?",  ".");
        
        // Now just go and lookup the letters
        
        //System.out.println("\nThis is the pattern match we want: " + regx);
        return lookupWords(signals.length(), regx);
        
    }
	
	/**
	 * Takes a regx string and attempts to find all the keys that
	 * both have the proper length and also the proper pattern match
	 * @param nbrSignals The numer of bytes the complete signal is.  Could
	 * be 1, 2, or 3
	 * @param patternString Regx patter to find all including the wildcard ?
	 * 
	 * @return List(String) - All letters that match, if any
	 * 
	 */
	private static List<String> lookupWords(int nbrSignals, String patternString) {
//		Map<Integer, String> collect = map.entrySet().stream()
//				.filter(x -> x.getKey() == 3)
//				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		List<String> wordsFound = new ArrayList<>();
			signalMap
			.keySet()
			.stream()
			.filter(thisEntry -> {
				return (thisEntry.length() == nbrSignals && thisEntry.matches(patternString));
			})
			.forEach(thisKey -> wordsFound.add(signalMap.get(thisKey)));

		//System.out.println("This this is what we got back: " + wordsFound);
	        
		return wordsFound;
	}
	
	
	public static void main(String[] args) {
		List<String> charsTranslated = possibilities(".");
		System.out.println("Characters found for . where: " + charsTranslated);
		
		charsTranslated = possibilities("-");
		System.out.println("Characters found for - where: " + charsTranslated);

		charsTranslated = possibilities(".-");
		System.out.println("Characters found for .- where: " + charsTranslated);
		
		charsTranslated = possibilities("?");
		System.out.println("\nCharacters found for ? where: " + charsTranslated);
		
		charsTranslated = possibilities(".?");
		System.out.println("Characters found for .? where: " + charsTranslated);
		charsTranslated = possibilities("?.");
		System.out.println("Characters found for ?. where: " + charsTranslated);

		charsTranslated = possibilities("???");
		System.out.println("Characters found for ??? where: " + charsTranslated);

		charsTranslated = possibilities("..?");
		System.out.println("Characters found for ... where: " + charsTranslated);

		charsTranslated = possibilities("?..");
		System.out.println("Characters found for ..? where: " + charsTranslated);
		
		charsTranslated = possibilities(".?.");
		System.out.println("Characters found for .?. where: " + charsTranslated);

	}

}
