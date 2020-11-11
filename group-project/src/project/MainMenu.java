package project;

import project.cards.LargeHealthPotion;
import project.cards.Revive;
import project.cards.Slash;
import project.cards.SmallHealthPotion;
import project.cards.Stab;
import project.cards.Stick;
import starter.AudioPlayer;
import starter.GraphicsApplication;

public class MainMenu extends GraphicsApplication {
	public static final int RESOLUTION_X = 1920;
	public static final int RESOLUTION_Y = 1080;
	
	private MainMenuGraphics mainMenuPane;
	private MapGraphics mapPane;
	private BoardGraphics boardPane;
	private ShopGraphics shopPane;
	private CharacterSelectGraphics characterSelectPane;

	private AudioPlayer audioPlayer;
	
	private Player player;
	
	public void init() {
		setSize(RESOLUTION_X, RESOLUTION_Y);
	}
	
	public void run() {
		addMouseListeners();

		loadPlayer();
		
		mainMenuPane = new MainMenuGraphics(this);
		mapPane = new MapGraphics(this);
		boardPane = new BoardGraphics(this);
		shopPane = new ShopGraphics(this);
		characterSelectPane = new CharacterSelectGraphics(this);
		
		audioPlayer = AudioPlayer.getInstance();
		
		switchToScreen(mainMenuPane);
	}
	
	public AudioPlayer getAudioPlayer() {
		return audioPlayer;
	}
	
	private void loadPlayer() {
		player = new Player();
		player.setHp(10);
		player.setMaxHp(10);
		player.setMana(10);
		player.setMaxMana(10);
		
		player.getDeck().add(new SmallHealthPotion());
		player.getDeck().add(new LargeHealthPotion());
		player.getDeck().add(new Revive());
		player.getDeck().add(new Stick());
		player.getDeck().add(new Slash());
		player.getDeck().add(new Stab());
	}
	
	public void openMainMenu() {
		switchToScreen(mapPane);
	}
	
	public void openGame() {
		switchToScreen(mapPane);
	}
	
	public void openBoard(Enemy enemy) {
		boardPane.setPlayer(player);
		boardPane.setEnemy(enemy);
		boardPane.loadCards();
		switchToScreen(boardPane);
	}
	
	public void openShop() {
		switchToScreen(shopPane);
	}
	
	public void openCharacterSelect() {
		switchToScreen(characterSelectPane);
	}

}
