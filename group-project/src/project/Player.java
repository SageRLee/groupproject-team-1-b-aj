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
	
	public boolean hasCard(String cardName) {
		if (cardName != null) {
			for (Card cardsInDeck : getDeck()) {
				if (cardsInDeck != null && cardsInDeck.getName().equalsIgnoreCase(cardName)) {
					return true;
				}
			}
		}
		return false;
	}

	public void addCard(Card card) {
		if (card != null && !hasCard(card.getName())) {
			String comma = ",";
			if (getDeck().size() == 0)
				comma = "";
			ConfigManager.setPath("cards", ConfigManager.getPath("cards") + comma + card.getName().toLowerCase().replaceAll(" ", ""));
			getDeck().add(card);
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
