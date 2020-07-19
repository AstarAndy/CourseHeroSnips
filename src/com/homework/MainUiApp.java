package com.homework;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainUiApp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String ssn = (String)JOptionPane.showInputDialog(
                null,
                "Enter your SSN Please",
                null,
                JOptionPane.QUESTION_MESSAGE);

			//If a string was returned, say so.
			if ((ssn != null) && (ssn.length() > 0)) {
				// Now do logic to value the manager's SSN
				if (ssn.equalsIgnoreCase("andrew")) {
					JOptionPane.showMessageDialog(null,
						    "The SSN entered is either not a valid SSN or is not a Manager's SSN",
						    "Validation Error",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}
				
			} else {
				return;
			}
			
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUiApp frame = new MainUiApp();
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
	public MainUiApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	
	/** Ok, first ask them who they are and validate that we can proceed
	 * 
	 * @return true if we can continue or false if not
	 */
	public boolean getManagerSsn() {
		
		
		
		
		return true;
	}

}
