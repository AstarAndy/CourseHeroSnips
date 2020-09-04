package com.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadsAndShipping {

	 
	
	
    public static void main(String args[]) throws IOException, InterruptedException, ParseException {
    	 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 
        List<Shipment> shipmentList = new ArrayList<Shipment>();
        shipmentList.add(new Shipment(2390900L,"Agro Ltd",88412525L,"Mumbai",sdf.parse("16/05/2017"),sdf.parse("16/05/2017"),null,7500,10,41004500));
        shipmentList.add(new Shipment(2391990L,"Tumac Commodities",88425455L,"Mumbai",sdf.parse("14/05/2017"),sdf.parse("16/05/2017"),null,7500,10,41004500));
        shipmentList.add(new Shipment(2356000L,"HAKAN AGRO",88412522L,"Mumbai",sdf.parse("12/05/2017"),sdf.parse("16/05/2017"),null,7500,10,41004500));
        shipmentList.add(new Shipment(2366785L,"BTW",88415522L,"Mumbai",sdf.parse("14/05/2017"),sdf.parse("16/05/2017"),null,7500,10,41004500));
        shipmentList.add(new Shipment(2366854L,"Bisk Farm",86555520L,"Mumbai",sdf.parse("16/05/2017"),sdf.parse("16/05/2017"),null,7500,10,41004500));
        shipmentList.add(new Shipment(2398222L,"Meat Products of India",88785545L,"Mumbai",sdf.parse("16/05/2017"),sdf.parse("16/05/2017"),null,7500,10,41004500));
        shipmentList.add(new Shipment(2389452L,"Balaji Group",88123455L,"Mumbai",sdf.parse("16/05/2017"),sdf.parse("16/05/2017"),null,7500,10,41004500));
        shipmentList.add(new Shipment(2352000L,"Agro Ltd",88412785L,"Mumbai",sdf.parse("13/05/2017"),sdf.parse("16/05/2017"),null,7500,10,41004500));
        shipmentList.add(new Shipment(2394566L,"Heritage Foods",88412563L,"Mumbai",sdf.parse("15/05/2017"),sdf.parse("16/05/2017"),null,7500,10,41004500));
        shipmentList.add(new Shipment(237800L,"ITC",88452678L,"Mumbai",sdf.parse("16/05/2017"),sdf.parse("16/05/2017"),null,7500,10,41004500));
 
 
        System.out.println("Enter number of threads to process the data:");
 
        int numberOfThreads = Integer.parseInt(reader.readLine());
 
        if (numberOfThreads > shipmentList.size()) {
        	numberOfThreads = shipmentList.size();
        }
        
        int countPerThread = (shipmentList.size() / numberOfThreads);
        
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        
        ExportShipmentThread est = null;
        List<Shipment> subList = new ArrayList<>();
        List<ExportShipmentThread> jobList = new ArrayList<>();
        
        for (int idx = 0; idx < shipmentList.size(); idx++) {
        	if (idx > 0) {
        		if (idx % countPerThread == 0) {
                	est = new ExportShipmentThread(subList);
                	executor.execute(est);
                	jobList.add(est);
                	subList = new ArrayList<>();
        		}
        	}
        	subList.add(shipmentList.get(idx));
        }
        
        if (!subList.isEmpty()) {
        	est = new ExportShipmentThread(subList);
        	executor.execute(est);
        	jobList.add(est);
        }
        
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        
        System.out.println("Shipping Details\n");
        jobList.forEach(thisJob -> {
        	System.out.println(thisJob.getShipmentDetails().toString());
        });
        
        
 
        
        
    }
 
    /**
     * Included as part of the template but has no implementation
     * 
     * @param list
     */
    public static void displayPrice(List<Double> list) {
        //fill in your code here
    }
}

class Shipment {
	 
    private Long id;
    private String name;
    private Long bookingNumber;
    private String executedPlace;
    private Date executedDate;
    private Date departureDate;
    private Date arrivalDate;
    private Integer totalWeight;
    private Integer shipmentStatus;
    private Integer carrierId;
 
    public Shipment(Long id,String name,Long bookingNumber,String executedPlace,Date executedDate,Date departureDate,Date arrivalDate,Integer totalWeight,Integer shipmentStatus,Integer carrierId) {
        this.id = id;
        this.name = name;
        this.bookingNumber = bookingNumber;
        this.executedPlace = executedPlace;
        this.executedDate = executedDate;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.totalWeight = totalWeight;
        this.shipmentStatus = shipmentStatus;
        this.carrierId = carrierId;
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Long getBookingNumber() {
        return bookingNumber;
    }
 
    public void setBookingNumber(Long bookingNumber) {
        this.bookingNumber = bookingNumber;
    }
 
    public String getExecutedPlace() {
        return executedPlace;
    }
 
    public void setExecutedPlace(String executedPlace) {
        this.executedPlace = executedPlace;
    }
 
    public Date getExecutedDate() {
        return executedDate;
    }
 
    public void setExecutedDate(Date executedDate) {
        this.executedDate = executedDate;
    }
 
    public Date getDepartureDate() {
        return departureDate;
    }
 
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
 
    public Date getArrivalDate() {
        return arrivalDate;
    }
 
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
 
    public Integer getTotalWeight() {
        return totalWeight;
    }
 
    public void setTotalWeight(Integer totalWeight) {
        this.totalWeight = totalWeight;
    }
 
    public Integer getShipmentStatus() {
        return shipmentStatus;
    }
 
    public void setShipmentStatus(Integer shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }
 
    public Integer getCarrierId() {
        return carrierId;
    }
 
    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }
    
}

class ExportShipmentThread extends Thread
{
 
	private List<Shipment> shipmentList;
	private StringBuilder shipmentDetails;
	SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
 
    public ExportShipmentThread(List<Shipment> shipmentList) {
        this.shipmentList = shipmentList;
    }
 
    public void run() {
 
    	shipmentDetails = new StringBuilder();
    	//String outputTemplate = "id | name | booking number | executed place | executed date | departure date | arrival date | total weight | shipment status | carrier id";
    	String outputTemplate = "%s | %s | %s | %s | %s | %s | %s | %s | %s | %s\n";
    	
    	
    	// Ok, build the output.
    	
    	shipmentList.forEach(thisShipment -> {
    		shipmentDetails.append(String.format(outputTemplate,
    								thisShipment.getId(),
    								thisShipment.getName(),
    								thisShipment.getBookingNumber(),
    								thisShipment.getExecutedPlace(),
    								df.format(thisShipment.getExecutedDate()),
    								df.format(thisShipment.getDepartureDate()),
    								" ",
    								thisShipment.getTotalWeight(),
    								thisShipment.getShipmentStatus(),
    								thisShipment.getCarrierId()    								
    						) // end of String.format
    		); // end of append
    		
    	}); // end of forEach...
    	
 
    }
 
    public StringBuilder getShipmentDetails() {
        return shipmentDetails;
    }
 
}
