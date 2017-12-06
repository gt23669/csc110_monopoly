package edu.neumont.csc110;

public class Player {

	public String name;
	public PlayerTokens token;
	public double cash = 1500;
	public int location;
	public String owner;
	public boolean didRollDoubles;
	public boolean jailTurn0 = false;

	public boolean inJail = false;
	public int inJailTurn = 0;
	public int owned;
	public boolean jailCard = false;
	public boolean doubleJail = false;
	public int auctionBid=0;
	public int playerIndex = 0;
	public int houseNum=0;
	public int hotelNum=0;

	public void printPlayer() {
		System.out.println(name);
		System.out.println(token);
		System.out.println(cash);
		System.out.println(location);
	}

}
