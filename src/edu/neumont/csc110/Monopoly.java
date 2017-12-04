package edu.neumont.csc110;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Monopoly {
	Player[] playerList = null;
	int firstPlayer;
	ArrayList<PlayerTokens> tokenList = new ArrayList();
	boolean inJail = true;
	int jailTurn = 0;

	String ownerMA = null;
	Player ownerIndexMA = null;
	boolean isOwnedMA = false;

	String ownerBA = null;
	Player ownerIndexBA = null;
	boolean isOwnedBA = false;

	String ownerRR = null;
	Player ownerIndexRR = null;
	boolean isOwnedRR = false;

	String ownerOR = null;
	Player ownerIndexOR = null;
	boolean isOwnedOR = false;

	String ownerVA = null;
	Player ownerIndexVA = null;
	boolean isOwnedVA = false;

	String ownerCA = null;
	Player ownerIndexCA = null;
	boolean isOwnedCA = false;

	String ownerSTC = null;
	Player ownerIndexSTC = null;
	boolean isOwnedSTC = false;

	String ownerEC = null;
	Player ownerIndexEC = null;
	boolean isOwnedEC = false;

	String ownerSA = null;
	Player ownerIndexSA = null;
	boolean isOwnedSA = false;

	String ownerVAve = null;
	Player ownerIndexVAve = null;
	boolean isOwnedVAve = false;

	String ownerPR = null;
	Player ownerIndexPR = null;
	boolean isOwnedPR = false;

	String ownerSJ = null;
	Player ownerIndexSJ = null;
	boolean isOwnedSJ = false;

	String ownerTA = null;
	Player ownerIndexTA = null;
	boolean isOwnedTA = false;

	String ownerNY = null;
	Player ownerIndexNY = null;
	boolean isOwnedNY = false;

	String ownerKA = null;
	Player ownerIndexKA = null;
	boolean isOwnedKA = false;

	String ownerIndA = null;
	Player ownerIndexIndA = null;
	boolean isOwnedIndA = false;

	String ownerIllA = null;
	Player ownerIndexIllA = null;
	boolean isOwnedIllA = false;

	String ownerBOR = null;
	Player ownerIndexBOR = null;
	boolean isOwnedBOR = false;

	String ownerAA = null;
	Player ownerIndexAA = null;
	boolean isOwnedAA = false;

	String ownerVetA = null;
	Player ownerIndexVetA = null;
	boolean isOwnedVetA = false;

	String ownerWW = null;
	Player ownerIndexWW = null;
	boolean isOwnedWW = false;

	String ownerMG = null;
	Player ownerIndexMG = null;
	boolean isOwnedMG = false;

	String ownerPA = null;
	Player ownerIndexPA = null;
	boolean isOwnedPA = false;

	String ownerNCA = null;
	Player ownerIndexNCA = null;
	boolean isOwnedNCA = false;

	String ownerPennA = null;
	Player ownerIndexPennA = null;
	boolean isOwnedPennA = false;

	String ownerSL = null;
	Player ownerIndexSL = null;
	boolean isOwnedSL = false;

	String ownerPP = null;
	Player ownerIndexPP = null;
	boolean isOwnedPP = false;

	String ownerBW = null;
	Player ownerIndexBW = null;
	boolean isOwnedBW = false;

	public void gameSetUp(Dice d, Player p, Board b, Auction a) throws IOException {
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
			}
			System.out.println();
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
			normalGame(d, p, b, a, numPlayers);
		} else {
			speedPlay();
		}

	}

	public void onMe(int currentPlayer, Board b, Player p, Dice d, Auction a, int numPlayers) throws IOException {

		// if current player is on me(any spot on board) then ask to buy or auction.
		// if it is owned pay rent to other player check if they have houses or hotels
		// pay.
		// if player owns all three or two ask to put houses or hotels
		// if player lands on Go to jail do it.
		// if player passes go give money.
		if (playerList[currentPlayer].location == 0) {
			AllBoardPlaces abp = b.getCardAt(0);
			playerList[currentPlayer].cash = playerList[currentPlayer].cash + 200;
		}
		if (playerList[currentPlayer].location == 1) {// MEDITERRANEAN("Mediterranean Avenue",
														// 60,2,10,30,90,190,250,30,30,50,50)
			AllBoardPlaces abp = b.getCardAt(1);
			System.out.println(abp);

			if (isOwnedMA == true) {
				System.out.println(ownerIndexMA + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexMA.cash = ownerIndexMA.cash + abp.baseRent;

			} else if (isOwnedMA == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerMA = playerList[currentPlayer].name;
					isOwnedMA = true;
					ownerIndexMA = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 2) { // COMMUNITY1("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(2);
			System.out.println("Community Chest");
			Communitychest(currentPlayer, numPlayers);
		}
		if (playerList[currentPlayer].location == 3) {// BALIC("Balic Avenu", 60,4,20,60,180,320,450,50,50,50,50),

			AllBoardPlaces abp = b.getCardAt(3);
			System.out.println(abp);
			if (isOwnedBA == true) {
				System.out.println(ownerBA + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexBA.cash = ownerIndexBA.cash + abp.baseRent;

			} else if (isOwnedBA == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerBA = playerList[currentPlayer].name;
					isOwnedBA = true;
					ownerIndexBA = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 4) {// INCOME("Income Tax",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(4);
			System.out.println("Income Tax");
			String input = ConsoleUI.promptForInput("Do you want to pay 10%(yes) or $200(no)?", false);
			if (input.equalsIgnoreCase("yes") || input.equals("10") || input.equals("10%")) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - (playerList[currentPlayer].cash * .1);
			}
			if (input.equalsIgnoreCase("no") || input.equals("200") || input.equals("$200")) {
				playerList[currentPlayer].cash -= 200;
			}
		}
		if (playerList[currentPlayer].location == 5) {// READING("Reading Railroad",200,25,0,50,100,200,0,100,100,0,0),

			AllBoardPlaces abp = b.getCardAt(5);
			System.out.println(abp);
			if (isOwnedRR == true) {
				System.out.println(ownerRR + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexRR.cash = ownerIndexRR.cash + abp.baseRent;

			} else if (isOwnedRR == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerRR = playerList[currentPlayer].name;
					isOwnedRR = true;
					ownerIndexRR = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 6) {// ORIENTAL("Oriental
														// Avenenu",100,6,30,90,270,400,550,50,50,50,50),

			AllBoardPlaces abp = b.getCardAt(6);
			System.out.println(abp);
			if (isOwnedOR == true) {
				System.out.println(ownerOR + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexOR.cash = ownerIndexOR.cash + abp.baseRent;

			} else if (isOwnedOR == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerOR = playerList[currentPlayer].name;
					isOwnedOR = true;
					ownerIndexOR = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 7) {// CHANCE1("Chance",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(7);
			System.out.println("Chance");
			Chance(currentPlayer, numPlayers);

		}
		if (playerList[currentPlayer].location == 8) {// VERMONT("Vermont Avenue",100,6,30,90,270,400,550,50,50,50,50),

			AllBoardPlaces abp = b.getCardAt(8);
			System.out.println(abp);
			if (isOwnedVA == true) {
				System.out.println(ownerVA + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexVA.cash = ownerIndexVA.cash + abp.baseRent;

			} else if (isOwnedVA == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerVA = playerList[currentPlayer].name;
					isOwnedVA = true;
					ownerIndexVA = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 9) {// CONNECTICUT("Connecticut
														// Avenue",120,8,40,100,300,450,600,60,60,50,50),

			AllBoardPlaces abp = b.getCardAt(9);
			System.out.println(abp);
			if (isOwnedCA == true) {
				System.out.println(ownerCA + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexCA.cash = ownerIndexCA.cash + abp.baseRent;

			} else if (isOwnedCA == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerCA = playerList[currentPlayer].name;
					isOwnedCA = true;
					ownerIndexCA = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 10) {// JAIL("Jail",0,0,0,0,0,0,0,0,0,0,0),

			AllBoardPlaces abp = b.getCardAt(10);
			if (playerList[currentPlayer].inJail == false) {
				System.out.println("You have landed on jail. Do not worry, you are just visiting");
			}
			if (playerList[currentPlayer].inJail == true) {
				jail(currentPlayer, d, p);
			}
		}
		if (playerList[currentPlayer].location == 11) {// CHARLES("St.Charles
														// Place",140,10,50,150,450,625,750,70,70,100,100),

			AllBoardPlaces abp = b.getCardAt(11);
			System.out.println(abp);
			if (isOwnedSTC == true) {
				System.out.println(ownerSTC + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexSTC.cash = ownerIndexSTC.cash + abp.baseRent;

			} else if (isOwnedSTC == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerSTC = playerList[currentPlayer].name;
					isOwnedSTC = true;
					ownerIndexSTC = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 12) {// ELECTRIC("Electric Company",150,0,0,0,0,0,0,0,0,0,0),

			AllBoardPlaces abp = b.getCardAt(12);
			System.out.println(abp);
			if (isOwnedEC == true) {
				System.out.println(ownerEC + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexEC.cash = ownerIndexEC.cash + abp.baseRent;

			} else if (isOwnedEC == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerEC = playerList[currentPlayer].name;
					isOwnedEC = true;
					ownerIndexEC = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 13) {// STATES("States
														// Avenue",140,10,50,150,450,625,750,70,70,100,100),

			AllBoardPlaces abp = b.getCardAt(13);
			System.out.println(abp);
			if (isOwnedSA == true) {
				System.out.println(ownerSA + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexSA.cash = ownerIndexSA.cash + abp.baseRent;

			} else if (isOwnedSA == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerSA = playerList[currentPlayer].name;
					isOwnedSA = true;
					ownerIndexSA = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 14) {// PENNSYLVANIARR("Pennsylvania
														// Railraod",200,25,0,50,100,200,0,100,100,0,0),

			AllBoardPlaces abp = b.getCardAt(14);
			System.out.println(abp);
			if (isOwnedVAve == true) {
				System.out.println(ownerVAve + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexVAve.cash = ownerIndexVAve.cash + abp.baseRent;

			} else if (isOwnedVAve == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerVAve = playerList[currentPlayer].name;
					isOwnedVAve = true;
					ownerIndexVAve = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 15) {// VIRGINIA("Virginia
														// Avenue",160,12,60,180,500,700,900,80,80,100,100),

			AllBoardPlaces abp = b.getCardAt(15);
			System.out.println(abp);
			if (isOwnedPR == true) {
				System.out.println(ownerPR + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexPR.cash = ownerIndexPR.cash + abp.baseRent;

			} else if (isOwnedPR == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerPR = playerList[currentPlayer].name;
					isOwnedPR = true;
					ownerIndexPR = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 16) {// COMMUNITY2("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(16);
			System.out.println("Community Chest");
			Communitychest(currentPlayer, numPlayers);
		}
		if (playerList[currentPlayer].location == 17) {// JAMES("St.James
														// Pllace",180,14,70,200,550,750,950,90,90,100,100),

			AllBoardPlaces abp = b.getCardAt(18);
			System.out.println(abp);
			if (isOwnedSJ == true) {
				System.out.println(ownerSJ + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexSJ.cash = ownerIndexSJ.cash + abp.baseRent;

			} else if (isOwnedSJ == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerSJ = playerList[currentPlayer].name;
					isOwnedSJ = true;
					ownerIndexSJ = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 18) {// TENNESSEE("Tennessee
														// Avenue",180,14,70,200,550,750,950,90,90,100,100),

			AllBoardPlaces abp = b.getCardAt(18);
			System.out.println(abp);
			if (isOwnedTA == true) {
				System.out.println(ownerTA + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexTA.cash = ownerIndexTA.cash + abp.baseRent;

			} else if (isOwnedTA == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerTA = playerList[currentPlayer].name;
					isOwnedTA = true;
					ownerIndexTA = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 19) {// NEWYORK("New York Avenue",
														// 200,16,220,600,800,1000,100,100,100,100,100),

			AllBoardPlaces abp = b.getCardAt(19);
			System.out.println(abp);
			if (isOwnedNY == true) {
				System.out.println(ownerNY + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexNY.cash = ownerIndexNY.cash + abp.baseRent;

			} else if (isOwnedNY == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerNY = playerList[currentPlayer].name;
					isOwnedNY = true;
					ownerIndexNY = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 20) {// FREE("Free Parking",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(20);
			System.out.println("Free Parking. Take a Rest!");
		}
		if (playerList[currentPlayer].location == 21) {// KENTUCKY("Kentucky
														// Avenue",220,18,90,250,700,875,1050,110,110,150,150),

			AllBoardPlaces abp = b.getCardAt(21);
			System.out.println(abp);
			if (isOwnedKA == true) {
				System.out.println(ownerKA + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexKA.cash = ownerIndexKA.cash + abp.baseRent;

			} else if (isOwnedKA == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerKA = playerList[currentPlayer].name;
					isOwnedKA = true;
					ownerIndexKA = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 22) {// CHANCE2("Chance",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(22);
			System.out.println("Chance");
			Chance(currentPlayer, numPlayers);
		}
		if (playerList[currentPlayer].location == 23) {// INDIANA("Indiana
														// Avenue",220,18,90,250,700,875,1050,110,110,150,150),

			AllBoardPlaces abp = b.getCardAt(23);
			System.out.println(abp);
			if (isOwnedIndA == true) {
				System.out.println(ownerIndA + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexIndA.cash = ownerIndexIndA.cash + abp.baseRent;

			} else if (isOwnedIndA == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerIndA = playerList[currentPlayer].name;
					isOwnedIndA = true;
					ownerIndexIndA = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 24) {// ILLINOIS("Illinois
														// Avenue",240,20,100,300,750,925,1100,120,120,150,150),

			AllBoardPlaces abp = b.getCardAt(24);
			System.out.println(abp);
			if (isOwnedIllA == true) {
				System.out.println(ownerIllA + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexIllA.cash = ownerIndexIllA.cash + abp.baseRent;

			} else if (isOwnedIllA == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerIllA = playerList[currentPlayer].name;
					isOwnedIllA = true;
					ownerIndexIllA = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 25) {// BANDO("B & O Railroad",200,25,0,50,100,200,0,100,100,0,0),

			AllBoardPlaces abp = b.getCardAt(25);
			System.out.println(abp);
			if (isOwnedBOR == true) {
				System.out.println(ownerBOR + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexBOR.cash = ownerIndexBOR.cash + abp.baseRent;

			} else if (isOwnedBOR == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerBOR = playerList[currentPlayer].name;
					isOwnedBOR = true;
					ownerIndexBOR = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 26) {// ATLANTIC("Atlatic
														// Avenue",260,22,110,330,800,975,1150,130,130,150,150),

			AllBoardPlaces abp = b.getCardAt(26);
			System.out.println(abp);
			if (isOwnedAA == true) {
				System.out.println(ownerAA + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexAA.cash = ownerIndexAA.cash + abp.baseRent;

			} else if (isOwnedAA == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerAA = playerList[currentPlayer].name;
					isOwnedAA = true;
					ownerIndexAA = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 27) {// VENTNOR("Ventnor
														// Avenue",260,22,110,330,800,975,1150,130,130,150,150),

			AllBoardPlaces abp = b.getCardAt(27);
			System.out.println(abp);
			if (isOwnedVetA == true) {
				System.out.println(ownerVetA + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexVetA.cash = ownerIndexVetA.cash + abp.baseRent;

			} else if (isOwnedVetA == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerVetA = playerList[currentPlayer].name;
					isOwnedVetA = true;
					ownerIndexVetA = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 28) {// WATER("Water Works",150,0,0,0,0,0,0,0,0,0,0),

			AllBoardPlaces abp = b.getCardAt(28);
			System.out.println(abp);
			if (isOwnedWW == true) {
				System.out.println(ownerWW + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexWW.cash = ownerIndexWW.cash + abp.baseRent;

			} else if (isOwnedWW == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerWW = playerList[currentPlayer].name;
					isOwnedWW = true;
					ownerIndexWW = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 29) {// MARVIN("Marvin
														// Gardens",280,24,120,360,850,1025,1200,140,140,150,150),

			AllBoardPlaces abp = b.getCardAt(29);
			System.out.println(abp);
			if (isOwnedMG == true) {
				System.out.println(ownerMG + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexMG.cash = ownerIndexMG.cash + abp.baseRent;

			} else if (isOwnedMG == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerMG = playerList[currentPlayer].name;
					isOwnedMG = true;
					ownerIndexMG = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 30) {// GOTJAIL("Go To Jail",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(30);
			System.out.println("You have landed on jail.");
			System.out.println(
					playerList[currentPlayer].name + ", Go straight to jail, do not pass go, do not collect $200");
			playerList[currentPlayer].location = 10;
			playerList[currentPlayer].inJail = true;

		}
		if (playerList[currentPlayer].location == 31) {// PACIFIC("Pacific
														// Avenue",300,26,130,390,900,110,1275,150,150,200,200),

			AllBoardPlaces abp = b.getCardAt(31);
			System.out.println(abp);
			if (isOwnedPA == true) {
				System.out.println(ownerPA + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexPA.cash = ownerIndexPA.cash + abp.baseRent;

			} else if (isOwnedPA == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerPA = playerList[currentPlayer].name;
					isOwnedPA = true;
					ownerIndexPA = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 32) {// NCAROLINA("North Carolina
														// Avenue",300,26,130,390,900,1100,1275,150,150,200,200),

			AllBoardPlaces abp = b.getCardAt(32);
			System.out.println(abp);
			if (isOwnedNCA == true) {
				System.out.println(ownerNCA + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexNCA.cash = ownerIndexNCA.cash + abp.baseRent;

			} else if (isOwnedNCA == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerNCA = playerList[currentPlayer].name;
					isOwnedNCA = true;
					ownerIndexNCA = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 33) {// COMMUNITY3("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(33);
			System.out.println("Community Chest");
			Communitychest(currentPlayer, numPlayers);
		}
		if (playerList[currentPlayer].location == 34) {// PENNSYLVANIA("Pennsylvania
														// Avenue",320,28,150,450,1000,1200,1400,160,160,200,200),

			AllBoardPlaces abp = b.getCardAt(34);
			System.out.println(abp);
			if (isOwnedPennA == true) {
				System.out.println(ownerPennA + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexPennA.cash = ownerIndexPennA.cash + abp.baseRent;

			} else if (isOwnedPennA == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerPennA = playerList[currentPlayer].name;
					isOwnedPennA = true;
					ownerIndexPennA = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 35) {// SHORT("Short Line",200,25,0,50,100,200,0,100,100,0,0),

			AllBoardPlaces abp = b.getCardAt(35);
			System.out.println(abp);
			if (isOwnedSL == true) {
				System.out.println(ownerSL + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexSL.cash = ownerIndexSL.cash + abp.baseRent;

			} else if (isOwnedSL == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerSL = playerList[currentPlayer].name;
					isOwnedSL = true;
					ownerIndexSL = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 36) {// CHANCE3("Chance",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(36);
			System.out.println("Chance");
			Chance(currentPlayer, numPlayers);
		}
		if (playerList[currentPlayer].location == 37) {// PARK("Park
														// Place",350,35,175,500,1100,1300,1500,175,175,200,200),

			AllBoardPlaces abp = b.getCardAt(37);
			System.out.println(abp);
			if (isOwnedPP == true) {
				System.out.println(ownerPP + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexPP.cash = ownerIndexPP.cash + abp.baseRent;

			} else if (isOwnedPP == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerPP = playerList[currentPlayer].name;
					isOwnedPP = true;
					ownerIndexPP = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}
		if (playerList[currentPlayer].location == 38) {// TAX("Lutury Tax",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(38);
			System.out.println("Luxury Tax. You must pay $100");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash - 100;
		}
		if (playerList[currentPlayer].location == 39) {// BOARDWALK("Boardwalk",400,50,200,600,1400,1700,2000,200,200,200,200);

			AllBoardPlaces abp = b.getCardAt(39);
			System.out.println(abp);
			if (isOwnedBW == true) {
				System.out.println(ownerBW + " ownes this property. " + playerList[currentPlayer].name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.baseRent;
				ownerIndexBW.cash = ownerIndexBW.cash + abp.baseRent;

			} else if (isOwnedBW == false) {
				boolean input = ConsoleUI.promptForBool(
						playerList[currentPlayer].name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - abp.cardPrice;
					ownerBW = playerList[currentPlayer].name;
					isOwnedBW = true;
					ownerIndexBW = playerList[currentPlayer];
				} else {
					a.auction();
				}
			}
		}

	}

	public void Communitychest(int currentPlayer, int numPlayers) {
		ArrayList<Integer> usedListCC = new ArrayList();

		// randomly shuffle deck
		int num = 0;
		Random gen = new Random();
		do {
			num = gen.nextInt(16) + 1;
//			 num = 12;
			if (!usedListCC.contains(num)) {
				usedListCC.add(num);
			}
		} while (!usedListCC.contains(num));
		// usedListCC.add(num);

		switch (num) {

		case 1:
			System.out.println("Advance to Go (Collect $200)");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash + 200;
			playerList[currentPlayer].location = playerList[currentPlayer].location = 0;
			break;
		case 2:
			System.out.println("Bank error in your favor – Collect $200");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash + 200;
			break;
		case 3:
			System.out.println("Doctor's fees {fee} – Pay $50");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash - 50;
			break;
		case 4:
			System.out.println("From sale of stock you get $50");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash + 50;
			break;
		case 5:
			System.out.println("Get out of Jail, Free");
			playerList[currentPlayer].jailCard = true;
			break;
		case 6:
			System.out.println("Go directly to jail – Do not pass Go – Do not collect $200");
			playerList[currentPlayer].location = 10;
			break;
		case 7:
			System.out.println("Grand Opera Night – Collect $50 from every player for opening night seats");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash + (50 * (numPlayers - 1));
			break;
		case 8:
			System.out.println("Holiday Fund matures - Collect $100");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash + 100;
			break;
		case 9:
			System.out.println("Income tax refund – Collect $20");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash + 20;
			break;
		case 10:
			System.out.println("It is your birthday - Collect $10 from each player");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash + (10 * numPlayers);
			break;
		case 11:
			System.out.println("Life insurance matures – Collect $100");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash + 100;
			break;
		case 12:
			System.out.println("Pay hospital fees of $100");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash - 100;
			break;
		case 13:
			System.out.println("Pay school fees of $150");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash - 150;
			break;
		case 14:
			System.out.println("Receive $25 consultancy fee");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash + 25;
			break;
		case 15:
			System.out.println("You are assessed for street repairs – $40 per house – $115 per hotel");// **************************
			// check how many houses
			break;
		case 16:
			System.out.println("You have won second prize in a beauty contest – Collect $10");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash + 10;

			break;
		default:
			System.out.println("You hit default, Community Chest");
			break;
		}
	}

	public void Chance(int currentPlayer, int numPlayers) {
		ArrayList<Integer> usedListC = new ArrayList();

		// randomly shuffle deck
		int num = 0;
		Random gen = new Random();
		do {
			num = gen.nextInt(16) + 1;
			// num = 1;
			if (!usedListC.contains(num)) {
				usedListC.add(num);
			}
		} while (!usedListC.contains(num));
		// usedListCC.add(num);

		switch (num) {

		case 1:
			System.out.println("Advance to Go (Collect $200)");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash + 200;
			playerList[currentPlayer].location = playerList[currentPlayer].location = 0;
			break;
		case 2:
			System.out.println("Advance to Illinois Ave. - If you pass Go, collect $200 ");
			if (playerList[currentPlayer].location > 24) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash + 200;
				playerList[currentPlayer].location = 24;
			}
			if (playerList[currentPlayer].location < 24) {
				playerList[currentPlayer].location = 24;
			}
			break;
		case 3:
			System.out.println("Advance to St. Charles Place – If you pass Go, collect $200");
			if (playerList[currentPlayer].location > 11) {
				playerList[currentPlayer].cash = playerList[currentPlayer].cash + 200;
				playerList[currentPlayer].location = 11;
			}
			if (playerList[currentPlayer].location < 11) {
				playerList[currentPlayer].location = 11;
			}
			break;
		case 4:
			System.out.println(
					"Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.");
			playerList[currentPlayer].location = playerList[currentPlayer].location = 12; // 12/28
			if (playerList[currentPlayer].location < 12) {
				playerList[currentPlayer].location = 12;
			}
			if (playerList[currentPlayer].location > 12 && playerList[currentPlayer].location < 28) {
				playerList[currentPlayer].location = 28;
			}
			if (playerList[currentPlayer].location > 28 && playerList[currentPlayer].location < 39) {
				playerList[currentPlayer].location = 12;
				playerList[currentPlayer].cash = playerList[currentPlayer].cash + 200;
			}
			break;
		case 5:
			System.out.println(
					"Advance token to the nearest Railroad and pay owner twice the rental to which he/she {he} is otherwise entitled. If Railroad is unowned, you may buy it from the Bank");
			playerList[currentPlayer].location = playerList[currentPlayer].location = 15;// 5/15/25/35
			if (playerList[currentPlayer].location < 5) {
				playerList[currentPlayer].location = 5;
			}
			if (playerList[currentPlayer].location > 5 && playerList[currentPlayer].location < 15) {
				playerList[currentPlayer].location = 15;
			}
			if (playerList[currentPlayer].location > 15 && playerList[currentPlayer].location < 25) {
				playerList[currentPlayer].location = 25;
			}
			if (playerList[currentPlayer].location > 25 && playerList[currentPlayer].location < 39) {
				playerList[currentPlayer].location = 5;
				playerList[currentPlayer].cash = playerList[currentPlayer].cash + 200;

			}
			break;
		case 6:
			System.out.println("Bank pays you dividend of $50 ");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash + 50;
			break;
		case 7:
			System.out.println("Get out of Jail Free");
			playerList[currentPlayer].jailCard = true;
			break;
		case 8:
			System.out.println("Go Back 3 Spaces");
			playerList[currentPlayer].location = playerList[currentPlayer].location - 3;
			break;
		case 9:
			System.out.println("Go directly to Jail – Do not pass Go, do not collect $200");
			playerList[currentPlayer].location = 10;
			playerList[currentPlayer].inJail = true;
			break;
		case 10:
			System.out.println(
					"Make general repairs on all your property – For each house pay $25 – For each hotel $100");// *****************

			break;
		case 11:
			System.out.println("Pay poor tax of $15");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash - 15;
			break;
		case 12:
			System.out.println("Take a trip to Reading Railroad – If you pass Go, collect $200 ");
			if (playerList[currentPlayer].location < 5) {
				playerList[currentPlayer].location = 5;
			}
			if (playerList[currentPlayer].location > 5) {
				playerList[currentPlayer].location = 5;
				playerList[currentPlayer].cash = playerList[currentPlayer].cash + 200;
			}
			break;
		case 13:
			System.out.println("Take a walk on the Boardwalk – Advance token to Boardwalk");
			if (playerList[currentPlayer].location < 39) {
				playerList[currentPlayer].location = 39;
			}
			break;
		case 14:
			System.out.println("You have been elected Chairman of the Board – Pay each player $50");// ******************************
			playerList[currentPlayer].cash = playerList[currentPlayer].cash - (50 * (numPlayers -1));
			break;
		case 15:
			System.out.println("Your building loan matures – Collect $150");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash + 150;
			break;
		case 16:
			System.out.println("You have won a crossword competition - Collect $100");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash + 100;

			break;
		default:
			System.out.println("You hit the default case, chance");
			;
			break;
		}
	}

	public boolean jail(int currentPlayer, Dice d, Player p) throws IOException {
		Random gen = new Random();
		String askFor50 = null;
		int die1;
		int die2;
		int jailTurn = 0;
	if(playerList[currentPlayer].doubleJail==true) {
		return true;
	}
		if (jailTurn == 3) {
			System.out.println(playerList[currentPlayer].name
					+ ", you have been in jail for 3 turns. You must pay your $50 fine.");
			playerList[currentPlayer].cash = playerList[currentPlayer].cash - 50;
			return false;
		}
		if (playerList[currentPlayer].jailCard == true) {
			System.out.println(playerList[currentPlayer].name
					+ ", You currently have a 'Get of jail free' card. Would you like to use it?");
			String input = ConsoleUI.promptForInput("yes(1) or no(2)", false);
			if (input.equalsIgnoreCase("yes") || input.equals("1")) {
				playerList[currentPlayer].jailCard = false;
				playerList[currentPlayer].inJail = false;
				return false;
			}
		}
		if (playerList[currentPlayer].inJail==true) {
			if (playerList[currentPlayer].cash >= 50) {
				askFor50 = ConsoleUI.promptForInput("You are in jail. Do you want to pay $50(1) to leave?", false);
				if (askFor50.equals("50") || askFor50.equals("$50") || askFor50.equals("1")||askFor50.equalsIgnoreCase("yes")) {
					System.out.println(playerList[currentPlayer].name + ", you have opted to pay your way out.");
					playerList[currentPlayer].inJail = false;
					playerList[currentPlayer].cash = playerList[currentPlayer].cash - 50;
					double cash = playerList[currentPlayer].cash;
					System.out.println("You now have $"+cash+".");
					return playerList[currentPlayer].inJail;
				}
				askFor50 = ConsoleUI.promptForInput("Do you want to roll for doubles(2)?", false);
			}
			if (askFor50.equalsIgnoreCase("roll for doubles") || askFor50.equalsIgnoreCase("doubles")
					|| askFor50.equalsIgnoreCase("roll") || askFor50.equals("2")) {
				die1 = gen.nextInt(5) + 1;
				die2 = gen.nextInt(5) + 1;
				System.out.println("first die is a " + die1);
				System.out.println("second die is a " + die2);
				if (die1 == die2) {
					System.out.println("Congrats, you have rolled doubles! You are now just visiting jail");
					return false;
				}

				if (!(die1 == die2)) {
					System.out.println(playerList[currentPlayer].name + ", you have failed to roll doubles. ");
					return true;
				}
			}
		}
		jailTurn++;
		return inJail;
	}
		

	

	private void speedPlay() {
		// TODO Auto-generated method stub

	}

	public void normalGame(Dice d, Player p, Board b, Auction a, int numPlayers) throws IOException {

		boolean gameWin = false;
		int currentPlayer = firstPlayer;
		int turnCount = 0;

		do {
			for (int i = 0; i < playerList.length; i++) {
				currentPlayer = firstPlayer + i;
				if (currentPlayer >= playerList.length) {
					currentPlayer = currentPlayer - playerList.length;
				}
				System.out.println("***********************************");
				playerList[currentPlayer].printPlayer();
				System.out.println(playerList[currentPlayer].inJail);
				System.out.println("***********************************");
				System.out.println();

				// onMe(currentPlayer);
				// System.out.println("You landed on board space
				// "+playerList[currentPlayer].location);

				System.out.println();
				System.out.println("Okay " + playerList[currentPlayer].name + ", the roll is yours.");
				System.out.println();
				if (playerList[currentPlayer].inJail == false) {
					playerList[currentPlayer].location = playerList[currentPlayer].location
							+ d.rollDice(playerList[currentPlayer]);
					if (playerList[currentPlayer].location > 39) {
						playerList[currentPlayer].location = playerList[currentPlayer].location - 40;
						playerList[currentPlayer].cash = playerList[currentPlayer].cash + 200;
					} 
					
				}
				if (playerList[currentPlayer].inJail == true) {
					jail(currentPlayer, d, p);
					if (playerList[currentPlayer].inJail == false) {
						playerList[currentPlayer].location = playerList[currentPlayer].location
								+ d.rollDice(playerList[currentPlayer]);
					}
				}
				// System.out.println(playerList[currentPlayer].location);
				onMe(currentPlayer, b, p, d, a, numPlayers);
				System.out.println("***********************************");
				System.out.println("End turn");
				playerList[currentPlayer].printPlayer();
				System.out.println(playerList[currentPlayer].inJail);
				System.out.println("***********************************");
				System.out.println();
				String pause = ConsoleUI.promptForInput("", true);

			}
			turnCount++;
			System.out.println("turn number: " + turnCount);
			System.out.println();

		} while (turnCount < 100);

		// need to add code to move piece after every roll, regardless if doubles
		boolean validYesno = false;
		while (!validYesno) {
			String yesno = ConsoleUI.promptForInput("Do you want to play again? Yes/No", false);
			if (yesno.equalsIgnoreCase("yes")) {
				gameSetUp(d, p, b, a);
			}
		}
	}
}