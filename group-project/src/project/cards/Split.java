package project.cards;

import java.util.Random;

import acm.graphics.GImage;
import project.BoardGraphics;
import project.Card;
import project.Enemy;
import project.Entity;
import project.Player;

public class Split extends Card {

	public Split() {
		super(new GImage("media/images/cards/SplitCard.png"), "Split", 3, 100);
	}
	
	@Override
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {
		//TODO fix
		for (int x = 0; x < 5; x++) {
			int rand = new Random().nextInt(1);
			if (rand == 0) {
				bG.changeEntityStats(player, -1, true);
			} else {
				bG.changeEntityStats(enemy, -1, false);
			}
		}
	}

}
