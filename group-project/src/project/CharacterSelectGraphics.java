package project;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.program.GraphicsProgram;
import starter.GraphicsPane;

public class CharacterSelectGraphics extends GraphicsPane {

	private MainMenu program;
	
	private GImage maleKnight;
	private GImage femaleKnight;
	private GImage maleMagician;
	private GImage femaleMagician;

	public CharacterSelectGraphics(MainMenu program) {
		super();
		this.program = program;
		initializeObjects();
	}
	
	public void initializeObjects() {
		maleKnight = new GImage("media/images/MaleKnight.jpg", 0 * (MainMenu.RESOLUTION_X / 4), 0);
		maleKnight.setSize(MainMenu.RESOLUTION_X / 4, MainMenu.RESOLUTION_Y);
		femaleKnight = new GImage("media/images/FemaleKnight.png", 1 * (MainMenu.RESOLUTION_X / 4), 0);
		femaleKnight.setSize(MainMenu.RESOLUTION_X / 4, MainMenu.RESOLUTION_Y);
		maleMagician = new GImage("media/images/MaleMagician.png", 2 * (MainMenu.RESOLUTION_X / 4), 0);
		maleMagician.setSize(MainMenu.RESOLUTION_X / 4, MainMenu.RESOLUTION_Y);
		femaleMagician = new GImage("media/images/FemaleMagician.png", 3 * (MainMenu.RESOLUTION_X / 4), 0);
		femaleMagician.setSize(MainMenu.RESOLUTION_X / 4, MainMenu.RESOLUTION_Y);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (program.getElementAt(e.getX(), e.getY()) instanceof GImage) {
			GImage clickedImage = (GImage) program.getElementAt(e.getX(), e.getY());
			if (clickedImage == MainMenuGraphics.menuButton) {
				program.openMainMenu();
			}
		}
	}

	@Override
	public void showContents() {
		program.add(maleKnight);
		program.add(femaleKnight);
		program.add(maleMagician);
		program.add(femaleMagician);
		program.add(MainMenuGraphics.menuButton);
	}

	@Override
	public void hideContents() {
		program.remove(maleKnight);
		program.remove(femaleKnight);
		program.remove(maleMagician);
		program.remove(femaleMagician);
		program.remove(MainMenuGraphics.menuButton);
	}
	
}
