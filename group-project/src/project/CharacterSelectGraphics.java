package project;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class CharacterSelectGraphics extends GraphicsProgram implements ActionListener {
//commit 2
	GImage maleKnight;
	GImage femaleKnight;
	GImage maleMagician;
	GImage femaleMagician;
	
	public void run() {
		maleKnight = new GImage("media/images/MaleKnight.jpg", 0, 0);
		add(maleKnight);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
}
