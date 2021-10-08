package com.hubgitalvin.week3;

import java.util.Scanner;
import java.util.Random; 

/*
 * Student: Alvin H. Revilas
 *
 * Week 3 Assignment 2:  Guess Random Number Game
 *
 * Project Summary:  
 * In this integer guessing game, the player needs to guess the 
 * randomly picked number in 5 guesses or less.  
 * 
 * - After every attempt, the computer responds in one of three 
 * ways:  
 *   - Too Low (Please pick a higher number)
 *   - Too High (Please pick a lower number)
 *   - Correct! YOU WIN!!  
 *
 * - Player loses when the five guess attempts are used up with 
 * no correct guess. 
 * 
 * - Player wins if the player guesses the correct number in five 
 * tries or less.  
 * 
 * Other parameters:  
 * 
 * - Guess attempt does NOT count if an invalid input is tried, 
 * like "a35" or "3.1415927" or is outside of the bounds.  
 * 
 * - Bounds for this game are the lowest integer being "1" and 
 * the highest integer being "100".  
 * 
 * Possible Ideas for the design: 
 * 
 * - use a separate method just to collect input that isn't directly 
 * tied with the five guess loop 
 * 
 * - implement a game loop that calls the different methods when 
 * needed
 * 
 * - try to make one method per filename.java file 
 * --- update:  can't seem to make multi files work for now.  Will
 * have to go with multiple methods/functions all in one file
*/

public class AlvGame01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Basic Program Logic: 
		 * 1. Display intro stuff 
		 * 2. Set up initial conditions 
		 * 3. Execute game loop to determine win or lose 
		 * 4. Display finished game results
		*/ 

	//----------------------------------------------------------------------------------------------------
			
			// initialize needed variables
			int currentAttempt = 1; 
			int maxAttempts    = 5; 
			int LowerLimit     = 1; 
			int UpperLimit     = 100; 
			int currentGuess   = 1; 
			int secretNumber   = 0; // initialized at zero just to have the variable available 
			
			boolean winGame    = false; // only way to win to to guess correctly.  anything else is a loss 

	//----------------------------------------------------------------------------------------------------

			// formally start the game and show rules
			displayStart(LowerLimit, UpperLimit, maxAttempts); 
		
			// get the secretNumber for the player to try to guess 
			Random rand = new Random(); 
			secretNumber = rand.nextInt(UpperLimit - LowerLimit) + LowerLimit; 

	//----------------------------------------------------------------------------------------------------
		
			// go into game loop 
			
			while ( (currentAttempt <= maxAttempts) && !winGame ) { 
			
				/* 
				 * we only leave the game loop when the player wins or 
				 * uses up all attempts to guess, which is a losing condition 
				*/
			
				currentGuess = getGuess(currentAttempt, maxAttempts, LowerLimit, UpperLimit); 
				
				if (currentGuess == secretNumber) { 
					winGame = true; 
				} else if (currentGuess > secretNumber) { 
					System.out.println("Too High (Please pick a lower number)"); 
					currentAttempt ++; 
				} else if (currentGuess < secretNumber) { 
					System.out.println("Too Low (Please pick a higher number)"); 
					currentAttempt ++; 
				} else { 
					System.out.println("Something weird happened. This attempt does NOT count."); 
				}
			} 
			// end of game loop 

	//----------------------------------------------------------------------------------------------------
			
			// display game results 
			displayGameResults(winGame, secretNumber); 
		
		
	}



public static void displayStart (int LowLim, int UpLim, int numTries) { 
		
	    System.out.println("Welcome to Alvin's Guessing game!"); 
	    System.out.println("To win, you must guess the randomly chosen number."); 
	    System.out.println("The number's range is from " + LowLim + " to " + UpLim + "."); 
	    System.out.println("You only get " + numTries + " tries to guess. "); 
	    System.out.println("You will be told that your guess is either too low, too high, out of the number range, or correct."); 
	    System.out.println("Guesses outside of the number range do not count, but give no clue if too low or too high."); 
	    System.out.println("Typos also do not count and obviously do not give a clue as to being too low or too high. "); 
	    System.out.println("Good luck!!"); 
			
}

public static int getGuess (
		int attemptNum, 
		int totalAttempts, 
		int lowLim, 
		int highLim) {
	// TODO Auto-generated method stub

	int retGuess; 
	
	System.out.println("Attempt # " + attemptNum + " of " + totalAttempts + ": Type a number between " + lowLim + " and " + highLim + ": ");
	Scanner gameInput = new Scanner(System.in); 
	
	String  parseNum = gameInput.nextLine(); 
	Integer myResult = Integer.parseInt(parseNum); 
	retGuess         = myResult.intValue();	

	while ((retGuess < lowLim) || (retGuess > highLim)) { 
	
	// only enter the while loop when the input is NOT between lowLim and highLim 
	// if the first try actually is valid then we just use that
	
		System.out.println("Oops, that number wasn't between " + lowLim + " and " + highLim + ", try again: "); 
		parseNum = gameInput.nextLine(); 
		myResult = Integer.parseInt(parseNum); 
		retGuess = myResult.intValue(); 
	} 
	
	// gameInput.close(); 
	// I don't know why the method wants to keep gameInput closed?  
	// So, I'll just comment out the .close() method call for now.  
	// Does gameInput automatically close when program flow leaves scope?? 
	
	return retGuess; 		
	
}

public static void displayGameResults(boolean didPlayerWin, int gameNumber) {

	String resultString = " "; 

    if (didPlayerWin) { 
		resultString = "CONGRATULATIONS! You Win!";
    } else { 
		resultString = "Sorry, you lose. The number you tried to guess is: " + gameNumber;
	}
	
	System.out.println(resultString); 

}

}
    
