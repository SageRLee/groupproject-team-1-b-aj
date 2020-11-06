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

	private GImage picture;
	private String name;
	private String description;
	private int cost;
	
	public Card(GImage picture, String name, String description, int cost) {
		this.picture = picture;
		this.name = name;
		this.description = description;
		this.cost = cost;
	}

	public boolean canPlay(Entity user, Entity target) {//Function to test if card is playable (can pay mana cost, can target entity, etc)

		return true;
	}
	


	public GImage getPicture() {
		return picture;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void play(boolean isPlayerTurn, Player player, Enemy enemy) {
		
	}
	
}

