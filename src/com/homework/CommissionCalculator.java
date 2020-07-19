package com.homework;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CommissionCalculator {
	

    private static final NumberFormat nf = new DecimalFormat("$#.00");    

	public static final int APPRENTICE = 1;
	public static final int JUNIOR = 2;
	public static final int SENIOR = 3;
	
	private String salesPersonName = "";
	private BigDecimal monthlySales = BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP);
	private Integer yearsOfService = 0;
	private Integer rank = APPRENTICE;
	
	public CommissionCalculator(String salesPersonName, BigDecimal monthlySales, Integer yearsOfService, Integer rank) {
		super();
		this.salesPersonName = salesPersonName;
		this.monthlySales = monthlySales;
		this.yearsOfService = yearsOfService;
		this.rank = rank;
	}
	

	@Override
	public String toString() {
		
		return "\n\tCommissionCalculator \n\t[salesPersonName=" + salesPersonName + 
					"\n\tmonthlySales=" + nf.format(monthlySales) + 
					"\n\tyearsOfService=" + yearsOfService + 
					"\n\t\nrank=" + rank + "]";
		
	}




	public String getSalesPersonName() {
		return salesPersonName;
	}

	public void setSalesPersonName(String salesPersonName) {
		this.salesPersonName = salesPersonName;
	}

	public BigDecimal getMonthlySales() {
		return monthlySales;
	}

	public void setMonthlySales(BigDecimal monthlySales) {
		this.monthlySales = monthlySales;
	}

	public Integer getYearsOfService() {
		return yearsOfService;
	}

	public void setYearsOfService(Integer yearsOfService) {
		this.yearsOfService = yearsOfService;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public static int getApprentice() {
		return APPRENTICE;
	}

	public static int getJunior() {
		return JUNIOR;
	}

	public static int getSenior() {
		return SENIOR;
	}
	

	
}
