package com.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SalaryLookup {

	/**
	 * This contains a single job definition with an ID,
	 * description, and salary
	 * @author Student's name
	 *
	 */
	private static class Job {
		private Integer id;
		private String desc;
		private Integer salary;
		public Job(Integer Id, String desc, Integer salary) {
			this.id = Id;
			this.desc = desc;
			this.salary = salary;
		}
		public Integer getId() {
			return id;
		}
		public String getDesc() {
			return desc;
		}
		public Integer getSalary() {
			return salary;
		}		
		
	}
	
	/**
	 * This contains a table of positions &
	 * salaries identified by a position id
	 * @author Student's name
	 *
	 */
	private static class SalaryTable {
		List<Job> jobList = new ArrayList<>();
		public SalaryTable() {
			// Initialize the job list table
			Job thisJob = new Job(1, "Manager", 5500);
			jobList.add(thisJob);

			thisJob = new Job(2, "Chef", 5050);
			jobList.add(thisJob);

			thisJob = new Job(3, "Kitchen Staff", 3500);
			jobList.add(thisJob);
			
			thisJob = new Job(4, "Waiter / Waitress", 3300);
			jobList.add(thisJob);
			
		}
		
		/**
		 * Searches job table by job-id and returns that job
		 * or an error.
		 * @param jobId
		 * @return
		 * @throws NoSuchElementException
		 */
		public Job getJobById(Integer jobId) throws NoSuchElementException {
			Job jobFound = jobList
							.stream()
							.filter(thisJob -> thisJob.getId().equals(jobId))
							.findAny()
							.orElseThrow(NoSuchElementException::new);
			return jobFound;
						
		}
	}
	
	public static void main(String[] args) {
		// This contains the job ids, descriptions, and salaries.
		SalaryTable st = new SalaryTable();
		
		// Get a data input object
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter an associate's name: ");
		String empName = sc.nextLine();
		Integer posNbr = -1;
		
		try {
			// If they don't enter a numeric value then we'll get an error
			System.out.print("\nEnter a position number for this associate: ");
			posNbr = sc.nextInt();
			
			// Now get the job details using the job number.  If the job
			// is not on file we'll get an error
			Job whichJob = st.getJobById(posNbr);
			
			// Ok, print-out everything
			
			System.out.println(String.format("Position is %s and should be paid $%s", whichJob.getDesc(), whichJob.getSalary()));
			
		} catch (Exception e) {
			if (e instanceof NoSuchElementException) {
				System.err.println("There is no job desciption for job number " + posNbr);
			} else {
				System.err.println("You did not enter a numeric value");
			}
		}

	}

}
