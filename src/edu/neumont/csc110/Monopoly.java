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
	private void onMe(int currentPlayer) throws IOException {
		
		//if current player is on me(any spot on board) then ask to buy or acution.
		//if it is owned pay rent to other player check if they have houses or hotels pay.
		//if player owns all three or two ask to put houses or hotels
		//if player lands on Go to jail do it.
		//if player passes go give money.
		if(playerList[currentPlayer].location == 0) {
			AllBoardPlaces abp = b.getCardAt(0);
			p.cash += 200;
		}
		if(playerList[currentPlayer].location == 1) {//MEDITERRANEAN("Mediterranean Avenue", 60,2,10,30,90,190,250,30,30,50,50),
			AllBoardPlaces abp = b.getCardAt(1);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				playerList[currentPlayer].cash -= abp.cardPrice;
			}
			//else put up for action
		}
		if(playerList[currentPlayer].location == 2) { //COMMUNITY1("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(2);
			System.out.println(abp);
		}
		if(playerList[currentPlayer].location == 3) {//BALIC("Baltic Avenue", 60,4,20,60,180,320,450,50,50,50,50),
			AllBoardPlaces abp = b.getCardAt(3);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				playerList[currentPlayer].cash -= abp.getCardPrice();
			}
		}
		if(playerList[currentPlayer].location == 4) {//INCOME("Income Tax",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(4);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you want to pay 10% or 200 Yes for 10% No for 200", false);
			if(input.equalsIgnoreCase("Yes")) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - playerList[currentPlayer].cash * .01;
			}
			else if (input.equalsIgnoreCase("No")) {
				playerList[currentPlayer].cash -= 200;
			}
		}
		if(playerList[currentPlayer].location == 5) {//READING("Reading Railroad",200,25,0,50,100,200,0,100,100,0,0),
			AllBoardPlaces abp = b.getCardAt(5);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				playerList[currentPlayer].cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 6) {//ORIENTAL("Oriental Avenenu",100,6,30,90,270,400,550,50,50,50,50),
			AllBoardPlaces abp = b.getCardAt(6);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				playerList[currentPlayer].cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 7) {//CHANCE1("Chance",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(7);
			System.out.println(abp);
		}
		if(playerList[currentPlayer].location == 8) {//VERMONT("Vermont Avenue",100,6,30,90,270,400,550,50,50,50,50),
			AllBoardPlaces abp = b.getCardAt(8);	
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				playerList[currentPlayer].cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 9) {//CONNECTICUT("Connecticut Avenue",120,8,40,100,300,450,600,60,60,50,50),
			AllBoardPlaces abp = b.getCardAt(9);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				playerList[currentPlayer].cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 10) {//JAIL("Jail",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(10);
			System.out.println(abp);
		}
		if(playerList[currentPlayer].location == 11) {//CHARLES("St.Charles Place",140,10,50,150,450,625,750,70,70,100,100),
			AllBoardPlaces abp = b.getCardAt(11);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				playerList[currentPlayer].cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 12) {//ELECTRIC("Electric Company",150,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(12);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				playerList[currentPlayer].cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 13) {//STATES("States Avenue",140,10,50,150,450,625,750,70,70,100,100),
			AllBoardPlaces abp = b.getCardAt(13);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 14) {//PENNSYLVANIARR("Pennsylvania Railraod",200,25,0,50,100,200,0,100,100,0,0),
			AllBoardPlaces abp = b.getCardAt(14);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 15) {//VIRGINIA("Virginia Avenue",160,12,60,180,500,700,900,80,80,100,100),
			AllBoardPlaces abp = b.getCardAt(15);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 16) {//COMMUNITY2("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(16);
			System.out.println(abp);
		}
		if(playerList[currentPlayer].location == 17) {//JAMES("St.James Pllace",180,14,70,200,550,750,950,90,90,100,100),
			AllBoardPlaces abp = b.getCardAt(18);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 18) {//TENNESSEE("Tennessee Avenue",180,14,70,200,550,750,950,90,90,100,100),
			AllBoardPlaces abp = b.getCardAt(18);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 19) {//NEWYORK("New York Avenue", 200,16,220,600,800,1000,100,100,100,100,100),

			AllBoardPlaces abp = b.getCardAt(19);	
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 20) {//FREE("Free Parking",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(20);
			System.out.println(abp);
		}
		if(playerList[currentPlayer].location == 21) {//KENTUCKY("Kentucky Avenue",220,18,90,250,700,875,1050,110,110,150,150),
			AllBoardPlaces abp = b.getCardAt(21);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 22) {//CHANCE2("Chance",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(22);
			System.out.println(abp);
		}
		if(playerList[currentPlayer].location == 23) {//INDIANA("Indiana Avenue",220,18,90,250,700,875,1050,110,110,150,150),
			AllBoardPlaces abp = b.getCardAt(23);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 24) {//ILLINOIS("Illinois Avenue",240,20,100,300,750,925,1100,120,120,150,150),
			AllBoardPlaces abp = b.getCardAt(24);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 25) {//BANDO("B & O Railroad",200,25,0,50,100,200,0,100,100,0,0),
			AllBoardPlaces abp = b.getCardAt(25);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 26) {//ATLANTIC("Atlatic Avenue",260,22,110,330,800,975,1150,130,130,150,150),
			AllBoardPlaces abp = b.getCardAt(26);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 27) {//VENTNOR("Ventnor Avenue",260,22,110,330,800,975,1150,130,130,150,150),
			AllBoardPlaces abp = b.getCardAt(27);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 28) {//WATER("Water Works",150,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(28);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 29) {//MARVIN("Marvin Gardens",280,24,120,360,850,1025,1200,140,140,150,150),
			AllBoardPlaces abp = b.getCardAt(29);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 30) {//GOTJAIL("Go To Jail",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(30);
			System.out.println(abp);
		}
		if(playerList[currentPlayer].location == 31) {//PACIFIC("Pacific Avenue",300,26,130,390,900,110,1275,150,150,200,200),
			AllBoardPlaces abp = b.getCardAt(31);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 32) {//NCAROLINA("North Carolina Avenue",300,26,130,390,900,1100,1275,150,150,200,200),
			AllBoardPlaces abp = b.getCardAt(32);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 33) {//COMMUNITY3("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(33);
			System.out.println(abp);
		}
		if(playerList[currentPlayer].location == 34) {//PENNSYLVANIA("Pennsylvania Avenue",320,28,150,450,1000,1200,1400,160,160,200,200),
			AllBoardPlaces abp = b.getCardAt(34);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 35) {//SHORT("Short Line",200,25,0,50,100,200,0,100,100,0,0),
			AllBoardPlaces abp = b.getCardAt(35);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 36) {//CHANCE3("Chance",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(36);
			System.out.println(abp);
		}
		if(playerList[currentPlayer].location == 37) {//PARK("Park Place",350,35,175,500,1100,1300,1500,175,175,200,200),
			AllBoardPlaces abp = b.getCardAt(37);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		if(playerList[currentPlayer].location == 38) {//TAX("Lutury Tax",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(38);	
			System.out.println(abp);
			p.cash -= 75;
		}
		if(playerList[currentPlayer].location == 39) {//BOARDWALK("Boardwalk",400,50,200,600,1400,1700,2000,200,200,200,200);
			AllBoardPlaces abp = b.getCardAt(39);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you wan't to buy this Yes/No", false);
			if(input.equalsIgnoreCase("Yes")) {
				p.cash -= abp.cardPrice;
			}
		}
		
	}

	private void speedPlay() {
		// TODO Auto-generated method stub

	}

	private void normalGame(Dice d) throws IOException {

		
		
		

		boolean gameWin=false;
		int currentPlayer = firstPlayer;
		int turnCount=0;
//		
		do {
			for(int i = 0;i<playerList.length;i++) {
				currentPlayer=firstPlayer+i;
				if(currentPlayer >= playerList.length) {
					currentPlayer=currentPlayer-playerList.length;
				}
				System.out.println("******************************");
				playerList[currentPlayer].printPlayer();
				System.out.println("******************************");
				System.out.println();
				System.out.println("Okay " + playerList[currentPlayer].name + ", the roll is yours.");
				playerList[currentPlayer].location = playerList[currentPlayer].location + d.rollDice(playerList[currentPlayer]);
				System.out.println(playerList[currentPlayer].location);
				onMe(currentPlayer);
				turnCount++;
				// p = playerList[currentPlayer]; We need to change p.location to whatever this means. cryptic tutors...
			}

		}while(gameWin==false);

		// need to add code to move piece after every roll, regardless if doubles
		boolean validYesno = false;
		while(!validYesno) {
		String yesno = ConsoleUI.promptForInput("Do you want to play again? Yes/No", false);
		if (yesno.equalsIgnoreCase("yes")) {
			
		}
		}
	}
}