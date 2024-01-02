public class ExtendedLetter extends Letter{

/*
 * Content string private variable
 */
	private String content;

/*
 * Family integer private variable
 */
	private int family;

/*
 * Related boolean private variable
 */
	private boolean related;

/*
 * SINGLETON private variable initialized to constant value of -1
 */
	private final int SINGLETON = -1;

/*
 * This method is used to initialize instance variables to corresponding values
 * @param this.content initalized to s
 * @param this.related initialized to false
 * @param this.family initialized to this.SINGLETON
 */
	public ExtendedLetter(String s) {
		super('c');
		this.content = s;
		this.related = false;
		this.family = this.SINGLETON;
	}

/*
 * This method is used to initialize instance variables to corresponding values
 * @param this.content initalized to s
 * @param this.related initialized to false
 * @param this.family initialized to fam
 */
	public ExtendedLetter(String s, int fam) {
		super('c');
		this.content = s;
		this.related = false;
		this.family = fam;
	}

/*
 * This method is used to compare the family attributes of the other and this object 
 */
	public boolean equals(Object other) {
		if(other instanceof ExtendedLetter) {
		//if statement used to check whether other is of the class ExtendedLetter
			ExtendedLetter object = (ExtendedLetter) other;
			if(object.family == this.family) {
				this.related = true;
			//if statement used to check if the object and this family instance variables are equal
			}
		
			if (object.content == this.content) {
				return true;
			//if statement used to check if the object and this content instance variables are equal

			}
		
		}
		return false;
	}

/*
 * This method is used to create a string in the correct form to show the word and letter values as well as the corresponding label values
 */
	public String toString() {
		if (this.related && decorator() == "-") {
			return "." + this.content + ".";
		//if statement used to check if the extended letter value is unused and has a related value of true and return corresponding format
		}
		else {
			return decorator() + this.content + decorator();
		//else statement used to return the corresponding decorator values
		}
	}

/*
 * This method is used to create an array of the correct size and return them after storing
 * @return letters represents the letter array
 */
	public static Letter[] fromStrings(String[] content, int[] codes) {
		ExtendedLetter[] letters = new ExtendedLetter[content.length];
		if (codes != null) {
		for(int i = 0; i<content.length; i++) {
			letters[i] = new ExtendedLetter(content[i],codes[i]);
		}
		}
		else{
			for (int i = 0; i<content.length; i++) {
			letters[i] = new ExtendedLetter(content[i]);
		}
		}
		return letters;
	}

}
