package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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

		Enemy levelOneEnemy = new Enemy();
		levelOneEnemy.setHp(20);
		levelOneEnemy.setMaxHp(20);
		levelOneEnemy.setMana(10);
		levelOneEnemy.setMaxMana(10);

		levelOneEnemy.getDeck().add(new SmallHealthPotion());
		levelOneEnemy.getDeck().add(new SmallHealthPotion());
		levelOneEnemy.getDeck().add(new SmallHealthPotion());
		levelOneEnemy.getDeck().add(new SmallHealthPotion());
		levelOneEnemy.getDeck().add(new SmallHealthPotion());
		levelOneEnemy.getDeck().add(new Stab());
		levelOneEnemy.getDeck().add(new Stab());
		levelOneEnemy.getDeck().add(new Stab());
		levelOneEnemy.getDeck().add(new Stab());
		levelOneEnemy.getDeck().add(new Stab());
		
		Enemy levelTwoEnemy = new Enemy();
		Enemy levelThreeEnemy = new Enemy();
		Enemy levelFourEnemy = new Enemy();
		Enemy levelFiveEnemy = new Enemy();
		Enemy levelSixEnemy = new Enemy();
		Enemy levelSevenEnemy = new Enemy();
		Enemy levelEightEnemy = new Enemy();
		
		levelOne = new Level(new GImage("media/images/level1.png", 150, 600), 1, levelOneEnemy, false);
		levelOne.getLevelImage().setSize(150, 150);
		levelTwo = new Level(new GImage("media/images/level2.png", 150, 300), 1, levelTwoEnemy, false);
		levelTwo.getLevelImage().setSize(150, 150);
		levelThree = new Level(new GImage("media/images/level3.png", 450, 300), 1, levelThreeEnemy, false);
		levelThree.getLevelImage().setSize(150, 150);
		levelFour = new Level(new GImage("media/images/level4.png", 450, 600), 1, levelFourEnemy, false);
		levelFour.getLevelImage().setSize(150, 150);
		levelFive = new Level(new GImage("media/images/level5.png", 750, 600), 1, levelFiveEnemy, false);
		levelFive.getLevelImage().setSize(150, 150);
		levelSix = new Level(new GImage("media/images/level6.png", 750, 300), 1, levelSixEnemy, false);
		levelSix.getLevelImage().setSize(150, 150);
		levelSeven = new Level(new GImage("media/images/level7.png", 1050, 300), 1, levelSevenEnemy, false);
		levelSeven.getLevelImage().setSize(150, 150);
		levelEight = new Level(new GImage("media/images/level8.png", 1050, 600), 1, levelEightEnemy, false);
		levelEight.getLevelImage().setSize(150, 150);

		levelList.add(levelOne);
		levelList.add(levelTwo);
		levelList.add(levelThree);
		levelList.add(levelFour);
		levelList.add(levelFive);
		levelList.add(levelSix);
		levelList.add(levelSeven);
		levelList.add(levelEight);
		
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
		program.add(levelOne.getLevelImage());
		program.add(levelTwo.getLevelImage());
		program.add(levelThree.getLevelImage());
		program.add(levelFour.getLevelImage());
		program.add(levelFive.getLevelImage());
		program.add(levelSix.getLevelImage());
		program.add(levelSeven.getLevelImage());
		program.add(levelEight.getLevelImage());
		program.add(MainMenuGraphics.menuButton);
	}
	
	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(levelOne.getLevelImage());
		program.remove(levelTwo.getLevelImage());
		program.remove(levelThree.getLevelImage());
		program.remove(levelFour.getLevelImage());
		program.remove(levelFive.getLevelImage());
		program.remove(levelSix.getLevelImage());
		program.remove(levelSeven.getLevelImage());
		program.remove(levelEight.getLevelImage());
		program.remove(MainMenuGraphics.menuButton);
	}
	
}
