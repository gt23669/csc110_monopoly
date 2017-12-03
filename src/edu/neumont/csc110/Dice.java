package edu.neumont.csc110;

import java.util.Random;

public class Dice {

	Random gen = new Random();
	int die1 = 0;
	int die2 = 0;
	int doubleCount = 0;
	

	public int firstRoll(Player p) {
		boolean doubleRoll = false;
		doubleRoll = false;
		die1 = gen.nextInt(5) + 1;

		// System.out.println(die1+"Random first die");
		die2 = gen.nextInt(5) + 1;
		// System.out.println(die2+"random second die");
		int rollValue = die1 + die2;
		do {
			if (die1 == die2) {
				// System.out.println("do while loop, first roll*********************");
				doubleRoll = true;
				die1 = gen.nextInt(5) + 1;
				die2 = gen.nextInt(5) + 1;
				rollValue = die1 + die2;
				return rollValue;
			}
			return rollValue;
		} while (doubleRoll == true);
	}

	public int rollDice(Player p) {
	
		int rolledValue =0;
		
//		die1 = gen.nextInt(6) + 1;
//		die2 = gen.nextInt(6) + 1;
		die1 = 1;
		die2 = 0;
		rolledValue = die1 + die2;
		if(die1==die2) {
			doubleCount++;
		}
		System.out.println(p.name + " Your roll was a " + die1 + " and " + die2 + ".");
		System.out.println();

		if (doubleCount == 3) {
			jail(p);
			return 0;
		}
		return rolledValue;
		
	}
	
				
		
		

	public void jail(Player p) {
		
		System.out.println("You have rolled 3 doubles, Go straight to jail, do not pass go, do not collect $200");
		p.location = 20;
		
	}

}
