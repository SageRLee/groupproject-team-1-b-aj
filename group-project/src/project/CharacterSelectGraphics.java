package project;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class CharacterSelectGraphics extends ProjectGraphics implements ActionListener {
//commit 2
	GImage maleKnight;
	GImage femaleKnight;
	GImage maleMagician;
	GImage femaleMagician;
	
	public void run() {
		initializeApplet();
		maleKnight = new GImage("media/images/MaleKnight.jpg", 0, 0);
		maleKnight.setSize(ProjectGraphics.RESOLUTION_X / 4, ProjectGraphics.RESOLUTION_Y);
		add(maleKnight);
		femaleKnight = new GImage("media/images/FemaleKnight.jpg", 480, 0);
		femaleKnight.setSize(ProjectGraphics.RESOLUTION_X / 4, ProjectGraphics.RESOLUTION_Y);
		add(femaleKnight);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
}
