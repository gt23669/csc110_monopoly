package edu.neumont.csc110;

import java.util.ArrayList;

public class Board {

	public static void main(String[] args) {
	
		Board b = new Board();
		
		// for each card in the list 
			
			// print the card details
			//System.out.println(card.toString());
	}
	
	ArrayList<Card> board = new ArrayList<>();
	
	public Board() {
		createBoard();
		
	}
	
	
	private void createBoard() {
		// FOR (this object) IN (this collection)
		for (AllBoardPlaces piece : AllBoardPlaces.values()) {
			Card card = new Card(piece);
			board.add(card);
		}
	}
	
	public Card getCardAt(int index) {
		return board.get(index);
		
	}
}
