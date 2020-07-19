package com.homework.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.util.Stack;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StackSimulator extends JFrame {

	private JPanel contentPane;
	private JTextField txtStackEntry;
	JTextArea txaStackData;
	JButton btnPush;
	JButton btnPop;
	JButton btnDisplay;
	
	private Stack<String> stackEntries = new Stack<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackSimulator frame = new StackSimulator();
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
	public StackSimulator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter text to add to stack");
		lblNewLabel.setBounds(39, 28, 172, 16);
		contentPane.add(lblNewLabel);
		
		txtStackEntry = new JTextField();
		txtStackEntry.setBounds(207, 23, 186, 26);
		contentPane.add(txtStackEntry);
		txtStackEntry.setColumns(10);
		
		txaStackData = new JTextArea();
		txaStackData.setBounds(49, 56, 340, 130);
		contentPane.add(txaStackData);
		
		btnPush = new JButton("Push");
		btnPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentValue = txtStackEntry.getText();
				if (currentValue != null && !currentValue.isEmpty()) {
					stackEntries.push(currentValue);
					txtStackEntry.setText("");
					checkButtonStatus();
				}
			}
		});
		btnPush.setBounds(84, 204, 75, 29);
		contentPane.add(btnPush);
		
		btnPop = new JButton("Pop");
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!stackEntries.isEmpty()) {
					stackEntries.pop();
					checkButtonStatus();
				}
			}
		});
		btnPop.setEnabled(false);
		btnPop.setBounds(171, 204, 75, 29);
		contentPane.add(btnPop);
		
		btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!stackEntries.isEmpty()) {
					txaStackData.setText("");
					StringBuffer sb = new StringBuffer();
					while(!stackEntries.isEmpty()) {
						sb.append(stackEntries.pop() + "\n");
					}
					txaStackData.setText(sb.toString());
					checkButtonStatus();
				}
			}
		});
		btnDisplay.setEnabled(false);
		btnDisplay.setBounds(258, 204, 96, 29);
		contentPane.add(btnDisplay);
	}
	
	private void checkButtonStatus() {
		btnPop.setEnabled(!stackEntries.empty());
		btnDisplay.setEnabled(btnPop.isEnabled());
	}
}
