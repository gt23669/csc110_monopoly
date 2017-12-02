package edu.neumont.csc110;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Monopoly {
	Player[] playerList = null;
	int firstPlayer;
	ArrayList<PlayerTokens> tokenList = new ArrayList();
//	Board b = new Board();
//	Player p = new Player();
//	Dice d = new Dice();
	boolean inJail = true;

	public void gameSetUp(Dice d, Player p, Board b) throws IOException {
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
			for (int j = 0; j < tokenList.size(); j++) {
				System.out.println((j + 1) + "" + tokenList.get(j));
				System.out.println();
			}
			boolean goodToken = true;

			System.out.println("You can enter a number for the respective token choice.");
			System.out.println();

			int chosenIndex = ConsoleUI.promptForInt("What token would you like?", 1, tokenList.size());
			System.out.println();
			playerList[i].token = tokenList.get(chosenIndex - 1);
			tokenList.remove(chosenIndex - 1);
			System.out.println(playerList[i].token);
			System.out.println();

			firstRoll[i] = d.firstRoll(playerList[i]);
			if (firstRoll[i] > maxRoll) {
				maxRoll = firstRoll[i];
				firstPlayer = i;
				// System.out.println(maxRoll+"Maxroll");

			} else if (firstRoll[i] == maxRoll) {
				do {
					// System.out.println("do while loop, game setup, reroll************");
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
		System.out.println(playerList[firstPlayer].name + ", you are first player.");
		System.out.println();
		// System.out.println("Please choose your token");
		// for(int i=8;i>=playerList.length;i--) {
		//
		// }

		System.out.println("Which game would you like to play?");
		String gameChoice = ConsoleUI.promptForInput("Normal(1) or speedplay(2)?", false);
		if (gameChoice.equalsIgnoreCase("normal") || gameChoice.equals("1")) {
			normalGame(d, p, b);
		} else {
			speedPlay();
		}

	}

	public void onMe(int currentPlayer, Board b, Player p, Dice d) throws IOException {

		// if current player is on me(any spot on board) then ask to buy or auction.
		// if it is owned pay rent to other player check if they have houses or hotels
		// pay.
		// if player owns all three or two ask to put houses or hotels
		// if player lands on Go to jail do it.
		// if player passes go give money.
		if (playerList[currentPlayer].location == 0) {
			AllBoardPlaces abp = b.getCardAt(0);
			p.cash += 200;
		}

		if (playerList[currentPlayer].location == 1) {// MEDITERRANEAN("Mediterranean Avenue",
														// 60,2,10,30,90,190,250,30,30,50,50),

			AllBoardPlaces abp = b.getCardAt(1);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (input=true) {

				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;

			}
			if (input = false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 2) { // COMMUNITY1("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(2);
			System.out.println("Community Chest");
			Communitychest(currentPlayer);
		}
		if (playerList[currentPlayer].location == 3) {// BALIC("Balic Avenu", 60,4,20,60,180,320,450,50,50,50,50),
			AllBoardPlaces abp = b.getCardAt(3);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (input=true) {

				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (input=false) {
				// if no put up for action

			}
		}
		if (playerList[currentPlayer].location == 4) {// INCOME("Income Tax",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(4);
			System.out.println(abp);
			String input = ConsoleUI.promptForInput("Do you want to pay 10%(yes) or $200(no)?", false);
			if (input.equalsIgnoreCase("yes")||input.equals("10")||input.equals("10%")) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - playerList[currentPlayer].cash * abp.baseRent;
			} if (!input.equalsIgnoreCase("yes")||!input.equals("10")||!input.equals("10%")) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
		}
		if (playerList[currentPlayer].location == 5) {// READING("Reading Railroad",200,25,0,50,100,200,0,100,100,0,0),
			AllBoardPlaces abp = b.getCardAt(5);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 6) {// ORIENTAL("Oriental
														// Avenenu",100,6,30,90,270,400,550,50,50,50,50),
			AllBoardPlaces abp = b.getCardAt(6);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {

				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action

			}
		}
		if (playerList[currentPlayer].location == 7) {// CHANCE1("Chance",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(7);
			System.out.println("Chance");
			Chance(currentPlayer);
			
		}
		if (playerList[currentPlayer].location == 8) {// VERMONT("Vermont Avenue",100,6,30,90,270,400,550,50,50,50,50),
			AllBoardPlaces abp = b.getCardAt(8);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {

				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {

			}
		}
		if (playerList[currentPlayer].location == 9) {// CONNECTICUT("Connecticut
														// Avenue",120,8,40,100,300,450,600,60,60,50,50),
			AllBoardPlaces abp = b.getCardAt(9);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;

			}
			if (false) {
				// if no put up for action

			}
		}
		if (playerList[currentPlayer].location == 10) {// JAIL("Jail",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(10);
			System.out.println("You have landed on jail. Do not worry, you are just visiting");
		}
		if (playerList[currentPlayer].location == 11) {// CHARLES("St.Charles
														// Place",140,10,50,150,450,625,750,70,70,100,100),
			AllBoardPlaces abp = b.getCardAt(11);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {

				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;

			}
			if (false) {
				// if no put up for action

			}
		}
		if (playerList[currentPlayer].location == 12) {// ELECTRIC("Electric Company",150,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(12);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {

				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action

			}
		}
		if (playerList[currentPlayer].location == 13) {// STATES("States
														// Avenue",140,10,50,150,450,625,750,70,70,100,100),
			AllBoardPlaces abp = b.getCardAt(13);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 14) {// PENNSYLVANIARR("Pennsylvania
														// Railraod",200,25,0,50,100,200,0,100,100,0,0),
			AllBoardPlaces abp = b.getCardAt(14);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 15) {// VIRGINIA("Virginia
														// Avenue",160,12,60,180,500,700,900,80,80,100,100),
			AllBoardPlaces abp = b.getCardAt(15);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 16) {// COMMUNITY2("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(16);
			System.out.println("Community Chest");
			Communitychest(currentPlayer);
		}
		if (playerList[currentPlayer].location == 17) {// JAMES("St.James
														// Pllace",180,14,70,200,550,750,950,90,90,100,100),
			AllBoardPlaces abp = b.getCardAt(18);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 18) {// TENNESSEE("Tennessee
														// Avenue",180,14,70,200,550,750,950,90,90,100,100),
			AllBoardPlaces abp = b.getCardAt(18);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 19) {// NEWYORK("New York Avenue",
														// 200,16,220,600,800,1000,100,100,100,100,100),

			AllBoardPlaces abp = b.getCardAt(19);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 20) {// FREE("Free Parking",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(20);
			System.out.println(abp);
		}
		if (playerList[currentPlayer].location == 21) {// KENTUCKY("Kentucky
														// Avenue",220,18,90,250,700,875,1050,110,110,150,150),
			AllBoardPlaces abp = b.getCardAt(21);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 22) {// CHANCE2("Chance",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(22);
			System.out.println("Chance");
			Chance(currentPlayer);
		}
		if (playerList[currentPlayer].location == 23) {// INDIANA("Indiana
														// Avenue",220,18,90,250,700,875,1050,110,110,150,150),
			AllBoardPlaces abp = b.getCardAt(23);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 24) {// ILLINOIS("Illinois
														// Avenue",240,20,100,300,750,925,1100,120,120,150,150),
			AllBoardPlaces abp = b.getCardAt(24);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 25) {// BANDO("B & O Railroad",200,25,0,50,100,200,0,100,100,0,0),
			AllBoardPlaces abp = b.getCardAt(25);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 26) {// ATLANTIC("Atlatic
														// Avenue",260,22,110,330,800,975,1150,130,130,150,150),
			AllBoardPlaces abp = b.getCardAt(26);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 27) {// VENTNOR("Ventnor
														// Avenue",260,22,110,330,800,975,1150,130,130,150,150),
			AllBoardPlaces abp = b.getCardAt(27);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 28) {// WATER("Water Works",150,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(28);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 29) {// MARVIN("Marvin
														// Gardens",280,24,120,360,850,1025,1200,140,140,150,150),
			AllBoardPlaces abp = b.getCardAt(29);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 30) {// GOTJAIL("Go To Jail",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(30);
			System.out.println("You have landed on jail.");
			System.out.println(playerList[currentPlayer].name+", Go straight to jail, do not pass go, do not collect $200");
			playerList[currentPlayer].location = 10;
			if(playerList[currentPlayer].inJail=true) {
				jail(currentPlayer, d, p);
			}
			playerList[currentPlayer].inJail = true;
			
		}
		if (playerList[currentPlayer].location == 31) {// PACIFIC("Pacific
														// Avenue",300,26,130,390,900,110,1275,150,150,200,200),
			AllBoardPlaces abp = b.getCardAt(31);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 32) {// NCAROLINA("North Carolina
														// Avenue",300,26,130,390,900,1100,1275,150,150,200,200),
			AllBoardPlaces abp = b.getCardAt(32);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 33) {// COMMUNITY3("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(33);
			System.out.println("Community Chest");
			Communitychest(currentPlayer);
		}
		if (playerList[currentPlayer].location == 34) {// PENNSYLVANIA("Pennsylvania
														// Avenue",320,28,150,450,1000,1200,1400,160,160,200,200),
			AllBoardPlaces abp = b.getCardAt(34);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 35) {// SHORT("Short Line",200,25,0,50,100,200,0,100,100,0,0),
			AllBoardPlaces abp = b.getCardAt(35);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 36) {// CHANCE3("Chance",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(36);
			System.out.println("Chance");
			Chance(currentPlayer);
		}
		if (playerList[currentPlayer].location == 37) {// PARK("Park
														// Place",350,35,175,500,1100,1300,1500,175,175,200,200),
			AllBoardPlaces abp = b.getCardAt(37);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}
		if (playerList[currentPlayer].location == 38) {// TAX("Lutury Tax",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(38);
			System.out.println(abp);
			playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.baseRent;
		}
		if (playerList[currentPlayer].location == 39) {// BOARDWALK("Boardwalk",400,50,200,600,1400,1700,2000,200,200,200,200);
			AllBoardPlaces abp = b.getCardAt(39);
			System.out.println(abp);
			boolean input = ConsoleUI.promptForBool("Do You Want To Buy? Yes/No", "Yes", "No");
			if (true) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= abp.cardPrice;
			}
			if (false) {
				// if no put up for action
			}
		}

	}
	public void Communitychest(int currentPlayer) {
		ArrayList<Integer> usedListCC = new ArrayList();
		
			// randomly shuffle deck
			int num = 0;
			Random gen = new Random();
			do {
//				num = gen.nextInt(16) + 1;
				num = 1;
			} while (!usedListCC.contains(num));
			usedListCC.add(num);
		
			switch (num) {

			case 1: 
				System.out.println("Advance to Go (Collect $200)");
				playerList[currentPlayer].cash = playerList[currentPlayer].cash += 200;
				playerList[currentPlayer].location = playerList[currentPlayer].location = 0;
				break;
			case 2:
				System.out.println("Bank error in your favor – Collect $200");
				playerList[currentPlayer].cash =playerList[currentPlayer].cash += 200;
				break;
			case 3:
				System.out.println("Doctor's fees {fee} – Pay $50");
				playerList[currentPlayer].cash =playerList[currentPlayer].cash -= 50;
				break;
			case 4:
				System.out.println("From sale of stock you get $50");
				playerList[currentPlayer].cash =playerList[currentPlayer].cash += 50;
				break;
			case 5:
				System.out.println("Get out of Jail, Free");
				// give card to get out of jail
				break;
			case 6:
				System.out.println("Go directly to jail – Do not pass Go – Do not collect $200");
				// makes current player go to jail
				break;
			case 7:
				System.out.println("Grand Opera Night – Collect $50 from every player for opening night seats");
				playerList[currentPlayer].cash =playerList[currentPlayer].cash += 50;
				break;
			case 8:
				System.out.println("Holiday Fund matures - Collect $100");
				playerList[currentPlayer].cash =playerList[currentPlayer].cash += 100;
				break;
			case 9:
				System.out.println("Income tax refund – Collect $20");
				playerList[currentPlayer].cash =playerList[currentPlayer].cash += 20;
				break;
			case 10:
				System.out.println("It is your birthday - Collect $10 from each player");
				playerList[currentPlayer].cash =playerList[currentPlayer].cash += 10;
				break;
			case 11:
				System.out.println("Life insurance matures – Collect $100");
				playerList[currentPlayer].cash =playerList[currentPlayer].cash += 100;
				break;
			case 12:
				System.out.println("Pay hospital fees of $100");
				playerList[currentPlayer].cash =playerList[currentPlayer].cash -= 100;
				break;
			case 13:
				System.out.println("Pay school fees of $150");
				playerList[currentPlayer].cash =playerList[currentPlayer].cash -= 150;
				break;
			case 14:
				System.out.println("Receive $25 consultancy fee");
				playerList[currentPlayer].cash =playerList[currentPlayer].cash -= 25;
				break;
			case 15:
				System.out.println("You are assessed for street repairs – $40 per house – $115 per hotel");
				//check how many houses
				break;
			case 16:
				System.out.println("You have won second prize in a beauty contest – Collect $10");
				playerList[currentPlayer].cash =playerList[currentPlayer].cash += 10;

				break;
			default: playerList[currentPlayer].location = 30;
				break;
		}
	}
	
	public void Chance(int currentPlayer) {
		ArrayList<Integer> usedListC = new ArrayList();
		
			// randomly shuffle deck
			int num = 0;
			Random gen = new Random();
			do {
				num = 1;
//				num = gen.nextInt(16) + 1;
			} while (!usedListC.contains(num));
			usedListC.add(num);
		
			switch (num) {

			case 1: 
				System.out.println("Advance to Go (Collect $200)");
				playerList[currentPlayer].cash = playerList[currentPlayer].cash += 200;
				playerList[currentPlayer].location = playerList[currentPlayer].location = 0;
				break;
			case 2:
				System.out.println("Advance to Illinois Ave. - If you pass Go, collect $200 ");
				playerList[currentPlayer].location = playerList[currentPlayer].location = 23;
				if(playerList[currentPlayer].location < 0) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash += 200;
				}
				break;
			case 3:
				System.out.println("Advance to St. Charles Place – If you pass Go, collect $200");
				playerList[currentPlayer].location = playerList[currentPlayer].location = 11;
				if(playerList[currentPlayer].location < 0) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash += 200;
				}
				break;
			case 4:
				System.out.println("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.");
				playerList[currentPlayer].location = playerList[currentPlayer].location = 12;
				if(playerList[currentPlayer].location < 0) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash += 200;
				}
				break;
			case 5:
				System.out.println("Advance token to the nearest Railroad and pay owner twice the rental to which he/she {he} is otherwise entitled. If Railroad is unowned, you may buy it from the Bank");
				playerList[currentPlayer].location = playerList[currentPlayer].location = 15;
				if(playerList[currentPlayer].location < 0) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash += 200;
				}
				break;
			case 6:
				System.out.println("Bank pays you dividend of $50 ");
				playerList[currentPlayer].cash = playerList[currentPlayer].cash += 50;
				break;
			case 7:
				System.out.println("Get out of Jail Free");
				//get out of jail card
				break;
			case 8:
				System.out.println("Go Back 3 Spaces");
				playerList[currentPlayer].location = playerList[currentPlayer].location - 3;
				break;
			case 9:
				System.out.println("Go directly to Jail – Do not pass Go, do not collect $200");
				//goto jail
				break;
			case 10:
				System.out.println("Make general repairs on all your property – For each house pay $25 – For each hotel $100");
				
				break;
			case 11:
				System.out.println("Pay poor tax of $15");
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= 15;
				break;
			case 12:
				System.out.println("Take a trip to Reading Railroad – If you pass Go, collect $200 ");
				playerList[currentPlayer].location = playerList[currentPlayer].location = 5;
				if(playerList[currentPlayer].location < 0) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash += 200;
				}
				break;
			case 13:
				System.out.println("Take a walk on the Boardwalk – Advance token to Boardwalk");
				playerList[currentPlayer].location = playerList[currentPlayer].location = 39;
				break;
			case 14:
				System.out.println("You have been elected Chairman of the Board – Pay each player $50");
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -= 50;
				break;
			case 15:
				System.out.println("Your building loan matures – Collect $150");
				playerList[currentPlayer].cash = playerList[currentPlayer].cash += 150;
				break;
			case 16:
				System.out.println("You have won a crossword competition - Collect $100");
				playerList[currentPlayer].cash = playerList[currentPlayer].cash += 100;

				break;
			default: playerList[currentPlayer].location = 30;
				break;
		}
	}
	

	public boolean jail(int currentPlayer, Dice d, Player p) throws IOException {
		Random gen = new Random();
		String askFor50=null;
		int die1;
		int die2;
		int jailTurn=0;
		if(jailTurn==3) {
			System.out.println(playerList[currentPlayer].name+", you have been in jail for 3 turns. You must pay your $50 fine.");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash-50;
		}
		if(playerList[currentPlayer].cash>=50) {
		askFor50=ConsoleUI.promptForInput("You are in jail. Do you want to pay $50(1) or roll for doubles(2)?", false);
			if(askFor50.equals("50")||askFor50.equals("$50")||askFor50.equals("1")) {
				System.out.println(playerList[currentPlayer].name+", you have opted to pay your way out.");
				playerList[currentPlayer].cash = playerList[currentPlayer].cash -50;
				return false;
			}
			askFor50=ConsoleUI.promptForInput("You are in jail. Do you want to roll for doubles(2)?", false);
		}if(askFor50.equalsIgnoreCase("roll for doubles")||askFor50.equalsIgnoreCase("doubles")||askFor50.equalsIgnoreCase("roll")||askFor50.equals("2")) {
			die1 = gen.nextInt(5) + 1;
			die2 = gen.nextInt(5) + 1;
			System.out.println("first die is a "+die1);
			System.out.println("second die is a "+die2);
			if(die1==die2) {
				System.out.println("Congrats, you have rolled doubles! You are now just visiting jail");
				return false;
			}
			
		}
			jailTurn++;
			return true;
	}

	private void speedPlay() {
		// TODO Auto-generated method stub

	}

	public void normalGame(Dice d, Player p, Board b) throws IOException {

		boolean gameWin = false;
		int currentPlayer = firstPlayer;
		int turnCount =0;

		do {
			for (int i = 0; i < playerList.length; i++) {
				currentPlayer = firstPlayer + i;
				if (currentPlayer >= playerList.length) {
					currentPlayer = currentPlayer - playerList.length;
				}
				System.out.println("***********************************");
				playerList[currentPlayer].printPlayer();
				System.out.println("***********************************");
				System.out.println();

//				onMe(currentPlayer);
//				System.out.println("You landed on board space "+playerList[currentPlayer].location);

				System.out.println();
				System.out.println("Okay " + playerList[currentPlayer].name + ", the roll is yours.");
				System.out.println();
				playerList[currentPlayer].location = playerList[currentPlayer].location+ d.rollDice(playerList[currentPlayer]);
//				System.out.println(playerList[currentPlayer].location);
				onMe(currentPlayer, b, p, d);
				turnCount++;
				// p = playerList[currentPlayer]; We need to change p.location to whatever this
				// means. cryptic tutors...

			}

		} while (turnCount<10);


		// need to add code to move piece after every roll, regardless if doubles
		boolean validYesno = false;
		while (!validYesno) {
			String yesno = ConsoleUI.promptForInput("Do you want to play again? Yes/No", false);
			if (yesno.equalsIgnoreCase("yes")) {
				gameSetUp(d, p, b);
			}
		}
	}
}