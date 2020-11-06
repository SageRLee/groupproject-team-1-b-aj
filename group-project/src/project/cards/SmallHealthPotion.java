package project.cards;

import acm.graphics.GImage;
import project.BoardGraphics;
import project.Card;
import project.Enemy;
import project.Entity;
import project.Player;

public class SmallHealthPotion extends Card {

	public SmallHealthPotion() {
		super(new GImage("media/images/SmallHealthPotion.jpg"), "Small Health Potion", "+2 Health", 50);
	}
	
	@Override
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {
		if (isPlayerTurn) {
			bG.playerHealed(2);
		} else {
			bG.enemyHealed(2);
		}
	}

}
