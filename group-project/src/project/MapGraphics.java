package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

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
	public void run() {
		Map = new GImage("media/images/Background.png", 0, 0);
		add(Map);
	}
}
