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
		maleKnight = new GImage("media/images/MaleKnight.jpg", 0 * (ProjectGraphics.RESOLUTION_X / 4), 0);
		maleKnight.setSize(ProjectGraphics.RESOLUTION_X / 4, ProjectGraphics.RESOLUTION_Y);
		add(maleKnight);
		femaleKnight = new GImage("media/images/FemaleKnight.jpg", 1 * (ProjectGraphics.RESOLUTION_X / 4), 0);
		femaleKnight.setSize(ProjectGraphics.RESOLUTION_X / 4, ProjectGraphics.RESOLUTION_Y);
		add(femaleKnight);
		maleMagician = new GImage("media/images/MaleMagician.jpg", 2 * (ProjectGraphics.RESOLUTION_X / 4), 0);
		maleMagician.setSize(ProjectGraphics.RESOLUTION_X / 4, ProjectGraphics.RESOLUTION_Y);
		add(maleMagician);
		femaleMagician = new GImage("media/images/FemaleMagician.png", 3 * (ProjectGraphics.RESOLUTION_X / 4), 0);
		femaleMagician.setSize(ProjectGraphics.RESOLUTION_X / 4, ProjectGraphics.RESOLUTION_Y);
		add(femaleMagician);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
}
