package edu.neumont.csc110;


public enum AllBoardPlaces {
	GO("Go", 0,0,0,0,0,0,0,0,0,0,0,false,null),
	MEDITERRANEAN("Mediterranean Avenue", 60,2,10,30,90,190,250,30,30,50,50,false,null),
	COMMUNITY1("Community Chest", 0,0,0,0,0,0,0,0,0,0,0,false,null),
	BALIC("Balic Avenu", 60,4,20,60,180,320,450,50,50,50,50,false,null),
	INCOME("Income Tax",0,0,0,0,0,0,0,0,0,0,0,false,null),
	READING("Reading Railroad",200,25,0,50,100,200,0,100,100,0,0,false,null),
	ORIENTAL("Oriental Avenenu",100,6,30,90,270,400,550,50,50,50,50,false,null),
	CHANCE1("Chance",0,0,0,0,0,0,0,0,0,0,0,false,null),
	VERMONT("Vermont Avenue",100,6,30,90,270,400,550,50,50,50,50,false,null),
	CONNECTICUT("Connecticut Avenue",120,8,40,100,300,450,600,60,60,50,50,false,null),
	JAIL("Jail",0,0,0,0,0,0,0,0,0,0,0,false,null),
	CHARLES("St.Charles Place",140,10,50,150,450,625,750,70,70,100,100,false,null),
	ELECTRIC("Electric Company",150,0,0,0,0,0,0,0,0,0,0,false,null),
	STATES("States Avenue",140,10,50,150,450,625,750,70,70,100,100,false,null),
	VIRGINIA("Virginia Avenue",160,12,60,180,500,700,900,80,80,100,100,false,null),
	PENNSYLVANIARR("Pennsylvania Railraod",200,25,0,50,100,200,0,100,100,0,0,false,null),
	COMMUNITY2("Community Chest", 0,0,0,0,0,0,0,0,0,0,0,false,null),
	JAMES("St.James Pllace",180,14,70,200,550,750,950,90,90,100,100,false,null),
	TENNESSEE("Tennessee Avenue",180,14,70,200,550,750,950,90,90,100,100,false,null),
	NEWYORK("New York Avenue", 200,16,220,600,800,1000,100,100,100,100,100,false,null),
	FREE("Free Parking",0,0,0,0,0,0,0,0,0,0,0,false,null),
	KENTUCKY("Kentucky Avenue",220,18,90,250,700,875,1050,110,110,150,150,false,null),
	CHANCE2("Chance",0,0,0,0,0,0,0,0,0,0,0,false,null),
	INDIANA("Indiana Avenue",220,18,90,250,700,875,1050,110,110,150,150,false,null),
	ILLINOIS("Illinois Avenue",240,20,100,300,750,925,1100,120,120,150,150,false,null),
	BANDO("B & O Railroad",200,25,0,50,100,200,0,100,100,0,0,false,null),
	ATLANTIC("Atlatic Avenue",260,22,110,330,800,975,1150,130,130,150,150,false,null),
	VENTNOR("Ventnor Avenue",260,22,110,330,800,975,1150,130,130,150,150,false,null),
	WATER("Water Works",150,0,0,0,0,0,0,0,0,0,0,false,null),
	MARVIN("Marvin Gardens",280,24,120,360,850,1025,1200,140,140,150,150,false,null),
	GOTJAIL("Go To Jail",0,0,0,0,0,0,0,0,0,0,0,false,null),
	PACIFIC("Pacific Avenue",300,26,130,390,900,110,1275,150,150,200,200,false,null),
	NCAROLINA("North Carolina Avenue",300,26,130,390,900,1100,1275,150,150,200,200,false,null),
	COMMUNITY3("Community Chest", 0,0,0,0,0,0,0,0,0,0,0,false,null),
	PENNSYLVANIA("Pennsylvania Avenue",320,28,150,450,1000,1200,1400,160,160,200,200,false,null),
	SHORT("Short Line",200,25,0,50,100,200,0,100,100,0,0,false,null),
	CHANCE3("Chance",0,0,0,0,0,0,0,0,0,0,0,false,null),
	PARK("Park Place",350,35,175,500,1100,1300,1500,175,175,200,200,false,null),
	TAX("Lutury Tax",0,0,0,0,0,0,0,0,0,0,0,false,null),
	BOARDWALK("Boardwalk",400,50,200,600,1400,1700,2000,200,200,200,200,false,null);
	
