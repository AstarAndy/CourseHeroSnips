package com.homework;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadsAndRunnable {

    public static void main(String args[]) throws IOException, InterruptedException, ParseException {
    	 
    	// First we'll do a fixed-size thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new SimpleThread("Donatello's Equestrian Monument of Gattamelata", Thread.MAX_PRIORITY));
        executor.execute(new SimpleThread("The Terracotta Army", Thread.MIN_PRIORITY));
        executor.execute(new SimpleRunnable("Michelangelo's David"));
        executor.execute(new SimpleRunnable("Maman"));
        executor.shutdown();
        if (executor.awaitTermination(30, TimeUnit.SECONDS)) {
        	System.out.println("Fixed threadpool normal shutdown");
        } else {
        	System.out.println("The fixed thread pool was forced to shutdown");
        }
        
        // Now a cached thread pool
        executor = Executors.newCachedThreadPool();
        executor.execute(new SimpleThread("Donatello's Equestrian Monument of Gattamelata", Thread.MAX_PRIORITY));
        executor.execute(new SimpleThread("The Terracotta Army", Thread.MIN_PRIORITY));
        executor.execute(new SimpleRunnable("Michelangelo's David"));
        executor.execute(new SimpleRunnable("Maman"));
        executor.shutdownNow();
        if (executor.awaitTermination(30, TimeUnit.SECONDS)) {
        	System.out.println("Cached threadpool normal shutdown");
        } else {
        	System.out.println("The Cached thread pool was forced to shutdown");
        }
        
        
        
    }
     
}


class SimpleThread extends Thread
{
 
	private String printThisValue = null;
	
    public SimpleThread(String whatString, int newPriority) {
        printThisValue = whatString;
        setPriority(newPriority);
    }
 
    public void run() {
    	
    	IntStream.rangeClosed(1, 20).forEach(thisIdx -> {
    		System.out.println(printThisValue);
    		try {
				TimeUnit.MICROSECONDS.sleep(100L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	});
    }
}

class SimpleRunnable implements Runnable
{
 
	private String printThisValue = null;
	
    public SimpleRunnable(String whatString) {
        printThisValue = whatString;
    }
 
    public void run() {
    	
    	IntStream.rangeClosed(1, 20).forEach(thisIdx -> {
    		System.out.println(printThisValue);
    		try {
				TimeUnit.MICROSECONDS.sleep(100L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	});
    }
}
