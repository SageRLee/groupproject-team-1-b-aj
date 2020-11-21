package project;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.GImage;
import project.cards.LargeHealthPotion;
import project.cards.LargeManaPotion;
import project.cards.LifeSteal;
import project.cards.ManaRevive;
import project.cards.Revive;
import project.cards.Slash;
import project.cards.SmallHealthPotion;
import project.cards.SmallManaPotion;
import project.cards.SoulSteal;
import project.cards.Split;
import project.cards.Stab;
import project.cards.Stick;
import project.cards.Suicide;
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

		ConfigManager.initializeFile();
		
		mainMenuPane = new MainMenuGraphics(this);
		mapPane = new MapGraphics(this);
		boardPane = new BoardGraphics(this);
		shopPane = new ShopGraphics(this);
		characterSelectPane = new CharacterSelectGraphics(this);
		
		audioPlayer = AudioPlayer.getInstance();

		
		loadPlayer();
		
		switchToScreen(mainMenuPane);
	}
	
	public AudioPlayer getAudioPlayer() {
		return audioPlayer;
	}
	
	private void loadPlayer() {
		ArrayList<Card> playerDeck = loadPlayerDeck();

		//todo set sprite and gold
		player = new Player(null, 10, 10, 10, 10, playerDeck);
	}
	
	private ArrayList<Card> loadPlayerDeck() {
		ArrayList<Card> playerDeck = new ArrayList<Card>();
		String cards = ConfigManager.getPath("cards");
		String[] cardsArray = cards.split(",");
		for (String cardString : cardsArray) {
			Card cardToAdd = null;
			switch (cardString) {
			case "smallhealthpotion": cardToAdd = new SmallHealthPotion(); break;
			case "largehealthpotion": cardToAdd = new LargeHealthPotion(); break;
			case "revive": cardToAdd = new Revive(); break;
			case "stick": cardToAdd = new Stick(); break;
			case "slash": cardToAdd = new Slash(); break;
			case "stab": cardToAdd = new Stab(); break;
			case "smallmanapotion": cardToAdd = new SmallManaPotion(); break;
			case "largemanapotion": cardToAdd = new LargeManaPotion(); break;
			case "manarevive": cardToAdd = new ManaRevive(); break;
			case "lifesteal": cardToAdd = new LifeSteal(); break;
			case "soulsteal": cardToAdd = new SoulSteal(); break;
			case "suicide": cardToAdd = new Suicide(); break;
			case "split": cardToAdd = new Split(); break;
			}
			playerDeck.add(cardToAdd);
		}
		return playerDeck;
	}
	
	public void openMainMenu() {
		switchToScreen(mainMenuPane);
	}
	
	public void openGame() {
		switchToScreen(mapPane);
	}
	
	public void openBoard(Level level) {
		player.setHp(player.getMaxHp());
		player.setMana(player.getMaxMana());
		boardPane.setPlayer(player);
		boardPane.setEnemy(level.getEnemy());
		boardPane.setLevelNumber(level.getLevelNumber());
		boardPane.loadCards();
		boardPane.initializeObjects();
		switchToScreen(boardPane);
	}
	
	public void openShop() {
		switchToScreen(shopPane);
	}
	
	public void openCharacterSelect() {
		switchToScreen(characterSelectPane);
	}

	public MapGraphics getMapGraphics() {
		return mapPane;
	}
}
