package com.homework;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SavedBankAccount {
	   // Constants
	   private static final int ACCOUNT_BALANCE_MENU_ITEM = 1;
	   private static final int DEPOSIT_AMOUNT_MENU_ITEM = 2;
	   private static final int WITHDRAW_AMOUNT_MENU_ITEM = 3;
	   private static final int EXIT_MENU_ITEM = 4;
	   // Instance variables
	   private String accountName;
	   private int accountNum;
	   private double accountBalance;
	   // Constructor
	   SavedBankAccount () {
	       accountName = "";
	       accountNum = 0;
	       accountBalance = 0;
	   }
	   // Constructor
	   SavedBankAccount (String accountName, int accountNum, double accountBalance) {
	       this.accountName = accountName;
	       this.accountNum = accountNum;
	       this.accountBalance = accountBalance;
	   }
	   // Method to get bank account from customer file; will initialize bank account if customer file does not exist
	   private static SavedBankAccount getBankAccount (String customerName, String customerFileName) {
	       SavedBankAccount ba = null;
	       try {
	           
	    	   // Java 8 beauty..
	    	   List<String> content = Files.readAllLines(Paths.get(customerFileName));
	    	   
	    	   // If the list is empty or null then we'll assume the file was not there
	    	   if (content.isEmpty()) {
	    		   throw new Exception();
	    	   }
	    	   
	    	   // Populate the SavedBankAccount object
	    	   ba = new SavedBankAccount(content.get(0), Integer.parseInt(content.get(1)), Double.parseDouble(content.get(2)));
	    	   
	       } catch (Exception ex) {
	           ba = new SavedBankAccount(customerName, 0, 0.0);
	       }
	       return ba;
	   }
	   // Method to save bank account to customer file
	   private static void saveBankAccount (String customerFileName, SavedBankAccount ba) {
	       try {
	    	   
	    	   // More java 8 beauty ...
	    	   Charset utf8 = StandardCharsets.UTF_8;
	    	   List<String> newContent = Arrays.asList(ba.accountName, Integer.toString(ba.accountNum), Double.toString(ba.accountBalance));
	    	   Files.write(Paths.get(customerFileName), newContent, utf8);
	        
	       } catch (Exception ex) {
	           System.out.format("Could not write to file %s ", customerFileName);      
	       }
	   }
	   // Method to print the menu, prompt the user for a selection, and retrieve and return the selection
	   private int menu () {
	       int userSelection;
	       // Output menu options
	       System.out.format("\nMenu:\n");
	       System.out.format("1. Check Balance\n");
	       System.out.format("2. Deposit Amount\n");
	       System.out.format("3. Withdraw Amount\n");
	       System.out.format("4. Exit\n");
	       // Prompt the user for a selection
	       System.out.format("Please make a selection: ");      
	       // Create a scanner oject to accept input from the keyboard
	       Scanner s = new Scanner(System.in);
	       // Accept user input
	       userSelection = s.nextInt();
	       return (userSelection);
	   }
	   // Method to output account balance
	   private void accountBalance () {
	       System.out.format("\nAccount information:\n");   
	       System.out.format("Account for: %s\n", accountName);
	       System.out.format("Account #: %d\n", accountNum);
	       System.out.format("Balance: $%.2f\n", accountBalance);
	   }
	   // Method to deposit into account
	   private void deposit () {
	       // Prompt the user for a selection
	       System.out.format("\nEnter the amount you want to deposit: ");      
	       // Create a scanner oject to accept input from the keyboard
	       Scanner s = new Scanner(System.in);
	       // Accept user input
	       double depositAmount = s.nextDouble();
	       // Verify user selection
	       if (depositAmount <= 0)
	       {
	           System.out.format("ERROR: Invalid deposit amount\n");
	       } else {
	           // Update the account balance
	           System.out.format("Depositing $%.2f to Account # %d\n", depositAmount, accountNum);      
	           accountBalance += depositAmount;
	           System.out.format("Your new account balance is now $%.2f\n", accountBalance);      
	       }
	   }
	   // Method to withdraw from account
	   private void withdraw () {
	       // Prompt the user for a selection
	       System.out.format("\nEnter the amount you want to withdraw: ");      
	       // Create a scanner oject to accept input from the keyboard
	       Scanner s = new Scanner(System.in);
	       // Accept user input
	       double withdrawAmount = s.nextDouble();
	       // Verify user selection
	       if (withdrawAmount <= 0)
	       {
	           System.out.format("ERROR: Invalid withdrawal amount\n");
	       } else if (withdrawAmount > accountBalance) {
	           System.out.format("ERROR: Withdrawal amount exceeds account balance ($%.2f)\n", accountBalance);
	       } else {
	           // Update the account balance
	           System.out.format("Withdrawing $%.2f from Account # %d\n", withdrawAmount, accountNum);      
	           accountBalance -= withdrawAmount;
	           System.out.format("Your new account balance is now $%.2f\n", accountBalance);      
	       }
	   }
	   // Main
	   public static void main(String[] args) {
	       SavedBankAccount ba;
	       String customerName = null;
	       String customerFileName = null;
	       // Confirm an customer name was provided as a command line argument
	       if (args.length < 1) {
	           System.out.format("ERROR: Customer name not provided\n");
	           System.exit(0);
	       }
	       // Set the customer name from the command line argument
	       customerName = args[0];
	       // Build the customer file name
	       customerFileName = "./" + customerName + ".dat";
	       // Load the bank account from the customer file, if it exists;
	       // If it doesn't exist, create a new bank account
	       ba = getBankAccount (customerName, customerFileName);
	       // Output the current balance
	       ba.accountBalance();
	       // Process the SavedBankAccount object according to user selections
	       boolean run = true;
	       while (run)
	       {
	           // Get the menu selection for the SavedBankAccount object
	           int menuSelection = ba.menu();
	           // Process the menu selection
	           if (menuSelection == ACCOUNT_BALANCE_MENU_ITEM) {
	               ba.accountBalance();
	           } else if (menuSelection == DEPOSIT_AMOUNT_MENU_ITEM) {
	               ba.deposit();
	           } else if (menuSelection == WITHDRAW_AMOUNT_MENU_ITEM) {
	               ba.withdraw();
	           } else if (menuSelection == EXIT_MENU_ITEM) {
	               run = false;
	           } else {
	               System.out.format("ERROR: Invalid choice. Please try again\n");
	           }
	       }
	       // Save the bank account data to the customer file
	       saveBankAccount (customerFileName, ba);
	   }
	}
