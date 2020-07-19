package com.homework;

import java.util.Scanner;

class FoodTrack {
	
	private static int nbrOrders = 0;
	private static double grossOrderTotal = 0.0;
	private static double discountTotal = 0.0;
	private static double totalTaxes = 0.0;
	private static double netOrderTotal = 0.0;

	public static void main(String[] args)
	{
		while(true){

			FoodDiscount FD= new FoodDiscount(); //making object object of sub class and calling it's constructor
			Scanner input = new Scanner(System.in);
			System.out.println("Press y to continue or press any other key to exit");
			int user_input = input.next().charAt(0);
			if(user_input == 'y')
				continue;
			else
				break;

		}

		// Display running totals
		System.out.println("Total Number of Orders was: " + nbrOrders);
		System.out.println("Total Gross Sales " + grossOrderTotal);
		System.out.println("Total discounts given: " + discountTotal);
		System.out.println("Total Taxes collected: " + totalTaxes);
		System.out.println("Total Net Sales: " + netOrderTotal);

		//end of main()



	}
	
	// Start of instance objects
	
	Scanner input = new Scanner(System.in);

	//constant prices for menu items

	int num_menu = 5;
	final double[] menu = new double[num_menu];

	final double SALES_TAX = 0.06;
	int[] quantities = new int[num_menu]; //array for user input
	double[] subtotals = new double[num_menu]; //array for invidiual quantities * their menu prices
	double subtotal = 0; //accumulator of the subtotal array

	int i = 0;

	String[] selections = { //array for corresponding prompts of user input
			"Small Regular Pizza ---------- $",
			"Small Veggie pizza ----------- $",
			"Large Regular pizza----------- $",
			"Large Veggie Pizza-------------$",
	"Softdrink--------------------- $"};


	static double DiscountPercentage=0.0;
	static double Discountamount=0.0;



	FoodTrack(double Discount)



	{



		this.DiscountPercentage=Discount;// initializing discount percentage coming from subclass



		menu[0] = 8.99; // small regular Pizza
		menu[1] = 1.50; // small veggie pizza
		menu[2] = 12.90; // large regular pizza
		menu[3] = 2.50; // large veggie pizza
		menu[4] = 1.50; // softdrink

		greeting(); //Waiter/ress greeting & foodtruck/restuarant address


		for (i = 0; i < num_menu; i++)
		{

			//Prompts for user input and price calculations per menu item

			System.out.print(selections[i] + menu[i] + " each: ");
			quantities[i] = input.nextInt();
			subtotals[i] = quantities[i] * menu[i];

			subtotal += subtotals[i];
			System.out.println("Ok that'll be " + subtotals[i] + ".");
		}

		//Remaining charge calculations



		//System.out.println("Total before calculation:"+subtotal);



		Discountamount=Discount(subtotal);



		//System.out.println("Discountamount:"+Discountamount);



		Double TotalAfterDiscount=subtotal-Discountamount;



		double subtax = TotalAfterDiscount * SALES_TAX;











		double total_due = TotalAfterDiscount + subtax;







		System.out.println("Ok, your total including tax with applicable discount is $" + total_due);







		//Payment







		System.out.println("Sorry this register only accept cash at the time.");







		System.out.print("How much is being tendered? $");







		double tender = input.nextDouble();







		double amount = total_due - tender; // balance amount to be paid







		double paid = tender; // paid amount







		// this loop will take the amount until







		// the tendered amount is lesser than the total amount







		while (amount > 0)







		{







			if (paid < total_due)







			{







				System.out.println("Insufficient amount, pay $" + amount);







				tender = input.nextDouble(); // taking the balance amount







				amount = amount - tender; // balance amount







				paid = paid + tender; // paid amount







			}







			else break;







		}







		tender = paid; // total tendered amount







		double cash_back = tender - total_due;







		System.out.println("Ok, here's your cash back or how much you still owe: $" + (cash_back) + ".");







		System.out.println("Here's your receipt.\nThanks for your patronage.\nHave a great day!");







		// Display receipt







		receipt(quantities, selections, menu, subtotals, subtotal,Discountamount, subtax, total_due, tender, cash_back);







	}











	public static double Discount(double Total)



	{



		if(Total>50.0) // checking the total amount if it's greater than $50 then calculting discount and return



		{



			double discountV=DiscountPercentage/100.0;



			double DiscountAmount = Total *discountV;//calculating discount amount







			return DiscountAmount ;



		}



		else



		{



			return 0.0;



		}



	}











	public static void receipt(int[] qtts, String[] sltns, double[] mnu, double[] stts, double sttl,double Discountamount, double stx, double ttde, double tdr, double c_b)
	{


		System.out.println("");
		System.out.println("");
		System.out.println("------------------------------------------------------");
		System.out.println(" --------------------------------------------------------");

		System.out.println(" Simply Pizza");
		System.out.println(" 6500 Landover, Dodge park Md 20785");
		System.out.println(" 888-442-3312");
		System.out.println(" Fresh Out Of the Oven!");
		System.out.println(" A bite will make you want to Eat more!-");

		System.out.println("\nYour order was: ");

		int i = 0; //reinitialize the index variable as a local variable
		for (i = 0; i < mnu.length; i++)
		{
			System.out.println(qtts[i] + " " + sltns[i] + mnu[i] + " each $" + stts[i]);
		}

	
		// Accumulate the daily totals
		nbrOrders += 1;
		grossOrderTotal += sttl;
		discountTotal += Discountamount;
		totalTaxes += stx;
		netOrderTotal += ttde;

		// Existing code - no change required
		System.out.println("Subtotal = $" + sttl);
		System.out.println("Subtax = $" + stx);
		System.out.println("Discount Amount = $"+Discountamount);
		System.out.println("Total = $" + ttde);
		System.out.println("Tendered = $" + tdr);
		System.out.println("Cash back = $" + c_b);

	}



	public static void greeting()







	{







		//only text, no values inputted or outputted







		System.out.println("Welcome to Simply Pizza!");







		System.out.println("6500 Landover, Dodge park Md 20785");







		System.out.println("888-442-3312");







		System.out.println("Due to COVID 19 we only do Drive thru and carryout .");







		System.out.println("I'll give the rundown of what we have and you can let me know how much of those items you'd like: ");



		System.out.println("Simply pizza gives a 10% discount on orders over $50 (the total BEFORE tax)");







		System.out.println("Selection -- $XX.XX each __ (enter a quantity here)\n");







	}



}



class FoodDiscount extends FoodTrack



{



	// int Discount =10;



	FoodDiscount() //constructor of FoodDiscount class



	{



		super(10.0);//calling constructor of super class (FoodTrack)



	}



}
