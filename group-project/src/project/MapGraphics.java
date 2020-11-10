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
import starter.GraphicsPane;

public class MapGraphics extends GraphicsPane {

	private MainMenu program;
	
	public MapGraphics(MainMenu program) {
		super();
		this.program = program;
		initializeObjects();
	}
	
	private void initializeObjects() {
		mapimg = new GImage("media/images/Background.png", 0, 0);
		mapimg.setSize(MainMenu.RESOLUTION_X, MainMenu.RESOLUTION_Y);
		
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
	}

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
	
	/*
	public void run() {
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
	}*/
	
	public void mousePressed(MouseEvent e) {
		GObject elem = program.getElementAt(e.getX(), e.getY());
		if (elem instanceof GImage) {
			if(elem.isVisible()&& elem.getWidth()!=MainMenu.RESOLUTION_X) {
				((GImage) elem).setVisible(false);
				
		}		}
	}
	public void finishLevel(int levelnum) {
		Iconlist.get(levelnum).setVisible(false);
	}
	 public void mouseMoved(MouseEvent e) {
			GObject elem = program.getElementAt(e.getX(), e.getY());
			if (elem instanceof GImage) {
				if(Leveltemp!=elem) {
					if(Leveltemp.getWidth()!=MainMenu.RESOLUTION_X) {
						Leveltemp.setSize(150, 150);
					}
					Leveltemp=(GImage) elem;
					
				}
				if(elem.isVisible()&& elem.getWidth()!=MainMenu.RESOLUTION_X) {
					((GImage) elem).setSize(140, 140);

			}
		}
		}
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(mapimg);
		program.add(Level1);
		program.add(Level2);
		program.add(Level3);
		program.add(Level4);
		program.add(Level5);
		program.add(Level6);
		program.add(Level7);
		program.add(Level8);
	}
	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.remove(mapimg);
		program.remove(Level1);
		program.remove(Level2);
		program.remove(Level3);
		program.remove(Level4);
		program.remove(Level5);
		program.remove(Level6);
		program.remove(Level7);
		program.remove(Level8);
		
	}
}
