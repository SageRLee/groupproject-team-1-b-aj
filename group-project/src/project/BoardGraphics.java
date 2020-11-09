package project;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Random;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import project.cards.LargeHealthPotion;
import project.cards.Revive;
import project.cards.Slash;
import project.cards.SmallHealthPotion;
import project.cards.Stab;
import project.cards.Stick;

//ANDREW

public class BoardGraphics extends ProjectGraphics implements ActionListener {
	
	private Font statsFont;
	
	private GImage background;
	
	private GRect enemyHealthBar;
	private GRect enemyManaBar;
	private GRect enemyArmorBar;
	private GLabel playerHealthText; //TODO
	private GImage playerHealthBar; //TODO
	private GRect playerHealthDamageBar; //TODO
	private GLabel playerManaText; //TODO
	private GImage playerManaBar; //TODO
	private GRect playerManaUseBar; //TODO
	//private GLabel playerArmorText; //TODO
	//private GImage playerArmorBar; //TODO

	private static int PLAYER_BAR_WIDTH;
	private static int ENEMY_BAR_WIDTH;
	
	private Player player;
	private Enemy enemy;
	
	private boolean isPlayerTurn;
	
	public BoardGraphics() {
		//todo idk why the fuck i need this
	}
	
	public BoardGraphics(Player player, Enemy enemy) {
		this.player = player;
		this.enemy = enemy;
	}
	
	public void run() {
		addMouseListeners();
		initializeApplet();
		
		statsFont = new Font("TimesRoman", Font.PLAIN, 50);
		
		background = new GImage("media/images/DungeonBackground.jpg");
		
		enemyHealthBar = new GRect(843, 640, 193, 15);
		enemyHealthBar.setFillColor(Color.RED);
		enemyHealthBar.setFilled(true);
		
		enemyManaBar = new GRect(843, 660, 193, 10);
		enemyManaBar.setFillColor(Color.BLUE);
		enemyManaBar.setFilled(true);
		
		enemyArmorBar = new GRect(843, 680, 193, 5);
		enemyArmorBar.setFillColor(Color.GRAY);
		enemyArmorBar.setFilled(true);
		
		playerHealthBar = new GImage("media/images/PlayerHealth.png", 0, 0);
		playerHealthBar.setSize(366, 82);
		playerHealthDamageBar = new GRect(80, 12, 273, 57);
		playerHealthDamageBar.setFilled(true);
		playerHealthDamageBar.setFillColor(Color.GREEN);
		playerHealthDamageBar.setColor(Color.GREEN);
		playerHealthText = new GLabel("10/10"); //TODO getHealth
		playerHealthText.setLocation(176, 57);
		playerHealthText.setFont(statsFont);
		
		playerManaBar = new GImage("media/images/PlayerMana.png", 0, 82);
		playerManaBar.setSize(366, 82);
		playerManaUseBar = new GRect(80, 94, 273, 57);
		playerManaUseBar.setFilled(true);
		playerManaUseBar.setFillColor(Color.BLUE);
		playerManaUseBar.setColor(Color.BLUE);
		playerManaText = new GLabel("10/10"); //TODO getMana
		playerManaText.setLocation(176, 140);
		playerManaText.setFont(statsFont);

		/*
		playerArmorBar = new GImage("media/images/PlayerArmor.png", 0, 164);
		playerArmorBar.setSize(148, 82);
		playerArmorText = new GLabel("10"); //TODO getMana
		playerArmorText.setLocation(82, 220);
		playerArmorText.setFont(statsFont);
		*/

		add(background);
		
		add(enemyHealthBar);
		add(enemyManaBar);
		add(enemyArmorBar);

		add(playerHealthBar);
		add(playerHealthDamageBar);
		add(playerHealthText);
		
		add(playerManaBar);
		add(playerManaUseBar);
		add(playerManaText);
		
		//add(playerArmorBar);
		//add(playerArmorText);
		
		PLAYER_BAR_WIDTH = (int) playerHealthDamageBar.getWidth();
		ENEMY_BAR_WIDTH = (int) enemyHealthBar.getWidth();
		
		isPlayerTurn = true;
		
		testRun();
	}
	
	private void testRun() {
		
		player = new Player();
		player.setHp(10);
		player.setMaxHp(10);
		player.setMana(10);
		player.setMaxMana(10);
		enemy = new Enemy();
		enemy.setHp(20);
		enemy.setMaxHp(20);
		enemy.setMana(10);
		enemy.setMaxMana(10);
		
		loadTestCards();
		/*changeEntityStats(player, -1, true);
		pause(2000);
		changeEntityStats(player, 1, true);
		pause(2000);
		changeEntityStats(enemy, -1, true);
		pause(2000);
		changeEntityStats(enemy, 1, true);
		pause(2000);
		changeEntityStats(player, -1, false);
		pause(2000);
		changeEntityStats(player, 1, false);
		pause(2000);
		changeEntityStats(enemy, -1, false);
		pause(2000);
		changeEntityStats(enemy, 1, false);
		pause(2000);*/
	}
	
