package project;

import acm.graphics.GImage;

public class Card {

	
	//public string getName;
	enum type{
		ATTACK,
		EQUIP,
		ACTION,
		MANA,
		HEALING
		
	}
	private int cost;
	public type cardType;
	private GImage sprite = new GImage("media/images.Strike.png");
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) { //Probably will be unused, unless we add cards to do that later
		this.cost = cost;
	}
	public boolean canPlay(Entity user, Entity target) {//Function to test if card is playable (can pay mana cost, can target entity, etc)
		return true;
	}
	public void play(Entity user, Entity target) {//Function to play the card
		
	}
	
	
}

