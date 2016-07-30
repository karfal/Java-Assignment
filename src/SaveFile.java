package assignment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class SaveFile extends JFrame {
	
	
	private ArrayList<Box> orders;
	
	
	public SaveFile(ArrayList<Box> orders) {
		super("Save File");
		this.orders = orders;
		
		saveFile();
	}//end constructor	
	
	
	//allow user to save file to chosen directory
	private void saveFile() {
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save file");
		
		int selection = fileChooser.showSaveDialog(this);
		
		if(selection == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			saveOrders(file);
		}//end if
		
	}//end saveFile
	
	/**
	 * Save the orders to a file
	 * @param file the file to save to
	 */
	private void saveOrders(File file) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(orders);
			out.close();
		} catch (Exception e) {
			System.err.println("Error saving orders to file");
		}
	}//end saveOrders
	
}//end class
