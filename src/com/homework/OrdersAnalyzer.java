package com.homework;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrdersAnalyzer {

	static class Order {
		int orderId;
		LocalDateTime creationDate;
		List<OrderLine> orderLines;
	}

	static class OrderLine {
		int productId;
		String name;
		int quantity;
		BigDecimal unitPrice;
	}
	
	
	
	
}