package assignment;

public class Validate {
	
	//Enum Type reference
	private static final Types[] boxChoice = { Types.TYPE_1, Types.TYPE_2, Types.TYPE_3, Types.TYPE_4, Types.TYPE_5 };
	//Box type reference
	private Box box;
	
	
	public Validate(Box box) {
		this.box = box;
	}//end constructor
	
	
	public Types validateType() {
		
		int value = 1;
		
		//check box values and return TYPE based on these values
		if((box.getGrade() >= 1 && box.getGrade() <= 3) && (box.getPrinting() == 0) && (box.getReinforcedBottom() == false && box.getReinforcedCorners() == false)) {
			value = 1;
		}
		else if((box.getGrade() >= 2 && box.getGrade() <= 4) && (box.getPrinting() == 1) && (box.getReinforcedBottom() == false && box.getReinforcedCorners() == false)) {
			value = 2;
		}
		else if((box.getGrade() >= 2 && box.getGrade() <= 5) && (box.getPrinting() == 2) && (box.getReinforcedBottom() == false && box.getReinforcedCorners() == false)) {
			value = 3;
		}
		else if((box.getGrade() >= 2 && box.getGrade() <= 5) && (box.getPrinting() == 2) && (box.getReinforcedBottom() == true && box.getReinforcedCorners() == false)) {
			value = 4;
		}
		else if((box.getGrade() >= 3 && box.getGrade() <= 5) && (box.getPrinting() == 2) && (box.getReinforcedBottom() == true && box.getReinforcedCorners() == true)) {
			value = 5;
		}
		else {
			value = 0;
		}
		
		if(value != 0) {
			//set box type based on value
			box.setType(boxChoice[value - 1]);
			return boxChoice[value - 1];
		}
		else
			return null;
		
	}//end validate
	
	
	public boolean canProcess() {
		
		if(validateType() != null) {
			return true;
		}
		else
			return false;
		
	}// returnType
	
	
}//end class
