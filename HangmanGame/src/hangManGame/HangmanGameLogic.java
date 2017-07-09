package hangManGame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGameLogic extends HangmanCategory {

	// Variables in pickWord()
	public String wordSelected = "";
	public String[] wordArray;
	public int wordSize;

	// Variable in prompt(), checkGuessedLetter, alreadyGuessed(),stillHasChance
	public char userEnter;
	public String guessedLetter;
	public int maxNumOftries = 5;
	public char[] badGuessedLetter = new char[maxNumOftries];
	public int numOfBadGuess;
	public int numOfTriesLeft = maxNumOftries;
	public int numOfGoodGuess;
	public char[] alreadyGuessedCorrectLetter;
	public int index = 0;
	String userEnterString;
	public String[] alreadyGuessedLetter;

	/******************************************************************************
	 * Select a random word
	 *******************************************************************************/
	public String pickWord() {

		/*
		 * show user the possible selections
		 */

		System.out.println("Category" + Arrays.toString(super.category));

		/*
		 * ask user to select a category
		 */

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the category you want to select: ");
		String userCategorySelection = scan.next();

		boolean match = false;

		/*
		 * check if the user selection matches a category selection then output
		 * the category otherwise ask user to retry
		 */

		do {

			if (userCategorySelection.equals(super.category[0]) || userCategorySelection.equals(super.category[1])) {

				System.out.println("You have chosen" + " " + userCategorySelection);

				match = true;
			}

			else {

				System.out.println("Please enter one of the selection shown on the list above");
				System.out.println("Enter the category you want to select: ");
				userCategorySelection = scan.next();
				match = false;
			}

		}

		while (match == false);

		/*
		 * Randomly select a word from the category selected by the user Store
		 * the word in category fruit in fruitWordSelected Store the word in
		 * category clothingItem in clothingWordSelected
		 **/

		Random random = new Random();

		if (userCategorySelection.equals("fruit")) {

			String fruitList[] = super.fruit;
			System.out.println("Category" + Arrays.toString(fruitList));

			int fruitIndex = random.nextInt(fruitList.length);
			System.out.println(fruitList[fruitIndex]);

			wordSelected = fruitList[fruitIndex];
		}

		else {

			String clothingItemList[] = super.clothingItem;
			System.out.println("Category" + Arrays.toString(clothingItemList));

			int clothingIndex = random.nextInt(clothingItemList.length);
			System.out.println(clothingItemList[clothingIndex]);
			wordSelected = clothingItemList[clothingIndex];
		}

		// Convert String wordSelected to a String array
		wordArray = wordSelected.split("(?!^)");
		System.out.println("The choosen word array is " + Arrays.toString(wordArray));

		// Set the size of the wordArray to "wordSize"
		wordSize = wordArray.length;

		/*
		 * Now I know the size of the wordArray, I can set the size of the
		 * alreadyGuessedCorrectLetter array otherwise I will run into a null
		 * pointer exception in checkGuessedLetter()
		 */
		alreadyGuessedCorrectLetter = new char[wordSize];

		// Set the size of alreadyGuessedLetter to selected word size + 5

		alreadyGuessedLetter = new String[wordSize + maxNumOftries];
		System.out.println("It is a " + wordSize + " letter word");

		return wordSelected;

	}

	/******************************************************************************
	 * Ask user to enter a letter until win or lose the game
	 *******************************************************************************/

	public char prompt() {

		do {

			Scanner scan = new Scanner(System.in);
			// Ask user to enter a letter
			System.out.println("Enter a letter ");

			// Set char userEnter to the first character of user entered string
			userEnter = scan.nextLine().charAt(0);
			/*
			 * Save the userEnter character in a String variable so I can use
			 * Arrays.asList(array).contains(x) in later methods
			 */
			userEnterString = String.valueOf(userEnter);
			System.out.println("User entered " + userEnter);

			// Check if user entered letter is good or bad guess
			checkGuessedLetter(alreadyGuessedCorrectLetter, alreadyGuessedLetter);

			/*
			 * Determine if the user win or lost the game based of return value
			 * of stillHasChance()
			 */
			if (numOfGoodGuess == wordSize) {

				System.out.println("You did it ^-^ !");

			}

			if (numOfTriesLeft == 0) {

				System.out.println("Go home -_- ");

			}

			System.out.println("number of tries " + numOfTriesLeft);

		}

		while (stillHasChance() == true);
		return userEnter;
	}

	/******************************************************************************
	 * Check of the user entered letter matches the letter in the
	 * alreadyGuessedLetter String array if so, inform user the letter is
	 * already guessed
	 *******************************************************************************/
	public boolean alreadyGuessed(String[] alreadyGuessedLetter) {

		if (Arrays.asList(alreadyGuessedLetter).contains(userEnterString)) {

			System.out.println("Letter already guessed");

			return true;
		}

		return false;
	}

	/******************************************************************************
	 * Check if the user enter letter match the letters in the wordArray
	 *******************************************************************************/
	public char checkGuessedLetter(char[] correctGuessedLetter, String[] alreadyGuessedLetter) {

		// Need to add the occurrences and the index of the user enter letter

		/*
		 * If the user entered letter exist in the word array then store the
		 * userEnter value in correctGuessedLetter Char array and increment the
		 * numOfGoodGuess
		 */
		if (Arrays.asList(wordArray).contains(userEnterString) && alreadyGuessed(alreadyGuessedLetter) == false) {

			System.out.println(
					"Print the correct guessed char index" + Arrays.asList(wordArray).indexOf(userEnterString));

			correctGuessedLetter[Arrays.asList(wordArray).indexOf(userEnterString)] = userEnter;
			System.out.println("Print the correct guessed char " + Arrays.toString(correctGuessedLetter));

			numOfGoodGuess++;

		}

		/*
		 * If the user entered letter does not exist in the word array then
		 * store the userEnter value in badGuessedLetter Char array and
		 * increment the numOfBadGuess and decrease the numOfTriesLeft count
		 */
		if (!Arrays.asList(wordArray).contains(userEnterString) && alreadyGuessed(alreadyGuessedLetter) == false) {

			badGuessedLetter[numOfBadGuess] = userEnter;
			System.out.println("Print the bad guessed char " + Arrays.toString(badGuessedLetter));
			numOfBadGuess++;
			numOfTriesLeft = badGuessedLetter.length - numOfBadGuess;

		}

		// Add each guessed letter (good and bad) in a char array for
		// alreadyGuessed()
		alreadyGuessedLetter[index] = userEnterString;
		index++;
		;

		return userEnter;

	}

	public boolean stillHasChance() {

		if (numOfTriesLeft == 0) {

			return false;
		}

		if (numOfGoodGuess == wordSize) {

			return false;

		}

		else {

			return true;
		}

	}

}
