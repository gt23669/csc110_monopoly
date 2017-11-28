package edu.neumont.csc110;

import java.io.IOException;

public class PlayMonopoly {

	public static void main(String[] args) throws IOException {
		
		Monopoly m = new Monopoly();
		playerToken pt = new playerToken();
		Board bd = new Board();
		Bank bk = new Bank();
		Dice d = new Dice();
		
		m.gameSetUp(d);
		
	}

}
