package hangManGame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PickWord extends HangmanLogic {

	public String pickCategory() {

		// show user the possible selections
		System.out.println("Category" + Arrays.toString(super.category));

		
		// ask user to select a category
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the category you want to select: ");
		String userCategorySelection = scan.next();
		
		boolean match = false;
		
		do {

			/*
			 * if the user selection matches a category selection then output the
			 * category otherwise ask user to retry
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
		
		 Random random = new Random();
		 
		 String fruitWordSelected = "apple";
		 String clothingWordSelected = "shoe";
		//retrieve a list of words based on the category selected
		  if (userCategorySelection.equals("fruit")){
		  
			  String fruitList[]=super.fruit;
			  System.out.println("Category" + Arrays.toString(fruitList));
			  
			 
			  int fruitIndex = random.nextInt(fruitList.length);
			  System.out.println(fruitList[fruitIndex]);
			  
			  fruitWordSelected = fruitList[fruitIndex];
		  }
		  
		 else{
			 
			 String clothingItemList[]=super.clothingItem;
			 System.out.println("Category" + Arrays.toString(clothingItemList));
			 
			 int clothingIndex = random.nextInt(clothingItemList.length);
			  System.out.println(clothingItemList[clothingIndex]);
			  clothingWordSelected = clothingItemList[clothingIndex];
		 }
		
		  
		  System.out.println(fruitWordSelected);
		  System.out.println(clothingWordSelected);

		return "Fruit";
	}

}
