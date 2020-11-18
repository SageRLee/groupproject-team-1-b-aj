package project;
import java.util.ArrayList;
import java.util.Objects;

public class Shop {
	private int buycards;
	private int sellcards;
	  public int Card;
	private String cardname;
	private int cost;
	private String cardtypes;
	private double money;
	
	public Shop( int buycards, int sellcards, int Card) {
		this.buycards = buycards;
		this.sellcards = sellcards;
		this.Card = Card;
	}
	
	public int getbuycards() {
		return buycards;
	}
	
    public int getsellcards() {
	   return sellcards;
}

    public void hasCards( String cardname,String cardtypes){  
        this.cardname = cardname;
        this.cardtypes=cardtypes;

        if(cardtypes == "Attack" || cardtypes == "Mana" || cardtypes == "Equipment"||cardtypes == "Action")
        {
            this.cardtypes = cardname;
        }
    } 

    public void buyCards(String cardname, int cost, double money) {
    	this.money=money;
    	if(money>cost) {
    		System.out.println("You got"+cardname+"card");
    		money=money-cost;
    	}
    	if(money<cost) {
    		System.out.println("Don't have enough money to buy this"+ cardname+"card");
    		this.money=money;
    	}
    }
    
    public void sellCards(String cardname, int cost) {	
    }
}
