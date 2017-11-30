package edu.neumont.csc110;

import edu.neumont.csc110.AllBoardPlaces;

public class Card {
	
	private AllBoardPlaces cardValue;


	public Card(AllBoardPlaces cardValue) {
		
		this.cardValue = cardValue;
	}


	public String getCardName() {
		return cardValue.getName();
	}


	public int getCardPrice() {
		return cardValue.getCardPrice();
	}





}
