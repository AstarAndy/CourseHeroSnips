package com.homework;

import javax.swing.*;
import java.util.*;
import java.awt.EventQueue;
import java.awt.event.*;

class BWebb_AgeCalc extends JPanel{

	private JLabel lblName = new JLabel("Name:");
	private JLabel lblAge = new JLabel("Age:");
	private JTextField txtName = new JTextField(" ");
	private JTextField txtAge = new JTextField(" ");
	private JButton btnCalc = new JButton("Calculate");
	private JFrame window = new JFrame("Age Calculator/HoroScope");
	private JTextArea txtStuff = new JTextArea(" ");
	private JLabel lblMonth = new JLabel("Enter birth month:");
	private JLabel lblDay = new JLabel("Enter birth day:");
	private JTextField txtMonth = new JTextField(" ");
	private JTextField txtDay = new JTextField(" ");


	private int years; 
	private int months; 
	private int days; 
	private int hours; 
	private int minutes; 
	private int seconds; 
	private int day;


	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BWebb_AgeCalc frame = new BWebb_AgeCalc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BWebb_AgeCalc(){            

		setLayout(null);
		lblName.setBounds(10, 10, 80, 100);
		lblAge.setBounds(10, 30, 80, 100);
		txtName.setBounds(120, 50, 100, 25);
		txtAge.setBounds(120, 70, 100, 25);
		btnCalc.setBounds(250, 100, 90, 40);
		txtStuff.setBounds(10, 150, 300, 200);
		lblMonth.setBounds(10, 55, 120, 100);
		lblDay.setBounds(10, 75, 120, 100);
		txtMonth.setBounds(120, 100, 100, 25);
		txtDay.setBounds(120, 120, 100, 25);

		add(lblName);
		add(lblAge);
		add(txtName);
		add(txtAge);
		add(btnCalc);
		add(txtStuff);
		add(lblMonth);
		add(lblDay);
		add(txtMonth);
		add(txtDay);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 500);
		window.add(this);
		window.setVisible(true);

		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String name = txtName.getText();
				years = Integer.parseInt(txtAge.getText());
				day = Integer.parseInt(txtDay.getText());
				String month = txtMonth.getText();            


				months = years * 12; 
				days = 365 * years; 
				hours = 8760 * years; 
				minutes = 525600 * years; 
				seconds = 86400 * days; 



				txtName.setText(" ");
				txtAge.setText(" ");
				txtMonth.setText(" ");
				txtDay.setText(" ");

				// TODO: You have an error when calling showZodiac on the next line.  That method requires an int for month 
				// but you have it as a string.  
				//txtStuff.setText(name + "\n" + years + "\n" + months + "\n" + days + "\n" + hours + "\n" + minutes + "\n" + seconds + "\n" + month + "\n" + day + "\n" + showZodiac(month, day));

			}
		});
	}
	
	public String showZodiac(int month, int day){

		if((month == 12 && day >= 22 && day <= 31) || (month ==  1 && day >= 1 && day <= 19))
			txtStuff.setText("Capricorn");
		else if ((month ==  1 && day >= 20 && day <= 31) || (month ==  2 && day >= 1 && day <= 17))
			txtStuff.setText("Aquarius");
		else if ((month ==  2 && day >= 18 && day <= 29) || (month ==  3 && day >= 1 && day <= 19))
			txtStuff.setText("Pisces");
		else if ((month ==  3 && day >= 20 && day <= 31) || (month ==  4 && day >= 1 && day <= 19))
			txtStuff.setText("Aries");
		else if ((month ==  4 && day >= 20 && day <= 30) || (month ==  5 && day >= 1 && day <= 20))
			txtStuff.setText("Taurus");
		else if ((month ==  5 && day >= 21 && day <= 31) || (month ==  6 && day >= 1 && day <= 20))
			txtStuff.setText("Gemini");
		else if ((month ==  6 && day >= 21 && day <= 30) || (month ==  7 && day >= 1 && day <= 22))
			txtStuff.setText("Cancer");
		else if ((month ==  7 && day >= 23 && day <= 31) || (month ==  8 && day >= 1 && day <= 22))
			txtStuff.setText("Leo");
		else if ((month ==  8 && day >= 23 && day <= 31) || (month ==  9 && day >= 1 && day <= 22))
			txtStuff.setText("Virgo");
		else if ((month ==  9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22))
			txtStuff.setText("Libra");
		else if ((month == 10 && day >= 23 && day <= 31) || (month == 11 && day >= 1 && day <= 21))
			txtStuff.setText("Scorpio");
		else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day >= 1 && day <= 21))
			txtStuff.setText("Sagittarius");

		return "Zodiac not found";                                          


	}



}


