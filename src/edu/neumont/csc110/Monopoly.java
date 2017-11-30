package edu.neumont.csc110;

import java.io.IOException;
import java.util.ArrayList;

public class Monopoly {
	Player[] playerList = null;
	int firstPlayer;
	ArrayList<PlayerTokens> tokenList = new ArrayList();
	Board b = new Board();
	Player p = new Player();
	

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
//				System.out.println(maxRoll+"Maxroll");

			} else if (firstRoll[i] == maxRoll) {
				do {
//					System.out.println("do while loop, game setup, reroll************");
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
	private void onMe() {
		
		//if current player is on me(any spot on board) then ask to buy or acution.
		//if it is owned pay rent to other player check if they have houses or hotels pay.
		//if player owns all three or two ask to put houses or hotels
		//if player lands on Go to jail do it.
		//if player passes go give money.
		if(p.location == 0) {
			AllBoardPlaces abp = b.getCardAt(0);
		}
		if(p.location == 1) {
			AllBoardPlaces abp = b.getCardAt(1);
		}
		if(p.location == 2) {
			AllBoardPlaces abp = b.getCardAt(2);
		}
		if(p.location == 3) {
			AllBoardPlaces abp = b.getCardAt(3);
		}
		if(p.location == 4) {
			AllBoardPlaces abp = b.getCardAt(4);
		}
		if(p.location == 5) {
			AllBoardPlaces abp = b.getCardAt(5);
		}
		if(p.location == 6) {
			AllBoardPlaces abp = b.getCardAt(6);
		}
		if(p.location == 7) {
			AllBoardPlaces abp = b.getCardAt(7);
		}
		if(p.location == 8) {
			AllBoardPlaces abp = b.getCardAt(8);	
		}
		if(p.location == 9) {
			AllBoardPlaces abp = b.getCardAt(9);
		}
		if(p.location == 10) {
			AllBoardPlaces abp = b.getCardAt(10);
		}
		if(p.location == 11) {
			AllBoardPlaces abp = b.getCardAt(11);
		}
		if(p.location == 12) {
			AllBoardPlaces abp = b.getCardAt(12);
		}
		if(p.location == 13) {
			AllBoardPlaces abp = b.getCardAt(13);
		}
		if(p.location == 14) {
			AllBoardPlaces abp = b.getCardAt(14);
		}
		if(p.location == 15) {
			AllBoardPlaces abp = b.getCardAt(15);
		}
		if(p.location == 16) {
			AllBoardPlaces abp = b.getCardAt(16);
		}
		if(p.location == 17) {
			AllBoardPlaces abp = b.getCardAt(18);
		}
		if(p.location == 18) {
			AllBoardPlaces abp = b.getCardAt(18);
		}
		if(p.location == 19) {
			AllBoardPlaces abp = b.getCardAt(19);	
		}
		if(p.location == 20) {
			AllBoardPlaces abp = b.getCardAt(20);
		}
		if(p.location == 21) {
			AllBoardPlaces abp = b.getCardAt(21);
		}
		if(p.location == 22) {
			AllBoardPlaces abp = b.getCardAt(22);
		}
		if(p.location == 23) {
			AllBoardPlaces abp = b.getCardAt(23);
		}
		if(p.location == 24) {
			AllBoardPlaces abp = b.getCardAt(24);
		}
		if(p.location == 25) {
			AllBoardPlaces abp = b.getCardAt(25);
		}
		if(p.location == 26) {
			AllBoardPlaces abp = b.getCardAt(26);
		}
		if(p.location == 27) {
			AllBoardPlaces abp = b.getCardAt(27);
		}
		if(p.location == 28) {
			AllBoardPlaces abp = b.getCardAt(28);
		}
		if(p.location == 29) {
			AllBoardPlaces abp = b.getCardAt(29);
		}
		if(p.location == 30) {
			AllBoardPlaces abp = b.getCardAt(30);
		}
		if(p.location == 31) {
			AllBoardPlaces abp = b.getCardAt(31);
		}
		if(p.location == 32) {
			AllBoardPlaces abp = b.getCardAt(32);
		}
		if(p.location == 33) {
			AllBoardPlaces abp = b.getCardAt(33);
		}
		if(p.location == 34) {
			AllBoardPlaces abp = b.getCardAt(34);
		}
		if(p.location == 35) {
			AllBoardPlaces abp = b.getCardAt(35);
		}
		if(p.location == 36) {
			AllBoardPlaces abp = b.getCardAt(36);
		}
		if(p.location == 37) {
			AllBoardPlaces abp = b.getCardAt(37);
		}
		if(p.location == 38) {
			AllBoardPlaces abp = b.getCardAt(38);	
		}
		if(p.location == 39) {
			AllBoardPlaces abp = b.getCardAt(39);
		}
		if(p.location == 40) {
			AllBoardPlaces abp = b.getCardAt(40);
		}
	}

	private void speedPlay() {
		// TODO Auto-generated method stub

	}

	private void normalGame(Dice d) {
		playerList[firstPlayer].printPlayer();
		System.out.println("Okay " + playerList[firstPlayer].name + ", the first roll is yours.");
		int location = p.location + d.rollDice(playerList[firstPlayer].name);
		playerList[firstPlayer].location = playerList[firstPlayer].location+location;
		playerList[firstPlayer].printPlayer();
		
		// need to add code to move piece after every roll, regardless if doubles
	}
}
