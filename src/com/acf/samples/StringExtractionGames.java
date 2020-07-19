package com.acf.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringExtractionGames {

	public static void main(String[] args) {

        int indent = 20;

        String asterisks = "***";

        for (int i = 0; i < 5; i++) {

            String thisLine = String.format("%" + indent + "s", asterisks);

            System.out.println(thisLine);

            asterisks += "**";
            indent++;
            
            String cards[] = {"z", "a", "w", "c", "d", "u", "v"};
            List<String> newDesk = new ArrayList<>(Arrays.asList(cards));
            Collections.shuffle(newDesk);
            
            Map<String, List<String>> cardGame = new HashMap<>();
            int cardNo = 0;
            for (int playerNbr = 1; playerNbr < 10; playerNbr++) {
            	String playerName = "Somename";
            	List<String> playersHand = new ArrayList<>();
            	for (int a = 0; a < 6; a++) {
            		playersHand.add(newDesk.remove(0));
            	}
            	// Now add the hand delt to playerName to the cardGame
            	cardGame.put(playerName, playersHand);
            }
            
            // Now cardGame has some number of players with 5 cards.
            // Just adjust the counters used in the loop to change how
            // many players and how many hands each

        }


	}
	
	private List<String> getAllInputWords( String...args) {
		List<String> result = null;
		
		return result;
	}

}
