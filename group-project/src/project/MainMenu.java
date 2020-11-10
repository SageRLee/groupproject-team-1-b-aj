package project;

import starter.GraphicsApplication;

public class MainMenu extends GraphicsApplication {
	public static final int RESOLUTION_X = 1920;
	public static final int RESOLUTION_Y = 1080;
	
	private MainMenuGraphics mainMenuPane;
	private MapGraphics mapPane;
	
	public void init() {
		setSize(RESOLUTION_X, RESOLUTION_Y);
	}
	
	public void run() {
		addMouseListeners();
		
		mainMenuPane = new MainMenuGraphics(this);
		mapPane = new MapGraphics(this);
		
		switchToScreen(mainMenuPane);
	}
	
	public void playGame() {
		switchToScreen(mapPane);
	}
	
	public void openShop(){
		
	}
	
	public void openCharacterSelect() {
		
	}
	
	public void setResolution() {
		
	}
}
