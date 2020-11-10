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
	
	public Entity() {
		this.hand = new ArrayList<Card>();
		this.deck = new ArrayList<Card>();
		this.discard = new ArrayList<Card>();
	}
	
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
	
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	public void setDiscard(ArrayList<Card> discard) {
		this.discard = discard;
	}
	
	public ArrayList<Card> getDiscard() {
		return discard;
	}
	
	/*
	
	public void shuffleDeck() {
		int length = deck.size();
		ArrayList<Card> temp = new ArrayList<Card>();
		while(temp.size() <= length) {
			int ran = rand.nextInt(deck.size());
			temp.add(deck.get(ran));
			deck.remove(ran);
		}
		deck = temp;
	}
	
	public void resetDeck() {
		if (deck.size() == 0) {
			for(Card discardedCards : discard) {
				deck.add(discardedCards);
			}
			shuffleDeck();
		}
	}
	*/
	
	public void resetDeck() {
		while (getDiscard().size() != 0) {
			Card card = getDiscard().get(new Random().nextInt(getDiscard().size()));
			getDeck().add(card);
			getDiscard().remove(card);
		}
		loadHand();
	}
	
	public void loadHand() {
		while (getHand().size() <= 3) {
			int randCard = new Random().nextInt(getDeck().size());
			getHand().add(getDeck().get(randCard));
			getDeck().remove(randCard);
		}
	}
	
	public boolean isAlive() {
		if(hp <= 0) return false;
		else return true;
	}
	
}
 