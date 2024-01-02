public class WordLL {

/*
 * private word variable
 */
	private Word mysteryWord;

/*
 * Node private variable referencing the past guesses
 */
	private LinearNode<Word> history;

/*
 * This method is used to initialize the history value and mystery word to corresponding values
 * @param history initialized to an empty value
 * @param this.mysteryWord initalized to mystery
 */
	public WordLL(Word mystery) {
		history = null;
		this.mysteryWord = mystery;
	}

/*
 * This method is used to take a word and test it against the mystery word
 * @return correctValue represents the guessed word
 */
	public boolean tryWord(Word guess) {
		boolean correctValue = guess.labelWord(mysteryWord);
		//boolean value used to call the labelWord method and input the mystery word
		LinearNode<Word> guessNode = new LinearNode<Word>(guess);

		guessNode.setNext(history);
		history = guessNode;
		//This adds the guess to the front of history
		
		return correctValue;
	}

/*
 * This method is used to create a string in the correct form to represent past guesses with the most recent guesses first
 * @param display used to display the letters and correct format to display the word
 * @return returns the display value
 */
	public String toString() {
		LinearNode <Word> nodeHistory = history;
		String display = "";
		while (nodeHistory != null) {
			display += nodeHistory.getElement().toString() + "\n";
			nodeHistory = nodeHistory.getNext();
		//while loop created which creates the proper format and gets the letters and values by calling other methods needed
		}
		return display;
	}
	
	
}
