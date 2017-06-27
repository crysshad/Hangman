import java.util.Arrays;
import java.util.regex.PatternSyntaxException;

import hangManGame.HangmanLogic;
import hangManGame.PickWord;

public class Hangman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HangmanLogic hml = new HangmanLogic();
		PickWord pw = new PickWord();
		
		//Generate random letters
		
		/*final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    final int N = alphabet.length(); //length=26

	    Random r = new Random();

	    for (int i = 0; i < 1; i++) {
	        System.out.print(alphabet.charAt(r.nextInt(N)));
	    }*/

	    
	    pw.pickCategory();
	    
	    String word = pw.getWord();
	    
	    System.out.print(word);
	  
	    String[] wordArray = word.split("(?!^)");
	    System.out.println(Arrays.toString(wordArray));
	   
	}

}
