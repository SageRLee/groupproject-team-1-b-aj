package project;
import java.util.ArrayList;
import java.util.Random;

import acm.graphics.GImage;

public class Entity {
	private int hp;
	private int maxHp;
	private int armor;
	private int mana;
	private int maxMana;
	private ArrayList<Card> hand;
	private ArrayList<Card> deck;
	private ArrayList<Card> discard;
	private GImage sprite;
	Random rand = new Random();
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getMaxMana() {
		return maxMana;
	}
	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}
	public void setDiscard(ArrayList<Card> discard) {
		this.discard = discard;
	}
	public void shuffleDeck() {
		int length = deck.size();
		ArrayList<Card> temp = new ArrayList<Card>();
		int ran = rand.nextInt(length-1);
		while(temp.size() < length) {
			temp.add(deck.get(ran));
			deck.remove(ran);
		}
	}
	public void resetDeck() {
		for(Card a : discard) {
			deck.add(a);
		}
		shuffleDeck();
	}
	public boolean isAlive() {
		if(hp <= 0) return false;
		else return true;
	}
	public void playCard(Card card) {
		
	};
	
}
 