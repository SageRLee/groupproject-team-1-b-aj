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
		enemy.setHp(10);
		enemy.setMaxHp(20);
		enemy.setMana(10);
		enemy.setMaxMana(10);

		playerHealthDamageBar.setSize((player.getHp()*PLAYER_BAR_WIDTH)/player.getMaxHp(), playerHealthDamageBar.getHeight());
		playerHealthText.setLabel(player.getHp() + "/" + player.getMaxHp());
		enemyHealthBar.setSize((enemy.getHp()*ENEMY_BAR_WIDTH)/enemy.getMaxHp(), enemyHealthBar.getHeight());

		/*
		loadCards();
		pause(2000);*/
		loadCards();
		playerDamaged(1);
		pause(2000);
		enemyDamaged(1);
		pause(2000);
		//playerHealed(1);
		//pause(2000);
		//enemyHealed(1);
		//pause(2000);
		//playerArmorAdd(5);
		//pause(2000);
		//playerArmorSubtract(5);
		//pause(2000);
		//enemyArmorAdd(5);
		//pause(2000);
		//enemyArmorSubtract(5);
		//pause(2000);
	}
	
	private void loadCards() {
		player.getDeck().add(new SmallHealthPotion());
		player.getDeck().add(new LargeHealthPotion());
		player.getDeck().add(new Revive());
		player.getDeck().add(new Stick());
		player.getDeck().add(new Slash());
		player.getDeck().add(new Stab());
		while (player.getHand().size() <= 5) {
			int randCard = new Random().nextInt(player.getDeck().size());
			player.getHand().add(player.getDeck().get(randCard));
			player.getDeck().remove(randCard);
		}

		reloadHand();
	}
	
	private void reloadHand() {
		int x = 0;
		for (Card cards : player.getHand()) {
			cards.getPicture().setLocation((202 * x) + 400, 700);
			cards.getPicture().sendToBack();
			add(cards.getPicture());
			x++;
		}
	}
	
	public void playerDamaged(int damageAmt) {
		int newHp = player.getHp() - damageAmt;
		if (newHp < 0)
			newHp = 0;
				
		player.setHp(newHp);
		
		playerHealthDamageBar.setSize((player.getHp()*PLAYER_BAR_WIDTH)/player.getMaxHp(), playerHealthDamageBar.getHeight());
		
		playerHealthText.setLabel(player.getHp() + "/" + player.getMaxHp());
		
		new Thread() {
	        public void run() {
	        	GLabel damageLabel = new GLabel("-" + damageAmt);
	        	damageLabel.setColor(Color.RED);
	        	damageLabel.setFont(statsFont);
	        	damageLabel.setLocation(400, 50);
	    		add(damageLabel);
	    		for (int x = 0; x < 30; x++) {
	    			damageLabel.move(0, 1);
	    			pause(30);
	    		}
	    		
	    		remove(damageLabel);
	        }
	    }.start();
	}
	
	public void enemyDamaged(int damageAmt) {
		int newHp = enemy.getHp() - damageAmt;
		if (newHp < 0)
			newHp = 0;
				
		enemy.setHp(newHp);
		
		enemyHealthBar.setSize((enemy.getHp()*ENEMY_BAR_WIDTH)/enemy.getMaxHp(), enemyHealthBar.getHeight());
		
		new Thread() {
	        public void run() {
	        	GLabel damageLabel = new GLabel("-" + damageAmt);
	        	damageLabel.setColor(Color.RED);
	        	damageLabel.setFont(statsFont);
	        	damageLabel.setLocation(1050, 740);
	    		add(damageLabel);
	    		for (int x = 0; x < 30; x++) {
	    			damageLabel.move(0, 1);
	    			pause(30);
	    		}
	    		
	    		remove(damageLabel);
	        }
	    }.start();
	}
	
	public void playerHealed(int healAmt) {
		int newHp = player.getHp() + healAmt;

		if (newHp > player.getMaxHp())
			newHp = player.getMaxHp();
		
		player.setHp(newHp);
		
		playerHealthDamageBar.setSize((newHp*PLAYER_BAR_WIDTH)/player.getMaxHp(), playerHealthDamageBar.getHeight());
		
		playerHealthText.setLabel(player.getHp() + "/" + player.getMaxHp());
		
		new Thread() {
	        public void run() {
	        	GLabel healLabel = new GLabel("+" + healAmt);
	    		healLabel.setColor(Color.GREEN);
	    		healLabel.setFont(statsFont);
	    		healLabel.setLocation(400, 50);
	    		add(healLabel);
	    		for (int x = 0; x < 30; x++) {
	    			healLabel.move(0, 1);
	    			pause(30);
	    		}
	    		
	    		remove(healLabel);
	        }
	    }.start();
	}
	
	public void enemyHealed(int healAmt) {
		int newHp = enemy.getHp() + healAmt;
		if (newHp > enemy.getMaxHp())
			newHp = enemy.getMaxHp();
				
		enemy.setHp(newHp);
		
		enemyHealthBar.setSize((enemy.getHp()*ENEMY_BAR_WIDTH)/enemy.getMaxHp(), enemyHealthBar.getHeight());
			
		new Thread() {
	        public void run() {
	        	GLabel healLabel = new GLabel("+" + healAmt);
	    		healLabel.setColor(Color.GREEN);
	    		healLabel.setFont(statsFont);
	    		healLabel.setLocation(1050, 740);
	    		add(healLabel);
	    		for (int x = 0; x < 30; x++) {
	    			healLabel.move(0, 1);
	    			pause(30);
	    		}
	    		
	    		remove(healLabel);
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
		
		//isPlayerTurn = !isPlayerTurn;
	}
	
	public void playEnemyTurn(Player player, Card card) {
		
	}
	
}
