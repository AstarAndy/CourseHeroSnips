package com.homework.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculator extends JFrame implements ActionListener {

	private static final String VALID_ENTRIES = "0123456789+-/x=CE.";
	private static final String OPERATOR_CHARACTERS = "+-x/";
	

	private JPanel contentPane;

	private JPanel pnDisplay;

	private JPanel pnInput;

	private JPanel pnHistory;

	private JTextField textField;

	private JButton btn7;

	private JButton btn8;

	private JButton btn9;

	private JButton btnAdd;

	private JButton btnClearAll;

	private JButton btn4;

	private JButton btn5;

	private JButton btn6;

	private JButton btnMinus;

	private JButton btnClearText;

	private JButton btn1;

	private JButton btn2;

	private JButton btn3;

	private JButton btnMultiply;

	private JButton btnMemSet;

	private JButton btn0;

	private JButton btnDot;

	private JButton btnEqual;

	private JButton btnDivide;

	private JButton btnMemRead;

	private JList list;



	// String to store input data

	private String num1;

	private String num2;

	private String operator;

	private final String NONE = "NONE";

	private DefaultListModel<String> listData;



	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Calculator frame = new Calculator();

					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}



	/**

	 * Create the frame.

	 */

	public Calculator() {



		/*

		 * GUI code

		 */

		setTitle("Simple Calculator");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);



		pnDisplay = new JPanel();

		contentPane.add(pnDisplay, BorderLayout.NORTH);

		pnDisplay.setLayout(new GridLayout(0, 1, 0, 0));



		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ( !VALID_ENTRIES.contains(Character.toString(c))) {
					e.consume();  // ignore event
				} else {
					processEntry(Character.toString(c), true);
				}
			}
		});

		textField.setHorizontalAlignment(SwingConstants.RIGHT);

		textField.setFont(new Font("Courier New", Font.PLAIN, 28));

		pnDisplay.add(textField);

		textField.setColumns(10);



		pnInput = new JPanel();

		contentPane.add(pnInput, BorderLayout.CENTER);

		pnInput.setLayout(new GridLayout(4, 5, 5, 5));



		btn7 = new JButton("7");

		btn7.setFont(new Font("Times Roman", Font.BOLD, 14));

		btn7.addActionListener(this);

		pnInput.add(btn7);



		btn8 = new JButton("8");

		btn8.setFont(new Font("Times Roman", Font.BOLD, 14));

		btn8.addActionListener(this);

		pnInput.add(btn8);



		btn9 = new JButton("9");

		btn9.setFont(new Font("Times Roman", Font.BOLD, 14));

		btn9.addActionListener(this);

		pnInput.add(btn9);



		btnAdd = new JButton("+");

		btnAdd.setFont(new Font("Times Roman", Font.BOLD, 14));

		btnAdd.addActionListener(this);

		pnInput.add(btnAdd);



		btnClearAll = new JButton("C");

		btnClearAll.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				// reset the text field

				textField.setText("");

				num1 = NONE;

				num2 = NONE;

				operator = NONE;

			}

		});

		btnClearAll.setFont(new Font("Times Roman", Font.BOLD, 14));

		pnInput.add(btnClearAll);



		btn4 = new JButton("4");

		btn4.setFont(new Font("Times Roman", Font.BOLD, 14));

		btn4.addActionListener(this);

		pnInput.add(btn4);



		btn5 = new JButton("5");

		btn5.setFont(new Font("Times Roman", Font.BOLD, 14));

		btn5.addActionListener(this);

		pnInput.add(btn5);



		btn6 = new JButton("6");

		btn6.setFont(new Font("Times Roman", Font.BOLD, 14));

		btn6.addActionListener(this);

		pnInput.add(btn6);



		btnMinus = new JButton("-");

		btnMinus.setFont(new Font("Times Roman", Font.BOLD, 14));

		btnMinus.addActionListener(this);

		pnInput.add(btnMinus);



		btnClearText = new JButton("CE");

		btnClearText.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// reset the text field and the JList

				textField.setText("");

				num1 = NONE;

				num2 = NONE;

				operator = NONE;
				
				listData.clear();


				textField.setEditable(true);

			}

		});

		btnClearText.setFont(new Font("Times Roman", Font.BOLD, 14));

		pnInput.add(btnClearText);



		btn1 = new JButton("1");

		btn1.setFont(new Font("Times Roman", Font.BOLD, 14));

		btn1.addActionListener(this);

		pnInput.add(btn1);



		btn2 = new JButton("2");

		btn2.setFont(new Font("Times Roman", Font.BOLD, 14));

		btn2.addActionListener(this);

		pnInput.add(btn2);



		btn3 = new JButton("3");

		btn3.setFont(new Font("Times Roman", Font.BOLD, 14));

		btn3.addActionListener(this);

		pnInput.add(btn3);



		btnMultiply = new JButton("x");

		btnMultiply.setFont(new Font("Times Roman", Font.BOLD, 14));

		btnMultiply.addActionListener(this);

		pnInput.add(btnMultiply);



		btnMemSet = new JButton("MS");
		btnMemSet.setEnabled(false);

		btnMemSet.setFont(new Font("Times Roman", Font.BOLD, 14));

		pnInput.add(btnMemSet);



		btn0 = new JButton("0");

		btn0.setFont(new Font("Times Roman", Font.BOLD, 14));

		btn0.addActionListener(this);

		pnInput.add(btn0);



		btnDot = new JButton(".");

		btnDot.setFont(new Font("Times Roman", Font.BOLD, 14));

		pnInput.add(btnDot);



		btnEqual = new JButton("=");

		btnEqual.setFont(new Font("Times Roman", Font.BOLD, 14));

		btnEqual.addActionListener(this);

		pnInput.add(btnEqual);



		btnDivide = new JButton("/");

		btnDivide.setFont(new Font("Times Roman", Font.BOLD, 14));

		btnDivide.addActionListener(this);

		pnInput.add(btnDivide);



		btnMemRead = new JButton("MR");
		btnMemRead.setEnabled(false);

		btnMemRead.setFont(new Font("Times Roman", Font.BOLD, 14));

		pnInput.add(btnMemRead);



		pnHistory = new JPanel();

		contentPane.add(pnHistory, BorderLayout.EAST);

		pnHistory.setPreferredSize(new Dimension(120, 200));



		listData = new DefaultListModel();

		pnHistory.setLayout(new BorderLayout(5, 5));

		list = new JList(listData);
		
		JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setViewportView(list);
	    list.setLayoutOrientation(JList.VERTICAL);
	    pnHistory.add(scrollPane);
		//pnHistory.add(list);



		/*

		 * End of GUI code

		 */



		// initialize data

		num1 = NONE;

		num2 = NONE;

		operator = NONE;


	}



	// Receive the events from all buttons

	@Override

	public void actionPerformed(ActionEvent e) {

		// Get the string from the button

		String s = e.getActionCommand();
		
		// Call the same method as the keypress event
		
		processEntry(s, false);
		
	}
	
	public void processEntry(String enteredValue, boolean wasEntered) {
		// If s is equal to = then perform the calculation otherwise just add it to 
		// the text box and the JList list
		
		System.out.println("Key, or Button, entered was: " + enteredValue);
		
		// Ok, if this is an operator key then set one of the 
		// string operators
		
		if (enteredValue.equals("=")) {
			computeResult();
		} else {
			if (!wasEntered) {
				textField.setText(textField.getText().concat(enteredValue));				
			}
		}
		
		// Set the operator if entered one
		
		if (OPERATOR_CHARACTERS.contains(enteredValue)) {
			operator = enteredValue;
		}
		
	}
	
	/**
	 * This will parse the text field and perform the required calculations
	 */
	public void computeResult() {
		
		String tempValue = textField.getText();
		
		// Minor clean-up
		tempValue = tempValue.replace("=", "");
		
		// Ok, extract the first part.
		
		String[] numbers = tempValue.replace(operator, ",").split(",");
		int result = 0;
		
		try {
			num1 = numbers[0];
			num2 = numbers[1];
			int leftNum = Integer.parseInt(numbers[0]);
			int rightNum = Integer.parseInt(numbers[1]);
			switch (operator) {
			case "+" :
				result = leftNum + rightNum;
				break;
			case "-" :
				result = leftNum - rightNum;
				break;
			case "x" :
				result = leftNum * rightNum;
				break;
			default :
				if (leftNum == 0 || rightNum == 0) {
					result = 0;
				} else {
					result = leftNum / rightNum;
				}
				
			}
			
			listData.addElement(num1);
			listData.addElement(operator);
			listData.addElement(num2);
			listData.addElement("=");
			listData.addElement(Integer.toString(result));
			textField.setText(Integer.toString(result));

		} catch (NumberFormatException e) {
			num1 = NONE;
			num2 = NONE;
			operator = NONE;
		}
					
		
	}

}