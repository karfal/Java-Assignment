package assignment;

import java.io.Serializable;

public class Box extends Container {
	
	
	private int grade;
	private int printing;
	private boolean reinforcedBottom;
	private boolean reinforcedCorners;
	private boolean sealableTop;
	private int quantity;
	private Types type;
	

	public Box(double width, double height, double length, int grade, int printing, boolean reinforcedBottom, boolean reinforcedCorners, boolean sealableTop, int quantity) {
		super(width, height, length);
		this.grade = grade;
		this.printing = printing;
		this.reinforcedBottom = reinforcedBottom;
		this.reinforcedCorners = reinforcedCorners;
		this.sealableTop = sealableTop;
		this.quantity = quantity;
	}//end constructor
	
	
	// --- Getters ---
	public int getGrade() {
		return grade;
	}
	
	public int getPrinting() {
		return printing;
	}
	
	public boolean getReinforcedBottom() {
		return reinforcedBottom;
	}
	
	public boolean getReinforcedCorners() {
		return reinforcedCorners;
	}
	
	public boolean getSealableTop() {
		return sealableTop;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public Types getType() {
		return type;
	}
	
	//set box type based from Validation class
	public void setType(Types type) {
		this.type = type;
	}
	
	
	@Override
	public double getContainerCost() {
		
		//convert values to meters
		double width = getWidth() / 100;
		double height = getHeight() / 100;
		double length = getLength() / 100;
		//based on entered we store the price of the grade box
		double gradeCost = Costs.BASICCOST[getGrade() - 1];
		
		//store total of percentages
		int percent = 0;
		
		//check which printing has been selected
		if(getPrinting() == 1) {
			percent = Costs.PRINT1;
		}
		else if(getPrinting() == 2) {
			percent = Costs.PRINT2;
		}
		
		//check which reinforcing has been checked
		if(getReinforcedBottom() == true) {
			percent += Costs.REINFORCEDBOTTOM;
		}
		if(getReinforcedCorners() == true) {
			percent += Costs.REINFORCEDCORNERS;
		}
		if(getSealableTop() == true) {
			percent += Costs.SEALABLETOP;
		}
		
		//total the sum of percentages
		percent += 100;
		
		//calculate the TSA of the box
		double area = 2 * ((length * width) + (width * height) + (height * length));
		//calculate basic cost of the box, and add costs of extra percentages
		double basicCost = (area * gradeCost) * getQuantity();
		double totalCost = (percent * basicCost) / 100;
		
		return totalCost;
		
	}//end getContainerCost
	
	@Override
	public String toString() {
		return String.format("%s\nGrade: %d\nColour printing: %d\nBottom: %b\nCorners: %b\nSealable top: %b\nQuantity: %d\nType: %s\nPrice: %.2f", 
				super.toString(), getGrade(), getPrinting(), getReinforcedBottom(), getReinforcedCorners(), getSealableTop(), getQuantity(), getType(), getContainerCost());
	}//end toString
	

}//end class
