package edu.neumont.csc110;


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
	
	
	@Override
	public String toString() {
		// build the string that represents the card object
		
		// return the string
		return null;
	}
	
}