package com.homework.swing;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HedgeYourBet {
	
	private Map<Integer, List<String>> answersMap = new HashMap<>();
	private List<String> questions = new ArrayList<>();
	private List<Integer> correctAnswers = new ArrayList<>();
	private int questionNbr = -1;
	private int totalPoints = 0;
	
	private JFrame frame;
	private JLabel labGameStatus;
	private JLabel labQuestion;
	private JCheckBox cbxAnswer2;
	private JCheckBox cbxAnswer3;
	private JButton btnSubmit;
	private JCheckBox cbxAnswer1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HedgeYourBet window = new HedgeYourBet();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HedgeYourBet() {
		
		// Initialize the questions map
		
		List<String> answers = new ArrayList<>(3);
		
		questions.add("What types of equipment is used in American Baseball");
		Collections.addAll(answers, "A bat", "A ball", "Both a bat and ball");
		answersMap.put(0, answers);
		correctAnswers.add(2);
		
		answers = new ArrayList<>(3);
		Collections.addAll(answers, "Red Striped", "Solid Red", "Blue");
		questions.add("What is the color of the line that separates an ice hockey rink in half");
		answersMap.put(1, answers);
		correctAnswers.add(0);
		
		answers = new ArrayList<>(3);
		questions.add("How much time is a minor penalty in ice hockey?");
		Collections.addAll(answers, "1 Minute", "2 Minutes", "3 Minutes");
		answersMap.put(2, answers);
		correctAnswers.add(1);
		
		answers = new ArrayList<>(3);
		questions.add("What does 3 cubed (3^3) equal?");
		Collections.addAll(answers, "27", "9", "36");
		answersMap.put(3, answers);
		correctAnswers.add(0);

		answers = new ArrayList<>(3);
		questions.add("How many innings are there in a normal baseball game?");
		Collections.addAll(answers, "7", "1", "9");
		answersMap.put(4, answers);
		correctAnswers.add(2);
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 558, 179);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		labGameStatus = new JLabel("Question 1, Score 0");
		frame.getContentPane().add(labGameStatus, BorderLayout.SOUTH);
		
		labQuestion = new JLabel("Question");
		frame.getContentPane().add(labQuestion, BorderLayout.NORTH);
		
		JPanel panQuestionArea = new JPanel();
		frame.getContentPane().add(panQuestionArea, BorderLayout.CENTER);
		panQuestionArea.setLayout(null);
		
		cbxAnswer1 = new JCheckBox("Answer 1");
		cbxAnswer1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkSubmitStatus();
			}
		});
		cbxAnswer1.setBounds(16, 19, 371, 23);
		panQuestionArea.add(cbxAnswer1);
		
		cbxAnswer2 = new JCheckBox("Answer 2");
		cbxAnswer2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkSubmitStatus();
			}
		});
		cbxAnswer2.setBounds(16, 42, 371, 23);
		panQuestionArea.add(cbxAnswer2);
		
		cbxAnswer3 = new JCheckBox("Answer 2");
		cbxAnswer3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkSubmitStatus();
			}
		});
		cbxAnswer3.setBounds(16, 66, 371, 23);
		panQuestionArea.add(cbxAnswer3);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processSubmit();
			}
		});
		btnSubmit.setBounds(26, 90, 117, 29);
		panQuestionArea.add(btnSubmit);
		
		setQuestionAndAnswers();
		checkSubmitStatus();
	}

	/**
	 * This is called when we need to reset the
	 * UI for the next question
	 */
	private void setQuestionAndAnswers() {
		questionNbr++;
		cbxAnswer1.setSelected(false);
		cbxAnswer2.setSelected(false);
		cbxAnswer3.setSelected(false);
		
		String question = questions.get(questionNbr);
		labQuestion.setText(question);

		List<String> answers = answersMap.get(questionNbr);
		cbxAnswer1.setText(answers.get(0));
		cbxAnswer2.setText(answers.get(1));
		cbxAnswer3.setText(answers.get(2));
	
		labGameStatus.setText("Question Number: " + (questionNbr + 1) + ", total points: " + totalPoints);

	}
	
	private void checkSubmitStatus() {
		boolean enable = (cbxAnswer1.isSelected() || cbxAnswer2.isSelected() || cbxAnswer3.isSelected());
		btnSubmit.setEnabled(enable);
	}
	
	/**
	 * Check on what they did, accumulate their score
	 */
	protected void processSubmit() {
		Integer correctNbr = correctAnswers.get(questionNbr);
		String answer = answersMap.get(questionNbr).get(correctNbr);
		
		int pointsEarned = 0;
		int nbrChecked = 0;
		
		// Now accumulate number checked
		
		nbrChecked += (cbxAnswer1.isSelected() ? 1 : 0);
		nbrChecked += (cbxAnswer2.isSelected() ? 1 : 0);
		nbrChecked += (cbxAnswer3.isSelected() ? 1 : 0);
		
		// Next, did they get it right?
		boolean correctlyAnswered = false;
		
		switch (correctNbr) {
		case 0:
			if (cbxAnswer1.isSelected()) {
				correctlyAnswered = true;
				pointsEarned = 5;
			}
			break;
		case 1:
			if (cbxAnswer2.isSelected()) {
				correctlyAnswered = true;
				pointsEarned = 5;
			}
			break;
		case 2:
			if (cbxAnswer3.isSelected()) {
				correctlyAnswered = true;
				pointsEarned = 5;
			}
		}
		
		// Finalize the point total
		if (correctlyAnswered) {
			if (nbrChecked > 1) {
				pointsEarned = (nbrChecked == 3 ? 1 : 2);
			}
		}
		
		totalPoints += pointsEarned;
		
		// Now let them know
		String template = "You selected " + (correctlyAnswered ? "the correct" : "an incorrect") + " answer.  \nThe correct answer was \n\n%s\n\nYour score for this question is: %d";
		String message = String.format(template, answer, pointsEarned);
		JOptionPane.showMessageDialog(frame, message, "Result", JOptionPane.INFORMATION_MESSAGE);
		
		// We only have 5 questions so stop if we're at 5 else reset for the next question
		
		if (questionNbr == 4) {
			String level = "Ok";
			if (totalPoints > 15) {
				level = "Very Good";
			}
			if (totalPoints > 21) {
				level = "Fantastic";
			}
			
			message = "The same is over.  Your total score was " + totalPoints + "\nYou did" + level;
			JOptionPane.showMessageDialog(frame, message, "Result", JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
					
		} else {
			setQuestionAndAnswers();
			checkSubmitStatus();
		}
		
		
	}


	
}
