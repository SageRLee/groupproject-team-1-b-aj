package project;
import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class MainMenuGraphics extends ProjectGraphics {
	private static GImage titleImage = new GImage("media/images/Title.jpg");
	private static GImage playButtonImage = new GImage("media/images/PlayButton.png");
	private static GImage shopButtonImage;
	private static GImage background = new GImage("media/images/Background.png", 0, 0);//Yeah I know the background is low res, it's just a placeholder 
	
	public void run() {
		initializeApplet();
		background.setSize(MainMenu.RESOLUTION_X, MainMenu.RESOLUTION_Y);
		
		playButtonImage.setSize(MainMenu.RESOLUTION_X / 6, MainMenu.RESOLUTION_Y / 6);
		playButtonImage.setLocation(MainMenu.RESOLUTION_X / 2 - playButtonImage.getWidth()/2, MainMenu.RESOLUTION_Y / 3);
		titleImage.setSize(MainMenu.RESOLUTION_X / 4, MainMenu.RESOLUTION_Y / 4);
		titleImage.setLocation(MainMenu.RESOLUTION_X / 2 - titleImage.getWidth()/2, MainMenu.RESOLUTION_Y / 16);
		
		add(titleImage);
		add(background);
		add(titleImage);
		add(playButtonImage);
		
		
	}
	public void mousePressed(MouseEvent e) {
		//Mouse event for all button options
	}
	
}
