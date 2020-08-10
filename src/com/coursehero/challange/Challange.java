package com.coursehero.challange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Challange {
	public static Integer countChange( Integer money, List<Integer> coins ) {
		return recursiveCount(coins, (coins.size() - 1), money);
	}

	// Function to find the total number of distinct ways to get
	// change of money from unlimited supply of coins in List<Integer> coins
	public static int recursiveCount(List<Integer> coins, int n, int money)
	{
		// if total is 0, return 1 (solution found)
		if (money == 0) {
			return 1;
		}

		// return 0 (solution do not exist) if total become negative or
		// no elements are left
		if (money < 0 || n < 0) {
			return 0;
		}

		// Case 1. include current coin coins.get(n) in solution and recur
		// with remaining change (coins - coins.get(n)) with same number of coins
		int incl = recursiveCount(coins, n, money - coins.get(n));

		// Case 2. exclude current coin coins.get(n) from solution and recur
		// for remaining coins (n - 1)
		int excl = recursiveCount(coins, n - 1, money);

		// return total ways by including or excluding current coin
		return incl + excl;
	}

	public static void main(String...args) {
		
		String template = "How many ways to get change for %d from %s coins is %d";

		List<Integer> coins = new ArrayList<>();
		Collections.addAll(coins, 1, 2);
		Integer money = 4;
		Integer howManyWays = countChange(money, coins);
		System.out.println(template.format(template, money, coins, howManyWays));

		// Change for 10
		money = 10;
		coins.clear();
		Collections.addAll(coins, 5, 2, 3);
		howManyWays = countChange(money, coins);

		System.out.println(template.format(template, money, coins, howManyWays));

		// Total Change for 0
		money = 0;
		coins.clear();
		Collections.addAll(coins, 5, 2, 3);
		howManyWays = countChange(money, coins);
		System.out.println(template.format(template, money, coins, howManyWays));
		
		// Total Change for 79
		money = 79;
		coins.clear();
		Collections.addAll(coins, 2, 6, 1, 3, 7);
		howManyWays = countChange(money, coins);
		System.out.println(template.format(template, money, coins, howManyWays));
		
		
	}
}

