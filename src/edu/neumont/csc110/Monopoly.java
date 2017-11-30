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
			System.out.println();
			System.out.println("Your choices are");
			System.out.println();
			for(int j =0;j<tokenList.size();j++) {
				System.out.println((j+1)+""+tokenList.get(j));
				System.out.println();
			}
			boolean goodToken = true;
		
			System.out.println("You can enter a number for the respective token choice.");
			System.out.println();
			
			int chosenIndex = ConsoleUI.promptForInt("What token would you like?", 1, tokenList.size());
			System.out.println();
			playerList[i].token=tokenList.get(chosenIndex-1);
			tokenList.remove(chosenIndex-1);
			System.out.println(playerList[i].token);
			System.out.println();
		
		
			
			
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
	private void onMe() throws IOException {
		
		//if current player is on me(any spot on board) then ask to buy or acution.
		//if it is owned pay rent to other player check if they have houses or hotels pay.
		//if player owns all three or two ask to put houses or hotels
		//if player lands on Go to jail do it.
		//if player passes go give money.
		if(p.location == 0) {
			AllBoardPlaces abp = b.getCardAt(0);
			p.cash += 200;
		}
		if(p.location == 1) {
			AllBoardPlaces abp = b.getCardAt(1);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
			//else put up for action
		}
		if(p.location == 2) { //COMMUNITY1("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(2);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 3) {//BALIC("Balic Avenu", 60,4,20,60,180,320,450,50,50,50,50),
			AllBoardPlaces abp = b.getCardAt(3);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 4) {//INCOME("Income Tax",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(4);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 5) {//READING("Reading Railroad",200,25,0,50,100,200,0,100,100,0,0),
			AllBoardPlaces abp = b.getCardAt(5);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 6) {//ORIENTAL("Oriental Avenenu",100,6,30,90,270,400,550,50,50,50,50),
			AllBoardPlaces abp = b.getCardAt(6);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 7) {//CHANCE1("Chance",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(7);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 8) {//VERMONT("Vermont Avenue",100,6,30,90,270,400,550,50,50,50,50),
			AllBoardPlaces abp = b.getCardAt(8);	
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 9) {//CONNECTICUT("Connecticut Avenue",120,8,40,100,300,450,600,60,60,50,50),
			AllBoardPlaces abp = b.getCardAt(9);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 10) {//JAIL("Jail",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(10);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 11) {//CHARLES("St.Charles Place",140,10,50,150,450,625,750,70,70,100,100),
			AllBoardPlaces abp = b.getCardAt(11);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 12) {//ELECTRIC("Electric Company",150,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(12);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 13) {//STATES("States Avenue",140,10,50,150,450,625,750,70,70,100,100),
			AllBoardPlaces abp = b.getCardAt(13);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 14) {//PENNSYLVANIARR("Pennsylvania Railraod",200,25,0,50,100,200,0,100,100,0,0),
			AllBoardPlaces abp = b.getCardAt(14);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 15) {//VIRGINIA("Virginia Avenue",160,12,60,180,500,700,900,80,80,100,100),
			AllBoardPlaces abp = b.getCardAt(15);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 16) {//COMMUNITY2("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(16);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 17) {//JAMES("St.James Pllace",180,14,70,200,550,750,950,90,90,100,100),
			AllBoardPlaces abp = b.getCardAt(18);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 18) {//TENNESSEE("Tennessee Avenue",180,14,70,200,550,750,950,90,90,100,100),
			AllBoardPlaces abp = b.getCardAt(18);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 19) {//NEWYORK("New York Avenue", 200,16,220,600,800,1000,100,100,100,100,100),

			AllBoardPlaces abp = b.getCardAt(19);	
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 20) {//FREE("Free Parking",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(20);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 21) {//KENTUCKY("Kentucky Avenue",220,18,90,250,700,875,1050,110,110,150,150),
			AllBoardPlaces abp = b.getCardAt(21);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 22) {//CHANCE2("Chance",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(22);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 23) {//INDIANA("Indiana Avenue",220,18,90,250,700,875,1050,110,110,150,150),
			AllBoardPlaces abp = b.getCardAt(23);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 24) {//ILLINOIS("Illinois Avenue",240,20,100,300,750,925,1100,120,120,150,150),
			AllBoardPlaces abp = b.getCardAt(24);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 25) {//BANDO("B & O Railroad",200,25,0,50,100,200,0,100,100,0,0),
			AllBoardPlaces abp = b.getCardAt(25);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 26) {
			AllBoardPlaces abp = b.getCardAt(26);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 27) {
			AllBoardPlaces abp = b.getCardAt(27);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 28) {
			AllBoardPlaces abp = b.getCardAt(28);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 29) {
			AllBoardPlaces abp = b.getCardAt(29);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 30) {
			AllBoardPlaces abp = b.getCardAt(30);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 31) {
			AllBoardPlaces abp = b.getCardAt(31);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 32) {
			AllBoardPlaces abp = b.getCardAt(32);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 33) {
			AllBoardPlaces abp = b.getCardAt(33);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 34) {
			AllBoardPlaces abp = b.getCardAt(34);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 35) {
			AllBoardPlaces abp = b.getCardAt(35);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 36) {
			AllBoardPlaces abp = b.getCardAt(36);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 37) {
			AllBoardPlaces abp = b.getCardAt(37);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 38) {
			AllBoardPlaces abp = b.getCardAt(38);	
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 39) {
			AllBoardPlaces abp = b.getCardAt(39);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		if(p.location == 40) {
			AllBoardPlaces abp = b.getCardAt(40);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash =- 60;
			}
		}
		
	}

	private void speedPlay() {
		// TODO Auto-generated method stub

	}

	private void normalGame(Dice d) throws IOException {
		playerList[firstPlayer].printPlayer();
		System.out.println();
		System.out.println("Okay " + playerList[firstPlayer].name + ", the first roll is yours.");
		p.location = p.location + d.rollDice(playerList[firstPlayer].name);
		System.out.println(p.location);
		onMe();
		
		// need to add code to move piece after every roll, regardless if doubles
	}
}
