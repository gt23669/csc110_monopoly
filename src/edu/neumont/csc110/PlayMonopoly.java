package edu.neumont.csc110;

import java.io.IOException;

public class PlayMonopoly {

	public static void main(String[] args) throws IOException {
		

		Monopoly m = new Monopoly();
		Dice d = new Dice();

		System.out.println(AllBoardPlaces.GO.toString());
		m.gameSetUp(d);
	}

}
