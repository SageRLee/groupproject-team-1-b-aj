package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class MapGraphics extends ProjectGraphics implements ActionListener {
	public static final int RESOLUTION_X = 1920;
	public static final int RESOLUTION_Y = 1080;
	private GImage Map;
	public GImage Level1;
	public GImage Level2;
	public GImage Level3;
	public GImage Level4;
	public GImage Level5;
	public GImage Level6;
	public GImage Level7;
	public GImage Level8;
	public Level LevelOne;
	public Level LevelTwo;
	public Level LevelThree;
	public Level LevelFlour;
	public Level LevelFive;
	public Level LevelSix;
	public Level LevelSeven;
	public Level LevelEight;
	public HashMap<GImage , Level > levelmap;
	public void run() {
		Map = new GImage("media/images/Background.png", 0, 0);
		
//		Level1=new  GImage("media/images/level1.png", 0, 0);
//		Level2=new  GImage("media/images/level2.png", 0, 0);
//		Level3=new  GImage("media/images/level3.png", 0, 0);
//		Level4=new  GImage("media/images/level4.png", 0, 0);
//		Level5=new  GImage("media/images/level5.png", 0, 0);
//		Level6=new  GImage("media/images/level6.png", 0, 0);
//		Level7=new  GImage("media/images/level7.png", 0, 0);
//		Level8=new  GImage("media/images/level8.png", 0, 0);
//		levelmap.put(Level1,LevelOne);
//		levelmap.put(Level2,LevelTwo);
//		levelmap.put(Level3,LevelThree);
//		levelmap.put(Level4,LevelFlour);
//		levelmap.put(Level5,LevelFive);
//		levelmap.put(Level6,LevelSix);
//		levelmap.put(Level7,LevelSeven);
//		levelmap.put(Level8,LevelEight);
		add(Map);
//		add(Level1);
//		add(Level2);
//		add(Level3);
//		add(Level4);
//		add(Level5);
//		add(Level6);
//		add(Level7);
//		add(Level8);
	}
}
