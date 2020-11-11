package project;

import java.util.ArrayList;

import project.cards.SmallHealthPotion;
import project.cards.LargeHealthPotion;
import project.cards.Revive;
import project.cards.Stick;
import project.cards.Slash;
import project.cards.Stab;

public class CardPool {
	public ArrayList<Card> cardList = new ArrayList<Card>();
	
	public CardPool() {
		cardList.add(new SmallHealthPotion());
		cardList.add(new LargeHealthPotion());
		cardList.add(new Revive());
		cardList.add(new Stick());
		cardList.add(new Slash());
		cardList.add(new Stab());
	}
	
}
