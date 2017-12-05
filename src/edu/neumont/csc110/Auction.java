package edu.neumont.csc110;

import java.io.IOException;
import java.util.ArrayList;

public class Auction {

	public Player auction(Player playerList[], Board b, int numPlayers, AllBoardPlaces abp, Player p) throws IOException {
		Monopoly m;
		int bidLow = 0;
		int bidHigh = 0;
		int highBidPlayer = 0;
		boolean input = false;
		String highName = null;
		System.out.println();
		System.out.println(abp.name+" is up for auction.");
		
		do{
			for(int i =0;i<numPlayers;i++) {
		
			System.out.println(playerList[i].name+" Would you like to bid?");
			input=ConsoleUI.promptForBool("", "yes", "no");
			boolean goodBid = true;
				do{
					if(input == true) {
					bidLow = ConsoleUI.promptForInt("How much do you bid?", 1, (int)playerList[i].cash);
					playerList[i].auctionBid=bidLow;
					System.out.println(playerList[i].auctionBid+"(your bid)");
					if(bidLow>bidHigh) {
						bidHigh=bidLow;
						System.out.println("Highest bid is "+ bidHigh);
						highName = playerList[i].name;
						abp.owner = playerList[i];
						abp.owned = true;
						goodBid=true;
						
					}
					if(bidLow<bidHigh) {
						goodBid=false;
						System.out.println("You must place a bid higher than the last");
					}	
					}
				}while(goodBid==false);
				if(input ==false&&!(abp.owner==null)) {
					System.out.println("The high bid was "+bidHigh);
					System.out.println(highName+" is the owner");
					
				}
				}
			
			}while(input ==true);
		return abp.owner;
		}
	}


