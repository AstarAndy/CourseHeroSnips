package com.homework;

import java.util.*;
// Import FileNotFoundException class to handle error
import java.io.*;
import java.util.Scanner; // Imports Scanner class to read the text files
import javax.swing.*; // the functionality provided by the swing.
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * WARNING:
 * 		The following import does NOT work with standard JDK 8 and Eclipse.
 * 		Take the comment off the following line in YOUR java editor as it
 * 		is listed as an input in your assignment directions
 */
//import import ou.*;

public class SalesTracker {

	static class Designer implements Comparable<Designer>

	{

		private int id;// Designer's id
		private static int nextId = 0;// Designer's next ID 
		private String name;// Designer's name
		private int years;// Determines bonus; range 1-6
		private String productCode;// The product code of the designer's product
		private int sales;// Total sales of product in 000s in last 6 months
		private int bonus;// Total bonus in WSE shares  

		/**

		 * Constructor for objects of class designer

		 */

		public Designer(String aName)

		{

			super();
			
			// Increment the next id number and use that for this designer's ID
			
			id = ++nextId;

			name = aName;

		}



		/**

		 * returns sales of the designer's product in the last 6 months

		 */

		public int getSales()

		{

			return this.sales;

		}



		/**

		 * sets sales for the designer's product to aSales

		 */

		public void setSales(int aSales)

		{

			this.sales = aSales;

		}



		/**

		 * returns the designer's ID

		 */

		public int getId()

		{

			return this.id;

		}



		/**

		 * returns the designer's name

		 */

		public String getName()

		{

			return this.name;

		}



		/**

		 * returns the number of years the designer has worked for the company

		 */

		public int getYears()

		{

			return this.years;

		}



		/**

		 * sets the number of years the designer has worked for the company, years,

		 * to aYears.

		 */

		public void setYears(int aYears)

		{

			this.years = aYears;  

		}



		/**

		 * returns the productCode

		 */

		public String getProductCode()

		{

			return this.productCode;

		}



		/**

		 *

		 * sets the productName to aProductName

		 */

		public void setProductCode(String aProductName)

		{

			this.productCode = aProductName;

		}



		/**

		 * returns the bonus

		 */

		public int getBonus()

		{

			return this.bonus;

		}



		/**

		 * sets the bonus to aBonus

		 */

		public void setBonus(int aBonus)

		{

			this.bonus = aBonus;

		}

		@Override
		public String toString() {
			String template = "%s (Years:%d,ID:%d)Prod:%s Sales:%d Bonus:%d";
			return String.format(template, name, years, id, productCode, sales, bonus);
		}



		@Override
		public int compareTo(Designer o) {
			// TODO Auto-generated method stub
			if (bonus == o.bonus) {
				return 0;
			}
			
			return (bonus < o.bonus ? -1 : 1);
			
		}
		
		

	}

	// end of class declaration Designer






	/*
	 * Begin instance of Sales Designer definitions
	 */
	public List<Designer> lstdesigner = new ArrayList<>();

	public static void main(String[] args)

	{  
		SalesTracker tracker = new SalesTracker();

		tracker.readDesignerData(); //function is called with no parameter and return type
		tracker.showBonusData();
		tracker.writeDataToFile();

	}


	private void readDesignerData()

	{

		JFileChooser chooser = new JFileChooser(); //chooser function

		String filename=null;

		FileNameExtensionFilter filter = new FileNameExtensionFilter("text files", "txt"); //only choose text file

		chooser.setFileFilter(filter);

		int returnVal = chooser.showOpenDialog(null);

		if(returnVal == JFileChooser.APPROVE_OPTION)

		{

			filename = chooser.getSelectedFile().getName(); //get selected file name

			if(!filename.equals("designerData.txt"))

			{

				System.out.println("Wrong filename selected"); //gives error if wrong file is selected

				return;

			}

		}

		Scanner myReader = null;

		try

		{

			File myObj = new File(filename);
			myReader = new Scanner(myObj); //initialized scanner object

			while (myReader.hasNextLine())

			{

				String data = myReader.nextLine();

				String[] tokensVal = data.split(","); //splited comma seperated string

				Designer designer = new Designer(tokensVal[0]); //passed first token as a paramter

				/* initialized all setter method&*/

				designer.setYears(Integer.parseInt(tokensVal[1]));

				designer.setProductCode(tokensVal[2]);

				designer.setSales(Integer.parseInt(tokensVal[3]));

				designer.setBonus(computeBonus(designer));; //bonus is calculated

				lstdesigner.add(designer); // finally added to list

			}

			

		} catch (FileNotFoundException e) {

			System.out.println("An error occurred."); //exception is handled

			e.printStackTrace();

		} finally {
			myReader.close(); //file is closed
		}

	}
	
	private int computeBonus(Designer aDesigner) {
		return ( (aDesigner.getYears() * aDesigner.getSales()) / 10);		
	}
	
	public void showBonusData() {
		lstdesigner.forEach(System.out::println);
		System.out.println("\n Ordered by bonus");
		Collections.sort(lstdesigner);
		lstdesigner.forEach(System.out::println);		
	}
	
	private void writeDataToFile() {
		String outputFileName = "./designerDataOutput.txt";
		
		BufferedWriter writer = null;
				
		try {
			writer = new BufferedWriter(new FileWriter(outputFileName));
			for (Designer thisDesigner: lstdesigner) {
				writer.write(thisDesigner.toString() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}



}