package com.homework;

import java.util.Random;
import java.util.function.Predicate;

/**
 * Assignment class
 * @author student
 *
 */
public class BankAccountTest {
		
	// Now the main testing method for BankAccountTest
	
	public static void main(String... args) {
		BankAccount mary = new BankAccount(100001, "Mary Bloggs", 500.0);
		BankAccount joe = new BankAccount(100002, "Joe Spot", 1000.00);
		
		System.out.println("Balance is " + mary.getBalance());
		
		System.out.println("******************");
		joe.print();
		System.out.println("******************");
		System.out.println("******************");

		joe.deposit(500.0);
		joe.print();
		System.out.println("******************");
		System.out.println("******************");

		mary.print();
		System.out.println("******************");

		mary.withdraw(600.0);
		mary.withdraw(400.00);
		System.out.println("******************");

		mary.setName("Mary Bloggs-Spot");
		mary.print();
		System.out.println("******************");	
		
		
	}

}

class BankAccount {
	private static final Random rndNbr = new Random();
	
	private int accountId;
	private String name;
	private double balance;
	
	/**
	 * Default no args constructor
	 */
	public BankAccount() {
		accountId = rndNbr.nextInt(Integer.MAX_VALUE);
		name = "Unassigned";
		balance = 0.0;
	}
	
	public BankAccount(int accountNbr, String name, double balance) {
		this.accountId = accountNbr;
		this.name = name;
		this.balance = balance;
	}

	public double deposit(double amtToAdd) {
		balance +=amtToAdd;
		return balance;
	}
	
	public double withdraw(double amtToWithdraw) {
		if (balance - amtToWithdraw < 0.0) {
			System.out.println("Insufficient funds");
		} else {
			balance -= amtToWithdraw;
		}
		
		return balance;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}
	
	public void print() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nbalance " + balance + "\nAccount Id: " + accountId;
	}	
	
} // end of BankAccount internal class
