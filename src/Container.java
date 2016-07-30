package assignment;

import java.io.Serializable;

/*
 * GENERIC ABSTRACT CLASS
 * Container class contains minimum characteristics for a containing shape
 */

public abstract class Container implements ContainerCosting, Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private double width;
	private double height;
	private double length;
	

	public Container(double width, double height, double length) {
		this.width = width;
		this.height = height;
		this.length = length;
	}//end constructor
	
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getLength() {
		return length;
	}

	
	@Override
	public String toString() {
		return String.format("Width: %.2f\nHeight: %.2f\nLength: %.2f", 
				getWidth(), getHeight(), getLength());
	}//end toString
	

}//end class
