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

public class MapGraphics extends ProjectGraphics implements ActionListener {
	public static final int RESOLUTION_X = 1920;
	public static final int RESOLUTION_Y = 1080;
	private GImage mapimg;
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
	public HashMap<GImage , Level > levelmapimg;
	public GImage Leveltemp;
	private ArrayList<GImage> Iconlist;
	public void run() {
		addMouseListeners();
		
		mapimg = new GImage("media/images/Background.png", 0, 0);
		mapimg.setSize(RESOLUTION_X, RESOLUTION_Y);
		
		Level1=new  GImage("media/images/level1.png", 150, 600);
		Level1.setSize(150, 150);
		Leveltemp=Level1;
		Level2=new  GImage("media/images/level2.png", 150, 300);
		Level2.setSize(150, 150);
		Level3=new  GImage("media/images/level3.png", 450, 300);
		Level3.setSize(150, 150);
		Level4=new  GImage("media/images/level4.png", 450, 600);
		Level4.setSize(150, 150);
		Level5=new  GImage("media/images/level5.png", 750, 600);
		Level5.setSize(150, 150);
		Level6=new  GImage("media/images/level6.png", 750, 300);
		Level6.setSize(150, 150);
		Level7=new  GImage("media/images/level7.png", 1050, 300);
		Level7.setSize(150, 150);
		Level8=new  GImage("media/images/level8.png", 1050, 600);
		Level8.setSize(150, 150);
//		Level4=new  GImage("media/images/level4.png", 0, 0);
//		Level5=new  GImage("media/images/level5.png", 0, 0);
//		Level6=new  GImage("media/images/level6.png", 0, 0);
//		Level7=new  GImage("media/images/level7.png", 0, 0);
//		Level8=new  GImage("media/images/level8.png", 0, 0);
//		levelmapimg.put(Level1,LevelOne);
//		levelmapimg.put(Level2,LevelTwo);
//		levelmapimg.put(Level3,LevelThree);
//		levelmapimg.put(Level4,LevelFlour);
//		levelmapimg.put(Level5,LevelFive);
//		levelmapimg.put(Level6,LevelSix);
//		levelmapimg.put(Level7,LevelSeven);
//		levelmapimg.put(Level8,LevelEight);
		add(mapimg);
		add(Level1);
		add(Level2);
		add(Level3);
		add(Level4);
		add(Level5);
		add(Level6);
		add(Level7);
		add(Level8);
//		Iconlist.add(Level1);
//		Iconlist.add(Level2);
//		Iconlist.add(Level3);
//		Iconlist.add(Level4);
//		Iconlist.add(Level5);
//		Iconlist.add(Level6);
//		Iconlist.add(Level7);
//		Iconlist.add(Level8);
	}
	public void mousePressed(MouseEvent e) {
		GObject elem = getElementAt(e.getX(), e.getY());
		if (elem instanceof GImage) {
			if(elem.isVisible()&& elem.getWidth()!=RESOLUTION_X) {
				((GImage) elem).setVisible(false);
				
		}		}
	}
	public void finishLevel(int levelnum) {
		Iconlist.get(levelnum).setVisible(false);
	}
	 public void mouseMoved(MouseEvent e) {
			GObject elem = getElementAt(e.getX(), e.getY());
			if (elem instanceof GImage) {
				if(Leveltemp!=elem) {
					if(Leveltemp.getWidth()!=RESOLUTION_X) {
						Leveltemp.setSize(150, 150);
					}
					Leveltemp=(GImage) elem;
					
				}
				if(elem.isVisible()&& elem.getWidth()!=RESOLUTION_X) {
					((GImage) elem).setSize(140, 140);

			}
		}
		}
}
