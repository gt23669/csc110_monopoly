package edu.neumont.csc110;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Monopoly {
	ArrayList<Player> playerList = null;
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
		playerList = new ArrayList<Player>(numPlayers);
		int[] firstRoll = new int[numPlayers];
		int maxRoll = 0;

		for (int i = 0; i < numPlayers; i++) {
			playerList.add(new Player());
			playerList.get(i).name = ConsoleUI.promptForInput("Player " + (i + 1) + " enter your name.", false);
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
			playerList.get(i).token = tokenList.get(chosenIndex - 1);
			tokenList.remove(chosenIndex - 1);
			System.out.println(playerList.get(i).token);
			System.out.println();

			firstRoll[i] = d.firstRoll(playerList.get(i));
			if (firstRoll[i] > maxRoll) {
				maxRoll = firstRoll[i];
				firstPlayer = i;
				// System.out.println(maxRoll+"Maxroll");

			} else if (firstRoll[i] == maxRoll) {
				do {
					// System.out.println("do while loop, game setup, reroll************");
					firstRoll[i] = d.firstRoll(playerList.get(i));

					if (firstRoll[i] > maxRoll) {
						maxRoll = firstRoll[i];
						firstPlayer = i;
					}
				} while (firstRoll[i] == maxRoll);
			}
			System.out.println(playerList.get(i).name + " your roll was " + firstRoll[i]);
			System.out.println();
		}
		System.out.println(playerList.get(firstPlayer).name + ", you are first player.");
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

	
		if (playerList.get(currentPlayer).location == 0) {
			AllBoardPlaces abp = b.getCardAt(0);
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 200;
		}
		if (playerList.get(currentPlayer).location == 1) {// MEDITERRANEAN("Mediterranean Avenue",
			
			AllBoardPlaces abp = b.getCardAt(1);
			System.out.println(abp);

			if (isOwnedMA == true) {
				System.out.println(ownerIndexMA + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexMA.cash = ownerIndexMA.cash + abp.baseRent;

			} else if (isOwnedMA == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerMA = playerList.get(currentPlayer).name;
					isOwnedMA = true;
					ownerIndexMA = playerList.get(currentPlayer);
				} else {
					ownerIndexMA = a.auction(playerList, b, numPlayers, abp, p);
					isOwnedMA = true;
				}
			}
		}
		if (playerList.get(currentPlayer).location == 2) { // COMMUNITY1("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(2);
			System.out.println("Community Chest");
			Communitychest(currentPlayer, numPlayers);
		}
		if (playerList.get(currentPlayer).location == 3) {// BALIC("Balic Avenu", 60,4,20,60,180,320,450,50,50,50,50),

			AllBoardPlaces abp = b.getCardAt(3);
			System.out.println(abp);
			if (isOwnedBA == true) {
				System.out.println(ownerBA + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexBA.cash = ownerIndexBA.cash + abp.baseRent;

			} else if (isOwnedBA == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerBA = playerList.get(currentPlayer).name;
					isOwnedBA = true;
					ownerIndexBA = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 4) {// INCOME("Income Tax",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(4);
			System.out.println("Income Tax");
			boolean input = ConsoleUI.promptForBool("Do you want to pay 10%(yes) or $200(no)?","yes", "no");
			if (input==true){

				playerList.get(currentPlayer).cash =(int)playerList.get(currentPlayer).cash - (playerList.get(currentPlayer).cash * .1);

			}
			if (input!=true){
				playerList.get(currentPlayer).cash -= 200;
			}
		}
		if (playerList.get(currentPlayer).location == 5) {// READING("Reading Railroad",200,25,0,50,100,200,0,100,100,0,0),

			AllBoardPlaces abp = b.getCardAt(5);
			System.out.println(abp);
			if (isOwnedRR == true) {
				if(ownerIndexRR.ownRR ==2) {
					System.out.println(ownerRR + " ownes this property. " + playerList.get(currentPlayer).name
							+ ", you owe them $" + (abp.baseRent+25) + " in rent.");
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - (abp.baseRent+25);
					ownerIndexRR.cash = ownerIndexRR.cash + (abp.baseRent+25);
			
				}
				if(ownerIndexRR.ownRR ==3) {
					System.out.println(ownerRR + " ownes this property. " + playerList.get(currentPlayer).name
							+ ", you owe them $" + (abp.baseRent+75) + " in rent.");
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - (abp.baseRent+75);
					ownerIndexRR.cash = ownerIndexRR.cash + (abp.baseRent+75);
					
				}
				if(ownerIndexRR.ownRR ==4) {
					System.out.println(ownerRR + " ownes this property. " + playerList.get(currentPlayer).name
							+ ", you owe them $" + (abp.baseRent+175) + " in rent.");
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - (abp.baseRent+175);
					ownerIndexRR.cash = ownerIndexRR.cash + (abp.baseRent+175);
					
				}
				if(ownerIndexRR.ownRR ==1) {
				System.out.println(ownerRR + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexRR.cash = ownerIndexRR.cash + abp.baseRent;
				}
			} else if (isOwnedRR == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerRR = playerList.get(currentPlayer).name;
					isOwnedRR = true;
					ownerIndexRR = playerList.get(currentPlayer);
					ownerIndexRR.ownRR=ownerIndexRR.ownRR+1;
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
					ownerIndexRR.ownRR=ownerIndexRR.ownRR+1;

				}
			}
		}
		if (playerList.get(currentPlayer).location == 6) {// ORIENTAL("Oriental
														// Avenenu",100,6,30,90,270,400,550,50,50,50,50),

			AllBoardPlaces abp = b.getCardAt(6);
			System.out.println(abp);
			if (isOwnedOR == true) {
				System.out.println(ownerOR + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexOR.cash = ownerIndexOR.cash + abp.baseRent;

			} else if (isOwnedOR == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerOR = playerList.get(currentPlayer).name;
					isOwnedOR = true;
					ownerIndexOR = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 7) {// CHANCE1("Chance",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(7);
			System.out.println("Chance");
			Chance(currentPlayer, numPlayers,b,p,d,a);

		}
		if (playerList.get(currentPlayer).location == 8) {// VERMONT("Vermont Avenue",100,6,30,90,270,400,550,50,50,50,50),

			AllBoardPlaces abp = b.getCardAt(8);
			System.out.println(abp);
			if (isOwnedVA == true) {
				System.out.println(ownerVA + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexVA.cash = ownerIndexVA.cash + abp.baseRent;

			} else if (isOwnedVA == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerVA = playerList.get(currentPlayer).name;
					isOwnedVA = true;
					ownerIndexVA = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 9) {// CONNECTICUT("Connecticut
														// Avenue",120,8,40,100,300,450,600,60,60,50,50),

			AllBoardPlaces abp = b.getCardAt(9);
			System.out.println(abp);
			if (isOwnedCA == true) {
				System.out.println(ownerCA + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexCA.cash = ownerIndexCA.cash + abp.baseRent;

			} else if (isOwnedCA == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerCA = playerList.get(currentPlayer).name;
					isOwnedCA = true;
					ownerIndexCA = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 10) {// JAIL("Jail",0,0,0,0,0,0,0,0,0,0,0),

			AllBoardPlaces abp = b.getCardAt(10);
			if (playerList.get(currentPlayer).inJail == false) {
				System.out.println("You have landed on jail. Do not worry, you are just visiting");
			}
			if (playerList.get(currentPlayer).inJail == true) {
				jail(currentPlayer, d, p);
			}
		}
		if (playerList.get(currentPlayer).location == 11) {// CHARLES("St.Charles
														// Place",140,10,50,150,450,625,750,70,70,100,100),

			AllBoardPlaces abp = b.getCardAt(11);
			System.out.println(abp);
			if (isOwnedSTC == true) {
				System.out.println(ownerSTC + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexSTC.cash = ownerIndexSTC.cash + abp.baseRent;

			} else if (isOwnedSTC == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerSTC = playerList.get(currentPlayer).name;
					isOwnedSTC = true;
					ownerIndexSTC = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 12) {// ELECTRIC("Electric Company",150,0,0,0,0,0,0,0,0,0,0),

			AllBoardPlaces abp = b.getCardAt(12);
			System.out.println(abp);
			if (isOwnedEC == true) {
				System.out.println(ownerEC + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexEC.cash = ownerIndexEC.cash + abp.baseRent;

			} else if (isOwnedEC == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerEC = playerList.get(currentPlayer).name;
					isOwnedEC = true;
					ownerIndexEC = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 13) {// STATES("States
														// Avenue",140,10,50,150,450,625,750,70,70,100,100),

			AllBoardPlaces abp = b.getCardAt(13);
			System.out.println(abp);
			if (isOwnedSA == true) {
				System.out.println(ownerSA + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexSA.cash = ownerIndexSA.cash + abp.baseRent;

			} else if (isOwnedSA == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerSA = playerList.get(currentPlayer).name;
					isOwnedSA = true;
					ownerIndexSA = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 14) {// PENNSYLVANIARR("Pennsylvania
														// Railraod",200,25,0,50,100,200,0,100,100,0,0),

			AllBoardPlaces abp = b.getCardAt(14);
			System.out.println(abp);
			if (isOwnedVAve == true) {
				System.out.println(ownerVAve + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexVAve.cash = ownerIndexVAve.cash + abp.baseRent;

			} else if (isOwnedVAve == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerVAve = playerList.get(currentPlayer).name;
					isOwnedVAve = true;
					ownerIndexVAve = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 15) {// VIRGINIA("Virginia
														// Avenue",160,12,60,180,500,700,900,80,80,100,100),

			AllBoardPlaces abp = b.getCardAt(15);
			System.out.println(abp);
			if (isOwnedPR == true) {
				if(ownerIndexPR.ownRR ==2) {
					System.out.println(ownerRR + " ownes this property. " + playerList.get(currentPlayer).name
							+ ", you owe them $" + (abp.baseRent+25) + " in rent.");
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - (abp.baseRent+25);
					ownerIndexPR.cash = ownerIndexPR.cash + (abp.baseRent+25);
					
				}
				if(ownerIndexPR.ownRR ==3) {
					System.out.println(ownerRR + " ownes this property. " + playerList.get(currentPlayer).name
							+ ", you owe them $" + (abp.baseRent+75) + " in rent.");
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - (abp.baseRent+75);
					ownerIndexPR.cash = ownerIndexPR.cash + (abp.baseRent+75);
					
				}
				if(ownerIndexPR.ownRR ==4) {
					System.out.println(ownerRR + " ownes this property. " + playerList.get(currentPlayer).name
							+ ", you owe them $" + (abp.baseRent+175) + " in rent.");
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - (abp.baseRent+175);
					ownerIndexPR.cash = ownerIndexPR.cash + (abp.baseRent+175);
					
				}
				if(ownerIndexPR.ownRR ==1) {
				System.out.println(ownerPR + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexPR.cash = ownerIndexPR.cash + abp.baseRent;
				}

			} else if (isOwnedPR == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerPR = playerList.get(currentPlayer).name;
					isOwnedPR = true;
					ownerIndexPR = playerList.get(currentPlayer);
					ownerIndexPR.ownRR=ownerIndexPR.ownRR+1;
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
					ownerIndexPR.ownRR=ownerIndexPR.ownRR+1;

				}
			}
		}
		if (playerList.get(currentPlayer).location == 16) {// COMMUNITY2("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(16);
			System.out.println("Community Chest");
			Communitychest(currentPlayer, numPlayers);
		}
		if (playerList.get(currentPlayer).location == 17) {// JAMES("St.James
														// Pllace",180,14,70,200,550,750,950,90,90,100,100),

			AllBoardPlaces abp = b.getCardAt(18);
			System.out.println(abp);
			if (isOwnedSJ == true) {
				System.out.println(ownerSJ + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexSJ.cash = ownerIndexSJ.cash + abp.baseRent;

			} else if (isOwnedSJ == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerSJ = playerList.get(currentPlayer).name;
					isOwnedSJ = true;
					ownerIndexSJ = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 18) {// TENNESSEE("Tennessee
														// Avenue",180,14,70,200,550,750,950,90,90,100,100),

			AllBoardPlaces abp = b.getCardAt(18);
			System.out.println(abp);
			if (isOwnedTA == true) {
				System.out.println(ownerTA + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexTA.cash = ownerIndexTA.cash + abp.baseRent;

			} else if (isOwnedTA == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerTA = playerList.get(currentPlayer).name;
					isOwnedTA = true;
					ownerIndexTA = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 19) {// NEWYORK("New York Avenue",
														// 200,16,220,600,800,1000,100,100,100,100,100),

			AllBoardPlaces abp = b.getCardAt(19);
			System.out.println(abp);
			if (isOwnedNY == true) {
				System.out.println(ownerNY + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexNY.cash = ownerIndexNY.cash + abp.baseRent;

			} else if (isOwnedNY == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerNY = playerList.get(currentPlayer).name;
					isOwnedNY = true;
					ownerIndexNY = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 20) {// FREE("Free Parking",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(20);
			System.out.println("Free Parking. Take a Rest!");
		}
		if (playerList.get(currentPlayer).location == 21) {// KENTUCKY("Kentucky
														// Avenue",220,18,90,250,700,875,1050,110,110,150,150),

			AllBoardPlaces abp = b.getCardAt(21);
			System.out.println(abp);
			if (isOwnedKA == true) {
				System.out.println(ownerKA + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexKA.cash = ownerIndexKA.cash + abp.baseRent;

			} else if (isOwnedKA == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerKA = playerList.get(currentPlayer).name;
					isOwnedKA = true;
					ownerIndexKA = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 22) {// CHANCE2("Chance",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(22);
			System.out.println("Chance");
			Chance(currentPlayer, numPlayers,b,p,d, a);
		}
		if (playerList.get(currentPlayer).location == 23) {// INDIANA("Indiana
														// Avenue",220,18,90,250,700,875,1050,110,110,150,150),

			AllBoardPlaces abp = b.getCardAt(23);
			System.out.println(abp);
			if (isOwnedIndA == true) {
				System.out.println(ownerIndA + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexIndA.cash = ownerIndexIndA.cash + abp.baseRent;

			} else if (isOwnedIndA == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerIndA = playerList.get(currentPlayer).name;
					isOwnedIndA = true;
					ownerIndexIndA = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 24) {// ILLINOIS("Illinois
														// Avenue",240,20,100,300,750,925,1100,120,120,150,150),

			AllBoardPlaces abp = b.getCardAt(24);
			System.out.println(abp);
			if (isOwnedIllA == true) {
				System.out.println(ownerIllA + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexIllA.cash = ownerIndexIllA.cash + abp.baseRent;

			} else if (isOwnedIllA == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerIllA = playerList.get(currentPlayer).name;
					isOwnedIllA = true;
					ownerIndexIllA = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 25) {// BANDO("B & O Railroad",200,25,0,50,100,200,0,100,100,0,0),

			AllBoardPlaces abp = b.getCardAt(25);
			System.out.println(abp);
			if (isOwnedBOR == true) {
				if(ownerIndexBOR.ownRR ==2) {
					System.out.println(ownerRR + " ownes this property. " + playerList.get(currentPlayer).name
							+ ", you owe them $" + (abp.baseRent+25) + " in rent.");
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - (abp.baseRent+25);
					ownerIndexBOR.cash = ownerIndexBOR.cash + (abp.baseRent+25);
					
				}
				if(ownerIndexBOR.ownRR ==3) {
					System.out.println(ownerRR + " ownes this property. " + playerList.get(currentPlayer).name
							+ ", you owe them $" + (abp.baseRent+75) + " in rent.");
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - (abp.baseRent+75);
					ownerIndexBOR.cash = ownerIndexBOR.cash + (abp.baseRent+75);
					
				}
				if(ownerIndexBOR.ownRR ==4) {
					System.out.println(ownerRR + " ownes this property. " + playerList.get(currentPlayer).name
							+ ", you owe them $" + (abp.baseRent+175) + " in rent.");
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - (abp.baseRent+175);
					ownerIndexBOR.cash = ownerIndexBOR.cash + (abp.baseRent+175);
					
				}
				if(ownerIndexBOR.ownRR ==1) {
				System.out.println(ownerBOR + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				}

			} else if (isOwnedBOR == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerBOR = playerList.get(currentPlayer).name;
					isOwnedBOR = true;
					ownerIndexBOR = playerList.get(currentPlayer);
					ownerIndexBOR.ownRR=ownerIndexBOR.ownRR+1;
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
					ownerIndexBOR.ownRR=ownerIndexBOR.ownRR+1;

				}
			}
		}
		if (playerList.get(currentPlayer).location == 26) {// ATLANTIC("Atlatic
														// Avenue",260,22,110,330,800,975,1150,130,130,150,150),

			AllBoardPlaces abp = b.getCardAt(26);
			System.out.println(abp);
			if (isOwnedAA == true) {
				System.out.println(ownerAA + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexAA.cash = ownerIndexAA.cash + abp.baseRent;

			} else if (isOwnedAA == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerAA = playerList.get(currentPlayer).name;
					isOwnedAA = true;
					ownerIndexAA = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 27) {// VENTNOR("Ventnor
														// Avenue",260,22,110,330,800,975,1150,130,130,150,150),

			AllBoardPlaces abp = b.getCardAt(27);
			System.out.println(abp);
			if (isOwnedVetA == true) {
				System.out.println(ownerVetA + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexVetA.cash = ownerIndexVetA.cash + abp.baseRent;

			} else if (isOwnedVetA == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerVetA = playerList.get(currentPlayer).name;
					isOwnedVetA = true;
					ownerIndexVetA = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 28) {// WATER("Water Works",150,0,0,0,0,0,0,0,0,0,0),

			AllBoardPlaces abp = b.getCardAt(28);
			System.out.println(abp);
			if (isOwnedWW == true) {
				System.out.println(ownerWW + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexWW.cash = ownerIndexWW.cash + abp.baseRent;

			} else if (isOwnedWW == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerWW = playerList.get(currentPlayer).name;
					isOwnedWW = true;
					ownerIndexWW = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 29) {// MARVIN("Marvin
														// Gardens",280,24,120,360,850,1025,1200,140,140,150,150),

			AllBoardPlaces abp = b.getCardAt(29);
			System.out.println(abp);
			if (isOwnedMG == true) {
				System.out.println(ownerMG + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexMG.cash = ownerIndexMG.cash + abp.baseRent;

			} else if (isOwnedMG == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerMG = playerList.get(currentPlayer).name;
					isOwnedMG = true;
					ownerIndexMG = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 30) {// GOTJAIL("Go To Jail",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(30);
			System.out.println("You have landed on jail.");
			System.out.println(
					playerList.get(currentPlayer).name + ", Go straight to jail, do not pass go, do not collect $200");
			playerList.get(currentPlayer).location = 10;
			playerList.get(currentPlayer).inJail = true;

		}
		if (playerList.get(currentPlayer).location == 31) {// PACIFIC("Pacific
														// Avenue",300,26,130,390,900,110,1275,150,150,200,200),

			AllBoardPlaces abp = b.getCardAt(31);
			System.out.println(abp);
			if (isOwnedPA == true) {
				System.out.println(ownerPA + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexPA.cash = ownerIndexPA.cash + abp.baseRent;

			} else if (isOwnedPA == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerPA = playerList.get(currentPlayer).name;
					isOwnedPA = true;
					ownerIndexPA = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 32) {// NCAROLINA("North Carolina
														// Avenue",300,26,130,390,900,1100,1275,150,150,200,200),

			AllBoardPlaces abp = b.getCardAt(32);
			System.out.println(abp);
			if (isOwnedNCA == true) {
				System.out.println(ownerNCA + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexNCA.cash = ownerIndexNCA.cash + abp.baseRent;

			} else if (isOwnedNCA == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerNCA = playerList.get(currentPlayer).name;
					isOwnedNCA = true;
					ownerIndexNCA = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 33) {// COMMUNITY3("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(33);
			System.out.println("Community Chest");
			Communitychest(currentPlayer, numPlayers);
		}
		if (playerList.get(currentPlayer).location == 34) {// PENNSYLVANIA("Pennsylvania
														// Avenue",320,28,150,450,1000,1200,1400,160,160,200,200),

			AllBoardPlaces abp = b.getCardAt(34);
			System.out.println(abp);
			if (isOwnedPennA == true) {
				System.out.println(ownerPennA + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexPennA.cash = ownerIndexPennA.cash + abp.baseRent;

			} else if (isOwnedPennA == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerPennA = playerList.get(currentPlayer).name;
					isOwnedPennA = true;
					ownerIndexPennA = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 35) {// SHORT("Short Line",200,25,0,50,100,200,0,100,100,0,0),

			AllBoardPlaces abp = b.getCardAt(35);
			System.out.println(abp);
			if (isOwnedSL == true) {
				if(ownerIndexSL.ownRR ==2) {
					System.out.println(ownerRR + " ownes this property. " + playerList.get(currentPlayer).name
							+ ", you owe them $" + (abp.baseRent+25) + " in rent.");
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - (abp.baseRent+25);
					ownerIndexSL.cash = ownerIndexSL.cash + (abp.baseRent+25);
					
				}
				if(ownerIndexSL.ownRR ==3) {
					System.out.println(ownerRR + " ownes this property. " + playerList.get(currentPlayer).name
							+ ", you owe them $" + (abp.baseRent+75) + " in rent.");
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - (abp.baseRent+75);
					ownerIndexSL.cash = ownerIndexSL.cash + (abp.baseRent+75);
					
				}
				if(ownerIndexSL.ownRR ==4) {
					System.out.println(ownerRR + " ownes this property. " + playerList.get(currentPlayer).name
							+ ", you owe them $" + (abp.baseRent+175) + " in rent.");
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - (abp.baseRent+175);
					ownerIndexSL.cash = ownerIndexSL.cash + (abp.baseRent+175);
					
				}
				if(ownerIndexSL.ownRR ==1) {
				System.out.println(ownerSL + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexSL.cash = ownerIndexSL.cash + abp.baseRent;
				}
			} else if (isOwnedSL == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerSL = playerList.get(currentPlayer).name;
					isOwnedSL = true;
					ownerIndexSL = playerList.get(currentPlayer);
					ownerIndexSL.ownRR=ownerIndexSL.ownRR+1;
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
					ownerIndexSL.ownRR=ownerIndexSL.ownRR+1;

				}
			}
		}
		if (playerList.get(currentPlayer).location == 36) {// CHANCE3("Chance",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(36);
			System.out.println("Chance");
			Chance(currentPlayer, numPlayers,b,p,d,a);
		}
		if (playerList.get(currentPlayer).location == 37) {// PARK("Park
														// Place",350,35,175,500,1100,1300,1500,175,175,200,200),

			AllBoardPlaces abp = b.getCardAt(37);
			System.out.println(abp);
			if (isOwnedPP == true) {
				System.out.println(ownerPP + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexPP.cash = ownerIndexPP.cash + abp.baseRent;

			} else if (isOwnedPP == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerPP = playerList.get(currentPlayer).name;
					isOwnedPP = true;
					ownerIndexPP = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}
		if (playerList.get(currentPlayer).location == 38) {// TAX("Lutury Tax",0,0,0,0,0,0,0,0,0,0,0),
			AllBoardPlaces abp = b.getCardAt(38);
			System.out.println("Luxury Tax. You must pay $100");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - 100;
		}
		if (playerList.get(currentPlayer).location == 39) {// BOARDWALK("Boardwalk",400,50,200,600,1400,1700,2000,200,200,200,200);

			AllBoardPlaces abp = b.getCardAt(39);
			System.out.println(abp);
			if (isOwnedBW == true) {
				System.out.println(ownerBW + " ownes this property. " + playerList.get(currentPlayer).name
						+ ", you owe them $" + abp.baseRent + " in rent.");
				System.out.println();
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.baseRent;
				ownerIndexBW.cash = ownerIndexBW.cash + abp.baseRent;

			} else if (isOwnedBW == false) {
				System.out.println();
				boolean input = ConsoleUI.promptForBool(
						playerList.get(currentPlayer).name + " Would you like to buy this property(yes)?", "yes", "no");
				if (input == true) {
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - abp.cardPrice;
					ownerBW = playerList.get(currentPlayer).name;
					isOwnedBW = true;
					ownerIndexBW = playerList.get(currentPlayer);
				} else {
					a.auction(playerList, b, numPlayers, abp, p);
				}
			}
		}

	}

	public void buyHouses(int currentPlayer) throws IOException {
		boolean input = ConsoleUI.promptForBool("Would you like to buy houses?", "Yes", "No");
		if (input == true) {
			if (isOwnedMA == true && isOwnedBA == true) {
				Boolean whatPlace = ConsoleUI.promptForBool("Where are you placing it (one or two", "one", "two");
				if (whatPlace == true) {
					int number = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
					switch (number) {
					case 1:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- AllBoardPlaces.MEDITERRANEAN.houseCost;
						AllBoardPlaces.MEDITERRANEAN.houseNum = 1;
						break;
					case 2:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.MEDITERRANEAN.houseCost * 2);
						AllBoardPlaces.MEDITERRANEAN.houseNum = 2;
						break;
					case 3:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.MEDITERRANEAN.houseCost * 3);
						AllBoardPlaces.MEDITERRANEAN.houseNum = 3;
						break;
					case 4:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.MEDITERRANEAN.houseCost * 4);
						AllBoardPlaces.MEDITERRANEAN.houseNum = 4;
						break;

					}
					if (whatPlace == false) {
						int number2 = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
						switch (number2) {
						case 1:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- AllBoardPlaces.BALIC.houseCost;
							AllBoardPlaces.BALIC.houseNum = 1;
							break;
						case 2:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.BALIC.houseCost * 2);
							AllBoardPlaces.BALIC.houseNum = 2;
							break;
						case 3:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.BALIC.houseCost * 3);
							AllBoardPlaces.BALIC.houseNum = 3;
							break;
						case 4:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.BALIC.houseCost * 4);
							AllBoardPlaces.BALIC.houseNum = 4;
							break;

						}

					}
				}
			}

			if (isOwnedOR == true && isOwnedVA == true && isOwnedCA == true) {
				int whatPlace = ConsoleUI.promptForInt("What place are you puting your houses 1 , 2 , or 3", 1, 3);
				if (whatPlace == 1) {
					int number = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
					switch (number) {
					case 1:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- AllBoardPlaces.ORIENTAL.houseCost;
						AllBoardPlaces.ORIENTAL.houseNum = 1;
						break;
					case 2:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.ORIENTAL.houseCost * 2);
						AllBoardPlaces.ORIENTAL.houseNum = 2;
						break;
					case 3:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.ORIENTAL.houseCost * 3);
						AllBoardPlaces.ORIENTAL.houseNum = 3;
						break;
					case 4:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.ORIENTAL.houseCost * 4);
						AllBoardPlaces.ORIENTAL.houseNum = 4;
						break;

					}
					if (whatPlace == 2) {
						int number2 = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
						switch (number2) {
						case 1:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- AllBoardPlaces.VERMONT.houseCost;

							AllBoardPlaces.ORIENTAL.houseNum = 1;

							break;
						case 2:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.VERMONT.houseCost * 2);

							AllBoardPlaces.ORIENTAL.houseNum = 2;

							break;
						case 3:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.VERMONT.houseCost * 3);

							AllBoardPlaces.ORIENTAL.houseNum = 3;

							break;
						case 4:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.VERMONT.houseCost * 4);

							AllBoardPlaces.ORIENTAL.houseNum = 4;

							break;

						}
						if (whatPlace == 3) {
							int number3 = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
							switch (number3) {
							case 1:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- AllBoardPlaces.CONNECTICUT.houseCost;

								AllBoardPlaces.ORIENTAL.houseNum = 1;

								break;
							case 2:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.CONNECTICUT.houseCost * 2);

								AllBoardPlaces.ORIENTAL.houseNum = 2;

								break;
							case 3:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.CONNECTICUT.houseCost * 3);

								AllBoardPlaces.ORIENTAL.houseNum = 3;

								break;
							case 4:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.CONNECTICUT.houseCost * 4);

								AllBoardPlaces.ORIENTAL.houseNum = 4;

								break;

							}
						}

					}
				}

			}
			if (isOwnedSTC == true && isOwnedVAve == true && isOwnedSA == true) {

				int whatPlace = ConsoleUI.promptForInt("What place are you puting your houses 1 , 2 , or 3", 1, 3);
				if (whatPlace == 1) {
					int number = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
					switch (number) {
					case 1:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- AllBoardPlaces.CHARLES.houseCost;
						AllBoardPlaces.CHARLES.houseNum = 1;
						break;
					case 2:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.CHARLES.houseCost * 2);
						AllBoardPlaces.CHARLES.houseNum = 2;
						break;
					case 3:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.CHARLES.houseCost * 3);
						AllBoardPlaces.CHARLES.houseNum = 3;
						break;
					case 4:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.CHARLES.houseCost * 4);
						AllBoardPlaces.CHARLES.houseNum = 4;
						break;

					}
					if (whatPlace == 2) {
						int number2 = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
						switch (number2) {
						case 1:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- AllBoardPlaces.STATES.houseCost;
							AllBoardPlaces.STATES.houseNum = 1;
							break;
						case 2:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.STATES.houseCost * 2);
							AllBoardPlaces.STATES.houseNum = 2;
							break;
						case 3:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.STATES.houseCost * 3);
							AllBoardPlaces.STATES.houseNum = 3;
							break;
						case 4:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.STATES.houseCost * 4);
							AllBoardPlaces.STATES.houseNum = 4;
							break;

						}
						if (whatPlace == 3) {
							int number3 = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
							switch (number3) {
							case 1:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- AllBoardPlaces.VIRGINIA.houseCost;
								AllBoardPlaces.VIRGINIA.houseNum = 1;
								break;
							case 2:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.VIRGINIA.houseCost * 2);
								AllBoardPlaces.VIRGINIA.houseNum = 2;
								break;
							case 3:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.VIRGINIA.houseCost * 3);
								AllBoardPlaces.VIRGINIA.houseNum = 3;
								break;
							case 4:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.VIRGINIA.houseCost * 4);
								AllBoardPlaces.VIRGINIA.houseNum = 4;
								break;

							}
						}

					}
				}


			}

			if (isOwnedSJ == true && isOwnedTA == true && isOwnedNY == true) {


			}
			if (isOwnedKA == true && isOwnedIndA == true && isOwnedIllA == true) {

				int whatPlace = ConsoleUI.promptForInt("What place are you puting your houses 1 , 2 , or 3", 1, 3);
				if (whatPlace == 1) {
					int number = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
					switch (number) {
					case 1:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- AllBoardPlaces.JAMES.houseCost;
						AllBoardPlaces.JAMES.houseNum = 1;
						break;
					case 2:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.JAMES.houseCost * 2);
						AllBoardPlaces.JAMES.houseNum = 2;
						break;
					case 3:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.JAMES.houseCost * 3);
						AllBoardPlaces.JAMES.houseNum = 3;
						break;
					case 4:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.JAMES.houseCost * 4);
						AllBoardPlaces.JAMES.houseNum = 4;
						break;

					}
					if (whatPlace == 2) {
						int number2 = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
						switch (number2) {
						case 1:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- AllBoardPlaces.TENNESSEE.houseCost;
							AllBoardPlaces.TENNESSEE.houseNum = 1;
							break;
						case 2:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.TENNESSEE.houseCost * 2);
							AllBoardPlaces.TENNESSEE.houseNum = 2;
							break;
						case 3:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.TENNESSEE.houseCost * 3);
							AllBoardPlaces.TENNESSEE.houseNum = 3;
							break;
						case 4:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.TENNESSEE.houseCost * 4);
							AllBoardPlaces.TENNESSEE.houseNum = 4;
							break;

						}
						if (whatPlace == 3) {
							int number3 = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
							switch (number3) {
							case 1:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- AllBoardPlaces.NEWYORK.houseCost;
								AllBoardPlaces.NEWYORK.houseNum = 1;
								break;
							case 2:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.NEWYORK.houseCost * 2);
								AllBoardPlaces.NEWYORK.houseNum = 2;
								break;
							case 3:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.NEWYORK.houseCost * 3);
								AllBoardPlaces.NEWYORK.houseNum = 3;
								break;
							case 4:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.NEWYORK.houseCost * 4);
								AllBoardPlaces.NEWYORK.houseNum = 4;
								break;

							}
						}

					}
				}

			}
			if (isOwnedKA == true && isOwnedIndA == true && isOwnedIllA == true) {
				int whatPlace = ConsoleUI.promptForInt("What place are you puting your houses 1 , 2 , or 3", 1, 3);
				if (whatPlace == 1) {
					int number = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
					switch (number) {
					case 1:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- AllBoardPlaces.KENTUCKY.houseCost;
						AllBoardPlaces.KENTUCKY.houseNum = 1;
						break;
					case 2:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.KENTUCKY.houseCost * 2);
						AllBoardPlaces.KENTUCKY.houseNum = 2;
						break;
					case 3:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.KENTUCKY.houseCost * 3);
						AllBoardPlaces.KENTUCKY.houseNum = 3;
						break;
					case 4:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.KENTUCKY.houseCost * 4);
						AllBoardPlaces.KENTUCKY.houseNum = 4;
						break;

					}
					if (whatPlace == 2) {
						int number2 = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
						switch (number2) {
						case 1:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- AllBoardPlaces.INDIANA.houseCost;
							AllBoardPlaces.INDIANA.houseNum = 1;
							break;
						case 2:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.INDIANA.houseCost * 2);
							AllBoardPlaces.INDIANA.houseNum = 2;
							break;
						case 3:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.INDIANA.houseCost * 3);
							AllBoardPlaces.INDIANA.houseNum = 3;
							break;
						case 4:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.INDIANA.houseCost * 4);
							AllBoardPlaces.INDIANA.houseNum = 4;
							break;

						}
						if (whatPlace == 3) {
							int number3 = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
							switch (number3) {
							case 1:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- AllBoardPlaces.ILLINOIS.houseCost;
								AllBoardPlaces.ILLINOIS.houseNum = 1;
								break;
							case 2:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.ILLINOIS.houseCost * 2);
								AllBoardPlaces.ILLINOIS.houseNum = 2;
								break;
							case 3:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.ILLINOIS.houseCost * 3);
								AllBoardPlaces.ILLINOIS.houseNum = 3;
								break;
							case 4:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.ILLINOIS.houseCost * 4);
								AllBoardPlaces.ILLINOIS.houseNum = 4;
								break;

							}
						}

					}
				}


			}

			if (isOwnedAA == true && isOwnedVetA == true && isOwnedMG == true) {

				int whatPlace = ConsoleUI.promptForInt("What place are you puting your houses 1 , 2 , or 3", 1, 3);
				if (whatPlace == 1) {
					int number = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
					switch (number) {
					case 1:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- AllBoardPlaces.ATLANTIC.houseCost;
						AllBoardPlaces.ATLANTIC.houseNum = 1;
						break;
					case 2:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.ATLANTIC.houseCost * 2);
						AllBoardPlaces.ATLANTIC.houseNum = 2;
						break;
					case 3:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.ATLANTIC.houseCost * 3);
						AllBoardPlaces.ATLANTIC.houseNum = 3;
						break;
					case 4:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.ATLANTIC.houseCost * 4);
						AllBoardPlaces.ATLANTIC.houseNum = 4;
						break;

					}
					if (whatPlace == 2) {
						int number2 = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
						switch (number2) {
						case 1:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- AllBoardPlaces.VENTNOR.houseCost;
							AllBoardPlaces.VENTNOR.houseNum = 1;
							break;
						case 2:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.VENTNOR.houseCost * 2);
							AllBoardPlaces.VENTNOR.houseNum = 2;
							break;
						case 3:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.VENTNOR.houseCost * 3);
							AllBoardPlaces.VENTNOR.houseNum = 3;
							break;
						case 4:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.VENTNOR.houseCost * 4);
							AllBoardPlaces.VENTNOR.houseNum = 4;
							break;

						}
						if (whatPlace == 3) {
							int number3 = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
							switch (number3) {
							case 1:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- AllBoardPlaces.MARVIN.houseCost;
								AllBoardPlaces.MARVIN.houseNum = 1;
								break;
							case 2:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.MARVIN.houseCost * 2);
								AllBoardPlaces.MARVIN.houseNum = 2;
								break;
							case 3:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.MARVIN.houseCost * 3);
								AllBoardPlaces.MARVIN.houseNum = 3;
								break;
							case 4:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.MARVIN.houseCost * 4);
								AllBoardPlaces.MARVIN.houseNum = 4;
								break;

							}
						}

					}
				}


			}

			if (isOwnedPA == true && isOwnedNCA == true && isOwnedPennA == true) {

				int whatPlace = ConsoleUI.promptForInt("What place are you puting your houses 1 , 2 , or 3", 1, 3);
				if (whatPlace == 1) {
					int number = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
					switch (number) {
					case 1:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- AllBoardPlaces.PACIFIC.houseCost;
						AllBoardPlaces.PACIFIC.houseNum = 1;
						break;
					case 2:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.PACIFIC.houseCost * 2);
						AllBoardPlaces.PACIFIC.houseNum = 2;
						break;
					case 3:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.PACIFIC.houseCost * 3);
						AllBoardPlaces.PACIFIC.houseNum = 3;
						break;
					case 4:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.PACIFIC.houseCost * 4);
						AllBoardPlaces.PACIFIC.houseNum = 4;
						break;

					}
					if (whatPlace == 2) {
						int number2 = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
						switch (number2) {
						case 1:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- AllBoardPlaces.NCAROLINA.houseCost;
							AllBoardPlaces.NCAROLINA.houseNum = 1;
							break;
						case 2:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.NCAROLINA.houseCost * 2);
							AllBoardPlaces.NCAROLINA.houseNum = 2;
							break;
						case 3:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.NCAROLINA.houseCost * 3);
							AllBoardPlaces.NCAROLINA.houseNum = 3;
							break;
						case 4:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.NCAROLINA.houseCost * 4);
							AllBoardPlaces.NCAROLINA.houseNum = 4;
							break;

						}
						if (whatPlace == 3) {
							int number3 = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
							switch (number3) {
							case 1:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- AllBoardPlaces.PENNSYLVANIA.houseCost;
								AllBoardPlaces.PENNSYLVANIA.houseNum = 1;
								break;
							case 2:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.PENNSYLVANIA.houseCost * 2);
								AllBoardPlaces.PENNSYLVANIA.houseNum = 2;
								break;
							case 3:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.PENNSYLVANIA.houseCost * 3);
								AllBoardPlaces.PENNSYLVANIA.houseNum = 3;
								break;
							case 4:
								playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
										- (AllBoardPlaces.PENNSYLVANIA.houseCost * 4);
								AllBoardPlaces.PENNSYLVANIA.houseNum = 4;
								break;

							}
						}

					}
				}


			}

			if (isOwnedPP == true && isOwnedBW == true) {
				Boolean whatPlace = ConsoleUI.promptForBool("Where are you placing it (one or two", "one", "two");
				if (whatPlace == true) {
					int number = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
					switch (number) {
					case 1:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash

								- AllBoardPlaces.MEDITERRANEAN.houseCost;
						AllBoardPlaces.MEDITERRANEAN.houseNum = 1;
						break;
					case 2:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.MEDITERRANEAN.houseCost * 2);
						AllBoardPlaces.MEDITERRANEAN.houseNum = 2;
						break;
					case 3:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.MEDITERRANEAN.houseCost * 3);
						AllBoardPlaces.MEDITERRANEAN.houseNum = 3;
						break;
					case 4:
						playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
								- (AllBoardPlaces.MEDITERRANEAN.houseCost * 4);
						AllBoardPlaces.MEDITERRANEAN.houseNum = 4;
						break;
						

					}
					if (whatPlace == false) {
						int number2 = ConsoleUI.promptForInt("How many houses would you like 1 - 4", 1, 4);
						switch (number2) {
						case 1:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash

									- AllBoardPlaces.BALIC.houseCost;
							AllBoardPlaces.BALIC.houseNum = 1;
							break;
						case 2:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.BALIC.houseCost * 2);
							AllBoardPlaces.BALIC.houseNum = 2;
							break;
						case 3:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.BALIC.houseCost * 3);
							AllBoardPlaces.BALIC.houseNum = 3;
							break;
						case 4:
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash
									- (AllBoardPlaces.BALIC.houseCost * 4);
							AllBoardPlaces.BALIC.houseNum = 4;
							break;
								
						}
					}
				}

			}
		}
	}

	public void Communitychest(int currentPlayer, int numPlayers) {
		ArrayList<Integer> usedListCC = new ArrayList();

		int num = 0;
		Random gen = new Random();
		do {
			num = gen.nextInt(16) + 1;
			// num = 12;
			if (!usedListCC.contains(num)) {
				usedListCC.add(num);
			}
		} while (!usedListCC.contains(num));
	

		switch (num) {

		case 1:
			System.out.println("Advance to Go (Collect $200)");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 200;
			playerList.get(currentPlayer).location = playerList.get(currentPlayer).location = 0;
			break;
		case 2:
			System.out.println("Bank error in your favor – Collect $200");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 200;
			break;
		case 3:
			System.out.println("Doctor's fees {fee} – Pay $50");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - 50;
			break;
		case 4:
			System.out.println("From sale of stock you get $50");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 50;
			break;
		case 5:
			System.out.println("Get out of Jail, Free");
			playerList.get(currentPlayer).jailCard = true;
			break;
		case 6:
			System.out.println("Go directly to jail – Do not pass Go – Do not collect $200");
			playerList.get(currentPlayer).location = 10;
			playerList.get(currentPlayer).inJail = true;
			break;
		case 7:
			System.out.println("Grand Opera Night – Collect $50 from every player for opening night seats");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + (50 * (numPlayers - 1));
			break;
		case 8:
			System.out.println("Holiday Fund matures - Collect $100");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 100;
			break;
		case 9:
			System.out.println("Income tax refund – Collect $20");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 20;
			break;
		case 10:
			System.out.println("It is your birthday - Collect $10 from each player");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + (10 * numPlayers-1);
			break;
		case 11:
			System.out.println("Life insurance matures – Collect $100");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 100;
			break;
		case 12:
			System.out.println("Pay hospital fees of $100");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - 100;
			break;
		case 13:
			System.out.println("Pay school fees of $150");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - 150;
			break;
		case 14:
			System.out.println("Receive $25 consultancy fee");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 25;
			break;
		case 15:
			System.out.println("You are assessed for street repairs – $40 per house – $115 per hotel");// **************************
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - ((40*playerList.get(currentPlayer).houseNum)+(115*playerList.get(currentPlayer).hotelNum));
			break;
		case 16:
			System.out.println("You have won second prize in a beauty contest – Collect $10");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 10;

			break;
		default:
			System.out.println("You hit default, Community Chest");
			break;
		}
	}

	public void Chance(int currentPlayer, int numPlayers,Board b,Player p,Dice d,Auction a) throws IOException {
		ArrayList<Integer> usedListC = new ArrayList();

		// randomly shuffle deck
		int num = 0;
		Random gen = new Random();
		do {
//			num = gen.nextInt(16) + 1;
			 num = 7;
			if (!usedListC.contains(num)) {
				usedListC.add(num);
			}
		} while (!usedListC.contains(num));
		// usedListCC.add(num);

		switch (num) {

		case 1:
			System.out.println("Advance to Go (Collect $200)");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 200;
			playerList.get(currentPlayer).location = playerList.get(currentPlayer).location = 0;
			break;
		case 2:
			System.out.println("Advance to Illinois Ave. - If you pass Go, collect $200 ");
			if (playerList.get(currentPlayer).location > 24) {
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 200;
				playerList.get(currentPlayer).location = 24;
			}
			if (playerList.get(currentPlayer).location < 24) {
				playerList.get(currentPlayer).location = 24;
			}
			break;
		case 3:
			System.out.println("Advance to St. Charles Place – If you pass Go, collect $200");
			if (playerList.get(currentPlayer).location > 11) {
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 200;
				playerList.get(currentPlayer).location = 11;
			}
			if (playerList.get(currentPlayer).location < 11) {
				playerList.get(currentPlayer).location = 11;
			}
			onMe(currentPlayer, b, p, d, a, numPlayers);
			break;
		case 4:
			System.out.println(
					"Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.");
			playerList.get(currentPlayer).location = playerList.get(currentPlayer).location = 12; // 12/28
			if (playerList.get(currentPlayer).location < 12) {
				playerList.get(currentPlayer).location = 12;
			}
			if (playerList.get(currentPlayer).location > 12 && playerList.get(currentPlayer).location < 28) {
				playerList.get(currentPlayer).location = 28;
			}
			if (playerList.get(currentPlayer).location > 28 && playerList.get(currentPlayer).location < 39) {
				playerList.get(currentPlayer).location = 12;
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 200;
			}
			if(isOwnedEC==true) {
				int tempRoll = d.rollDice(p);
				tempRoll = (tempRoll*10);
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash-tempRoll;
				ownerIndexEC.cash = ownerIndexEC.cash+tempRoll;
			}
			if(isOwnedWW==true) {
				int tempRoll = d.rollDice(p);
				tempRoll = (tempRoll*10);
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash-tempRoll;
				ownerIndexWW.cash = ownerIndexWW.cash+tempRoll;
			}
			
			break;
		case 5:
			System.out.println(
					"Advance token to the nearest Railroad and pay owner twice the rental to which he/she {he} is otherwise entitled. If Railroad is unowned, you may buy it from the Bank");
			playerList.get(currentPlayer).location = playerList.get(currentPlayer).location = 15;// 5/15/25/35
			if (playerList.get(currentPlayer).location < 5) {
				playerList.get(currentPlayer).location = 5;
			}
			if (playerList.get(currentPlayer).location > 5 && playerList.get(currentPlayer).location < 15) {
				playerList.get(currentPlayer).location = 15;
			}
			if (playerList.get(currentPlayer).location > 15 && playerList.get(currentPlayer).location < 25) {
				playerList.get(currentPlayer).location = 25;
			}
			if (playerList.get(currentPlayer).location > 25 && playerList.get(currentPlayer).location < 39) {
				playerList.get(currentPlayer).location = 5;
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 200;

			}
			break;
		case 6:
			System.out.println("Bank pays you dividend of $50 ");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 50;
			break;
		case 7:
			System.out.println("Get out of Jail Free");
			playerList.get(currentPlayer).jailCard = true;
			break;
		case 8:
			System.out.println("Go Back 3 Spaces");
			playerList.get(currentPlayer).location = playerList.get(currentPlayer).location - 3;
			break;
		case 9:
			System.out.println("Go directly to Jail – Do not pass Go, do not collect $200");
			playerList.get(currentPlayer).jailTurn0=true;									
			playerList.get(currentPlayer).location = 10;
			playerList.get(currentPlayer).inJail = true;
			break;
		case 10:
			System.out.println(
					"Make general repairs on all your property – For each house pay $25 – For each hotel $100");// *****************
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - ((25*playerList.get(currentPlayer).houseNum)+(100*playerList.get(currentPlayer).hotelNum));
			break;
		case 11:
			System.out.println("Pay poor tax of $15");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - 15;
			break;
		case 12:
			System.out.println("Take a trip to Reading Railroad – If you pass Go, collect $200 ");
			if (playerList.get(currentPlayer).location < 5) {
				playerList.get(currentPlayer).location = 5;
			}
			if (playerList.get(currentPlayer).location > 5) {
				playerList.get(currentPlayer).location = 5;
				playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 200;
			}
			break;
		case 13:
			System.out.println("Take a walk on the Boardwalk – Advance token to Boardwalk");
			if (playerList.get(currentPlayer).location < 39) {
				playerList.get(currentPlayer).location = 39;
			}
			break;
		case 14:
			System.out.println("You have been elected Chairman of the Board – Pay each player $50");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - (50 * (numPlayers - 1));
			break;
		case 15:
			System.out.println("Your building loan matures – Collect $150");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 150;
			break;
		case 16:
			System.out.println("You have won a crossword competition - Collect $100");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 100;

			break;
		default:
			System.out.println("You hit the default case, chance");
			;
			break;
		}
	}

	public boolean jail(int currentPlayer, Dice d, Player p) throws IOException {
		Random gen = new Random();
		boolean askFor50 = true;
		int die1;
		int die2;
		int jailTurn = 0;
//		System.out.println(playerList.get(currentPlayer).jailTurn0");
		if(playerList.get(currentPlayer).jailTurn0==false) {
		if (jailTurn == 3) {
				System.out.println(playerList.get(currentPlayer).name
			
					+ ", you have been in jail for 3 turns. You must pay your $50 fine.");
			playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - 50;
			return false;
		}
		if (playerList.get(currentPlayer).jailCard == true) {
			System.out.println(playerList.get(currentPlayer).name
					+ ", You currently have a 'Get of jail free' card. Would you like to use it?");
			String input = ConsoleUI.promptForInput("yes(1) or no(2)", false);
			if (input.equalsIgnoreCase("yes") || input.equals("1")) {
				playerList.get(currentPlayer).jailCard = false;
				playerList.get(currentPlayer).inJail = false;
				return false;
			}
		}
		if (playerList.get(currentPlayer).inJail == true) {
			if (playerList.get(currentPlayer).cash >= 50) {
				askFor50 = ConsoleUI.promptForBool("Do you want to pay $50 to leave?", "yes", "no"); 
				if(askFor50==true) {
					System.out.println(playerList.get(currentPlayer).name + ", you have opted to pay your way out.");
					playerList.get(currentPlayer).inJail = false;
					playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash - 50;
					double cash = playerList.get(currentPlayer).cash;
					System.out.println("You now have $" + cash + ".");
					return playerList.get(currentPlayer).inJail;
				}
				
			}
			if (askFor50!=true) {
				die1 = gen.nextInt(5) + 1;
				die2 = gen.nextInt(5) + 1;
				System.out.println("first die is a " + die1);
				System.out.println("second die is a " + die2);
				if (die1 == die2) {
					System.out.println("Congrats, you have rolled doubles! You are now just visiting jail");
					return false;
				}

				if (!(die1 == die2)) {
					System.out.println(playerList.get(currentPlayer).name + ", you have failed to roll doubles. ");
					return true;
				}
			}
		}
		jailTurn++;
		
		}
		playerList.get(currentPlayer).jailTurn0=false;
//		System.out.println(playerList.get(currentPlayer).didRollDoubles);
		return true;

	}

	private void speedPlay() {
		// TODO Auto-generated method stub

	}

	public void normalGame(Dice d, Player p, Board b, Auction a, int numPlayers) throws IOException {

		boolean gameWin = false;
		int currentPlayer = firstPlayer;
		int turnCount = 0;

		do {
			for (int i = 0; i < playerList.size(); i++) {
				currentPlayer = firstPlayer + i;
				if (currentPlayer >= playerList.size()) {
					currentPlayer = currentPlayer - playerList.size();
				}
				do {
					System.out.println("***********************************");
					playerList.get(currentPlayer).printPlayer();
					System.out.println(playerList.get(currentPlayer).inJail);
					System.out.println("***********************************");
					System.out.println();

					// onMe(currentPlayer);
					// System.out.println("You landed on board space
					// "+playerList.get(currentPlayer).location);

					System.out.println();
					System.out.println("Okay " + playerList.get(currentPlayer).name + ", the roll is yours.");
					System.out.println();
					if (playerList.get(currentPlayer).inJail == false) {
						playerList.get(currentPlayer).location = playerList.get(currentPlayer).location
								+ d.rollDice(playerList.get(currentPlayer));
						if (playerList.get(currentPlayer).location > 39) {
							playerList.get(currentPlayer).location = playerList.get(currentPlayer).location - 40;
							playerList.get(currentPlayer).cash = playerList.get(currentPlayer).cash + 200;
						}

					}
					if (playerList.get(currentPlayer).inJail == true) {
						jail(currentPlayer, d, p);
						if (playerList.get(currentPlayer).inJail == false) {
							playerList.get(currentPlayer).location = playerList.get(currentPlayer).location
									+ d.rollDice(playerList.get(currentPlayer));
						}
					}
					// System.out.println(playerList.get(currentPlayer).location);
					if(playerList.get(currentPlayer).inJail==false) {
						onMe(currentPlayer, b, p, d, a, numPlayers);
					}
					System.out.println("***********************************");
					System.out.println("End turn");
					playerList.get(currentPlayer).printPlayer();
					System.out.println(playerList.get(currentPlayer).inJail);
					System.out.println("***********************************");
					System.out.println();
					String pause = ConsoleUI.promptForInput("Press any button to continue...", true);
				} while (playerList.get(currentPlayer).didRollDoubles == true);
				// if(pause.equalsIgnoreCase("stbs")) {
				// AllBoardPlaces abp = b.toStringShort();
				// }

			}
			turnCount++;
			System.out.println("turn number: " + turnCount);
			System.out.println();
//			if(playerList.get(currentPlayer).cash<0)
//				System.out.println(playerList.get(currentPlayer).name+", you have $0 to your name. You lose.");
//				playerList.remove(currentPlayer);
//			if(playerList.get(currentPlayer).cash<0) {
//				Player playerRemove = playerList.get(currentPlayer);
//				playerList.remove(playerRemove);
//			}
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