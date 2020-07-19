package com.acf.samples;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Keeps a map of team names and players
 * @author student's name
 *
 */
public class SportsLeague {
	
	// First we need a player class that will
	// contain data for each player on a given team
	private static class Player {
		String name;
		String position;
		Double goalAverage;
		Double salary;
		public Player(String name, String position, Double goalAverage, Double salary) {
			super();
			this.name = name;
			this.position = position;
			this.goalAverage = goalAverage;
			this.salary = salary;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public Double getGoalAverage() {
			return goalAverage;
		}
		public void setGoalAverage(Double goalAverage) {
			this.goalAverage = goalAverage;
		}
		public Double getSalary() {
			return salary;
		}
		public void setSalary(Double salary) {
			this.salary = salary;
		}
		@Override
		public String toString() {
			return "Player [name=" + name + ", position=" + position + ", goalAverage=" + goalAverage + ", salary="
					+ salary + "]";
		}
		
	}
	
	// The map of team names, order by team name
	// containing a list of players for each team
	
	public static SortedMap<String, Set<Player>> leagueRoster = new TreeMap<>();
	
	/**
	 * Main entry point for testing
	 * @param args
	 */
	public static void main(String...args) {
		Set<Player> teamRoster = new HashSet<>();
		teamRoster.add(new Player("Bill Harris", "Goalie", 0.00, 150000.00));
		teamRoster.add(new Player("Tom Kicker", "Forward", 1.75, 250000.00));
		teamRoster.add(new Player("Andrew Jackson", "Defender", 1.00, 350000.00));
		leagueRoster.put("Roosters", teamRoster);
		
		// Another team
		teamRoster = new HashSet<>();
		teamRoster.add(new Player("Paul Kako", "Defender", 2.35, 350000.00));
		teamRoster.add(new Player("James Gooler", "Forward", 2.75, 1250000.00));
		teamRoster.add(new Player("Harry Potter", "Defender", 1.00, 350000.00));
		leagueRoster.put("Aces", teamRoster);
		
		// Now print everything and it will be in team order
		leagueRoster
			.forEach((key, value) -> System.out.println("Team: " + key + ", player roster: " + value));
		
		
	}

}
