package com.homework.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingVisibilityGames {

	private JFrame frame;
	
	// This is for question 3
	private List<JCheckBox> activities = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingVisibilityGames window = new SwingVisibilityGames();
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
	public SwingVisibilityGames() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 394, 203);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTop = new JPanel();
		frame.getContentPane().add(pnlTop, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Age Group");
		pnlTop.add(lblNewLabel);
		
		
		// Here are the two age group buttons.  Nothing big here
		JRadioButton rbtnGroup1 = new JRadioButton("9 - 12");
		rbtnGroup1.setSelected(true);
		pnlTop.add(rbtnGroup1);
		
		JRadioButton rbnGroup2 = new JRadioButton("13 - 15");
		pnlTop.add(rbnGroup2);
		
		ButtonGroup rbtnGrouper = new ButtonGroup();
		rbtnGrouper.add(rbtnGroup1);
		rbtnGrouper.add(rbnGroup2);
		
		JPanel pnlBottom = new JPanel();
		frame.getContentPane().add(pnlBottom, BorderLayout.SOUTH);
		
		// Just add a button-click event and clear all the selected
		// values in all the JComboBoxes in your activities list
		JButton btnClearFields = new JButton("Clear Fields");
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activities.forEach(thisBox -> thisBox.setSelected(false));
			}
		});
		pnlBottom.add(btnClearFields);
		
		JLabel lblNewLabel_1 = new JLabel("Select Mentor");
		pnlBottom.add(lblNewLabel_1);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Andrew Jones", "William Harris", "Mary Movis"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		pnlBottom.add(list);
		
		JPanel pnlMiddle = new JPanel();
		frame.getContentPane().add(pnlMiddle, BorderLayout.CENTER);
		
		// Here is the checkbox control and notice the mouse listener for
		// each time the checkbox is clicked then the mentor panel will appear
		// or disappear depending on the age group and if guidence is wanted.
		JCheckBox chkCareerGuidence = new JCheckBox("Career Guidence");
		chkCareerGuidence.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlBottom.setVisible(chkCareerGuidence.isSelected() && rbnGroup2.isSelected());
			}
		});
		pnlMiddle.add(chkCareerGuidence);
		
		rbtnGroup1.setSelected(true);
		rbnGroup2.setSelected(false);
		chkCareerGuidence.setSelected(false);
		
		pnlMiddle.setVisible(false);
		pnlBottom.setVisible(false);
		
		
		// Add a click event and check if the various
		// panels should be visibile or not
		rbtnGroup1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlMiddle.setVisible(rbnGroup2.isSelected());
				pnlBottom.setVisible(rbnGroup2.isSelected() && chkCareerGuidence.isSelected());
			}
		});

		// Add a click event and check if the various
		// panels should be visibile or not
		rbnGroup2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlMiddle.setVisible(rbnGroup2.isSelected());
				pnlBottom.setVisible(rbnGroup2.isSelected() && chkCareerGuidence.isSelected());
			}
		});
		
		// for question add your activities check boxes to your 
		// activities list.  Just remove the comments and use the 
		// actual names of the check boxes you used in your program
		
		// activities.add(chkCampusTours);
		// activities.add(chkFieldTrips);
		// activities.add(chkGames);
		// activities.add(chkIndustryVisits);
		
		
		
	}
	
}
