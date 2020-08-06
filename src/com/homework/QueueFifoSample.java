package com.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This is a simple queue example.  It oporates as a 
 * FIFO (first-in / first-out queue.
 * @author student's name
 *
 */
public class QueueFifoSample {

	public static void main(String[] args) {
		
		// First create an instance of this
		QueueFifoSample qfs = new QueueFifoSample();
		
		// Now build out a list of names
		List<String> tempList = new ArrayList<>();
		Collections.addAll(tempList, "Nidaba", "Sisipho", "Zandile", "Xowisla", "Fabian", "Bongani", "Ruan", "Modiselle", "Tian", "Aaron");
		Queue<String> listQueueOfNames = qfs.createQueueFromList(tempList);
		System.out.println("The List queue contains: " + listQueueOfNames);
		
		// Now do the array-based sample
		String arrayOfNames[] = {"Nidaba", "Sisipho", "Zandile", "Xowisla", "Fabian", "Bongani", "Ruan", "Modiselle", "Tian", "Aaron"};
		Queue<String> arrayQueueOfNames = qfs.createQueueFromArray(arrayOfNames);
		System.out.println("The array queue contains: " + arrayQueueOfNames);
		

	}
	
	/**
	 * Just a sample using a list object of strings
	 * @param listOfNames List[String]
	 * @return a Queue representation of the string
	 */
	public Queue<String> createQueueFromList(List<String> listOfNames) {
		Queue<String> newQueue = new LinkedList<>();
		
		// Build out the queue
		listOfNames.forEach(thisName -> {
			newQueue.add(thisName);
		});
		
		return newQueue;
	}
	
	public Queue<String> createQueueFromArray(String[] arrayOfNames) {
		Queue<String> newQueue = new LinkedList<>();
		for (int a = 0; a < arrayOfNames.length; a++) {
			newQueue.add(arrayOfNames[a]);
		}
		
		return newQueue;
	}

}
