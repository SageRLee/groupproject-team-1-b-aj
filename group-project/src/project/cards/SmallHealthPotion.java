package project.cards;

import acm.graphics.GImage;
import project.Card;
import project.Enemy;
import project.Entity;
import project.Player;

public class SmallHealthPotion extends Card {

	public SmallHealthPotion(GImage picture, String name, String description, int cost) {
		super(picture, name, description, cost);
	}
	
	@Override
	public void play(boolean isPlayerTurn, Player player, Enemy enemy) {
		Entity target;
		if (isPlayerTurn) {
			target = player;
		} else {
			target = enemy;
		}
	}

}
