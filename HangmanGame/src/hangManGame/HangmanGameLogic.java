package hangManGame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGameLogic extends HangmanCategory {

	// Variables in pickWord()
	public String wordSelected = "";
	public String[] wordArray;
	public int wordSize;

	// Variable in prompt()
	public char userEnter;
	public String guessedLetter;
	public int maxNumOftries = 5;
	public char[] badGuessedLetter = new char[maxNumOftries];
	public int numOfBadGuess;
	public int numOfTriesLeft;
	public int numOfGoodGuess;
	public char[] alreadyGuessedCorrectLetter;
	

	public String pickWord() {

		/******************************************************************************
		 * show user the possible selections
		 *******************************************************************************/

		System.out.println("Category" + Arrays.toString(super.category));

		/******************************************************************************
		 * ask user to select a category
		 *******************************************************************************/

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the category you want to select: ");
		String userCategorySelection = scan.next();

		boolean match = false;

		do {

			/*
			 * if the user selection matches a category selection then output
			 * the category otherwise ask user to retry
			 */
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

		/******************************************************************************
		 * Randomly select a word from the category selected by the user Store
		 * the word in category fruit in fruitWordSelected Store the word in
		 * category clothingItem in clothingWordSelected
		 *******************************************************************************/

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

		wordArray = wordSelected.split("(?!^)");
		System.out.println("The choosen word array is " + Arrays.toString(wordArray));

		wordSize = wordArray.length;
		
		alreadyGuessedCorrectLetter = new char[wordSize];
		System.out.println("It is a " + wordSize + " letter word");

		return wordSelected;

	}

	/******************************************************************************
	 * Ask user to enter a letter
	 *******************************************************************************/

	public char prompt() {

		do {

			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a letter ");
			userEnter = scan.nextLine().charAt(0);

			System.out.println("User entered " + userEnter);

			checkGuessedLetter(alreadyGuessedCorrectLetter);

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
	 * Save the letter in an array of size 5
	 *******************************************************************************/
	
	public char checkGuessedLetter(char[] correctGuessedLetter) {

		
		String userEnterString = String.valueOf(userEnter);

		if (Arrays.asList(wordArray).contains(userEnterString)) {

			System.out.println(
					"Print the correct guessed char index" + Arrays.asList(wordArray).indexOf(userEnterString));

			correctGuessedLetter[Arrays.asList(wordArray).indexOf(userEnterString)] = userEnter;
			System.out.println("Print the correct guessed char " + Arrays.toString(correctGuessedLetter));
			numOfTriesLeft = 1;
			numOfGoodGuess++;
			
			
			
		}

		if (!Arrays.asList(wordArray).contains(userEnterString)) {

			badGuessedLetter[numOfBadGuess] = userEnter;
			System.out.println("Print the bad guessed char " + Arrays.toString(badGuessedLetter));
			numOfBadGuess++;
			numOfTriesLeft = badGuessedLetter.length - numOfBadGuess;

		}

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
