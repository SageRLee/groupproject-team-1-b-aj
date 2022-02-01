package project.cards;

import java.util.Random;

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
				if(target == "self") {
					bG.changeEntityStats(player, power, false, true);	
				}
				else if(target == "other") {
					bG.changeEntityStats(player, power, false, true);
				}else if(target == "split") {
					for (int x = 0; x < power; x++) {
						int rand = new Random().nextInt(2);
						if (rand == 0) {
							bG.changeEntityStats(player, 1, false, true);
						} else {
							bG.changeEntityStats(enemy, 1, false, true);
						}
					}
				}
				break;
			case "decrease":
				if(target == "self") {
					bG.changeEntityStats(player, -power, false, true);	
				}
				else if(target == "other") {
					bG.changeEntityStats(player, -power, false, true);
				}else if(target == "split") {
					for (int x = 0; x < power; x++) {
						int rand = new Random().nextInt(2);
						if (rand == 0) {
							bG.changeEntityStats(player, -1, false, true);
						} else {
							bG.changeEntityStats(enemy, -1, false, true);
						}
					}
				}
				break;
			case "both":
				bG.changeEntityStats(player, power, false, true);	
				bG.changeEntityStats(enemy, secEff, false, true);	
				break;
			default:
				System.out.print("This shouldn't happen. Probably gonna fail the class if this occurs.");
		}
	}
	
	
}
