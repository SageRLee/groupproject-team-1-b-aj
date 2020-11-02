package project;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

//ANDREW

public class BoardGraphics extends ProjectGraphics implements ActionListener {
	
	private Font statsFont;
	
	private GRect enemyHealthBar;
	private GRect enemyManaBar;
	private GRect enemyArmorBar;
	private GLabel playerHealthText; //TODO
	private GImage playerHealthBar; //TODO
	private GRect playerHealthDamageBar; //TODO
	private GLabel playerManaText; //TODO
	private GImage playerManaBar; //TODO
	private GRect playerManaUseBar; //TODO
	private GLabel playerArmorText; //TODO
	private GImage playerArmorBar; //TODO
	
	public void run() {
		
		statsFont = new Font("TimesRoman", Font.PLAIN, 50);

		initializeApplet();
		
		enemyHealthBar = new GRect(860, 540, 200, 15);
		enemyHealthBar.setFillColor(Color.RED);
		enemyHealthBar.setFilled(true);
		
		enemyManaBar = new GRect(860, 560, 200, 10);
		enemyManaBar.setFillColor(Color.BLUE);
		enemyManaBar.setFilled(true);
		
		enemyArmorBar = new GRect(860, 580, 200, 5);
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

		add(enemyHealthBar);
		add(enemyManaBar);
		add(enemyArmorBar);

		add(playerHealthBar);
		add(playerHealthDamageBar);
		add(playerHealthText);
		
		add(playerManaBar);
		add(playerManaUseBar);
		add(playerManaText);
		
		add(playerArmorText);
		add(playerArmorBar);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void playPlayerTurn(Enemy enemy, Card card) {
		
	}
	
	public void playEnemyTurn(Player player, Card card) {
		
	}
}
