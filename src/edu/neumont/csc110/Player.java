package edu.neumont.csc110;

public class Player {

	public String name;
	public PlayerTokens token;
	public double cash = 1500;
	public int location;
	public boolean owned;

	public void printPlayer() {
		System.out.println(name);
		System.out.println(token);
		System.out.println(cash);
		System.out.println(location);
	}

}
