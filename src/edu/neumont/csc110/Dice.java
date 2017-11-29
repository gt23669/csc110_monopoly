package edu.neumont.csc110;

import java.util.Random;

public class Dice {

	Random gen = new Random();
	
	public int firstRoll(Player p) {
		int die1 = gen.nextInt(5) + 1;
		int die2 = gen.nextInt(5) + 1;
		int rollValue = die1+die2;
		return rollValue;
	}

	public int rollDice(String name) {
		boolean jail = false;
		boolean doubleRoll = false;
		int doubleCount = 0;
		int testRoll = 0;
		int die1 = 0;
		int die2 = 0;
		int rolledValue = die1 + die2;

		do {
			doubleRoll =false;
			die1 = gen.nextInt(5) + 1;
			die2 = gen.nextInt(5) + 1;
			testRoll++;
//			die1 = 1;
//			die2 = 1;
			if (doubleCount == 3) {
				jail();
				break;
			}
			System.out.println(name+" Your roll was a " + die1 + " and " + die2 + ".");
			if (die1 == die2) {
				doubleRoll = true;
				doubleCount++;
			}
		} while (doubleRoll == true);
		return rolledValue;

	}

	public boolean jail() {
		boolean jail = false;
		System.out.println("You have rolled 3 doubles, Go straight to jail, do not pass go, do not collect $200");
		return jail = true;
	}

}