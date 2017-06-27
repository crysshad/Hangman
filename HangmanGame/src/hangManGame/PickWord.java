package hangManGame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PickWord extends HangmanLogic {

	String wordSelected = "";

	public String pickCategory() {

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

		this.wordSelected = wordSelected;

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

		return "Fruit";
	}

	/******************************************************************************
	 * Getter and Setter
	 *******************************************************************************/

	public void settWord(String fw) {

		this.wordSelected = fw;
	}

	public String getWord() {

		return wordSelected;

	}

}
