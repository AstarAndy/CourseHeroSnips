package com.homework;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Shelter {
	
	/**
	 * to keep this simple, this class is included in the Shelter class
	 * so both classes can be used in one java file.  If need be
	 * you can separate this class into a separate .java file
	 * and then just import that class so the Shelter class can use it.
	 * 
	 * @author Student's Name
	 *
	 */
	static class Dog {
		String name, species, color;
		int weight, age;
		final double price = 12.16;
		public Dog(String name, String species, String color, int weight, int age) {
			super();
			this.name = name;
			this.species = species;
			this.color = color;
			this.weight = weight;
			this.age = age;
		}
		
		
		
		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public String getSpecies() {
			return species;
		}



		public void setSpecies(String species) {
			this.species = species;
		}



		public String getColor() {
			return color;
		}



		public void setColor(String color) {
			this.color = color;
		}



		public int getWeight() {
			return weight;
		}



		public void setWeight(int weight) {
			this.weight = weight;
		}



		public int getAge() {
			return age;
		}



		public void setAge(int age) {
			this.age = age;
		}



		@Override
		public String toString() {
			// Compute the total cost of the dog as weight & price
			BigDecimal cost = new BigDecimal( (price * weight) ).setScale(2, RoundingMode.HALF_UP);
			return "Dog [name=" + name + ", species=" + species + ", color=" + color + ", weight=" + weight + ", age="
					+ age + " Price + " + cost + "]";
		}
		
		
		
	}

	public static void main(String[] args) {
		Dog trueGrit = new Dog("TrueGrit", "Chesapeake Bay Retriever", "Brown", 67, 7);
		Dog snowBall = new Dog("Snowball", "Spitz", "White", 23, 3);
		Dog penny = new Dog("Penny", "Setter", "Copper", 55, 2);
		Dog speedy = new Dog("Speedy", "Grayhound", "Gray", 82, 5);
		
		System.out.println(penny.getName() + " is a " + penny.getAge() + 
							" year old " + penny.getColor() + " " +
							penny.getSpecies() + " who is already house broken and " +
							"a great temperment.");
		
		System.out.println("\n\nCurrent list of Dogs up for adoption");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println(trueGrit.toString());
		System.out.println(snowBall.toString());
		System.out.println(penny.toString());
		System.out.println(speedy.toString());
		
	}

}
