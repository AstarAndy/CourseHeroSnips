package com.homework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class illustrates several java features including
 * capabilities of OOP: classes, inheritance, polymorphism, encapsulation.
 * (see: toString methods, modern java file i/o,
 * error handling, and, of course, the streaming api.
 * @author student
 *
 */
public class StudentsFromCsvFile {
	
	/**
	 * Base class.  This class will be extended by child
	 * classes to illustrate different kinds of students.
	 * @author student
	 *
	 */
	class Student {
		protected int id;
		protected String name;
		public Student(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + "]\n";
		}
		
		
	}
	
	class UndergradStudent extends Student {
		private String level = "undergrad";

		public UndergradStudent(int id, String name) {
			super(id, name);
		}
		public String getLevel() {
			return level;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", level=" + level + "]\n";
		}		
	}

	class GradStudent extends Student {
		private String level = "grad";

		public GradStudent(int id, String name) {
			super(id, name);
		}
		public String getLevel() {
			return level;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", level=" + level + "]\n";
		}		
	}

	public static void main(String[] args) {
		StudentsFromCsvFile sfcf = new StudentsFromCsvFile();
		String useFile = (args.length == 0 ? "StudentList.csv" : args[0]);
		sfcf.execute("StudentList.csv");
	}
	
	public void execute(String...args) {
		
		// First load-up the student data and abort if needed
		
		List<Student> studentList = null;
		
		try {
			studentList = getStudentsFromFile(args);
		} catch (IOException e) {
			System.err.println("The file: " + args[0] + " can't be opened or is empty.  Aborting");
			return;
		}
	
		// Dump them to the console
		
		studentList.forEach(System.out::println);
		
		return;
		
	}
	
	/**
	 * Uses java 8 Files static method to read all the lines from the file into a
	 * list of strings.  Very nice 
	 * @param args[0] should be the name of the file
	 * @return List[Student] Each student will be either an ungrad or grad student
	 * @throws IOException, FileNotFoundException 
	 */
	public List<Student> getStudentsFromFile(String...args) throws IOException, FileNotFoundException {
		List<Student> studentList = new ArrayList<>();
			
		// Java 7 beauty..
		List<String> content = Files.readAllLines(Paths.get(args[0]));

		// If the list is empty or null then we'll assume the file was not there
		if (content.isEmpty()) {
			throw new FileNotFoundException("The file: " + args[0] + " is not locatable.");
		}
		
		// Now we'll build out the list
		// The first line is the header and we don't want that
		
		content.remove(0);
		
		// Now stream thru and transforms the lines of input into a list of grad/undergrad students
		studentList = content
						.stream()
						.map(thisLine -> {
							String cols[] = thisLine.split(",");
							Student thisStudent;
							if (cols[2].equalsIgnoreCase("u")) {
								thisStudent = new UndergradStudent(Integer.parseInt(cols[0]), cols[1]);
							} else {
								thisStudent = new GradStudent(Integer.parseInt(cols[0]), cols[1]);
							}
							return thisStudent;
						})
						.collect(Collectors.toList());
						
		
		return studentList;
		
	}
}
