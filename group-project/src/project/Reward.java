package project;

import acm.graphics.GRect;

public class Reward {
	
	Player player;
	int gold;
	Card card;
	
	public Reward(Player player, int gold, Card card) {
		this.player = player;
		this.gold = gold;
		this.card = card;
	}
	
	public void setRewardObjects(MainMenu program) {
		GRect rewardRect = new GRect(0, 0);
		rewardRect.setBounds(300, 300, 1620, 780);
		program.add(rewardRect);
	}
	
	public void giveReward() {
		player.setGold(player.getGold() + gold);
		player.addCard(card);
	}

}
