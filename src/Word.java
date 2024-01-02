public class Word {

/*
 * Node private variable referencing the first node in the linked list
 */
	private LinearNode<Letter> firstLetter;

/*
 * This method is used to initialize the Word object to allow for the letter objects to be stores within a linked structure
 */
	public Word (Letter[] letters) {
		LinearNode<Letter> nextLetterNode = null;
		//creating and setting the nextLetterNode to null
		for (int i = letters.length - 1; i >= 0; i--) {
			LinearNode<Letter> letterNode = new LinearNode<Letter>(letters[i]);
			letterNode.setNext(nextLetterNode);
			nextLetterNode = letterNode;
		//for loop created to work backwards and set letters in the correct place as needed
		}
	firstLetter = nextLetterNode;
}

/*
 * This method is used to create a string in the correct form to show the word and letter values as well as the corresponding label values
 * @param display used to display the letters and correct format to display the word
 * @return returns the display value
 */
	public String toString() {
		String display = "Word:";
		LinearNode<Letter> node = firstLetter;
		while(node != null) {
			display += " " + node.getElement().toString();
			node = node.getNext();
		//while loop created which creates the proper format and gets the letters and decorator values by calling other methods needed
		}
		display += " ";
		return display;
	}
/*
 * This method is used to take a mystery word and update each letter value with the correct label attribute 
 */
	public boolean labelWord(Word mystery) {
		LinearNode<Letter > currentNode = this.firstLetter;
		int i = 0;
		//create integer value i to compare mystery word and the content value
		boolean isIdentical = true;
		//boolean condition created to equal true if the mystery word and content are equal
		while (currentNode != null) {
		LinearNode<Letter> mysteryNode = mystery.firstLetter;
		int j = 0;
		//create integer value j to compare mystery word and the content value
		
		boolean isLetterCorrect = false;
		//boolean condition created to equal false if the letters are not correct 
		currentNode.getElement().setUnused();
		//used to set letter objects to unused if the letter values are not correct
			while (mysteryNode != null){
				if(currentNode.getElement().equals(mysteryNode.getElement())) {
				//if statement used to compare the content values and the mystery word
					if(i == j) {
						currentNode.getElement().setCorrect();	
						isLetterCorrect = true;
					//if statement used to set letter values to correct if the mystery word is equal to the content value
					} else if (currentNode.getElement().isUnused()){
							currentNode.getElement().setUsed();
							}
					}
				mysteryNode = mysteryNode.getNext();
				j++;
				//used to get next letter value until all letter values are compared from the mystery word
				}
			isIdentical = isIdentical&&isLetterCorrect;	
			currentNode = currentNode.getNext();
			i++;
			//used to get next letter value until all letter values are compared from the content values
			}
		return isIdentical;
		}
	}