package project;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class MainMenuGraphics extends ProjectGraphics {
	//Images
	private static GImage title = new GImage("media/images/Title.jpg");
	private static GImage play = new GImage("media/images/PlayButton.png");
	private static GImage shop = new GImage("media/images/Shop.png");
	private static GImage charSelect = new GImage("media/images/CharacterSelect.png");
	private static GImage background = new GImage("media/images/Background.png", 0, 0);//Yeah I know the background is low res, it's just a placeholder 
	//private Timer someTimeVar = new Timer(33, this);
	private static GObject target;
	private GRect hover = new GRect(0, 0, 3, 3 );
	//Classes
	private Map mp = new Map();
	//private Shop shp = new Shop();
	private CharacterSelect character = new CharacterSelect();
	public void run() {
		initializeApplet();
		addMouseListeners();
		background.setSize(MainMenu.RESOLUTION_X, MainMenu.RESOLUTION_Y);
		//Mess around with locations later to make them equal distance from each other
		play.setSize(MainMenu.RESOLUTION_X / 6, MainMenu.RESOLUTION_Y / 6);
		play.setLocation(MainMenu.RESOLUTION_X / 2 - play.getWidth()/2, MainMenu.RESOLUTION_Y / 3);
		shop.setSize(MainMenu.RESOLUTION_X / 6, MainMenu.RESOLUTION_Y / 6);
		shop.setLocation(MainMenu.RESOLUTION_X / 3 - shop.getWidth()/2, MainMenu.RESOLUTION_Y / 2 + 64);
		charSelect.setSize(MainMenu.RESOLUTION_X / 6, MainMenu.RESOLUTION_Y / 6);
		charSelect.setLocation(MainMenu.RESOLUTION_X * 2 / 3 - charSelect.getWidth()/2, MainMenu.RESOLUTION_Y / 2 + 64);
		title.setSize(MainMenu.RESOLUTION_X / 4, MainMenu.RESOLUTION_Y / 6);
		title.setLocation(MainMenu.RESOLUTION_X / 2 - title.getWidth()/2, MainMenu.RESOLUTION_Y / 8);
		hover.setSize(MainMenu.RESOLUTION_X / 6 + 16, MainMenu.RESOLUTION_Y / 6 + 16);
		hover.setColor(new Color(255));
		hover.setFilled(true);
		hover.setFillColor(new Color(255));
		hover.setVisible(false);
		add(title);
		add(background);
		add(hover);
		add(title);
		add(play);
		add(shop);
		add(charSelect);
	
		
	}
	public void mousePressed(MouseEvent e) {
		//Mouse event for all button options
		if(target == null) {
			
		} else if(target == play) {
			System.out.println("Playing game");	
			
			mp.run();
			
			} else if(target == shop){
				System.out.println("Opening shop");
				//shp.run();
				
			} else if(target == charSelect) {
				System.out.println("Opening character select");
				//character.run();
			}
		}
	public void mouseMoved(MouseEvent e) {
		//Mouse Hovering
		if(getElementAt(e.getX(), e.getY()) == play || getElementAt(e.getX(), e.getY()) == shop || getElementAt(e.getX(), e.getY()) == charSelect ) {
			hover.setLocation( getElementAt(e.getX(), e.getY()).getX() - 8,  getElementAt(e.getX(), e.getY()).getY() - 8);
			hover.setVisible(true);
			target = getElementAt(e.getX(), e.getY());
		}
		else {
			hover.setVisible(false);
			target = null;
		}
	}

	
}