	// name(name, buyPrice, baseRent, 1HsRent, 2HsRent, 3HsRent, 4HsRent,
	// hotelRent, mortgageValue, mortgageBuybackPrice, houseCost, hotelCost)

	

	public String name;
	public int cardPrice;
	public int baseRent;
	public int oneHsRent;
	public int twoHsRent;
	public int threeHsRent;
	public int fourHsRent;
	public int hotelRent;
	public int mortgageValue;
	public int mortgageBuybackPrice;
	public int houseCost;
	public int hotelCost;
	public boolean owned;
	public Player owner;

	AllBoardPlaces(String name, int cardPrice, int baseRent, int oneHsRent,
			int twoHsRent, int threeHsRent, int fourHsRent, int hotelRent,
			int morgageValue, int morgageBuybackPrice, int houseCost, int hotelCost, boolean owned, Player owner) {
		this.name = name;
		this.cardPrice = cardPrice;
		this.baseRent = baseRent;
		this.oneHsRent = oneHsRent;
		this.twoHsRent = twoHsRent;
		this.threeHsRent = threeHsRent;
		this.fourHsRent = fourHsRent;
		this.hotelRent = hotelRent;
		this.mortgageValue = morgageValue;
		this.mortgageBuybackPrice = morgageBuybackPrice;
		this.houseCost = houseCost;
		this.hotelCost = hotelCost;
		this.owned = owned;
		this.owner= owner;
		
	}
	/**
	 * This returns the name of the board piece
	 */
	public String getOwned() {
		return name;
	}

	public int getOwner() {
		return cardPrice;
	}
	
	public String getName() {
		return name;
	}

	public int getCardPrice() {
		return cardPrice;
	}
	public int getBaseRent() {
		return baseRent;
	}

	public int getOneHsRent() {
		return oneHsRent;
	}

	public int getTwoHsRent() {
		return twoHsRent;
	}

	public int getThreeHsRent() {
		return threeHsRent;
	}

	public int getFourHsRent() {
		return fourHsRent;
	}

	public int getHotelRent() {
		return hotelRent;
	}

	public int getMortgageValue() {
		return mortgageValue;
	}

	public int getMortgageBuybackPrice() {
		return mortgageBuybackPrice;
	}

	public int getHouseCost() {
		return houseCost;
	}

	public int getHotelCost() {
		return hotelCost;
	} 	
	@Override
	public String toString() {
		// build the string that represents the card object
		StringBuilder stb = new StringBuilder();
		stb.append(getName());
		stb.append(" \nThis property cost " + getCardPrice());
		stb.append(" \nThe Base rent is "+ getBaseRent());
		stb.append(" \nOne House Rent "+getOneHsRent());
		stb.append(" \nTwo House Rent "+getTwoHsRent());
		stb.append(" \nThree House Rent "+getThreeHsRent());
		stb.append(" \nFour House Rent"+getFourHsRent());
		stb.append(" \nHotel Rent "+getHotelRent());
		stb.append(" \nMorgage "+getMortgageValue());
		stb.append(" \nBuy Back Morgage "+getMortgageBuybackPrice());
		stb.append(" \nHouse Cost "+getHouseCost());
		stb.append(" \nHotel Cost "+getHotelCost());
		stb.append("");
		// return the string
		return stb.toString();
	}
//	@Override
	public String toStringShort() {
		StringBuilder stbs = new StringBuilder();
		stbs.append(getName());
		stbs.append(" \nThe Base rent is "+ getBaseRent());
		stbs.append("This property is owned");
		stbs.append("This property is owned by "+getOwner());
		return stbs.toString();
	}

}
