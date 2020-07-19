package com.homework.swing;

import javax.swing.*;

import org.ietf.jgss.GSSException;

import java.awt.Component;

import java.awt.event.ActionEvent;

public class BinarySearchTreeMain {

	private JRadioButton IsBalancedRadioButton;

	private JRadioButton integerRadioButton, fractionRadioButton;

	private JTextField expressionEntryField, expressionResultField;

	private JRadioButton InorderRadioButton;

	private Component IsFullButton;
	private JButton MakeTreeButton;

	public static void main(String[] args) throws GSSException {

		BinarySearchTreeMain binarySearch = new BinarySearchTreeMain();

		binarySearch.instantiateGui(null, null);

	}


	private void instantiateGui(Component IsProper, Component HeightButton) throws GSSException {

		JFrame window = new JFrame("Binary Tree Categorizer");

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = (JPanel) window.getContentPane();

		window.getContentPane().setLayout(null);

		JLabel promptLabel = new JLabel("Enter Tree");

		promptLabel.setBounds(25, 15, 100, 20);

		panel.add(promptLabel);

		JLabel resultLabel = new JLabel("Output");

		resultLabel.setBounds(25, 70, 100, 20);

		panel.add(resultLabel);

		expressionEntryField = new JTextField("", 30);

		expressionEntryField.setBounds(125, 15, 350, 20);

		panel.add(expressionEntryField);

		expressionResultField = new JTextField("", 30);

		expressionResultField.setBounds(125, 70, 350, 20);

		panel.add(expressionResultField);

		MakeTreeButton = new JButton("MakeTree");

		MakeTreeButton.setBounds(56, 106, 125, 25);

		MakeTreeButton.addActionListener((ActionEvent e) ->

		{

			try {

				String entry = expressionEntryField.getText();

				validateUserInput(entry);

				validateUserSelections();

				sortButtonAction(entry);

			} catch (Exception e1) {

				System.out.println("Uncaught Exception: " + e1);

			}

		});

		panel.add(MakeTreeButton);

		JButton IsBalancedButton = new JButton("IsBalanced");

		IsBalancedButton.setBounds(175, 125, 125, 25);

		IsBalancedButton.addActionListener((ActionEvent e) ->

		{

			try {

				String entry = expressionEntryField.getText();

				validateUserInput(entry);

				validateUserSelections();

				sortButtonAction(entry);

			} catch (Exception e1) {

				System.out.println("Uncaught Exception: " + e1);

			}

		});

		JButton IsFullButton = new JButton("IsFull");

		IsFullButton.setBounds(193, 130, 125, 25);

		IsFullButton.addActionListener((ActionEvent e) ->

		{

			try {

				String entry = expressionEntryField.getText();

				validateUserInput(entry);

				validateUserSelections();

				sortButtonAction(entry);

			} catch (Exception e1) {

				System.out.println("Uncaught Exception: " + e1);

			}

		});

		panel.add(IsFullButton);
		//panel.add(IsProper);

		JButton IsProperButton = new JButton("IsProper");

		IsProperButton.setBounds(175, 125, 125, 25);

		IsProperButton.addActionListener((ActionEvent e) ->

		{

			try {

				String entry = expressionEntryField.getText();

				validateUserInput(entry);

				validateUserSelections();

				sortButtonAction(entry);

			} catch (Exception e1) {

				System.out.println("Uncaught Exception: " + e1);

			}

		});

		panel.add(IsFullButton);
		//panel.add(HeightButton);

		JButton HeightButton1 = new JButton("Height");

		HeightButton1.setBounds(340, 106, 125, 25);

		HeightButton1.addActionListener((ActionEvent e) ->

		{

			try {

				String entry = expressionEntryField.getText();

				validateUserInput(entry);

				validateUserSelections();

				sortButtonAction(entry);

			} catch (Exception e1) {

				System.out.println("Uncaught Exception: " + e1);

			}

		});

		panel.add(HeightButton1);

		JButton NodesButton = new JButton("Nodes");

		NodesButton.setBounds(193, 102, 125, 25);

		NodesButton.addActionListener((ActionEvent e) ->

		{

			try {

				String entry = expressionEntryField.getText();

				validateUserInput(entry);

				validateUserSelections();

				sortButtonAction(entry);

			} catch (Exception e1) {

				System.out.println("Uncaught Exception: " + e1);

			}

		});

		panel.add(NodesButton);

		JButton InOrderButton = new JButton("InOrder");

		InOrderButton.setBounds(56, 130, 125, 25);

		InOrderButton.addActionListener((ActionEvent e) ->

		{

			try {

				String entry = expressionEntryField.getText();

				validateUserInput(entry);

				validateUserSelections();

				sortButtonAction(entry);

			} catch (Exception e1) {

				System.out.println("Uncaught Exception: " + e1);

			}

		});

		panel.add(InOrderButton);
		
		// TODO: I added these so the data validations would work
		integerRadioButton = new JRadioButton("Integer");
		integerRadioButton.setBounds(52, 167, 93, 23);
		integerRadioButton.setSelected(true);
		panel.add(integerRadioButton);
		
		fractionRadioButton = new JRadioButton("Fraction");
		fractionRadioButton.setBounds(175, 167, 141, 23);
		panel.add(fractionRadioButton);
		
		IsBalancedRadioButton = new JRadioButton("Is Balanced");
		IsBalancedRadioButton.setSize(141, 23);
		IsBalancedRadioButton.setLocation(328, 167);
		panel.add(IsBalancedRadioButton);
		

		window.getRootPane().setDefaultButton(MakeTreeButton);

		window.setSize(500, 275);

		window.setVisible(true);

	}

