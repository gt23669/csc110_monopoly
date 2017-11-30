package edu.neumont.csc110;

import java.util.ArrayList;

public class Board {

	ArrayList<AllBoardPlaces> board = new ArrayList<>();

	public Board() {
		createBoard();

	}

	private void createBoard() {
		// FOR (this object) IN (this collection)
		for (AllBoardPlaces piece : AllBoardPlaces.values()) {
			board.add(piece);
		}
	}

	public AllBoardPlaces getCardAt(int index) {
		return board.get(index);

	}
}