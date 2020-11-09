package project.cards;

import acm.graphics.GImage;
import project.BoardGraphics;
import project.Card;
import project.Enemy;
import project.Entity;
import project.Player;

public class Stick extends Card {

	public Stick() {
		super(new GImage("media/images/cards/StickCard.png"), "Stick", 2, 25);
	}
	
	@Override
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {
		if (isPlayerTurn) {
			bG.enemyDamaged(1);
		} else {
			bG.playerDamaged(1);
		}
	}

}
