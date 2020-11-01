package project;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.program.GraphicsProgram;

//ANDREW

public class BoardGraphics extends ProjectGraphics implements ActionListener {
	
	private GLine enemyHealthBar;
	private GLine enemyManaBar;
	private GLine enemyArmorBar;
	private GLabel playerHealthText;
	private GImage playerHealthBar;
	private GLine playerHealthDamageBar;
	private GLabel playerManaText;
	private GImage playerManaBar;
	private GLine playerManaUseBar;
	private GLabel playerArmorText;
	private GImage playerArmorBar;
	
	public void run() {
		enemyHealthBar = new GLine(20, 20, 200, 40);
		
		initializeApplet();
		
		add(enemyHealthBar);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void playPlayerTurn(Enemy enemy, Card card) {
		
	}
	
	public void playEnemyTurn(Player player, Card card) {
		
	}
}
