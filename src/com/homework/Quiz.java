package com.homework;

import javax.swing.JOptionPane;

public class Quiz {
	
	/**
	 * This class can be used to ask questions and record answers.
	 * If you want to put into it's own .java file then just cut-and-paste
	 * this class definition into a separate file in the default package
	 * @author Student's name
	 *
	 */
	static class MultipleChoiceQuestion {
		
		static int nQuestions = 0;
		static int nCorrect = 0;
		
		/**
		 * Static method to display the nQuestions & nCorrect counters
		 */
		static void showResults() {
			JOptionPane.showMessageDialog(null, String.format("You were asked %d questions \nand you answered %d correctly", nQuestions, nCorrect));
		}
		
		private String question;
		private String opt1;
		private String opt2;
		private String opt3;
		private String opt4;
		private String opt5;
		private String expectedAnswer;
		private String actualAnswer;
		private String fullQuestion;
		
		/**
		 * The constructor will initialize all inputs, prepare the full questions,
		 * and store both the correct answer and the actual answer
		 * @param query
		 * @param a
		 * @param b
		 * @param c
		 * @param d
		 * @param e
		 * @param correctAns
		 */
		public MultipleChoiceQuestion(String query, String a, String b, String c, String d, String e, String correctAns) {
			question = query;
			opt1 = a;
			opt2 = b;
			opt3 = c;
			opt4 = d;
			opt5 = e;
			
			fullQuestion = String.format("%s? \nA. %s \nB. %s \nC. %s \nD. %s \nE. %s \n", question, opt1, opt2, opt3, opt4, opt5);
			
			expectedAnswer = correctAns;
			actualAnswer = "Z";
		}
		
		/**
		 * Ask the question.  Also increment the nQuestions by 1
		 * @return
		 */
		private String ask() {
			nQuestions += 1;
			String answer = null;

			while (true) 

			{
				answer = JOptionPane.showInputDialog(fullQuestion);
				if(answer==null){
					answer = "Z";
					break;
				}
				answer = answer.toUpperCase();

				if (!(answer.equals("A") || answer.equals("B") || answer.equals("C") || answer.equals("D") || answer.equals("E"))) 
				{
					JOptionPane.showMessageDialog(null, "Invalid answer. Please enter A, B, C, D, or E.");

				} else 
				{
					break;
				}
			}
			
			actualAnswer = answer;
			
			return answer;
			
		}
		
		/**
		 * Call this method to check the answer and increment
		 * the number of correct answers if the answer is correcty
		 */
		public void check() {
			if (expectedAnswer.equalsIgnoreCase(actualAnswer)) {
				JOptionPane.showMessageDialog(null, "Correct!");
				nCorrect += 1;
			} else { 
				JOptionPane.showMessageDialog(null, "Incorrect!");				
			}
		}
		
	}

	/**
	 * Use this method to test the MultipleChoiceQuestion object
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Question 1
		MultipleChoiceQuestion mcq = new MultipleChoiceQuestion("Who is the president of the united states", "Obama", "Bush", "Clinton", "Trump", "Nixon", "D");
		mcq.ask();
		mcq.check();
		
		// Question 2 - Just reuse variable mcq
		mcq = new MultipleChoiceQuestion("What is the name of the Indonesia capitol", "Yangon", "Shanghai", "Washingaton", "Jakarta", "London", "D");
		mcq.ask();
		mcq.check();

		// Question 3 - Just reuse the mcq variable
		mcq = new MultipleChoiceQuestion("What is the sum of 10 and 70", "4344", "222", "87", "80", "45", "D");
		mcq.ask();
		mcq.check();
		
		// Question 4 - Just reuse the mcq variable
		mcq = new MultipleChoiceQuestion("What is the capitol of Pennesylvania", "Harrisburg", "Philadelphia", "Scranton", "Eary", "June", "A");
		mcq.ask();
		mcq.check();
		
		// Question 5 - Just reuse the mcq variable
		mcq = new MultipleChoiceQuestion("What is 35 divided by 5", "12", "47", "7", "80", "45", "C");
		mcq.ask();
		mcq.check();
		
		// Display the test results
		MultipleChoiceQuestion.showResults();
		
	}

}
