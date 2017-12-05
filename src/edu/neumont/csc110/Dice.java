package edu.neumont.csc110;

import java.util.Random;

public class Dice {

	Random gen = new Random();
	int die1 = 0;
	int die2 = 0;
	int doubleCount = 0;
	Monopoly m ;
	

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
		//if(p==p) {
//		die1 = gen.nextInt(6) + 1;
//		die2 = gen.nextInt(6) + 1;
		die1 = 2;
		die2 =2;
//		die1 = 30;
//		die2 = 0;
		rolledValue = die1 + die2;
		if(die1==die2) {
			p.didRollDoubles = true;
			doubleCount++;
		}else {
			doubleCount = 0;
			p.didRollDoubles=false;
		}
		System.out.println(p.name + " Your roll was a " + die1 + " and " + die2 + ".");
		System.out.println();
		tempMove(rolledValue, p, m);
		
		//}

		if (doubleCount == 3) {
			p.didRollDoubles=false;
			doubleCount=0;
			System.out.println("You have rolled 3 doubles! Go straight to jail, do not pass go and, do not collect $200.");
			p.doubleJail = true;
			jail(p);
			return 3;
		}
		return rolledValue;
		
	}
	
				
		
		

	private void tempMove(int rolledValue, Player p, Monopoly m) {
		p.location = p.location+rolledValue;
//		m.onMe();
		
		
	}

	public boolean jail(Player p) {
		p.location = 10;
		p.inJail=true;
		return p.inJail;
		
	}

}
