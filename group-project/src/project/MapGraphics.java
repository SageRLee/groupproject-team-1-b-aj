package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import project.cards.LargeHealthPotion;
import project.cards.Revive;
import project.cards.Slash;
import project.cards.SmallHealthPotion;
import project.cards.Stab;
import project.cards.Stick;
import starter.GraphicsPane;

public class MapGraphics extends GraphicsPane {

	private MainMenu program;
	
	private GImage background;
	private Level levelOne;
	private Level levelTwo;
	private Level levelThree;
	private Level levelFour;
	private Level levelFive;
	private Level levelSix;
	private Level levelSeven;
	private Level levelEight;
	private Level levelNine;
	private Level levelTen;
	private Level levelEleven;
	private Level levelTwelve;
	private Level levelThirteen;
	private Level levelFourteen;
	private Level levelFifteen;
	private Level levelSixteen;
	private Level levelSeventeen;
	private Level levelEighteen;
	private Level levelNineteen;
	private Level levelTwenty;
	
	private ArrayList<Level> levelList;
	
	private GImage levelHovered;
	
	public MapGraphics(MainMenu program) {
		super();
		this.program = program;
		initializeObjects();
	}
	
	private void initializeObjects() {
		background = new GImage("media/images/Background.png", 0, 0);
		background.setSize(MainMenu.RESOLUTION_X, MainMenu.RESOLUTION_Y);
		
		levelList = new ArrayList<>();

		Enemy levelOneEnemy = new Enemy("Fish", new GImage("media/images/monsters/LevelOne.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));

		Enemy levelTwoEnemy = new Enemy("Chicken", new GImage("media/images/monsters/LevelTwo.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelThreeEnemy = new Enemy("Sheep", new GImage("media/images/monsters/LevelThree.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelFourEnemy = new Enemy("Squid", new GImage("media/images/monsters/LevelFour.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelFiveEnemy = new Enemy("Rabbit", new GImage("media/images/monsters/LevelFive.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelSixEnemy = new Enemy("Pig", new GImage("media/images/monsters/LevelSix.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelSevenEnemy = new Enemy("Cow", new GImage("media/images/monsters/LevelSeven.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelEightEnemy = new Enemy("Bat", new GImage("media/images/monsters/LevelEight.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelNineEnemy = new Enemy("Spider", new GImage("media/images/monsters/LevelNine.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelTenEnemy = new Enemy("Dolphin", new GImage("media/images/monsters/LevelTen.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelElevenEnemy = new Enemy("Panda", new GImage("media/images/monsters/LevelEleven.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelTwelveEnemy = new Enemy("Bear", new GImage("media/images/monsters/LevelTwelve.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelThirteenEnemy = new Enemy("Wolf", new GImage("media/images/monsters/LevelThirteen.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelFourteenEnemy = new Enemy("Silverfish", new GImage("media/images/monsters/LevelFourteen.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelFifteenEnemy = new Enemy("Zombie", new GImage("media/images/monsters/LevelFifteen.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelSixteenEnemy = new Enemy("Skeleton", new GImage("media/images/monsters/LevelSixteen.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelSeventeenEnemy = new Enemy("Witch", new GImage("media/images/monsters/LevelSeventeen.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelEighteenEnemy = new Enemy("Ogre", new GImage("media/images/monsters/LevelEighteen.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelNineteenEnemy = new Enemy("Kraken", new GImage("media/images/monsters/LevelNineteen.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));
		Enemy levelTwentyEnemy = new Enemy("Dragon", new GImage("media/images/monsters/LevelTwenty.png"), 5, 5, 10, 10, new ArrayList<Card>(Arrays.asList(new Stick())));

		levelOne = new Level(new GImage("media/images/level1.png", 1 * 175, 1 * 175), 1, levelOneEnemy, false);
		levelTwo = new Level(new GImage("media/images/level2.png", 2 * 175, 1 * 175), 1, levelTwoEnemy, false);
		levelThree = new Level(new GImage("media/images/level3.png", 3 * 175, 1 * 175), 1, levelThreeEnemy, false);
		levelFour = new Level(new GImage("media/images/level4.png", 4 * 175, 1 * 175), 1, levelFourEnemy, false);
		levelFive = new Level(new GImage("media/images/level5.png", 5 * 175, 1 * 175), 1, levelFiveEnemy, false);
		levelSix = new Level(new GImage("media/images/level6.png", 1 * 175, 2 * 175), 1, levelSixEnemy, false);
		levelSeven = new Level(new GImage("media/images/level7.png", 2 * 175, 2 * 175), 1, levelSevenEnemy, false);
		levelEight = new Level(new GImage("media/images/level8.png", 3 * 175, 2 * 175), 1, levelEightEnemy, false);
		levelNine = new Level(new GImage("media/images/level8.png", 4 * 175, 2 * 175), 1, levelNineEnemy, false);
		levelTen = new Level(new GImage("media/images/level8.png", 5 * 175, 2 * 175), 1, levelTenEnemy, false);
		levelEleven = new Level(new GImage("media/images/level8.png", 1 * 175, 3 * 175), 1, levelElevenEnemy, false);
		levelTwelve = new Level(new GImage("media/images/level8.png", 2 * 175, 3 * 175), 1, levelTwelveEnemy, false);
		levelThirteen = new Level(new GImage("media/images/level8.png", 3 * 175, 3 * 175), 1, levelThirteenEnemy, false);
		levelFourteen = new Level(new GImage("media/images/level8.png", 4 * 175, 3 * 175), 1, levelFourteenEnemy, false);
		levelFifteen = new Level(new GImage("media/images/level8.png", 5 * 175, 3 * 175), 1, levelFifteenEnemy, false);
		levelSixteen = new Level(new GImage("media/images/level8.png", 1 * 175, 4 * 175), 1, levelSixteenEnemy, false);
		levelSeventeen = new Level(new GImage("media/images/level8.png", 2 * 175, 4 * 175), 1, levelSeventeenEnemy, false);
		levelEighteen = new Level(new GImage("media/images/level8.png", 3 * 175, 4 * 175), 1, levelEighteenEnemy, false);
		levelNineteen = new Level(new GImage("media/images/level8.png", 4 * 175, 4 * 175), 1, levelNineteenEnemy, false);
		levelTwenty = new Level(new GImage("media/images/level8.png", 5 * 175, 4 * 175), 1, levelTwentyEnemy, false);

		levelList.add(levelOne);
		levelList.add(levelTwo);
		levelList.add(levelThree);
		levelList.add(levelFour);
		levelList.add(levelFive);
		levelList.add(levelSix);
		levelList.add(levelSeven);
		levelList.add(levelEight);
		levelList.add(levelNine);
		levelList.add(levelTen);
		levelList.add(levelEleven);
		levelList.add(levelTwelve);
		levelList.add(levelThirteen);
		levelList.add(levelFourteen);
		levelList.add(levelFifteen);
		levelList.add(levelSixteen);
		levelList.add(levelSeventeen);
		levelList.add(levelEighteen);
		levelList.add(levelNineteen);
		levelList.add(levelTwenty);
		
		for (Level level : levelList) {
			level.getLevelImage().setSize(150, 150);
		}
		
		loadLevels();
	}
	
	public void loadLevels() {
		for (Level level : levelList) {
			if (level.isComplete())
				level.getLevelImage().setVisible(false);
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject currElem = program.getElementAt(e.getX(), e.getY());
		if (currElem instanceof GImage) {
			for (Level level : levelList) {
				if (level.getLevelImage() == currElem) {
					program.openBoard(level.getEnemy());
				}
			}
			if (currElem == MainMenuGraphics.menuButton) {
				program.openMainMenu();
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		GObject currElem = program.getElementAt(e.getX(), e.getY());
		
		if (currElem instanceof GImage) {
			for (Level level : levelList) {
				if (level.getLevelImage() == currElem) {
					levelHovered = level.getLevelImage();
					levelHovered.setSize(140, 140);
					return;
				}
			}
		}
		
		if (levelHovered != null) {
			levelHovered.setSize(150, 150);
			levelHovered = null;
		}
		
	}
	 
	@Override
	public void showContents() {
		program.add(background);
		
		for (Level level : levelList) {
			program.add(level.getLevelImage());
		}

		program.add(MainMenuGraphics.menuButton);
	}
	
	@Override
	public void hideContents() {
		program.remove(background);
		
		for (Level level : levelList) {
			program.remove(level.getLevelImage());
		}
		
		program.remove(MainMenuGraphics.menuButton);
	}
	
}
