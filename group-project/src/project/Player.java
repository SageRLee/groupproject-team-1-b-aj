package project;

import java.util.ArrayList;

import acm.graphics.GImage;

//ignore
public class Player extends Entity {
	
	private int gold;
	
	public Player(GImage sprite, int hp, int maxHp, int mana, int maxMana, ArrayList<Card> deck) {
		super(sprite, hp, maxHp, mana, maxMana, deck);
		// TODO Auto-generated constructor stub
	}
	
	public int getGold() {
		return gold;
	}
	
	public void setGold(int gold) {
		this.gold = gold;
	}

}
