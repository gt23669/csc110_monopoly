package edu.neumont.csc110;

import java.util.ArrayList;
import java.util.Random;

public class Communitychest {
	ArrayList<Integer> usedListCC = new ArrayList();

	public int randomCCCard() {
		// randomly shuffle deck
		int num = 0;
		Random gen = new Random();
		do {
			num = gen.nextInt(16) + 1;
		} while (!usedListCC.contains(num));
		usedListCC.add(num);

		return num;

	}
	private int chest(){
		switch (randomCCCard()) {
		case 1: System.out.println("Advance to Go (Collect $200)");
		
		}
		return 0;
	}

}
