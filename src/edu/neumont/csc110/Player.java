package edu.neumont.csc110;

public class Player {

	public String name;
	public PlayerTokens token;
	public int cash = 1500;
	public int location;
	
	public void printPlayer() {
		System.out.println(name);
		System.out.println(token);
		System.out.println(cash);
		System.out.println(location);
	}
	
	
}
