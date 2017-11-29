package edu.neumont.csc110;

import java.io.IOException;
import java.util.ArrayList;

public class Monopoly {

	Player[] playerList = null;
	int firstPlayer;
	ArrayList<PlayerTokens> tokenList = new ArrayList();
	

	public void gameSetUp(Dice d) throws IOException {
		tokenList.add(PlayerTokens.VENUSAUR);
		tokenList.add(PlayerTokens.CHARIZARD);
		tokenList.add(PlayerTokens.BLASTOISE);
		tokenList.add(PlayerTokens.MEW);
		tokenList.add(PlayerTokens.MEWTWO);
		tokenList.add(PlayerTokens.PIKACHU);
		tokenList.add(PlayerTokens.POKEBALL);
		tokenList.add(PlayerTokens.MASTERBALL);
		

		System.out.println("Hello, and welcome to Monopoly!");
		System.out.println("How many players are there? You must have 2 or more players to play.");
		int numPlayers = ConsoleUI.promptForInt("", 2, 8);
		playerList = new Player[numPlayers];
		int[] firstRoll = new int[numPlayers];
		int maxRoll = 0;

		for (int i = 0; i < playerList.length; i++) {
			playerList[i] = new Player();
			playerList[i].name = ConsoleUI.promptForInput("Player " + (i + 1) + " enter your name.", false);
			System.out.println("Your choices are");
			for(int j =0;j<tokenList.size();j++) {
				System.out.println((j+1)+""+tokenList.get(j));
			}
			boolean goodToken = true;
		
			System.out.println("You can enter a number for the respective token choice.");
			
			int chosenIndex = ConsoleUI.promptForInt("What token would you like?", 1, tokenList.size());
			playerList[i].token=tokenList.get(chosenIndex-1);
			tokenList.remove(chosenIndex-1);
			System.out.println(playerList[i].token);
		
		
			
			
			firstRoll[i] = d.firstRoll(playerList[i]);
			if (firstRoll[i] > maxRoll) {
				maxRoll = firstRoll[i];
				firstPlayer = i;

			} else if (firstRoll[i] == maxRoll) {
				do {
					firstRoll[i] = d.firstRoll(playerList[i]);

					if (firstRoll[i] > maxRoll) {
						maxRoll = firstRoll[i];
						firstPlayer = i;
					}
				} while (firstRoll[i] == maxRoll);
			}
			System.out.println(playerList[i].name + " your roll was " + firstRoll[i]);
			System.out.println();
		}
		System.out.println(playerList[firstPlayer].name+", you are first player.");
		System.out.println();
//		System.out.println("Please choose your token");
//		for(int i=8;i>=playerList.length;i--) {
//			
//		}
		
		

		System.out.println("Which game would you like to play?");
		String gameChoice = ConsoleUI.promptForInput("Normal(1) or speedplay(2)?", false);
		if (gameChoice.equalsIgnoreCase("normal") || gameChoice.equals("1")) {
			normalGame(d);
		} else {
			speedPlay();
		}

	}

	private void speedPlay() {
		// TODO Auto-generated method stub

	}

	private void normalGame(Dice d) {
		playerList[firstPlayer].printPlayer();
		System.out.println("Okay " + playerList[firstPlayer].name + ", the first roll is yours.");
		d.rollDice(playerList[firstPlayer].name);
		// need to add code to move piece after every roll, regardless if doubles
	}
}
