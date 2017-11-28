package edu.neumont.csc110;

import java.util.ArrayList;
import java.util.Random;

public class Chance {
	ArrayList<Integer> usedListChance = new ArrayList();

	public int randomCCCard() {
		// randomly shuffle deck
		int num = 0;
		Random gen = new Random();
		do {
			num = gen.nextInt(16) + 1;
		} while (!usedListChance.contains(num));
		usedListChance.add(num);

		
		return num;

	}

}
