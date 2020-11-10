package project;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.Timer;



import acm.graphics.*;
import acm.program.GraphicsProgram;
import starter.AudioPlayer;
import starter.GraphicsPane;

public class MainMenuGraphics extends GraphicsPane {
	
	private MainMenu program;

	private GImage title;
	private GImage play;
	private GImage shop;
	private GImage charSelect;
	private GImage background;
	private GImage quit;
	private AudioPlayer snd;
	//private Timer someTimeVar = new Timer(33, this); TODO fix
	
	private GObject target;
	private GRect hover;
	private GRect blackscrn;
	private int scrAlpha;
	private int lastX;
	private int lastY;
	private boolean transition;
	
	private void initializeObjects() {
		title = new GImage("media/images/Title.jpg");
		play = new GImage("media/images/PlayButton.png");
		shop = new GImage("media/images/Shop.png");
		charSelect = new GImage("media/images/CharacterSelect.png");
		background = new GImage("media/images/Background.png", 0, 0);//Yeah I know the background is low res, it's just a placeholder 
		quit = new GImage("media/images/Quit.png", 0, 0);
		hover = new GRect(0, 0, MainMenu.RESOLUTION_X / 6, MainMenu.RESOLUTION_Y / 6);
		blackscrn = new GRect(0, 0, MainMenu.RESOLUTION_X, MainMenu.RESOLUTION_Y );//Black screen for fade out
		scrAlpha = 5;
		lastX = 0;
		lastY = 0;
		transition = false;
		
		snd = AudioPlayer.getInstance();
		background.setSize(MainMenu.RESOLUTION_X, MainMenu.RESOLUTION_Y);//Mess around with locations later to make them equal distance from each other
		play.setSize(MainMenu.RESOLUTION_X / 6, MainMenu.RESOLUTION_Y / 6);
		play.setLocation(MainMenu.RESOLUTION_X / 2 - play.getWidth()/2, MainMenu.RESOLUTION_Y / 3);
		shop.setSize(MainMenu.RESOLUTION_X / 6, MainMenu.RESOLUTION_Y / 6);
		shop.setLocation(MainMenu.RESOLUTION_X / 3 - shop.getWidth()/2, MainMenu.RESOLUTION_Y / 2 + 64);
		charSelect.setSize(MainMenu.RESOLUTION_X / 6, MainMenu.RESOLUTION_Y / 6);
		charSelect.setLocation(MainMenu.RESOLUTION_X * 2 / 3 - charSelect.getWidth()/2, MainMenu.RESOLUTION_Y / 2 + 64);
		title.setSize(MainMenu.RESOLUTION_X / 4, MainMenu.RESOLUTION_Y / 6);
		title.setLocation(MainMenu.RESOLUTION_X / 2 - title.getWidth()/2, MainMenu.RESOLUTION_Y / 8);
		hover.setSize(MainMenu.RESOLUTION_X / 6 + 16, MainMenu.RESOLUTION_Y / 6 + 16);
		hover.setColor(new Color(0, 0, 0, 255));
		hover.setFilled(true);
		hover.setFillColor(new Color(255));
		hover.setVisible(false);
		blackscrn.setFillColor(new Color(0, 0, 0, 5));
		blackscrn.setFilled(true);
		quit.setSize(128, 128);
		quit.setLocation(MainMenu.RESOLUTION_X - quit.getWidth(), 0);
	}
	
	public MainMenuGraphics(MainMenu program) {
		super();
		this.program = program;
		initializeObjects();
	}
	
	//Trying to get custom cursor to work, not working for some reason. Check back if you have time, if not just ignore Ask David maybe?
	public void CustomCursor() {	
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("media/images/Cursor.png");
		Point hotspot = new Point(0, 0);
		Cursor cursor = toolkit.createCustomCursor(img, hotspot, "mainCursor");
		program.setCursor(cursor);
		
	}
	public void mousePressed(MouseEvent e) {
		//Mouse event for all button options
		if(target == null) {
			
		} else {
			program.add(blackscrn);
			snd.playSound("media/sounds/", "select.mp3");
			transition = true;
			if(target == play) {
			System.out.println("Playing game");	
			
			program.playGame();
			
			} else if(target == shop){
				System.out.println("Opening shop");
				//shp.run();
				
			} else if(target == charSelect) {
				System.out.println("Opening character select");
				//character.run();
			}
			}
		}
	public void actionPerformed(ActionEvent e) {
		if(transition) {
			blackscrn.setFillColor(new Color(0, 0, 0, scrAlpha));
			if(hover.isVisible()) {
				hover.setVisible(false);
			}else {
				hover.setVisible(true);
			}
			if(scrAlpha < 255) {
				scrAlpha+= 10;
			}
		}
	}
	public void mouseMoved(MouseEvent e) {
		//Mouse Hovering
		
		if(program.getElementAt(e.getX(), e.getY()) == play || program.getElementAt(e.getX(), e.getY()) == shop || program.getElementAt(e.getX(), e.getY()) == charSelect ) {
			//hover = getElementAt(e.getX(), e.getY());
			hover.setLocation(program.getElementAt(e.getX(), e.getY()).getX() - 8,  program.getElementAt(e.getX(), e.getY()).getY() - 8);
			hover.setVisible(true);
			target = program.getElementAt(e.getX(), e.getY());
			if(program.getElementAt(e.getX(), e.getY()) != program.getElementAt(lastX, lastY)) {
				snd.playSound("media/sounds/", "cardHover.mp3");
			}
		}
		else {
			hover.setVisible(false);
			target = null;
		}
		
		lastX = e.getX();
		lastY = e.getY();
	}
	public void mouseEntered(MouseEvent e) {
		//this.setCursor(c);
	}
	@Override
	public void showContents() {
		CustomCursor();
		//someTimeVar.start(); TODO fix
		program.add(title);
		program.add(background);
		program.add(hover);
		program.add(title);
		program.add(play);
		program.add(shop);
		program.add(charSelect);
		program.add(quit);
	}
	@Override
	public void hideContents() {
		program.remove(title);
		program.remove(background);
		program.remove(hover);
		program.remove(title);
		program.remove(play);
		program.remove(shop);
		program.remove(charSelect);
		program.remove(quit);
	}

	
}
