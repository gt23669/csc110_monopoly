package edu.neumont.csc110;


public enum AllBoardPlaces {
	GO("Go", 0,0,0,0,0,0,0,0,0,0,0),
	MEDITERRANEAN("Mediterranean Avenue", 60,2,10,30,90,190,250,30,30,50,50),
	COMMUNITY1("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
	BALIC("Balic Avenu", 60,4,20,60,180,320,450,50,50,50,50),
	INCOME("Income Tax",0,0,0,0,0,0,0,0,0,0,0),
	READING("Reading Railroad",200,25,0,50,100,200,0,100,100,0,0),
	ORIENTAL("Oriental Avenenu",100,6,30,90,270,400,550,50,50,50,50),
	CHANCE1("Chance",0,0,0,0,0,0,0,0,0,0,0),
	VERMONT("Vermont Avenue",100,6,30,90,270,400,550,50,50,50,50),
	CONNECTICUT("Connecticut Avenue",120,8,40,100,300,450,600,60,60,50,50),
	JAIL("Jail",0,0,0,0,0,0,0,0,0,0,0),
	CHARLES("St.Charles Place",140,10,50,150,450,625,750,70,70,100,100),
	ELECTRIC("Electric Company",150,0,0,0,0,0,0,0,0,0,0),
	STATES("States Avenue",140,10,50,150,450,625,750,70,70,100,100),
	PENNSYLVANIARR("Pennsylvania Railraod",200,25,0,50,100,200,0,100,100,0,0),
	VIRGINIA("Virginia Avenue",160,12,60,180,500,700,900,80,80,100,100),
	COMMUNITY2("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
	JAMES("St.James Pllace",180,14,70,200,550,750,950,90,90,100,100),
	TENNESSEE("Tennessee Avenue",180,14,70,200,550,750,950,90,90,100,100),
	NEWYORK("New York Avenue", 200,16,220,600,800,1000,100,100,100,100,100),
	FREE("Free Parking",0,0,0,0,0,0,0,0,0,0,0),
	KENTUCKY("Kentucky Avenue",220,18,90,250,700,875,1050,110,110,150,150),
	CHANCE2("Chance",0,0,0,0,0,0,0,0,0,0,0),
	INDIANA("Indiana Avenue",220,18,90,250,700,875,1050,110,110,150,150),
	ILLINOIS("Illinois Avenue",240,20,100,300,750,925,1100,120,120,150,150),
	BANDO("B & O Railroad",200,25,0,50,100,200,0,100,100,0,0),
	ATLANTIC("Atlatic Avenue",260,22,110,330,800,975,1150,130,130,150,150),
	VENTNOR("Ventnor Avenue",260,22,110,330,800,975,1150,130,130,150,150),
	WATER("Water Works",150,0,0,0,0,0,0,0,0,0,0),
	MARVIN("Marvin Gardens",280,24,120,360,850,1025,1200,140,140,150,150),
	GOTJAIL("Go To Jail",0,0,0,0,0,0,0,0,0,0,0),
	PACIFIC("Pacific Avenue",300,26,130,390,900,110,1275,150,150,200,200),
	NCAROLINA("North Carolina Avenue",300,26,130,390,900,1100,1275,150,150,200,200),
	COMMUNITY3("Community Chest", 0,0,0,0,0,0,0,0,0,0,0),
	PENNSYLVANIA("Pennsylvania Avenue",320,28,150,450,1000,1200,1400,160,160,200,200),
	SHORT("Short Line",200,25,0,50,100,200,0,100,100,0,0),
	CHANCE3("Chance",0,0,0,0,0,0,0,0,0,0,0),
	PARK("Park Place",350,35,175,500,1100,1300,1500,175,175,200,200),
	TAX("Lutury Tax",0,0,0,0,0,0,0,0,0,0,0),
	BOARDWALK("Boardwalk",400,50,200,600,1400,1700,2000,200,200,200,200);
	
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

	AllBoardPlaces(String name, int cardPrice, int baseRent, int oneHsRent,
			int twoHsRent, int threeHsRent, int fourHsRent, int hotelRent,
			int morgageValue, int morgageBuybackPrice, int houseCost, int hotelCost) {
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
		
	}
	/**
	 * This returns the name of the board piece
	 */
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
		stb.append(" How much it cost " + getBaseRent());
		stb.append(" One House Rent "+getOneHsRent());
		stb.append(" Two House Rent "+getTwoHsRent());
		stb.append(" Three House Rent "+getThreeHsRent());
		stb.append(" Four House Rent"+getFourHsRent());
		stb.append(" Hotel Rent "+getHotelRent());
		stb.append(" Morgage "+getMortgageValue());
		stb.append(" Buy Back Morgage "+getMortgageBuybackPrice());
		stb.append(" House Cost "+getHouseCost());
		stb.append(" Hotel Cost "+getHotelCost());
		// return the string
		return stb.toString();
	}

}
