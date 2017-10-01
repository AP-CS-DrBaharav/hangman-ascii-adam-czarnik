/**
 * 
 * HangMan in ASCII :
 *  You will need to complete the logic and ASCII graphic in the HangMan class.
 *  Nothing to do in this file, though you are welcome to look and understand the 
 *  overall structure.
 * 
 */

import java.util.Scanner;

public class MainHangMan {

	public static void main(String[] args) {
            
		// Create a game
		HangMan game = new HangMan();

		// Open the Keyboard
		Scanner keyboard = new Scanner(System.in);
	
                // Overall Game loop		
		boolean keepPlaying = true;
		while (keepPlaying) {
			game.startAnew();
			game.draw();        // Draw initial hangman

			// Single game loop
			boolean gameIsDone = false;
			while (!gameIsDone) {	
                            
				System.out.print("Enter your next letter guess (0 to quit): ");
				String ans = keyboard.next();
				char   c   = ans.charAt(0);
				c = Character.toLowerCase(c);
                                
				if (c == '0') {
					gameIsDone=true;
					continue;
				}
				
				game.newCharGuessed(c);
				gameIsDone = game.isDone();
				game.draw();		
			}
			
			// after end of game loop, do you want to keep playing? [y]/n
			System.out.print("Do you want to continue? y or n [y]: ");
			String ans = keyboard.next();
			if (ans.charAt(0) == 'n')
				keepPlaying = false;
				
		}
		keyboard.close();
	}

	
}

