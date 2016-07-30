package assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;


public class OpenFile extends JFrame {
	
	
	private Gui caller;
	
	
	public OpenFile(Gui caller) { //setup gui
		this.caller = caller;
		openFile();
	}//end constructor
	
	
	//open text file user selects
	private void openFile() {
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int selection = fileChooser.showOpenDialog(this);
		
		//revert to application if user selects cancel
		if(selection == JFileChooser.CANCEL_OPTION) {
			return;
		}
		
		//retrieve file chosen by user and pass reference to buffered reader
		File file = fileChooser.getSelectedFile();
		loadOrders(file);
		
		
	}//end openFile
	
	private void loadOrders(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fis);
			caller.orderList = (ArrayList<Box>) in.readObject();
			in.close();
			caller.refreshTable();
		} catch (Exception e) {
			System.err.println("Error loading orders from file");
			e.printStackTrace();
		}
	}//loadOrders
	
		
}//end class
