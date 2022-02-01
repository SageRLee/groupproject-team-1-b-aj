package project.cards;

import acm.graphics.GImage;
import project.BoardGraphics;
import project.Card;
import project.Enemy;
import project.Entity;
import project.Player;
import starter.GraphicsPane;

public class CustomCard extends Card {
	String effect, target;
	int power, secEff;
	public CustomCard(String name, String filepath, int price, int cost, String effect, String target, int power, int secEff) {
		super(new GImage(filepath), name, cost, price);
		effect = this.effect;
		target = this.target;
		power = this.power;
		secEff = this.secEff;
	}
	
	@Override
	public void play(BoardGraphics bG, boolean isPlayerTurn, Player player, Enemy enemy) {
		switch(effect){
			case "increase":
				
				break;
			case "decrease":
				break;
			case "both":
				break;
			default:
				System.out.print("This shouldn't happen. Probably gonna fail the class if this occurs.");
		}
		if (isPlayerTurn) {
//			bG.changeEntityStats(player, 5, true, true);
		} else {
//			bG.changeEntityStats(enemy, 5, true, true);
		}
	}
	
	
}
