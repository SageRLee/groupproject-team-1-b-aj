package project;

import acm.program.GraphicsProgram;

public class ProjectGraphics extends GraphicsProgram {

	private static final int RESOLUTION_X = 1920;
	private static final int RESOLUTION_Y = 1080;
	
	public void initializeApplet() {
		setSize(RESOLUTION_X, RESOLUTION_Y);
	}
	
}
