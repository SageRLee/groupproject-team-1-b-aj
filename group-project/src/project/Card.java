package project;

import acm.graphics.GImage;

public class Card {

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
	
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {
		
	}
	
}

