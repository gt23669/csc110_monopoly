package edu.neumont.csc110;

import java.io.IOException;

public class PlayMonopoly {

	public static void main(String[] args) throws IOException {
		Monopoly m = new Monopoly();
		Player p = new Player();
		Dice d = new Dice();
		Board b = new Board();
		Auction a = new Auction();
		
	
		m.gameSetUp(d,p,b,a);
//		d.rollDice(p);
		
	}

}
