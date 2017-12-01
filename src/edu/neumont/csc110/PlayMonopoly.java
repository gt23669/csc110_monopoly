package edu.neumont.csc110;

import java.io.IOException;

public class PlayMonopoly {

	public static void main(String[] args) throws IOException {
		Monopoly m = new Monopoly();
		Player p = new Player();
		Dice d = new Dice();
		
	
//		m.gameSetUp(d,p);
		d.rollDice(p);
		
	}

}
