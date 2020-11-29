package project;

import java.util.ArrayList;

import acm.graphics.GImage;

//ignore
public class Player extends Entity {
	
	private int gold;
	
	public Player(GImage sprite, int hp, int maxHp, int mana, int maxMana, ArrayList<Card> deck) {
		super(sprite, hp, maxHp, mana, maxMana, deck);
		gold = Integer.parseInt(ConfigManager.getPath("gold"));
	}
	
	public int getGold() {
		return gold;
	}
	
	public void setGold(int gold) {
		this.gold = gold;
		ConfigManager.setPath("gold", String.valueOf(gold));
	}
	
	public boolean hasCard(Card card) {
		if (card != null) {
			for (Card cardsInDeck : getDeck()) {
				if (cardsInDeck.getName().equalsIgnoreCase(card.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	public void addCard(Card card) {
		if (card != null && !hasCard(card)) {
			getDeck().add(card);
			ConfigManager.setPath("cards", ConfigManager.getPath("cards") + "," + card.getName().toLowerCase().replaceAll(" ", ""));
		}
	}
	
	public void removeCard(Card card) {
		if (card != null) {
			Card cardToRemove = null;
			for (Card cardsInDeck : getDeck()) {
				if (cardsInDeck.getName().equalsIgnoreCase(card.getName())) {
					String cardName = card.getName().toLowerCase().replaceAll(" ", "");
					ConfigManager.setPath("cards", ConfigManager.getPath("cards").replace("," + cardName, "")
							.replace(cardName + ",", "").replace(cardName, ""));
					cardToRemove = cardsInDeck;
					break;
				}
			}
			getDeck().remove(cardToRemove);
		}
	}

}
