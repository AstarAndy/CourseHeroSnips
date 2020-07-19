package com.homework.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

public class TicTacToe {

	private JFrame frame;
	private JButton btnOne;
	private JLabel lblPlayerName;
	private JButton btnNewGame;
	private JButton btnTwo;
	private JButton btnThree;
	private JButton btnFour;
	private JButton btnFive;
	private JButton btnSix;
	private JButton btnEight;
	private JButton btnSeven;
	private JButton btnNine;
	private boolean xTurn = false;
	private StringBuilder spotsSelected = new StringBuilder("         ");
	private JPanel pnlButtons;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe window = new TicTacToe();
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
	public TicTacToe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 316, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnlToolBar = new JPanel();
		frame.getContentPane().add(pnlToolBar, BorderLayout.NORTH);
		pnlToolBar.setLayout(new BorderLayout(0, 0));
		
		lblPlayerName = new JLabel("Player's Name");
		pnlToolBar.add(lblPlayerName, BorderLayout.CENTER);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewGame();
			}
		});
		pnlToolBar.add(btnNewGame, BorderLayout.EAST);
		
		pnlButtons = new JPanel();
		pnlButtons.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(pnlButtons, BorderLayout.CENTER);
		pnlButtons.setLayout(new GridLayout(3, 3, 0, 0));
		
		btnOne = new JButton("1");
		btnOne.setName("1");
		btnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markSpot(btnOne);
			}
		});
		btnOne.setMargin(new Insets(0, 0, 0, 0));
		btnOne.setPreferredSize(new Dimension(70, 29));
		btnOne.setMinimumSize(new Dimension(70, 29));
		btnOne.setMaximumSize(new Dimension(70, 29));
		pnlButtons.add(btnOne);
		
		btnTwo = new JButton("2");
		btnTwo.setName("2");
		btnTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markSpot(btnTwo);
			}
		});
		btnTwo.setMargin(new Insets(0, 0, 0, 0));
		btnTwo.setPreferredSize(new Dimension(70, 29));
		btnTwo.setMinimumSize(new Dimension(70, 29));
		btnTwo.setMaximumSize(new Dimension(70, 29));
		pnlButtons.add(btnTwo);
		
		btnThree = new JButton("3");
		btnThree.setName("3");
		btnThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markSpot(btnThree);
			}
		});
		pnlButtons.add(btnThree);
		
		btnFour = new JButton("4");
		btnFour.setName("4");
		btnFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markSpot(btnFour);
			}
		});
		pnlButtons.add(btnFour);
		
		btnFive = new JButton("5");
		btnFive.setName("5");
		btnFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markSpot(btnFive);
			}
		});
		btnFive.setPreferredSize(new Dimension(70, 29));
		btnFive.setMinimumSize(new Dimension(70, 29));
		btnFive.setMaximumSize(new Dimension(70, 29));
		btnFive.setMargin(new Insets(0, 0, 0, 0));
		pnlButtons.add(btnFive);
		
		btnSix = new JButton("6");
		btnSix.setName("6");
		btnSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markSpot(btnSix);
			}
		});
		pnlButtons.add(btnSix);
		
		btnSeven = new JButton("7");
		btnSeven.setName("7");
		btnSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markSpot(btnSeven);
			}
		});
		pnlButtons.add(btnSeven);
		
		btnEight = new JButton("8");
		btnEight.setName("8");
		btnEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markSpot(btnEight);
			}
		});
		pnlButtons.add(btnEight);
		
		btnNine = new JButton("9");
		btnNine.setName("9");
		btnNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markSpot(btnNine);
			}
		});
		pnlButtons.add(btnNine);
		
		setNewGame();
		
	}
	
	public void setNewGame() {
		// Set default for all the buttons on the
		// pnlButtons JPanel.  This panel only contains JButtons
		Component[] buttons = pnlButtons.getComponents();
		JButton whichButton = null;
		for (int a = 0; a < buttons.length; a++) {
			whichButton = (JButton)buttons[a];
			whichButton.setText("");
			whichButton.setEnabled(true);
			whichButton.setOpaque(true);
			whichButton.setBackground(Color.GRAY);
		}
		
		btnTwo.setText("");
		btnTwo.setEnabled(true);
		btnTwo.setOpaque(true);
		btnTwo.setBackground(Color.GRAY);
		btnThree.setText("");
		btnThree.setEnabled(true);
		btnThree.setOpaque(true);
		btnThree.setBackground(Color.GRAY);
		btnFour.setText("");
		btnFour.setEnabled(true);
		btnFour.setOpaque(true);
		btnFour.setBackground(Color.GRAY);
		btnFive.setText("");
		btnFive.setEnabled(true);
		btnFive.setOpaque(true);
		btnFive.setBackground(Color.GRAY);
		btnSix.setText("");
		btnSix.setEnabled(true);
		btnSix.setOpaque(true);
		btnSix.setBackground(Color.GRAY);
		btnSeven.setText("");
		btnSeven.setEnabled(true);
		btnSeven.setOpaque(true);
		btnSeven.setBackground(Color.GRAY);
		btnEight.setText("");
		btnEight.setEnabled(true);
		btnEight.setOpaque(true);
		btnEight.setBackground(Color.GRAY);
		btnNine.setText("");
		btnNine.setEnabled(true);
		btnNine.setOpaque(true);
		btnNine.setBackground(Color.GRAY);
		xTurn = true;
		
		togglePlayer();


	}
	
	public void togglePlayer() {
		String pName = (xTurn ? "X's" :"O's");
		lblPlayerName.setText(pName + " turn");
	}
	
	public void markSpot(JButton whichButton) {
		String markWith = (xTurn ? "X" : "O");
		whichButton.setText(markWith);
		whichButton.setEnabled(false);
		checkForWinner(markWith);
		xTurn = (!xTurn);
		togglePlayer();
	}
	
	public void checkForWinner(String markWith) {
		if (checkOneSpot(btnOne, markWith) && checkOneSpot(btnTwo, markWith) && checkOneSpot(btnThree, markWith)) {
			btnOne.setBackground(Color.GREEN);
			btnTwo.setBackground(Color.GREEN);
			btnThree.setBackground(Color.GREEN);
			return;
		}
		
		if (checkOneSpot(btnOne, markWith) && checkOneSpot(btnFive, markWith) && checkOneSpot(btnNine, markWith)) {
			btnOne.setBackground(Color.GREEN);
			btnFive.setBackground(Color.GREEN);
			btnNine.setBackground(Color.GREEN);
			return;
		}
	}
	
	public boolean checkOneSpot(JButton whichButton, String whatValue) {
		
		System.out.println("Which button is: " + 
				whichButton.getName() + 
				" and text value is: " + 
				whichButton.getText() + " and whatValue is: " + whatValue);
		return (whichButton.getText().equals(whatValue));
		
	}

}
