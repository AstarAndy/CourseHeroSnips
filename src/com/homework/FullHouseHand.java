package com.homework;

import java.util.HashMap;
import java.util.Map;

public class FullHouseHand {

	public static void main(String[] args) {
		String cards[] = new String[] {"A", "A", "K", "K", "A"};
		fullHouseCheck(cards);
	}
	
	private static void fullHouseCheck(String...cards) {
		Map<String, Integer> hand = new HashMap<>();
		Integer thisCount = null;
		// Count the instances of each card
		for (int a = 0; a < cards.length; a++) {
			thisCount = hand.get(cards[a]);
			if (thisCount == null) {
				hand.put(cards[a], Integer.valueOf(1));
			} else {
				thisCount += 1;
				hand.replace(cards[a], thisCount);
			}
		}
		
		// Now, see if we have a combination of 3 or 2
		
		StringBuffer threeOfAKind = new StringBuffer();
		StringBuffer twoOfAKind = new StringBuffer();
		hand.forEach( (letter, count) -> {
			if (count.equals(3)) {
				threeOfAKind.append("3 of a kind: " + letter);
			}
			if (count.equals(2)) {
				twoOfAKind.append("2 of a kind: " + letter);
			}
		});
		
		// Gotta have both a 3-of-a-kind AND a 2-of-a-kind or we have no full house
		if (threeOfAKind.length() == 0 || twoOfAKind.length() == 0) {
			System.out.println("Not a full house");
			return;
		}
		
		System.out.println(threeOfAKind.toString());
		System.out.println(twoOfAKind.toString());
		
		return;
		
	}

}
