package com.homework.swing;

import java.awt.EventQueue;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SchoolManagerApp {
	
	static class Employee {
		int id;
		String name;
		Employee(int newId, String newName) {
			id = newId;
			name = newName;
		}
		
		protected int getId() {
			return id;
		}

		protected void setId(int id) {
			this.id = id;
		}

		protected String getName() {
			return name;
		}

		protected void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + "]";
		}
		
	}
	
	static class Acadamic extends Employee {
		double courseRate;

		protected Acadamic(int newId, String newName, double courseRate) {
			super(newId, newName);
			this.courseRate = courseRate;
		}

		protected double getCourseRate() {
			return courseRate;
		}

		protected void setCourseRate(double courseRate) {
			this.courseRate = courseRate;
		}

		@Override
		public String toString() {
			return "Acadamic [courseRate=" + courseRate + ", id=" + id + ", name=" + name + "]";
		}
		
	}
	
	static class NonAcadamic extends Employee {
		double hourlyRate;

		protected NonAcadamic(int newId, String newName, double hourlyRate) {
			super(newId, newName);
			this.hourlyRate = hourlyRate;
		}

		protected double getHourlyRate() {
			return hourlyRate;
		}

		protected void setHourlyRate(double hourlyRate) {
			this.hourlyRate = hourlyRate;
		}

		@Override
		public String toString() {
			return "NonAcadamic [hourlyRate=" + hourlyRate + ", id=" + id + ", name=" + name + "]";
		}

		
	}
	
	static class Lecturer extends Acadamic {
		int nbrPubs;

		protected Lecturer(int newId, String newName, double courseRate, int nbrPubs) {
			super(newId, newName, courseRate);
			this.nbrPubs = nbrPubs;
		}

		protected int getNbrPubs() {
			return nbrPubs;
		}

		protected void setNbrPubs(int nbrPubs) {
			this.nbrPubs = nbrPubs;
		}

		@Override
		public String toString() {
			return "Lecturer [nbrPubs=" + nbrPubs + ", courseRate=" + courseRate + ", id=" + id + ", name=" + name
					+ "]";
		}
		
	}
	
	static class SecurityGuard extends NonAcadamic {
		String areaAssigned;

		protected SecurityGuard(int newId, String newName, double hourlyRate, String areaAssigned) {
			super(newId, newName, hourlyRate);
			this.areaAssigned = areaAssigned;
		}

		protected String getAreaAssigned() {
			return areaAssigned;
		}

		protected void setAreaAssigned(String areaAssigned) {
			this.areaAssigned = areaAssigned;
		}

		@Override
		public String toString() {
			return "SecurityGuard [areaAssigned=" + areaAssigned + ", hourlyRate=" + hourlyRate + ", id=" + id + ", name=" + name + "]";
		}
		
	}

	private JFrame frame;

	private JButton btnSave;
	private JButton btnView;
	
	private JRadioButton rbtnTeacher;
	private JRadioButton rdbtnSecurityGuard;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel labRateType;
	private JLabel lblCustomValue;
	private JTextField txtEmpId;
	private JTextField txtName;
	private JFormattedTextField fxtRate;
	private JTextField txtCustomValue;
	private JButton btnAdd;
	
	private List<Employee> empList = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchoolManagerApp window = new SchoolManagerApp();
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
	public SchoolManagerApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 356, 261);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblEmployeeDetails = new JLabel("Employee Details");
		frame.getContentPane().add(lblEmployeeDetails, BorderLayout.NORTH);
		
		JToolBar barButtons = new JToolBar();
		frame.getContentPane().add(barButtons, BorderLayout.SOUTH);
		
		btnSave = new JButton("Save");
		btnSave.setEnabled(false);
		barButtons.add(btnSave);
		
		btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empList.forEach(System.out::println);
			}
		});
		btnView.setEnabled(false);
		barButtons.add(btnView);
		
		JPanel pnlMainArea = new JPanel();
		pnlMainArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(pnlMainArea, BorderLayout.CENTER);
		pnlMainArea.setLayout(null);
		
		rbtnTeacher = new JRadioButton("Teacher");
		rbtnTeacher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labRateType.setText("Course Rate");
				lblCustomValue.setText("# of Publications:");
				fxtRate.setText("");
				txtCustomValue.setText("");
				checkButtonState();
			}
		});
		rbtnTeacher.setSelected(true);
		rbtnTeacher.setBounds(100, 17, 81, 23);
		pnlMainArea.add(rbtnTeacher);
		
		rdbtnSecurityGuard = new JRadioButton("Security Guard");
		rdbtnSecurityGuard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labRateType.setText("Hourly Rate");
				lblCustomValue.setText("Area Assigned");
				fxtRate.setText("");
				txtCustomValue.setText("");
				checkButtonState();
			}
		});
		rdbtnSecurityGuard.setBounds(189, 17, 141, 23);
		pnlMainArea.add(rdbtnSecurityGuard);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rbtnTeacher);
		radioGroup.add(rdbtnSecurityGuard);
		
		JLabel lblNewLabel = new JLabel("Role");
		lblNewLabel.setBounds(52, 18, 36, 23);
		pnlMainArea.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("EmployeeID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(42, 53, 99, 16);
		pnlMainArea.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(42, 81, 99, 16);
		pnlMainArea.add(lblNewLabel_2);
		
		labRateType = new JLabel("Course Rate:");
		labRateType.setHorizontalAlignment(SwingConstants.RIGHT);
		labRateType.setBounds(42, 105, 99, 16);
		pnlMainArea.add(labRateType);
		
		lblCustomValue = new JLabel("# of Publications:");
		lblCustomValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomValue.setBounds(31, 133, 110, 16);
		pnlMainArea.add(lblCustomValue);
		
		txtEmpId = new JTextField();
		txtEmpId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkButtonState();
			}
		});
		txtEmpId.setBounds(153, 48, 130, 26);
		pnlMainArea.add(txtEmpId);
		txtEmpId.setColumns(10);
		
		txtName = new JTextField();
		txtName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkButtonState();
			}
		});
		txtName.setBounds(153, 76, 130, 26);
		pnlMainArea.add(txtName);
		txtName.setColumns(10);
		
		fxtRate = new JFormattedTextField(NumberFormat.INTEGER_FIELD);
		fxtRate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkButtonState();
			}
		});
		fxtRate.setText("");
		fxtRate.setBounds(153, 100, 130, 26);
		pnlMainArea.add(fxtRate);
		
		txtCustomValue = new JTextField();
		txtCustomValue.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkButtonState();
			}
		});
		txtCustomValue.setBounds(153, 128, 130, 26);
		pnlMainArea.add(txtCustomValue);
		txtCustomValue.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewEmployee();
			}
		});
		btnAdd.setEnabled(false);
		btnAdd.setBounds(116, 161, 117, 29);
		pnlMainArea.add(btnAdd);
		
		// Initialize the buttons
		checkButtonState();
		
	}
	
	/**
	 * This will be called after each text field is changed to see if we can add.
	 * Also if the List of strings for each entered employee is not empty then the
	 * View button will also be enabled for viewing the list of entered employees
	 * 
	 */
	private void checkButtonState() {
		boolean addBtnDisabled = (!txtEmpId.getText().isEmpty() && !txtName.getText().isEmpty() && !fxtRate.getText().isEmpty() && !txtCustomValue.getText().isEmpty());
		btnAdd.setEnabled(addBtnDisabled);
		
		// Now see if there is anything to view
		btnView.setEnabled(!empList.isEmpty());
	}
	
	/**
	 * This will take the inputs and save a
	 * string of the entries
	 */
	private void addNewEmployee() {

		if (rbtnTeacher.isSelected()) {
			Lecturer lec = new Lecturer(Integer.parseInt(txtEmpId.getText()), txtName.getText(), Double.parseDouble(fxtRate.getText()), Integer.parseInt(txtCustomValue.getText()));
			empList.add(lec);
		} else {
			SecurityGuard sg = new SecurityGuard(Integer.parseInt(txtEmpId.getText()), txtName.getText(), Double.parseDouble(fxtRate.getText()), txtCustomValue.getText());
			empList.add(sg);
		}
		
		txtEmpId.setText("");
		txtName.setText("");
		fxtRate.setText("");
		txtCustomValue.setText("");
		
		checkButtonState();
		
	}
		
}
