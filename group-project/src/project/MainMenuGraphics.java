package project;
import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class MainMenuGraphics extends GraphicsProgram {
	private static GImage titleImage;
	private static GImage playButtonImage;
	private static GImage shopButtonImage;
	private static GImage background = new GImage("group-project/media/images/Background.png", 0, 0);
	
	public void run() {
		
		add(background);
	}
	public void mousePressed(MouseEvent e) {
		//Mouse event for all button options
	}
	
}
