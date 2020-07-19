package com.homework;

import java.util.*;

public class StudentAssignments {

    // Unmodifiable list of room names that can be accessed with a numeric index such as 0, 1, or 2
    private static final List<String> houseList = Arrays.asList("RED", "BLUE", "WHITE");
    private static final Random numGenerator = new Random();

    /**
     * Will hold the required student information
     */
	class Student {

	    String studentId;
	    String studentName;
	    Student(String name, String whichHouse) {
            //  return random.ints(min,(max+1)).findFirst().getAsInt();
	        studentId = whichHouse + "-" + numGenerator.nextInt(9999);
	        studentName = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "studentId='" + studentId + '\'' +
                    ", studentName='" + studentName + '\'' +
                    '}';
        }
    }

    // Holds the rooms actually assigned to each student
    private List<Student> roomAsignmentList = new ArrayList<>(3);
    private Scanner keyInputter = new Scanner(System.in);

	public static void main(String...args) {

		StudentAssignments tc = new StudentAssignments();
		
		tc.startRoomAssignments();
				
	}
	
	private void startRoomAssignments() {
		
		// Get the 3 student names
		
		String response = null;
		String newValue = null;
		String prompt = "Please enter student name or just enter to quit: ";
		int randomRoomNumber = -1;
		Student newStudent = null;

		// Now we loop until they enter nothing and then we'll quit
		
		while (roomAsignmentList.size() < 3) {
			response = getInputValue(prompt);
			if (response.isEmpty()) {
				System.out.println("\nAppreciate your time.  Goodbye");
				break;
			}

			// return random.ints(min,(max+1)).findFirst().getAsInt();
			newStudent = new Student(response, houseList.get(numGenerator.nextInt(2)));
			roomAsignmentList.add(newStudent);
		}

		System.out.println("Student room assignments are as follows:\n ");
		System.out.println(roomAsignmentList.toString());
		
		keyInputter.close();
		return;
	}
	
	
	/**
	 * Use this to prompt for input and return the entered
	 * value as a String.  This will only query for the input and
	 * the caller is responsible for any input validation
	 * @param promptValue A string value to prompt the user as to what to enter
	 * @return String the value entered.
	 */
	private String getInputValue(String promptValue) {
		System.out.println(promptValue + ": ");
		return keyInputter.nextLine();
		
	}

	/**
	 * Print's out the list of assigned rooms
	 */
    @Override
    public String toString() {
        return "StudentAssignments{" +
                "roomAsignmentList=" + roomAsignmentList +
                '}';
    }
}
