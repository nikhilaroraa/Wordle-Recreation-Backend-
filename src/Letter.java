
public class Letter {

/*
 * Letter character private variable
 */
	private char letter;

/*
 * Label integer private variable
 */
	
	private int label;
	
/*
 * Private variables for possible values of the "label" instance variable with unique values
 */
	private static final int UNSET = 1;
	private static final int UNUSED = 2;
	private static final int USED = 3;
	private static final int CORRECT = 4;

/*
 * This method is used to initialize the label value to UNSET and the letter variable as well
 * @param label label value
 * @param letter letter value
 */
	public Letter(char c) {
		label = UNSET;
		letter = c;
	}

/*
 * This method is used to compare the letter attributes of the otherObject and this object 
 */	
	public boolean equals(Object otherObject) {
		if(otherObject instanceof Letter) {
			Letter object = (Letter) otherObject;
		//if statement used to check whether otherObject is of the class Letter
			if(this.letter == object.letter) {
				return true;
			//if statement used to compare the this letter attributes with the otherObject
			}
			return false;
		}
		return false;
	}

/*
 * This method is used to initialize the possible label value being USED, UNUSED, CORRECT, UNSET to corresponding values
 */	
	public String decorator() {
		if(label == USED) {
			return "+";
		//if statement used to return + value if the label value is USED
		}
	
		if(label == UNUSED) {
			return "-";
		//if statement used to return - value if the label value is UNUSED
		}
	
		if(label == CORRECT) {
			return "!";
		//if statement used to return ! value if the label value is CORRECT
		}
	
		if(label == UNSET) {
			return " ";
		//if statement used to return a space value if the label value is UNSET
		}
		return "";
	}

/*
 * This method is used to represent the letter and label using the correct form being "dCd"
 * @return decorator() + letter + decorator() used to return the correct format of the letter and label
 */	
	public String toString() {
		return decorator() + letter + decorator();
	}
/*
 * This method is used to set and change the value of the attribute label to UNUSED
 * @param label represent the UNUSED value
 */
	public void setUnused() {
		label = UNUSED;
	}

/*
 * This method is used to set and change the value of the attribute label to USED
 * @param label represent the USED value
 */
	public void setUsed() {
		label = USED;
	}

/*
 * This method is used to set and change the value of the attribute label to CORRECT
 * @param label represent the CORRECT value
 */
	public void setCorrect() {
		label = CORRECT;
	}

/*
 * This method is used to return true  if the value of the attribute label is UNUSED
 * @return label == UNUSED represents true if the label is equal to UNUSED 
 */
	public boolean isUnused() {
		return label == UNUSED;
	}

/*
 * This method is used to produce an array of objects to where the letter objects are stored in a correct order based on the way the characters appear
 */
	public static Letter[] fromString(String s) {
		Letter[] value = new Letter[s.length()];
		//new letter array created
		for(int i = 0; i<s.length(); i++) {
			value[i] = new Letter(s.charAt(i));
		//for loop created to go through and store letter objects in the same order as they appear
		}
		
		return value;
	}
}
