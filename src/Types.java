package assignment;

/*
 * Types can be added here
 */

public enum Types {
	
	TYPE_1(1),
	TYPE_2(2),
	TYPE_3(3),
	TYPE_4(4),
	TYPE_5(5);
	
	private final int value;
	
	Types(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

}//end enum