	private void sortButtonAction(String entry) throws Exception {

		BinarySearchTree binarySearchTree;

		String values[] = entry.split(" ");

		// TODO: Optimize

		if (fractionRadioButton.isSelected()) {

			binarySearchTree = new BinarySearchTree();

			for (int i = 1; i < values.length; i++) {

				if (values[i].split("/").length > 2) {

					throw new Exception("Error. Malformed Fraction");

				}

				if (!values[i].contains("/")) {

					Integer.parseInt(values[i]);

					values[i] = values[i] + "/1";

				}

				binarySearchTree.bstInsert("int", (values[i]));

			}

		} else {

			binarySearchTree = new BinarySearchTree(Integer.parseInt(values[0]));

			for (int i = 1; i < values.length; i++) {

				binarySearchTree.insert(Integer.parseInt(values[i]));

			}

		}

		if (IsBalancedRadioButton.isSelected()) {

			expressionResultField.setText(binarySearchTree.ascendingOrder(binarySearchTree.getRoot()));

		} else {

			expressionResultField.setText(binarySearchTree.ascendingOrder(binarySearchTree.getRoot()));

		}

	}

	private void validateUserInput(String entry) throws Exception {

		if (entry.equals("")) {

			throw new Exception("Please Enter an Expression.");

		}

		for (int i = 0; i < entry.length(); i++) {

			char c = entry.charAt(i);

			if (!Character.isDigit(c) && c != '/' && !Character.isWhitespace(c)) {

				throw new Exception("Error: Non numeric input detected.");

			}

			if (c == '/' && integerRadioButton.isSelected()) {

				throw new Exception("Error: List of Integers contains a fraction.");

			}

		}

	}

	private void validateUserSelections() throws Exception {

		if (!fractionRadioButton.isSelected() && !integerRadioButton.isSelected()) {

			throw new Exception("Please Select a Numeric Type");

		}

		if (!IsBalancedRadioButton.isSelected() && !IsBalancedRadioButton.isSelected()) {

			throw new Exception("Please Select a Sort Type");

		}

	}

	public class BinarySearchTree {

		int key;

		BinarySearchTree left, right;

		public BinarySearchTree(int item) {

			key = item;

			left = right = null;

		}

		public BinarySearchTree() {

		}

		public void bstInsert(String string, String string2) {

		}

		public void insert(int parseInt) {

		}

		public Object getRoot() {

			return null;

		}

		public String ascendingOrder(Object root) {

			return null;

		}

	}

	// Java program to introduce Binary Tree

	class BinaryTree {



		//Root of the Binary Tree

		BinarySearchTree root;

		//Constructors

		BinaryTree(int key) {

			root = new BinarySearchTree(key);

		}



		BinaryTree() {

			root = null;
// There is NO Node class defined.
//			root = new Node(1)
//			root.left = new Node(2);
//			root.right = new Node(3);
//			root.left.left = new Node(4);
			
		}

		void printPostorder(BinarySearchTree node) {



			if (node == null)

				return;



			//firet recur on left subtree



			printPostorder(node.left);



			//then recur on right subtree



			printPostorder(node.right);



			//now deal with node

			System.out.print(node.key + " ");



		}

		//Given a binary tree print this node in inorder



		void printInorder(BinarySearchTree node) {



			if(node == null)



				return;

			//first recur on left child



			printInorder(node.left);



			//the print the data of node

			System.out.print(node.key + " ");



			//now recur on right child

			printInorder(node.right);



		}

		//Given a binary tree, print its nodes in preorder



		void printPreorder(BinarySearchTree node) {



			if(node == null)

				return;



			//first print data of node

			System.out.print(node.key + " ");



			//then recur on left subtree



			printPreorder(node.left);



			//now recur on right subtree

			printPreorder(node.right);



		} 

	}
}