package project;
import java.util.ArrayList;
import java.util.Objects;

public class Shop {
	private int buycards;
	private int sellcards;
	private Integer pid;
	  private String name;
	  private Double price;
	  public int Card;
	
	public Shop( int buycards, int sellcards, Integer pid, String name, Double price) {
		this.buycards = buycards;
		this.sellcards = sellcards;
		this.pid = pid;
        this.name = name;
        this.price = price;
	}
	
	public String getName() {
        return name;
    }
	
	public void setName(String name) {
        this.name = name;
    }
	
	public Double getPrice() {
        return price;
    }
	
	public void setPrice(Double price) {
        this.price = price;
    }
	
	 public Integer getPid() {
	        return pid;
	    }
	
	public int getbuycards() {
		return buycards;
	}
	
public int getsellcards() {
	return sellcards;
}

public int hashCode() {
    int hash = 7;
    hash = 29 * hash + Objects.hashCode(this.pid);
    hash = 29 * hash + Objects.hashCode(this.name);
    hash = 29 * hash + Objects.hashCode(this.price);
    return hash;
}

public void shuffle(){
	 int[] randomPermutation = null;
    ArrayList<Card> tempOldDeck = new ArrayList<>();

    ArrayList<project.Card> deck = null;
	for (Card card: deck){
        tempOldDeck.add(card);
    }

    int[] random = randomPermutation(deck.size());

    for (int i = 0; i < deck.size(); i++){  
       
		deck.set(i, tempOldDeck.get(randomPermutation[i] - 1));
    }       
}

private int[] randomPermutation(int size) {
	// TODO Auto-generated method stub
	return null;
}

}
