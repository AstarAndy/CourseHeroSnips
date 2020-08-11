package com.coursehero.challange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MorseCodeGuesser {

	/*
	 * This test will use all letters of the alphabet
	 * that can be represented by 1, 2, or 3 morse
	 * code signals.  When any of the 3 signals are 
	 * ? then we'll spin thru and check if that could be a . or a _
	 * and, if yes, we'll GUESS it could be that character
	 */
	
	// A map of dots n dashes for 3 character letters.  3 signal letters ONLY, NOT all letters
	
	private static final Map<String, String> signalMap = new HashMap<String, String>() {{
		put(".-", "A");
		put("-..", "D");
		put(".", "E");
		put("--.", "G");
		put("..", "I");
		put("-.-", "K");
		put("--", "M");	 	
		put("-.", "N");
		put("---", "O");
		put(".-.", "R");
		put("...", "S");
		put("-", "T"); 
		put("..-", "U");
		put(".--", "W");
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
        List<String> possibleLetters = new ArrayList<>();
        
        // First if signals is null or empty then just get out
        if (signals == null || signals.isEmpty()) {
        	return possibleLetters;
        }
        
        // Next, just see if there is an exact match.
        // If yes just return it
        if (signalMap.containsKey(signals)) {
        	possibleLetters.add(signalMap.get(signals));
        	return possibleLetters;
        }
        
        // Now see if we have any wildcard ? chars.  If not just get out
        // as we have a no valid signal sequence
        if (!signals.contains("?")) {
        	return possibleLetters;
        }
        
        /*
         * If we are here then we have 1, or more question marks
         * so let's do some replacement and see if we can find
         * any possible matches
         * 
         */
        
        String char1 = "";
        String char2 = "";
        String char3 = "";
        
        switch (signals.length()) {
        case 1:
            // Replace ? with . and look for a hit
            String tryAllDots = signals.replace("?", ".");
            if (signalMap.containsKey(tryAllDots)) {
            	possibleLetters.add(signalMap.get(tryAllDots));
            }
            
            // Now replace all ? with - and look for a hit
            String tryAllDashes = signals.replace("?", "-");
            if (signalMap.containsKey(tryAllDashes)) {
            	possibleLetters.add(signalMap.get(tryAllDashes));
            }        	
        	break;
        case 2:
            char1 = signals.substring(0, 1);
            char2 = signals.substring(1, 2);
            if (char1.equals("?") && char2.equals("?")) {
            	String comboToTry = "..";
                if (signalMap.containsKey(comboToTry)) {
                	possibleLetters.add(signalMap.get(comboToTry));
                }        	
            	comboToTry = ".-";
                if (signalMap.containsKey(comboToTry)) {
                	possibleLetters.add(signalMap.get(comboToTry));
                }        	
            	comboToTry = "--";
                if (signalMap.containsKey(comboToTry)) {
                	possibleLetters.add(signalMap.get(comboToTry));
                }        	
            	comboToTry = "-.";
                if (signalMap.containsKey(comboToTry)) {
                	possibleLetters.add(signalMap.get(comboToTry));
                }        	
            } else 
            if (char1.equals("?")) {
            	String comboToTry = "." + char2;
                if (signalMap.containsKey(comboToTry)) {
                	possibleLetters.add(signalMap.get(comboToTry));
                }        	
            	comboToTry = "-" + char2;
                if (signalMap.containsKey(comboToTry)) {
                	possibleLetters.add(signalMap.get(comboToTry));
                }        	
            } else
                if (char2.equals("?")) {
                	String comboToTry = char1 + ".";
                    if (signalMap.containsKey(comboToTry)) {
                    	possibleLetters.add(signalMap.get(comboToTry));
                    }        	
                	comboToTry = char1 + "-";
                    if (signalMap.containsKey(comboToTry)) {
                    	possibleLetters.add(signalMap.get(comboToTry));
                    }        	
                }
                	
            	
        	break;
        case 3:
            // Pull-out each of the 3 characters
        	char1 = signals.substring(0, 1);
            char2 = signals.substring(1, 2);
            char3 = signals.substring(2, 3);
            
            /*
             * Create 1 list for each char pos and either put
             * the char in there if it is not a ? or put a
             * - AND A .
             */
            List<String> firstChars = new ArrayList<>();
            List<String> secondChars = new ArrayList<>();
            List<String> thirdChars = new ArrayList<>();
            if (char1.equals("?")) {
            	firstChars.add("-");
            	firstChars.add(".");
            } else {
            	firstChars.add(char1);
            	firstChars.add("");
            }
            if (char2.equals("?")) {
            	secondChars.add("-");
            	secondChars.add(".");
            } else {
            	secondChars.add(char2);
            	secondChars.add("");
            }
            if (char3.equals("?")) {
            	thirdChars.add("-");
            	thirdChars.add(".");
            } else {
            	thirdChars.add(char3);
            	thirdChars.add("");
            }
            
            // Now put the combinations together
            List<String> sigsToTry = new ArrayList<>();
            String fullSigValue = "";
            for (int a = 0; a < 2; a++) {
                fullSigValue = firstChars.get(a) + secondChars.get(a) + thirdChars.get(a);
                if (!fullSigValue.isEmpty()) {
                    sigsToTry.add(fullSigValue);                	
                }
            }
            
            System.out.println(String.format("Trying the following combinations for %s, %s, %s : %s", char1, char2, char3, sigsToTry));

            // At this point all the combos to lookup should be
            // in the sigsToTry list so look-up those values
            
            sigsToTry.forEach(thisSignal -> {
                if (signalMap.containsKey(thisSignal)) {
                	possibleLetters.add(signalMap.get(thisSignal));
                }        	            	
            });
            
        }
        
        return possibleLetters;
        
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
			.forEach(thisKey -> wordsFound.add(thisKey));
		
		return wordsFound;
	}
	
	
	public static void main(String[] args) {
		List<String> charsTranslated = possibilities(".");
		System.out.println("Characters found for . where: " + charsTranslated);
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
		System.out.println("Characters found for ..? where: " + charsTranslated);

	}

}