	private void loadTestCards() {
		player.getDeck().add(new SmallHealthPotion());
		player.getDeck().add(new LargeHealthPotion());
		player.getDeck().add(new Revive());
		player.getDeck().add(new Stick());
		player.getDeck().add(new Slash());
		player.getDeck().add(new Stab());
		while (player.getHand().size() <= 3) {
			int randCard = new Random().nextInt(player.getDeck().size());
			player.getHand().add(player.getDeck().get(randCard));
			player.getDeck().remove(randCard);
		}
		
		enemy.getDeck().add(new SmallHealthPotion());
		enemy.getDeck().add(new LargeHealthPotion());
		enemy.getDeck().add(new Revive());
		enemy.getDeck().add(new Stick());
		enemy.getDeck().add(new Slash());
		enemy.getDeck().add(new Stab());
		while (enemy.getHand().size() <= 3) {
			int randCard = new Random().nextInt(enemy.getDeck().size());
			enemy.getHand().add(enemy.getDeck().get(randCard));
			enemy.getDeck().remove(randCard);
		}

		reloadHand();
	}
	
	private void reloadHand() {
		int x = 0;
		for (Card cards : player.getHand()) {
			cards.getPicture().setLocation((202 * x) + 400, 700);
			add(cards.getPicture());
			x++;
		}

		x = 0;
		for (Card cards : enemy.getHand()) {
			cards.getPicture().setLocation((101 * x) + 900, 0);
			cards.getPicture().setSize(100, 200);
			add(cards.getPicture());
			x++;
		}
	}
	
	public void changeEntityStats(Entity entity, int amt, boolean isHealth) {
		boolean isPositive = amt > 0;
		
		if (isHealth) {
			int newHp = entity.getHp() + amt;
			if (newHp > entity.getMaxHp())
				newHp = entity.getMaxHp();
			if (newHp < 0)
				newHp = 0;
					
			entity.setHp(newHp);
			
			if (entity instanceof Player) {
				playerHealthDamageBar.setSize((entity.getHp()*PLAYER_BAR_WIDTH)/entity.getMaxHp(), playerHealthDamageBar.getHeight());
				playerHealthText.setLabel(entity.getHp() + "/" + entity.getMaxHp());
			} else {
				enemyHealthBar.setSize((entity.getHp()*ENEMY_BAR_WIDTH)/entity.getMaxHp(), enemyHealthBar.getHeight());
			}
		} else {
			int newMana = entity.getMana() + amt;
			if (newMana > entity.getMaxMana())
				newMana = entity.getMaxMana();
			if (newMana < 0)
				newMana = 0;
					
			entity.setMana(newMana);
			
			if (entity instanceof Player) {
				playerManaUseBar.setSize((entity.getMana()*PLAYER_BAR_WIDTH)/entity.getMaxMana(), playerManaUseBar.getHeight());
				playerManaText.setLabel(entity.getMana() + "/" + entity.getMaxMana());
			} else {
				enemyManaBar.setSize((entity.getMana()*ENEMY_BAR_WIDTH)/entity.getMaxMana(), enemyManaBar.getHeight());
			}
		}
		
		
		new Thread() {
	        public void run() {
	        	GLabel statLabel;
	        	
	        	if (isPositive) {
	        		statLabel = new GLabel("+" + amt);
	        		if (isHealth) {
		        		statLabel.setColor(Color.GREEN);
	        		} else {
	        			statLabel.setColor(Color.BLUE);
	        		}
	        	} else {
	        		statLabel = new GLabel("" + amt);
	        		if (isHealth) {
	        			statLabel.setColor(Color.RED);
	        		} else {
	        			statLabel.setColor(Color.MAGENTA);
	        		}
	        	}
	        	
	        	statLabel.setFont(statsFont);
	        	if (entity instanceof Player) {
	        		if (isHealth) {
	        			statLabel.setLocation(400, 50);
	        		} else {
	        			statLabel.setLocation(400, 132);
	        		}
	        	} else {
	        		if (isHealth) {
	        			statLabel.setLocation(1050, 640);
	        		} else {
	        			statLabel.setLocation(1050, 660);
	        		}
	        	}
	    		add(statLabel);
	    		
	    		for (int x = 0; x < 30; x++) {
	    			statLabel.move(0, 1);
	    			pause(30);
	    		}
	    		
	    		remove(statLabel);
	        }
	    }.start();
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		Card cardToRemove = null;
		for (Card cards : player.getHand()) {
			if (getElementAt(e.getX(), e.getY()) == cards.getPicture()) {
				cards.play(this, isPlayerTurn, player, enemy);
				player.getDiscard().add(cards);
				remove(cards.getPicture());
				cardToRemove = cards;
				break;
			}
		}
		if (cardToRemove != null)
			player.getHand().remove(cardToRemove);
		
		reloadHand();
		
		new Thread() {
			public void run() {
				playEnemyTurn();
			}
		}.start();
	}
	
	public void playEnemyTurn() {
		pause(2000);
		
		isPlayerTurn = false;
		
		Card randomEnemyCard = enemy.getHand().get(new Random().nextInt(enemy.getHand().size()));
		randomEnemyCard.play(this, isPlayerTurn, player, enemy);
		remove(randomEnemyCard.getPicture());
		enemy.getHand().remove(randomEnemyCard);
		
		reloadHand();
		
		isPlayerTurn = true;
	}
	
}
