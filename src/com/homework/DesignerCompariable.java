package com.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DesignerCompariable implements Comparable<DesignerCompariable>
{
	private int id;      // designer's id
	private String name; // designer's name
	private int years;   // Determines bonus; range 1-6
	private String productCode;  //The product code of the designer's product
	private int sales;   // total sales of product  in 000s in last 6 months
	private int bonus;     // total bonus in WSE shares
	private static int nextId = 0; // ai

	/**
	 * Constructor for objects of class designer
	 */
	public DesignerCompariable(String aName)
	{
		super();
		//aii
		this.name = aName;
		nextId++;
		this.id = nextId;
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
		return "Designer [id=" + id + ", name=" + name + ", years=" + years + ", productCode=" + productCode
				+ ", sales=" + sales + ", bonus=" + bonus + "]";
	}


	/**
	 * This is used so we can naturally sort Designer
	 * objects, from lowest to highest, in Collection
	 * objects that use natural ordering
	 * @param o The Designer object to compare with
	 * @return -1 means bonus is < , 1 means highter, and 0 means equal to
	 */
	@Override
	public int compareTo(DesignerCompariable o) {
		if (bonus < o.bonus) {
			return -1;
		}
		
		if (bonus > o.bonus) {
			return 1;
		}
		return 0;
	}
	
	public static void main(String...args) {
		List<DesignerCompariable> myDesigners = new ArrayList<>();
		
		DesignerCompariable aDesign = new DesignerCompariable("400 person");
		aDesign.setBonus(400);
		aDesign.setSales(400);
		myDesigners.add(aDesign);
		
		aDesign = new DesignerCompariable("300 person");
		aDesign.setBonus(300);
		aDesign.setSales(300);
		myDesigners.add(aDesign);

		aDesign = new DesignerCompariable("200 person");
		aDesign.setBonus(200);
		aDesign.setSales(200);
		myDesigners.add(aDesign);

		aDesign = new DesignerCompariable("100 person");
		aDesign.setBonus(100);
		aDesign.setSales(100);
		myDesigners.add(aDesign);
		
		System.out.println(myDesigners.toString());
		
		Collections.sort(myDesigners);
		System.out.println("=== Now sorted by bonus ===");
		System.out.println(myDesigners.toString());
		
		Collections.sort(myDesigners, Comparator.comparingInt(DesignerCompariable::getBonus));

	}
}

