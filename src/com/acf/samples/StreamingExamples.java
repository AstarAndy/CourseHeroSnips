package com.acf.samples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Various examples of functions using streams
 * @author ACF
 *
 */
public class StreamingExamples {
	
	// Also can use just streams
	private static Stream<Double> floatStream = Stream.of(1.1, 2.3, 5.2, 5.9, 8.0, 9.1);
	private static Stream<Integer> intStream = Stream.of(1, 8, 7, 2, 5, 11, 9);
	
	/**
	 * This class is used for grouping examples
	 * @author AndyFaust
	 *
	 */
	static class Person {
		protected String name;
		protected String city;
		protected Double salary;
		public Person(String name, String city, Double salary) {
			super();
			this.name = name;
			this.city = city;
			this.salary = salary;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public Double getSalary() {
			return salary;
		}
		public void setSalary(Double salary) {
			this.salary = salary;
		}
		@Override
		public String toString() {
			return "Person [name=" + name + ", city=" + city + ", salary=" + salary + "]";
		}
		
	}

	public static void main(String...args) {
		StreamingExamples ssaa = new StreamingExamples();
		ssaa.minMaxSumAvg();
		ssaa.groupingSamples();
	}
	
	public void minMaxSumAvg() {
		
		// First get a list of doubles (it could also be integers)
		List<Double> floatList = new ArrayList<>();
		floatList.add(12.2);
		floatList.add(10.25);
		floatList.add(13.33);
		floatList.add(9.35);
		
		floatList.add(10.0);
		
		// Get the min value the long way
		Double min1 =
				floatList
				.stream()
				.mapToDouble(Double::doubleValue)
				.min()
				.orElse(0.0);
		// Now the short hand way
		Double min2 =
				floatList
				.stream()
				.min(Comparator.comparing(Double::doubleValue))
				.orElse(0.0);
		
		// Check them
		System.out.println("\nmin1 is: " + min1);
		System.out.println("min2 is: " + min2);
		
		
		// Now get the sum
		// Long way
		
		Double sum1 = 
				floatList
				.stream()
				.mapToDouble(Double::doubleValue)
				.sum();
		// Next way, better way but NO NULLS
		Double sum2 = 
				floatList
				.stream()
				.collect(Collectors.summingDouble(Double::doubleValue));
		
		// Same with averages
		Double avg1 = 
				floatList
				.stream()
				.mapToDouble(Double::doubleValue)
				.average()
				.orElse(0.0);
		// Next way, better way but NO NULLS
		Double avg2 = 
				floatList
				.stream()
				.collect(Collectors.averagingDouble(Double::doubleValue));

		// Sanity check
		System.out.println("\nSum1: " + sum1);
		System.out.println("Sum2: " + sum2);
		System.out.println("\nAvg1: " + avg1);
		System.out.println("Avg2: " + avg2);
		
		// Let filter some stuff
		// Get every double that is greater than the average
		
		// Now get every entry that is > the average
		List<Double> moreThanAverage = 
				floatList
				.stream()
				.filter(thisVal -> {
					return (thisVal > avg1);
				})
				.collect(Collectors.toList());
		System.out.println("Those over the average are: ");
		moreThanAverage.forEach(System.out::println);

		// Another way to get every entry that is > the average
		List<Double> moreThanAverage2 = 
				floatList
				.stream()
				.filter(thisVal -> {return thisVal > avg2;})
				.collect(Collectors.toList());
		System.out.println("Those over the average2 are: ");
		moreThanAverage2.forEach(System.out::println);
		
	}
	
	public void groupingSamples() {
		
		// First let's create a list of people using the Person class
		List<Person> peopleList = new ArrayList<Person>() {
			{
				add(new Person("William Harris", "Atlanta", 2100.00));
				add(new Person("Tom Jones", "Atlanta", 3100.34));
				add(new Person("Maru Moo", "Atlanta", 100.00));
				add(new Person("Gail Jackson", "Philadelphia", 222100.00));
				add(new Person("Ellie Barger", "Philadelphia", 322100.00));
				add(new Person("Andrew Lenour", "Philadelphia", 1237.88));
				add(new Person("Charles Faust", "Dallas", 877.34));
			}
		};
		
		// Now let's get a list of cities with their associated person list
		
		Map<String, List<Person>> salaryByCityMap = peopleList
				.stream()
				.collect(Collectors.groupingBy(Person::getCity));
		System.out.println("\nGroup of people by City\n" + salaryByCityMap);
		
		// Now get a count of the number of distinct city values
		
		Long howMany = peopleList
							.stream()
							.map(Person::getCity)
							.distinct()
							.count();
		System.out.println("The distinct number of city values is: " + howMany);
		
	}

}
