package project;
import java.util.ArrayList;
import java.util.Objects;

public class Shop {
	private int buycards;
	private int sellcards;
	  public int Card;
	private String cardname;
	
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

    public void hasCards( String cardname,String cost){  
        this.cardname = cardname;

        if(cardname == "Attack" || cardname == "Mana" || cardname == "Equipment"||cardname == "Action")
        {
            this.cardname = cost;
        }
    } 
    
}
