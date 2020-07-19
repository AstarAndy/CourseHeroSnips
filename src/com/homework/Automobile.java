package com.homework;

import java.time.LocalDate;

/**
 * Example Automobile class
 * @author Student Name
 *
 */
public class Automobile {
	
	private String make;
	private String model;
	private String style;
	private int year;
	private String color;
	private Double cost;
	private Double salesPrice;
	private LocalDate salesDate;
	private String soldBy;
	
	/**
	 * Default no-args consgtructor
	 */
	public Automobile() {
		
	}

	/**
	 * Public all-args constructor
	 * @param make
	 * @param model
	 * @param style
	 * @param year
	 * @param color
	 * @param cost
	 * @param salesPrice
	 * @param salesDate
	 * @param soldBy
	 */
	public Automobile(String make, String model, String style, int year, String color, Double cost, Double salesPrice,
			LocalDate salesDate, String soldBy) {
		super();
		this.make = make;
		this.model = model;
		this.style = style;
		this.year = year;
		this.color = color;
		this.cost = cost;
		this.salesPrice = salesPrice;
		this.salesDate = salesDate;
		this.soldBy = soldBy;
	}

	@Override
	public String toString() {
		return "Automobile [make=" + make + ", model=" + model + ", style=" + style + ", year=" + year + ", color="
				+ color + ", cost=" + cost + ", salesPrice=" + salesPrice + ", salesDate=" + salesDate + ", soldBy="
				+ soldBy + "]";
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public LocalDate getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(LocalDate salesDate) {
		this.salesDate = salesDate;
	}

	public String getSoldBy() {
		return soldBy;
	}

	public void setSoldBy(String soldBy) {
		this.soldBy = soldBy;
	}
		

}
