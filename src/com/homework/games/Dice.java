package com.homework.games;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * This game will roll 2 dice values and then
 * @author Student's name
 *
 */
public class Dice {
	
	private int nbrSides = 6;
	private int nbrDice = 2;
	private Random rand = new Random();
	
	/**
	 * Default constructor
	 */
	public Dice() {
		;
	}
	/**
	 * This can be used to change how many sides the dice have and 
	 * also how many dice.  The default is 2, 6 sided dice
	 * @param sides
	 * @param dice
	 */
	public Dice(int sides, int dice) {
		nbrSides = sides;
		nbrDice = dice;
	}
	
	public List<Integer> rollDice() {
		List<Integer> result = new ArrayList<>(nbrSides * nbrDice);
		
		IntStream.range(1, (nbrDice + 1))
		.forEach(outerInt -> {
			result.add(rand.nextInt(nbrSides) + 1);
		});
		
		return result;
			
	}
	
	public boolean isNaturalSet(List<Integer> listToCheck) {
		Long howMany = listToCheck
						.stream()
						.distinct()
						.count();
		return (howMany == 1 ? true : false);
	}

	public static void main(String[] args) {
		Dice dg = new Dice(6, 2);
		IntStream
			.range(1, 101)
			.forEach(thisVal -> {
				System.out.println("Values for try# " + thisVal + " are " + dg.rollDice());
			});		
	}	

}
