package edu.neumont.csc110;

import java.io.IOException;
import java.util.ArrayList;

public class Auction {


	public void auction(Player playerList[], Board b, int numPlayers, AllBoardPlaces abp) throws IOException {
		int bidLow = 0;
		int bidHigh = 0;
		int highBidPlayer = 0;
		System.out.println();
		System.out.println(abp.name+" is up for auction.");
		for(int i =0;i<numPlayers;i++) {
			System.out.println(playerList[i].name+" Would you like to bid?");
			boolean input=ConsoleUI.promptForBool("", "yes", "no");
				if(input == true) {
					bidLow = ConsoleUI.promptForInt("How much do you bid?", 1, (int)playerList[i].cash);
					playerList[i].auctionBid=bidLow;
					if(bidLow>bidHigh) {
						bidHigh=bidLow;
						
					}
				if(input ==false) {
					System.out.println("The high bid was "+bidHigh);
				}
				}
			}
			
	}
}

