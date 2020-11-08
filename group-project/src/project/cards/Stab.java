package project.cards;

import acm.graphics.GImage;
import project.BoardGraphics;
import project.Card;
import project.Enemy;
import project.Entity;
import project.Player;

public class Stab extends Card {

	public Stab() {
		super(new GImage("media/images/cards/StabCard.png"), "Stab", 7, 200);
	}
	
	@Override
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {
		if (isPlayerTurn) {
			bG.enemyDamaged(5);
		} else {
			bG.playerDamaged(5);
		}
	}

}
