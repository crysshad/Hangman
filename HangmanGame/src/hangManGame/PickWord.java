package hangManGame;

import java.util.Arrays;
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

		
		  if (userCategorySelection.equals("fruit")){
		  
			  String fruitList[]=super.fruit;
			  System.out.println("Category" + Arrays.toString(fruitList));
		  }
		  
		 else{
			 
			 String clothingItemList[]=super.clothingItem;
			 System.out.println("Category" + Arrays.toString(clothingItemList));
		 }
		

		return "Fruit";
	}

}
