package com.acf.samples.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Component;

public class AppWindowSample {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindowSample window = new AppWindowSample();
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
	public AppWindowSample() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mnSave = new JMenuItem("Save");
		mnFile.add(mnSave);
		
		JPanel pnlStatusBar = new JPanel();
		pnlStatusBar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		frame.getContentPane().add(pnlStatusBar, BorderLayout.SOUTH);
		pnlStatusBar.setLayout(new BorderLayout(0, 0));
		
		JLabel lblStatusArea = new JLabel("Status Area Messages");
		lblStatusArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlStatusBar.add(lblStatusArea, BorderLayout.CENTER);
		
		JLabel lblTimeOfDay = new JLabel("23:55:55");
		lblTimeOfDay.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlStatusBar.add(lblTimeOfDay, BorderLayout.EAST);
		
		JPanel pnlEditsAndButtons = new JPanel();
		frame.getContentPane().add(pnlEditsAndButtons, BorderLayout.CENTER);
		pnlEditsAndButtons.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnlEditsAndButtons.add(toolBar, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("New button");
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		toolBar.add(btnNewButton_1);
	}

}
