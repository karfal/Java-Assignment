package assignment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Gui extends JFrame {
	
	// --- GUI References ---
	private JPanel panel;
	private JButton processButton;	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JTextField width;
	private JTextField height;
	private JTextField length;	
	private JTextField quantity;
	private JComboBox combo;
	private ButtonGroup radioGroup;
	private JRadioButton radio1;
	private JRadioButton radio2;
	private JRadioButton radio3;
	private JCheckBox check1;
	private JCheckBox check2;
	private JCheckBox check3;
	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem menuItem1;
	private JMenuItem menuItem2;
	private JMenuItem menuItem3;
	private JTable tblOrderList;
	private JScrollPane scrollTable;
	
	public ArrayList<Box> orderList = new ArrayList<Box>();
	
	private Box box;
	private Validate validate;
	//store number of grades
	private String[] grades = {"1","2","3","4","5"};
	
	
	public Gui() {
		super("Flexbox");
		
		//instantiate GUI objects
		panel = new JPanel();
		panel.setLayout(new FlowLayout());		
		menuBar = new JMenuBar();
		file = new JMenu("File");	
		menuItem1 = new JMenuItem("Exit");
		menuItem2 = new JMenuItem("Save");
		menuItem3 = new JMenuItem("Open");		
		processButton = new JButton("Process");
		label1 = new JLabel("Width");
		label2 = new JLabel("Height");
		label3 = new JLabel("Length");
		label4 = new JLabel("Quantity");
		label5 = new JLabel("Grade");
		label6 = new JLabel("Colours");
		label7 = new JLabel("Features");
		width = new JTextField(10);
		height = new JTextField(10);
		length = new JTextField(10);	
		quantity = new JTextField(5);
		combo = new JComboBox(grades);
		radio1 = new JRadioButton("No Colours", true);
		radio2 = new JRadioButton("One Colour");
		radio3 = new JRadioButton("Two Colours");
		check1 = new JCheckBox("Reinforced Bottom");
		check2 = new JCheckBox("Reinforced Corners");
		check3 = new JCheckBox("Sealable Top");
		//create logical relationship between RadioButtons
		radioGroup = new ButtonGroup();
		radioGroup.add(radio1);
		radioGroup.add(radio2);
		radioGroup.add(radio3);
		
		//add the table
		initTable(); //fill table init
		scrollTable = new JScrollPane(tblOrderList);
		scrollTable.setPreferredSize(new Dimension(1000,350));
		tblOrderList.setFillsViewportHeight(true);
		
		//layout structure
		this.setLayout(new BorderLayout());
		JPanel pnlRight = new JPanel();
		JPanel pnlCentre = new JPanel();
		this.add(pnlRight, BorderLayout.WEST);
		this.add(pnlCentre, BorderLayout.CENTER);
		
		//entry form
		pnlRight.setLayout(new BoxLayout(pnlRight, BoxLayout.Y_AXIS));
		JPanel pnlWidth = new JPanel();
		pnlWidth.setLayout(new FlowLayout());
		pnlWidth.add(label1);
		pnlWidth.add(width);
		
		JPanel pnlHeight = new JPanel();
		pnlHeight.setLayout(new FlowLayout());
		pnlHeight.add(label2);
		pnlHeight.add(height);
		
		JPanel pnlLength = new JPanel();
		pnlLength.setLayout(new FlowLayout());
		pnlLength.add(label3);
		pnlLength.add(length);
	
		JPanel pnlGrade = new JPanel();
		pnlGrade.setLayout(new FlowLayout());
		pnlGrade.add(label5);
		pnlGrade.add(combo);
		
		JPanel pnlColours = new JPanel();
		pnlColours.setLayout(new BoxLayout(pnlColours, BoxLayout.Y_AXIS));
		pnlColours.add(label6);
		pnlColours.add(radio1);
		pnlColours.add(radio2);
		pnlColours.add(radio3);
		
		JPanel pnlFeatures = new JPanel();
		pnlFeatures.setLayout(new BoxLayout(pnlFeatures, BoxLayout.Y_AXIS));
		pnlFeatures.add(label7);
		pnlFeatures.add(check1);
		pnlFeatures.add(check2);
		pnlFeatures.add(check3);
		
		JPanel pnlQuantity = new JPanel();
		pnlQuantity.setLayout(new FlowLayout());
		pnlQuantity.add(label4);
		pnlQuantity.add(quantity);
		
		pnlRight.add(pnlWidth);
		pnlRight.add(pnlHeight);
		pnlRight.add(pnlLength);
		pnlRight.add(pnlGrade);
		pnlRight.add(pnlColours);
		pnlRight.add(pnlFeatures);
		pnlRight.add(pnlQuantity);
		pnlRight.add(processButton);		
		
		//add table
		pnlCentre.add(scrollTable);
		
		file.add(menuItem3);
		file.add(menuItem2);
		file.addSeparator();
		file.add(menuItem1);
        menuBar.add(file);
        setJMenuBar(menuBar);
        
        menuItem2.setEnabled(false);
        setSize(1300, 450);
        setVisible(true);
		
		//register handlers
		MenuListener handler = new MenuListener();//main menu action listener
		menuItem1.addActionListener(handler);
		menuItem2.addActionListener(handler);
		menuItem3.addActionListener(handler);
		
		ButtonListener buttonHandler = new ButtonListener();//button action listener
		processButton.addActionListener(buttonHandler);
		
	}//end constructor
	
	
	//add columns of fields to table
	private void initTable() {
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Width");
		dtm.addColumn("Height");
		dtm.addColumn("Length");
		dtm.addColumn("Grade");
		dtm.addColumn("Number of Colours");
		dtm.addColumn("Reinforced Bottom");
		dtm.addColumn("Reinforced Corners");
		dtm.addColumn("Sealable Top");
		dtm.addColumn("Quantity");
		dtm.addColumn("Price");
		tblOrderList = new JTable();
		tblOrderList.setModel(dtm);
		
	}//end initTable
	
	
	//remove previous orders from table and repopulate with new entry
	public void refreshTable() {
		
		DefaultTableModel dtm = (DefaultTableModel)tblOrderList.getModel();

		//delete rows and trigger TableModelEvent to update the GUI
		dtm.setRowCount(0);
		
		//add current orders of box object values to the table
		for(Box b:orderList) {
			Object[] row = {b.getWidth(), b.getHeight(), b.getLength(), b.getGrade(), b.getPrinting(), b.getReinforcedBottom(), 
					b.getReinforcedCorners(), b.getSealableTop(), b.getQuantity(), b.getContainerCost()};
			dtm.addRow(row);
		}
		
		tblOrderList.setModel(dtm);
	}//end refreshTable
	
	
	//inner class for main menu action listener
	private class MenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			//close application
			if(event.getSource() == menuItem1) {
				System.exit(0);
			}
			//save file
			else if(event.getSource() == menuItem2 ) {
				SaveFile saveFile = new SaveFile(orderList);
				saveFile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			//open file
			else if(event.getSource() == menuItem3 ) {
				OpenFile openFile = new OpenFile(Gui.this);
				openFile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}//end actionPerformed method
		
	}//end MenuListener class
	
	
	//inner class for process button action listener
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == processButton) {
				validateAndParseInputs();
			}			
		}//end actionPerformed method
		
	}//end ButtonListener
	
	
	//validate user input and parse values to proper format
	private void validateAndParseInputs() {
		
		double boxWidth = 0;
		double boxHeight = 0;
		double boxLength = 0;
		int boxQuantity = 0;
		int grade = 0;
		int printing = 0;
		boolean bottom = false;
		boolean corners = false;
		boolean sealed = false;
		
		//parse necessary values
		try {
			boxWidth = Double.parseDouble(width.getText());
			boxHeight = Double.parseDouble(height.getText());
			boxLength = Double.parseDouble(length.getText());
			
			try {
				boxQuantity = Integer.parseInt(quantity.getText());
			}
			catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Please enter a whole number for Quantity", "Input Error", JOptionPane.WARNING_MESSAGE);
				menuItem2.setEnabled(false);
				return;
			}//end inner try/catch
			
			//do not process until all values are > then 0
			if(boxWidth == 0 || boxHeight == 0 || boxLength == 0 || boxQuantity == 0) {
				JOptionPane.showMessageDialog(this, "Values must be greater then 0", "Input Error", JOptionPane.PLAIN_MESSAGE);
				menuItem2.setEnabled(false);
				return;
			}//end if
			
		}
		catch(NumberFormatException  ex) {
			JOptionPane.showMessageDialog(this, "Please enter numbers in the provided text fields", "Input Error", JOptionPane.WARNING_MESSAGE);
			menuItem2.setEnabled(false);
			return;//do not proceed until all inputs are numeric
		}//end try/catch
		
		//parse JComboBox selection to String format and parse same String value to integer
		grade = Integer.parseInt((String) combo.getSelectedItem());
		
		//radio button selection (printing option)
		if(radio1.isSelected()) {
			printing = 0;
		}
		else if(radio2.isSelected()) {
			printing = 1;
		}
		else if(radio3.isSelected()) {
			printing = 2;
		}
		
		//check if reinforced bottom
		if(check1.isSelected()) {
			bottom = true;
		}
		//check if reinforced corners
		if(check2.isSelected()) {
			corners = true;
		}
		//check if sealed top
		if(check3.isSelected()) {
			sealed = true;
		}
		
		box = new Box(boxWidth, boxHeight, boxLength, grade, printing, bottom, corners, sealed, boxQuantity);
		validate = new Validate(box);
		validate.validateType();
		
		processOrder();
		
	}//end validateAndParseInputs
	
	
	//verify if the order can be processed
	private void processOrder() {
		
		if(validate.canProcess()) {
			JOptionPane.showMessageDialog(this, "Price of your order: $" + box.getContainerCost());
			//add box object to arraylist
			orderList.add(box);
			refreshTable();
			//set save menu button clickable
			menuItem2.setEnabled(true);
		}
		else {
			JOptionPane.showMessageDialog(this, "Your order cannot be processed", "Process Error", JOptionPane.INFORMATION_MESSAGE);
			//set save menu button unclickable
			menuItem2.setEnabled(false);
			orderList.remove(box);
		}
		System.out.println(box.toString());
		
	}// end makeProcess
	

}//end class
