package edu.neuont.csc110;


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
